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

package org.jlib.core.codec.base64;

import static org.jlib.core.codec.base64.Base64Utility.PAD;
import static org.jlib.core.codec.base64.Base64Utility.base64Alphabet;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * FilterOutputStream performing a base64 encoding for a target OutputStream.
 * 
 * @author Igor Akkerman
 */
public class Base64OutputStream
extends FilterOutputStream {

    /** maximal length of a base64 line */
    private static final int MAXOUTPUTLINELENGTH = 76;

    /** input buffer */
    private int[] inputBuffer = {0, 0, 0};

    /** size of the input buffer */
    private int inputBufferSize = 0;

    /** output buffer */
    private byte[] outputBuffer = new byte[4];

    /** length of the current output line */
    private int outputLineLength = 0;

    /**
     * Creates a new filter output stream performing a base64 encoding to the specified output stream.
     * 
     * @param targetOutputStream
     *        output stream to write encoded output to
     */
    public Base64OutputStream(OutputStream targetOutputStream) {
        super(targetOutputStream);
    }

    // @see java.io.FilterOutputStream#write(int)
    @Override
    public void write(int b)
    throws IOException {
        inputBuffer[inputBufferSize ++] = b;
        if (inputBufferSize == 3) {
            encodeInputBlock();
        }
    }

    /**
     * Encodes the input block and writes the output to the target output stream.
     * 
     * @throws IOException
     *         if an I/O exception occurs
     */
    private void encodeInputBlock()
    throws IOException {
        if (inputBufferSize > 0) {
            // fill output buffer
            outputBuffer[0] = base64Alphabet[(inputBuffer[0] & 0xFC) >> 2];
            outputBuffer[1] = base64Alphabet[(inputBuffer[0] & 0x03) << 4 | (inputBuffer[1] & 0xF0) >> 4];
            outputBuffer[2] = base64Alphabet[(inputBuffer[1] & 0x0F) << 2 | (inputBuffer[2] & 0xC0) >> 6];
            outputBuffer[3] = base64Alphabet[inputBuffer[2] & 0x3F];

            // fill with padding characters
            if (inputBufferSize == 1) {
                outputBuffer[2] = PAD;
                outputBuffer[3] = PAD;
            }
            else if (inputBufferSize == 2) {
                outputBuffer[3] = PAD;
            }

            // write the stream to the target output stream
            out.write(outputBuffer);
            outputLineLength += 4;

            // create a line break if necessary
            if (outputLineLength == MAXOUTPUTLINELENGTH) {
                out.write('\r');
                out.write('\n');
                outputLineLength = 0;
            }

            // re-initialize input buffer
            for (int i = 0; i < 3; i ++) {
                inputBuffer[i] = 0;
            }
            inputBufferSize = 0;
        }
    }

    // @see java.io.FilterOutputStream#flush()
    @Override
    public void flush()
    throws IOException {
        encodeInputBlock();
        out.flush();
    }

    // @see java.io.FilterOutputStream#close()
    @Override
    public void close()
    throws IOException {
        flush();
        out.close();
    }
}
