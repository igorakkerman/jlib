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

package org.jlib.codec.number;

public class HexadecimalUtility {

    /** hexadecimal digit characters */
    public static final char[] HEX_DIGIT_CHARACTERS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
                                                        'D', 'E', 'F' };

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
     * Parses a hexadecimal signed byte value out of the specified array
     * containing the two hexadecimal digit characters as bytes. The character
     * order is assumed to be big-endian, that is, {@code hexCharacter[offset]}
     * holds the most significant hexadecimal character.
     *
     * @param hexCharacters
     *        array of bytes containing the hexadecimal digit characters
     * @return byte specifying the parsed value
     * @throws ArrayIndexOutOfBoundsException
     *         if {@code hexCharacters.length < 2}
     * @throws NumberFormatException
     *         if the array contains illegal characters
     */
    public static byte parseHexNumberAsByte(final byte[] hexCharacters)
    throws ArrayIndexOutOfBoundsException, NumberFormatException {
        return parseHexNumberAsByte(hexCharacters, 0);
    }

    /**
     * Parses a hexadecimal signed byte value at the specified offst in
     * specified array containing the two hexadecimal digit characters as bytes.
     * The character order is assumed to be big-endian, that is, {@code
     * hexCharacter[offset]} holds the most significant hexadecimal character.
     *
     * @param hexCharacters
     *        array of bytes containing the hexadecimal digit characters
     * @param offset
     *        integer specifying the offset in the array to start from
     * @return byte specifying the parsed value
     * @throws ArrayIndexOutOfBoundsException
     *         if {@code offset + 2 > hexCharacters.length}
     * @throws NumberFormatException
     *         if the array contains illegal characters at the parsed indices
     */
    public static byte parseHexNumberAsByte(final byte[] hexCharacters, final int offset)
    throws ArrayIndexOutOfBoundsException, NumberFormatException {
        return (byte) (parseHexDigit((char) hexCharacters[offset]) << 4 |
                       parseHexDigit((char) hexCharacters[offset + 1]));
    }

    private HexadecimalUtility() {}
}
