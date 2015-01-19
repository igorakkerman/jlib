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



package org.jlib.io;

import java.io.InputStream;
import java.io.OutputStream;

import static org.jlib.core.number.NumberUtility.parseHexDigit;

/**
 * Utility class providing static methods for input/output operations.
 * 
 * @author Igor Akkerman
 */
public final class IOUtility {

    /** no visible constructor */
    private IOUtility() {}

    /**
     * <p>
     * Converts the specified signed byte value into an unsigned integer value
     * taking in account the sign of the byte.
     * </p>
     * <p>
     * Many stream operations like the {@link OutputStream#write(int)} method
     * require a byte to be specified by an integer. Using this method, an
     * unsigned byte can be converted into such an integer.
     * </p>
     * 
     * @param signedByte
     *        the signed byte value (-128 to 127)
     * @return the unsigned integer value (0 to 255)
     */
    public static int toUnsignedInt(byte signedByte) {
        return signedByte >= 0 ? signedByte : signedByte + 256;
    }

    /**
     * <p>
     * Converts the specified unsigned integer value into an signed byte value
     * taking in account the sign of the byte.
     * </p>
     * <p>
     * The {@link InputStream#read() read()} method of the {@link InputStream}
     * class returns a byte as an integer. Using this method, such an integer
     * can be converted into a signed byte.
     * </p>
     * <p>
     * This method has the same functionality as a simple cast to a byte.
     * </p>
     * 
     * @param unsignedInt
     *        the unsigned integer value of a signed byte (0 to 255). The 24
     *        higher-order bits of this integer are ignored.
     * @return the signed byte value (-128 to 127)
     */
    public static byte toSignedByte(int unsignedInt) {
        return (byte) unsignedInt;
        // identical functionality to:
        // return (byte) (unsignedInt <= 127 ? unsignedInt : unsignedInt - 256);
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
    public static byte parseHexNumberAsByte(byte[] hexCharacters)
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
    public static byte parseHexNumberAsByte(byte[] hexCharacters, int offset)
    throws ArrayIndexOutOfBoundsException, NumberFormatException {
        return (byte) (parseHexDigit((char) hexCharacters[offset]) << 4 | parseHexDigit((char) hexCharacters[offset + 1]));
    }
}
