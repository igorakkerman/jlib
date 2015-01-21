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



package org.jlib.codec.base64;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.jlib.codec.base64.Base64Utility.BASE64_ALPHABET;
import static org.jlib.codec.base64.Base64Utility.PAD;
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
    private final int[] inputBuffer = {0, 0, 0};

    /** size of the input buffer */
    private int inputBufferSize = 0;

    /** output buffer */
    private final byte[] outputBuffer = new byte[4];

    /** length of the current output line */
    private int outputLineLength = 0;

    /**
     * Creates a new filter output stream performing a base64 encoding to the specified output stream.
     *
     * @param targetOutputStream
     *        output stream to write encoded output to
     */
    public Base64OutputStream(final OutputStream targetOutputStream) {
        super(targetOutputStream);
    }

    @Override
    public void write(final int b)
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
            outputBuffer[0] = BASE64_ALPHABET[(inputBuffer[0] & 0xFC) >> 2];
            outputBuffer[1] = BASE64_ALPHABET[(inputBuffer[0] & 0x03) << 4 | (inputBuffer[1] & 0xF0) >> 4];
            outputBuffer[2] = BASE64_ALPHABET[(inputBuffer[1] & 0x0F) << 2 | (inputBuffer[2] & 0xC0) >> 6];
            outputBuffer[3] = BASE64_ALPHABET[inputBuffer[2] & 0x3F];

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

    @Override
    public void flush()
    throws IOException {
        encodeInputBlock();
        out.flush();
    }

    @Override
    public void close()
    throws IOException {
        flush();
        out.close();
    }
}
