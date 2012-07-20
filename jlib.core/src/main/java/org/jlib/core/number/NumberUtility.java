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

package org.jlib.core.number;

/**
 * Utility class providing static methods for number operations and
 * manipulations.
 * 
 * @author Igor Akkerman
 */
public final class NumberUtility {

    /** hexadecimal digit characters */
    public static final char[] HEX_DIGIT_CHARACTERS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
                                                       'C', 'D', 'E', 'F' };

    /** no visible constructor */
    private NumberUtility() {}

    /**
     * Parses a hexadecimal digit of the specified character.
     * 
     * @param hexDigitCharacter
     *        character holding a hexadecimal digit
     * 
     * @return byte holding the value of hexDigitCharacter
     * 
     * @throws NumberFormatException
     *         if {@code hexDigitCharacter} does not hold a hexadecimal digit
     */
    public static byte parseHexDigit(final char hexDigitCharacter)
    throws NumberFormatException {
        if (hexDigitCharacter >= '0' && hexDigitCharacter <= '9')
            return (byte) (hexDigitCharacter - '0');

        if (hexDigitCharacter >= 'A' && hexDigitCharacter <= 'F')
            return (byte) (hexDigitCharacter - 'A' + 10);

        if (hexDigitCharacter >= 'a' && hexDigitCharacter <= 'f')
            return (byte) (hexDigitCharacter - 'a' + 10);

        throw new NumberFormatException(Character.toString(hexDigitCharacter));
    }

    /**
     * Creates a binary 8-bit String representation of the specified byte padded
     * with zeroes. The bit order is big-endian, that is, the most significant
     * bit first, as usual in both big-endian and little-endian byte order
     * systems.
     * 
     * @param bite
     *        byte to represent as a binary String
     * 
     * @return binary String representation of {@code bite}
     */
    public static String toBinaryString(final byte bite) {
        final StringBuilder bitStringBuilder = new StringBuilder(8);

        for (int digitIndex = 7; digitIndex >= 0; digitIndex --)
            bitStringBuilder.append(bite >> digitIndex & 1);

        return bitStringBuilder.toString();
    }

    /**
     * Creates a binary 32-bit String representation of the specified integer
     * padded with zeroes. The bit order is big-endian, that is, the most
     * significant bit first.
     * 
     * @param value
     *        integer to represent as a binary String
     * 
     * @return binary String representation of {@code integer}
     */
    public static String toBinaryString(final int value) {
        final StringBuilder bitStringBuilder = new StringBuilder(32);

        for (int digitIndex = 31; digitIndex >= 0; digitIndex --)
            bitStringBuilder.append(value >> digitIndex & 1);

        return bitStringBuilder.toString();
    }

    /**
     * Verifies whether the specified integer is even.
     * 
     * @param number
     *        integer to verify
     * 
     * @return {@code true} if {@code number} is even; {@code false} if
     *         {@code number} is odd
     */
    public static boolean isEven(final int number) {
        return (number & 1) == 0;
    }

    /**
     * Verifies whether the specified integer is odd.
     * 
     * @param number
     *        integer to verify
     * 
     * @return {@code true} if {@code number} is odd; {@code false} if
     *         {@code number} is even
     */
    public static boolean isOdd(final int number) {
        return (number & 1) == 1;
    }
}
