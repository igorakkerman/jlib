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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Utility class providing base64 encoding operations.
 * 
 * @author Igor Akkerman
 */
public final class Base64Utility {

    /** base64 alphabet */
    public static final byte[] base64Alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /** base64 padding character */
    public static final byte PAD = '=';

    /** no visible constructor */
    private Base64Utility() {}

    /**
     * Encodes the specified byte array using base64 encoding.
     * 
     * @param inputBytes
     *        array of bytes containing the bytes to encode
     * @return String containing the base64 encoded output of {@code inputBytes}
     * @throws IOException
     *         if an i/o exception occurs
     */
    public static String encodeBase64(byte[] inputBytes)
    throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStream base64OutputStream = new Base64OutputStream(outputStream);

        base64OutputStream.write(inputBytes);
        base64OutputStream.flush();
        base64OutputStream.close();

        return outputStream.toString();
    }

    /**
     * Decodes the specified String using base64 decoding.
     * 
     * @param base64String
     *        base64 encoded String
     * @return array of decoded bytes from {@code base64String}
     * @throws IOException
     *         if an i/o exception occurs
     */
    public static byte[] decodeBase64(String base64String)
    throws IOException {
        InputStream inputStream = new ByteArrayInputStream(base64String.getBytes());
        InputStream base64InputStream = new Base64InputStream(inputStream);

        byte[] readBytes = new byte[1024];

        int len = base64InputStream.read(readBytes);
        if (len == -1) {
            len = 0;
        }
        base64InputStream.close();

        byte[] outputBytes = new byte[len];
        for (int i = 0; i < len; i ++) {
            outputBytes[i] = readBytes[i];
        }

        return outputBytes;
    }

    /**
     * Returns the value represented by the specified base64 character.
     * 
     * @param base64Character
     *        integer specifying the base64 character
     * @return integer value represented by {@code base64Char}; -1 if
     *         {@code base64Char} is the padding character
     * @throws IllegalBase64CharacterException
     *         if the specified character does not belong to the base64 alphabet
     */
    public static int mapBase64Character(int base64Character)
    throws IllegalBase64CharacterException {

        if (base64Character >= 'A' && base64Character <= 'Z') {
            return base64Character - 'A';
        }

        if (base64Character >= 'a' && base64Character <= 'z') {
            return base64Character - 'a' + 26;
        }

        if (base64Character >= '0' && base64Character <= '9') {
            return base64Character - '0' + 52;
        }

        switch (base64Character) {
            case '+':
                return 62;
            case '/':
                return 63;
            case '=':
                return -1;
        }

        throw new IllegalBase64CharacterException(base64Character);
    }
}
