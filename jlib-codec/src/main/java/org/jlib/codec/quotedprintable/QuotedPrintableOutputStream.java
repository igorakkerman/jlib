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

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.checkerframework.checker.nullness.qual.NonNull;
import static org.jlib.codec.quotedprintable.QuotedPrintableUtility.createOctet;
import static org.jlib.core.io.StreamUtility.toSignedByte;
import static org.jlib.core.io.StreamUtility.toUnsignedInt;

/**
 * FilterOutputStream performing a quoted-printable encoding for a target OutputStream.
 *
 * @author Igor Akkerman
 */
public class QuotedPrintableOutputStream
extends FilterOutputStream {

    /** maximal length of an output line */
    private static final int MAXOUTPUTLINELENGTH = 76;

    /** length of the current output line */
    private int outputLineLength = 0;

    /** last written character */
    private int lastWrittenCharacter;

    /**
     * Creates a new QuotedPrintableOutputStream performing a quoted-printable encoding to the
     * specified output stream.
     *
     * @param targetOutputStream
     *        output stream to write encoded output to
     */
    public QuotedPrintableOutputStream(final OutputStream targetOutputStream) {
        super(targetOutputStream);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public void write(final int b)
    throws IOException {
        final byte value = toSignedByte(b);

        // if the character may be represented as a literal
        if (value >= 33 && value <= 60 || value >= 62 && value <= 126 || value == 9 || value == 32) {
            if (outputLineLength >= MAXOUTPUTLINELENGTH - 1)
                writeSoftLineBreak();

            writeCharacter(value);
        }

        // if a CR is to be represented

        else if (value == '\r') {
            // intentionally blank
        }
        else if (value == '\n') {
            if (lastWrittenCharacter == 9 || lastWrittenCharacter == 32)
                writeSoftLineBreak();

            writeCrlf();
        }

        // if the character is to be represented as an octet
        else {
            if (outputLineLength >= MAXOUTPUTLINELENGTH - 3)
                writeSoftLineBreak();

            writeCharacters(createOctet(value));
        }
    }

    @Override
    public void write(@NonNull final byte[] buffer, final int offset, final int length)
    throws IOException {
        for (int i = offset, j = 0; j < length; i++, j++)
            write(toUnsignedInt(buffer[i]));
    }

    /**
     * Writes the specified character to the target output stream.
     *
     * @param character
     *        byte specifying the character to write
     * @throws IOException
     *         if an I/O error occurs
     */
    private void writeCharacter(final byte character)
    throws IOException {
        out.write(toUnsignedInt(character));
        lastWrittenCharacter = character;
        outputLineLength++;
    }

    /**
     * Writes the specified characters to the target output stream.
     *
     * @param characters
     *        byte array containing the characters to write
     * @throws IOException
     *         if an I/O error occurs
     */
    private void writeCharacters(final byte[] characters)
    throws IOException {
        for (final byte character : characters)
            out.write(toUnsignedInt(character));

        lastWrittenCharacter = characters[characters.length - 1];
        outputLineLength += characters.length;
    }

    // documented in super class
    @Override
    public void flush()
    throws IOException {
        out.flush();
    }

    // documented in super class
    @Override
    public void close()
    throws IOException {
        flush();
        out.close();
    }

    /**
     * Writes a soft line break to the target output stream.
     *
     * @throws IOException
     *         if an I/O exception occurs
     */
    private void writeSoftLineBreak()
    throws IOException {
        out.write('=');
        writeCrlf();
    }

    /**
     * Writes a carriage return and line feed to the target output stream.
     *
     * @throws IOException
     *         if an I/O exception occurs
     */
    private void writeCrlf()
    throws IOException {
        out.write('\r');
        out.write('\n');
        outputLineLength = 0;
        lastWrittenCharacter = '\n';
    }
}
