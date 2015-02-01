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

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.checkerframework.checker.nullness.qual.NonNull;
import static org.jlib.codec.base64.Base64Utility.mapBase64Character;

/**
 * FilterInputStream performing a base64 decoding of a source InputStream.
 *
 * @author Igor Akkerman
 */

public class Base64InputStream
extends FilterInputStream {

    /** padding byte */
    private static final byte PAD = - 1;

    /** input buffer */
    private final int[] inputBuffer = new int[4];

    /** output buffer */
    private final int[] outputBuffer = new int[3];

    /** size of the output buffer */
    private int outputBufferSize = 0;

    /** current position in the output buffer */
    private int outputBufferPosition = 0;

    /**
     * Creates a new filter input stream decoding the specified base64 input stream.
     *
     * @param sourceInputStream
     *        input stream to be decoded
     */
    public Base64InputStream(final InputStream sourceInputStream) {
        super(sourceInputStream);
    }

    @Override
    public int read()
    throws IOException {
        do {
            try {
                if (outputBufferPosition == outputBufferSize) {
                    readBase64Block();
                    decodeBase64Block();
                    outputBufferPosition = 0;
                }

                return outputBuffer[outputBufferPosition++];
            }
            catch (final EndOfBase64StreamException eob64se) {
                return - 1;
            }
            catch (final InvalidBase64BlockPadException ib64bpe) {
                // illegal block is ignored
            }
        }
        while (true);
    }

    @Override
    public int read(@NonNull final byte[] buffer, final int offset, final int length)
    throws IOException {
        for (int i = 0; i < length; i++) {
            buffer[i] = (byte) read();
            if (buffer[i] == - 1) {
                return i != 0 ?
                       i :
                       - 1;
            }
        }
        return length;
    }

    /**
     * Reads a block of four base64 characters writing their values into the input buffer.
     *
     * @throws EndOfBase64StreamException
     *         if the end of the base64 stream was reached before the next block;
     *         this exception does not signal an error
     * @throws UnexpectedEndOfBase64StreamException
     *         if the base64 block was not completed at the end of the base64 stream
     * @throws IOException
     *         if an I/O error occurs
     */
    @SuppressWarnings("DuplicateThrows")
    private void readBase64Block()
    throws EndOfBase64StreamException, UnexpectedEndOfBase64StreamException, IOException {

        for (int characterIndex = 0; characterIndex <= 3; characterIndex++) {
            boolean illegalCharacterRead;
            do {
                try {
                    final int readCharacter = in.read();

                    // end of stream handling
                    if (readCharacter == - 1) {
                        if (characterIndex == 0) {
                            throw new EndOfBase64StreamException();
                        }
                        else {
                            throw new UnexpectedEndOfBase64StreamException();
                        }
                    }

                    final int characterValue = mapBase64Character(readCharacter);
                    inputBuffer[characterIndex] = characterValue;
                    illegalCharacterRead = false;
                }
                catch (final InvalidBase64CharacterException exception) {
                    illegalCharacterRead = true;
                }
            }
            while (illegalCharacterRead);
        }
    }

    /**
     * Decodes the currently read base64 block into the output buffer.
     *
     * @throws InvalidBase64BlockPadException
     *         if the read base64 block contains illegal padding characters
     */
    private void decodeBase64Block()
    throws InvalidBase64BlockPadException {

        // get number of padding characters and clear them in the input buffer
        final int paddingCharactersCount = getPaddingCharactersCount();
        clearPaddingCharacters();

        outputBuffer[0] = inputBuffer[0] << 2 | (inputBuffer[1] & 0x30) >> 4;
        outputBuffer[1] = (inputBuffer[1] & 0x0F) << 4 | (inputBuffer[2] & 0x3C) >> 2;
        outputBuffer[2] = (inputBuffer[2] & 0x03) << 6 | inputBuffer[3];

        outputBufferSize = 3 - paddingCharactersCount;
    }

    /**
     * Returns the number of padding characters in the currently read base64 block.
     *
     * @return integer specifying the number of padding characters
     * @throws InvalidBase64BlockPadException
     *         if the read base64 block contains illegal padding characters
     */
    private int getPaddingCharactersCount()
    throws InvalidBase64BlockPadException {
        final boolean[] pad = new boolean[4];
        for (int i = 0; i <= 3; i++)
            pad[i] = inputBuffer[i] == PAD;

        if (! pad[0] && ! pad[1] && ! pad[2] && ! pad[3])
            return 0;
        else if (! pad[0] && ! pad[1] && ! pad[2] /* && pad[3] */ && (inputBuffer[2] & 0x03) == 0)
            return 1;
        else if (! pad[0] && ! pad[1] && pad[2] && pad[3] && (inputBuffer[1] & 0x0F) == 0)
            return 2;
        else
            throw new InvalidBase64BlockPadException(inputBuffer);
    }

    /**
     * Clears all padding characters in the input buffer. Their positions are set to 0.
     */
    private void clearPaddingCharacters() {
        if (inputBuffer[2] == PAD) {
            inputBuffer[2] = 0;
        }
        if (inputBuffer[3] == PAD) {
            inputBuffer[3] = 0;
        }
    }

    @Override
    public int available() {
        return 4 - outputBufferPosition;
    }
}
