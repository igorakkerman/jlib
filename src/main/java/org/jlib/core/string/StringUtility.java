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
public final class StringUtility {
    
    /** property name of the system's line separator */
    public static final String LINE_SEPARATOR_PROPERTYNAME = "line.separator";

    /** the system's line separator */
    public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_PROPERTYNAME); 

    /** String padding options */
    public static enum PaddingType {
        
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
    private StringUtility() {}

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

        StringBuilder stringBuilder = new StringBuilder(length);

        switch (paddingType) {
            case FRONT:
                for (; currentLength < length; currentLength ++)
                    stringBuilder.append(paddingCharacter);
                stringBuilder.append(string);
                break;
            case BACK:
                stringBuilder.append(string);
                for (; currentLength < length; currentLength ++)
                    stringBuilder.append(paddingCharacter);
                break;
            case FRONTBACK:
                halfLength = (currentLength + length + 1) / 2;
                for (; currentLength < halfLength; currentLength ++)
                    stringBuilder.append(paddingCharacter);
                stringBuilder.append(string);
                for (; currentLength < length; currentLength ++)
                    stringBuilder.append(paddingCharacter);
                break;
            case BACKFRONT:
                halfLength = (currentLength + length) / 2;
                for (; currentLength < halfLength; currentLength ++)
                    stringBuilder.append(paddingCharacter);
                stringBuilder.append(string);
                for (; currentLength < length; currentLength ++)
                    stringBuilder.append(paddingCharacter);
        }
        return stringBuffer.toString();
    }

    public static String wrapOnWhitespace(String string, int lineWidth) {
        int stringLength = string.length();
        if (stringLength <= lineWidth)
            return string;

        StringBuilder stringBuilder = new StringBuilder(stringLength << 1);
        
        try {
        stringBuilder.append();
        
        int nextWhitespaceIndex;
        
        nextWhitespaceIndex = indexOfWhitespace(string, whitespaceIndex + 1, endIndex);

        
        
        
        int nextLIne
        for (int whitespaceIndex = 0; whitespaceIndex < stringLength; whitespaceIndex ++) {
            newWhitespaceIndex = subStringUntilNextWhitespace(stringBuilder, string, whitespaceIndex, );
            if (newWhitespaceIndex != whitespaceIndex) { 
                stringBuilder.append(LINE_SEPARATOR);
                whitespaceIndex = newWhitespaceIndex;
            }
        }

        return stringBuilder.toString();
    }
    private static int indexOfWhitespace(String string, int startIndex, int endIndex)
    throws NoWhitespaceCharacterException, NullPointerException, IndexOutOfBoundsException {
        for (int stringIndex = startIndex; stringIndex <= endIndex; stringIndex ++) {
            if (Character.isWhitespace(string.charAt(stringIndex)))
                return stringIndex;
        }
        throw new NoWhitespaceCharacterException();
    }

    public int subStringUntilNextWhitespace(StringBuilder stringBuilder, String string, int startIndex,
    int maximumLength) {
        int overIndex = Math.min(string.length(), startIndex + maximumLength);
        char character;
        int stringIndex;
        for (stringIndex = startIndex; stringIndex < overIndex; stringIndex ++) {
            character = string.charAt(stringIndex);
            if (Character.isWhitespace(character))
                return stringIndex;
            stringBuilder.append(character);
        }
        return stringIndex - 1;
    }

    private interface State {

        public int go(StringBuilder stringBuilder, String string, int startIndex, int maximumLength);
    }

    private class LineStart
    implements State {
        public int go(StringBuilder stringBuilder, String string, int startIndex, int maximumLength) {};
    }
    }

    private class LineMiddle
    implements State {

    }

    private class dingsResult {

        private int lastReadCharacterIndex;

        private State nextState();
    }
}
