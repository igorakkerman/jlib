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
 *    http://www.eclipse.org/legal/cpl-v10.html
 */

package org.jlib.core.io;

import static org.jlib.core.number.NumberUtility.parseHexDigit;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Utility class providing static methods for input/output operations.
 * 
 * @author Igor Akkerman
 */
public abstract class IOUtility {

    /** no visible constructor */
    private IOUtility() {
        // no visible constructor
    }
    
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
    throws NumberFormatException {
        return parseHexNumberAsByte(hexCharacters, 0);
    }

    /**
     * Parses a hexadecimal signed byte value at the specified offst in
     * specified array containing the two hexadecimal digit characters as bytes.
     * The character order is assumed to be big-endian, that is,
     * {@code hexCharacter[offset]} holds the most significant hexadecimal
     * character.
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
    throws NumberFormatException {
        return (byte) (parseHexDigit((char) hexCharacters[offset]) << 4 | parseHexDigit((char) hexCharacters[offset + 1]));
    }
}
