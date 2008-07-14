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

package org.jlib.core.string;

/**
 * Utility class providing static methods for String operations and manipulations.
 * 
 * @author Igor Akkerman
 */
public class StringUtility {
    
    /** property name of the system's line separator */
    public static final String LINE_SEPARATOR_PROPERTYNAME = "line.separator";

    /** the system's line separator */
    public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_PROPERTYNAME); 

    /** String padding options */
    public enum PaddingType {
        
        /** front padding */
        FRONT,

        /** back padding */
        BACK,

        /**
         * equal front and back padding. If the number of characters to pad is odd, the front will
         * be padded with one character more than the back
         */
        FRONTBACK,

        /**
         * equal front and back padding. If the number of characters to pad is odd, the back will be
         * padded with one character more than the front
         */
        BACKFRONT
    }

    /** no visible constructor */
    private StringUtility() {
        // no visible constructor
    }

    /**
     * Pads the specified String with the blank character at the back to the specified length.
     * 
     * @param string
     *        String to pad
     * @param length
     *        integer specifying the desired length of the String
     * @return padded String. If {@code string.length() >= length} then {@code string} is returned.
     */
    public static String pad(String string, int length) {
        return pad(string, length, ' ', PaddingType.BACK);
    }

    /**
     * Pads the specified String with the blank character using the specified PaddingType to the
     * specified length.
     * 
     * @param string
     *        String to pad
     * @param length
     *        integer specifying the desired length of the String
     * @param paddingType
     *        PaddingType specifying how the string should be padded
     * @return padded String. If {@code string.length() >= length} then {@code string} is returned.
     */
    public static String pad(String string, int length, PaddingType paddingType) {
        return pad(string, length, ' ', paddingType);
    }

    /**
     * Pads the specified String with the specified character using the specified PaddingType to the
     * specified length.
     * 
     * @param string
     *        String to pad
     * @param length
     *        integer specifying the desired length of the String
     * @param paddingCharacter
     *        character used for padding
     * @param paddingType
     *        PaddingType specifying how the string should be padded
     * @return padded String. If {@code string.length() >= length} then {@code string} is returned.
     */
    public static String pad(String string, int length, char paddingCharacter, PaddingType paddingType) {
        int halfLength;

        int currentLength = string.length();

        if (currentLength >= length)
            return string;

        StringBuffer stringBuffer = new StringBuffer(length);

        switch (paddingType) {
            case FRONT:
                for (; currentLength < length; currentLength ++)
                    stringBuffer.append(paddingCharacter);
                stringBuffer.append(string);
                break;
            case BACK:
                stringBuffer.append(string);
                for (; currentLength < length; currentLength ++)
                    stringBuffer.append(paddingCharacter);
                break;
            case FRONTBACK:
                halfLength = (currentLength + length + 1) / 2;
                for (; currentLength < halfLength; currentLength ++)
                    stringBuffer.append(paddingCharacter);
                stringBuffer.append(string);
                for (; currentLength < length; currentLength ++)
                    stringBuffer.append(paddingCharacter);
                break;
            case BACKFRONT:
                halfLength = (currentLength + length) / 2;
                for (; currentLength < halfLength; currentLength ++)
                    stringBuffer.append(paddingCharacter);
                stringBuffer.append(string);
                for (; currentLength < length; currentLength ++)
                    stringBuffer.append(paddingCharacter);
        }
        return stringBuffer.toString();
    }

}
