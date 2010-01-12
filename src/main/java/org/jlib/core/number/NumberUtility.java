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

import org.jlib.core.string.StringUtility;

import static org.jlib.core.string.StringUtility.PaddingType.FRONT;

/**
 * Utility class providing static methods for number operations and
 * manipulations.
 * 
 * @author Igor Akkerman
 */
public final class NumberUtility {

    /** hexadecimal digit characters */
    public static final char[] HEX_DIGIT_CHARACTERS =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /** no visible constructor */
    private NumberUtility() {}

    /**
     * Parses a hexadecimal digit of the specified character.
     * 
     * @param hexDigitCharacter
     *        character holding a hexadecimal digit
     * @return byte holding the value of hexDigitCharacter
     * @throws NumberFormatException
     *         if {@code hexDigitCharacter} does not hold a hexadecimal digit
     */
    public static byte parseHexDigit(char hexDigitCharacter) {
        if (hexDigitCharacter >= '0' && hexDigitCharacter <= '9')
            return (byte) (hexDigitCharacter - '0');
        else if (hexDigitCharacter >= 'A' && hexDigitCharacter <= 'F')
            return (byte) (hexDigitCharacter - 'A' + 10);
        else if (hexDigitCharacter >= 'a' && hexDigitCharacter <= 'f')
            return (byte) (hexDigitCharacter - 'a' + 10);
        else
            throw new NumberFormatException(Character.toString(hexDigitCharacter));
    }

    /**
     * Represents the specified integer to a String padded with the blank
     * character at the front to the specified length.
     * 
     * @param integer
     *        integer to represent as a padded String
     * @param length
     *        integer specifying the desired length of the String
     * @return padded String. If {@code string.length() >= length} then {@code
     *         string} is returned.
     */
    public static String toPaddedString(int integer, int length) {
        return StringUtility.pad(Integer.toString(integer), length, ' ', FRONT);
    }

    /**
     * Creates a binary String representation of the specified byte padded with
     * zeroes. The bit order is big-endian, that is, the most significant bit
     * first, as usual in both big-endian and little-endian byte order systems.
     * 
     * @param bite
     *        byte to represent as a binary String
     * @return binary String representation of {@code bite}
     */
    public static String toBinaryString(byte bite) {
        StringBuilder bitStringBuilder = new StringBuilder(8);

        for (int digitIndex = 7; digitIndex >= 0; digitIndex --)
            bitStringBuilder.append((bite >> digitIndex) & 1);

        return bitStringBuilder.toString();
    }

    /**
     * Creates a binary String representation of the specified integer padded
     * with zeroes. The bit order is big-endian, that is, the most significant
     * bit first.
     * 
     * @param integer
     *        integer to represent as a binary String
     * @return binary String representation of {@code integer}
     */
    public static String toBinaryString(int integer) {
        StringBuilder bitStringBuilder = new StringBuilder(32);

        for (int digitIndex = 31; digitIndex >= 0; digitIndex --)
            bitStringBuilder.append((integer >> digitIndex) & 1);

        return bitStringBuilder.toString();
    }

    /**
     * Returns whether the specified integer is even.
     * 
     * @param number integer to verify
     * 
     * @return {@code true} if {@code number} is even; {@code false} if {@code
     *         number} is odd
     */
    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    /**
     * Returns whether the specified integer is odd.
     * 
     * @param number integer to verify
     * 
     * @return {@code true} if {@code number} is odd; {@code false} if {@code
     *         number} is even
     */
    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
