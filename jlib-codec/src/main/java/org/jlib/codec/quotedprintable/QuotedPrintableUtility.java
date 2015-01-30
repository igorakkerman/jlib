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

import static org.jlib.codec.number.HexadecimalUtility.HEX_DIGIT_CHARACTERS;
import static org.jlib.codec.number.HexadecimalUtility.parseHexNumberAsByte;
import static org.jlib.core.io.StreamUtility.toUnsignedInt;

public final class QuotedPrintableUtility {

    /**
     * Creates an octet for the specified value.
     *
     * @param value
     *        byte holding the value of the octet to create
     *
     * @return array of bytes containing the octet characters
     */
    public static byte[] createOctet(final byte value) {
        final int intValue = toUnsignedInt(value);

        final byte[] octet = new byte[3];
        octet[0] = '=';
        octet[1] = (byte) HEX_DIGIT_CHARACTERS[(intValue & 0xF0) >> 4];
        octet[2] = (byte) HEX_DIGIT_CHARACTERS[intValue & 0x0F];

        return octet;
    }

    /**
     * Decodes an encoded octet from the specified array of bytes.
     *
     * @param octetBytes
     *        array of bytes containing an octet
     *
     * @return byte containing the octet value
     *
     * @throws InvalidQuotedPrintableOctetException
     *         if illegal characters follow the encoding prefix
     */
    public static byte decodeOctet(final byte[] octetBytes)
    throws InvalidQuotedPrintableOctetException {
        try {
            return parseHexNumberAsByte(octetBytes, 1);
        }
        catch (final NumberFormatException nfe) {
            throw new InvalidQuotedPrintableOctetException(octetBytes[1], octetBytes[2]);
        }
    }

    private QuotedPrintableUtility() {}
}
