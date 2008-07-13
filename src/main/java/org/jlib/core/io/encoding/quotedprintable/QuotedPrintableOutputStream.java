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
package org.jlib.core.io.encoding.quotedprintable;

import static org.jlib.core.io.IOUtility.toSignedByte;
import static org.jlib.core.io.IOUtility.toUnsignedInt;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
    public QuotedPrintableOutputStream(OutputStream targetOutputStream) {
        super(targetOutputStream);
    }

    // @see java.io.FilterOutputStream#write(int)
    @Override
    public void write(int b)
    throws IOException {
        byte value = toSignedByte(b);

        // if the character may be represented as a literal
        if (value >= 33 && value <= 60 || value >= 62 && value <= 126 || value == 9 || value == 32) {
            if (outputLineLength >= MAXOUTPUTLINELENGTH - 1) {
                writeSoftLineBreak();
            }
            writeCharacter(value);
        }

        // if a CR is to be represented
        else if (value == '\r') {
            // intentionally left blank
        }
        else if (value == '\n') {
            if (lastWrittenCharacter == 9 || lastWrittenCharacter == 32) {
                writeSoftLineBreak();
            }
            writeCRLF();
        }

        // if the character is to be represented as an octet
        else {
            if (outputLineLength >= MAXOUTPUTLINELENGTH - 3) {
                writeSoftLineBreak();
            }
            writeCharacters(QuotedPrintableUtility.createOctet(value));
        }
    }

    // @see java.io.FilterOutputStream#write(byte[], int, int)
    @Override
    public void write(byte[] buffer, int offset, int length)
    throws IOException {
        for (int i = offset, j = 0; j < length; i ++, j ++) {
            write(toUnsignedInt(buffer[i]));
        }
    }

    /**
     * Writes the specified character to the target output stream.
     * 
     * @param character
     *        byte specifying the character to write
     * @throws IOException
     *         if an I/O error occurs
     */
    private void writeCharacter(byte character)
    throws IOException {
        out.write(toUnsignedInt(character));
        lastWrittenCharacter = character;
        outputLineLength ++;
    }

    /**
     * Writes the specified characters to the target output stream.
     * 
     * @param characters
     *        byte array containing the characters to write
     * @throws IOException
     *         if an I/O error occurs
     */
    private void writeCharacters(byte[] characters)
    throws IOException {
        for (int i = 0; i < characters.length; i ++) {
            out.write(toUnsignedInt(characters[i]));
        }
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
        writeCRLF();
    }

    /**
     * Writes a carriage return and line feed to the target output stream.
     * 
     * @throws IOException
     *         if an I/O exception occurs
     */
    private void writeCRLF()
    throws IOException {
        out.write('\r');
        out.write('\n');
        outputLineLength = 0;
        lastWrittenCharacter = '\n';
    }
}
