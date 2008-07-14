/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.codec.quotedprintable;

import static org.jlib.core.codec.quotedprintable.QuotedPrintableUtility.decodeOctet;
import static org.jlib.core.io.IOUtility.toSignedByte;
import static org.jlib.core.io.IOUtility.toUnsignedInt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FilterInputStream performing a quoted-printable decoding of a source InputStream.
 * 
 * @author Igor Akkerman
 */
public class QuotedPrintableInputStream
extends FilterInputStream {

    /** line separator */
    private static final byte[] LINE_SEPARATOR = System.getProperty("line.separator").getBytes();

    /** input buffer */
    byte[] inputBuffer = new byte[3];

    /** size of the input buffer */
    int inputBufferSize = 0;

    /** output buffer (for line separator only) */
    byte[] outputBuffer = new byte[0];

    /** position in the output buffer */
    int outputBufferPosition = 0;

    /**
     * Creates a new QuotedPrintableInputStream decoding the specified quoted-printable InputStream.
     * 
     * @param sourceInputStream
     *        input stream to be decoded
     */
    public QuotedPrintableInputStream(InputStream sourceInputStream) {
        super(sourceInputStream);
    }

    // @see java.io.FilterInputStream#read()
    @Override
    public int read()
    throws IOException {
        try {
            return toUnsignedInt(getNextByte());
        }
        catch (EndOfQuotedPrintableStreamException eoqpse) {
            return -1;
        }
    }

    // @see java.io.FilterInputStream#read(byte[], int, int)
    @Override
    public int read(byte[] buffer, int offset, int length)
    throws IOException {
        for (int i = offset, j = 0; j < length; i ++, j ++) {
            try {
                buffer[i] = getNextByte();
            }
            catch (EndOfQuotedPrintableStreamException eoqpse) {
                return i != 0 ? i : -1;
            }
        }
        return length;
    }

    /**
     * Returns the next byte to be returned from this Stream.
     * 
     * @throws IllegalQuotedPrintableOctetException
     *         if illegal characters follow the octet encoding prefix in the stream
     * @throws IOException
     *         if an I/O error occurs
     * @throws EndOfQuotedPrintableStreamException
     *         if no more bytes are available from this stream
     * @return the next byte to be returned from this stream
     */
    private byte getNextByte()
    throws IllegalQuotedPrintableOctetException, IOException, EndOfQuotedPrintableStreamException {
        do {
            // if there are characters left in the output buffer, return the first one
            if (outputBufferPosition < outputBuffer.length)
                return outputBuffer[outputBufferPosition ++];

            // refill the input buffer
            refillInputBuffer();

            // if the end of the stream has been reached, throw exception
            if (inputBuffer[0] == -1)
                throw new EndOfQuotedPrintableStreamException();

            // if a soft line break occurs, simply ignore it
            else if (inputBuffer[0] == '=' && inputBuffer[1] == '\r' && inputBuffer[2] == '\n')
                inputBufferSize = 0;

            // if the buffered characters represent an encoded octet, return the (decoded) octet
            else if (inputBuffer[0] == '=') {
                inputBufferSize = 0;
                return decodeOctet(inputBuffer);
            }

            // if the buffered characters represent a hard line break,
            // prepare the output buffer and return the first character of LINE_SEPARATOR
            else if (inputBuffer[0] == '\r' && inputBuffer[1] == '\n') {
                outputBuffer = LINE_SEPARATOR;
                outputBufferPosition = 1;

                inputBufferSize = LINE_SEPARATOR.length - 1;
                return outputBuffer[0];
            }

            // if there is a simple character
            else {
                inputBufferSize = 2;
                return inputBuffer[0];
            }
        }
        while (true);

    }

    /**
     * Refill the input buffer so that it contains the next three characters.
     * 
     * @throws IOException
     *         if an I/O error occurs
     */
    private void refillInputBuffer()
    throws IOException {
        for (int i = 3 - inputBufferSize, j = 0; j < inputBufferSize; i ++, j ++) {
            inputBuffer[j] = inputBuffer[i];
        }
        for (int i = inputBufferSize; i <= 2; i ++) {
            inputBuffer[i] = toSignedByte(in.read());
        }
    }
}
