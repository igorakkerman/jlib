/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */



package org.jlib.codec.quotedprintable;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.checkerframework.checker.nullness.qual.NonNull;
import static org.jlib.codec.quotedprintable.QuotedPrintableUtility.decodeOctet;
import static org.jlib.core.io.StreamUtility.toSignedByte;
import static org.jlib.core.io.StreamUtility.toUnsignedInt;

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
    final byte[] inputBuffer = new byte[3];

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
    public QuotedPrintableInputStream(final InputStream sourceInputStream) {
        super(sourceInputStream);
    }

    @Override
    public int read()
    throws IOException {
        try {
            return toUnsignedInt(getNextByte());
        }
        catch (final EndOfQuotedPrintableStreamException eoqpse) {
            return -1;
        }
    }

    @Override
    public int read(@NonNull final byte[] buffer, final int offset, final int length)
    throws IOException {
        for (int i = offset, j = 0; j < length; i ++, j ++) {
            try {
                buffer[i] = getNextByte();
            }
            catch (final EndOfQuotedPrintableStreamException eoqpse) {
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
    @SuppressWarnings("DuplicateThrows")
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
