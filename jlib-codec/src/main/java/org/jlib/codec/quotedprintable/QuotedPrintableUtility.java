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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.jlib.io.IOUtility.parseHexNumberAsByte;
import static org.jlib.io.IOUtility.toUnsignedInt;
import static org.jlib.core.text.number.NumberUtility.HEX_DIGIT_CHARACTERS;

/**
 * Utility class for quoted-printable encoding operations.
 *
 * @author Igor Akkerman
 */
public final class QuotedPrintableUtility {

    /** no visible constructor */
    private QuotedPrintableUtility() {}

    /**
     * Encodes the specified byte array using quoted printable encoding.
     *
     * @param inputBytes
     *        array of bytes containing the bytes to encode
     * @return String containing the quoted-printable encoded output of {@code inputBytes}
     * @throws IOException
     *         if an i/o exception occurs
     */
    public static String encodeQuotedPrintable(byte[] inputBytes)
    throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStream qpOutputStream = new QuotedPrintableOutputStream(outputStream);

        qpOutputStream.write(inputBytes);
        qpOutputStream.flush();
        qpOutputStream.close();

        return outputStream.toString();
    }

    /**
     * Decodes the specified String using quoted-printable decoding.
     *
     * @param qpString
     *        quoted-printable encoded String
     * @return array of decoded bytes from {@code qpString}
     * @throws IOException
     *         if an i/o exception occurs
     */
    public static byte[] decodeQuotedPrintable(String qpString)
    throws IOException {
        InputStream inputStream = new ByteArrayInputStream(qpString.getBytes());
        InputStream qpInputStream = new QuotedPrintableInputStream(inputStream);

        byte[] readBytes = new byte[1024];

        int length = qpInputStream.read(readBytes);
        if (length == -1) {
            length = 0;
        }
        qpInputStream.close();

        byte[] outputBytes = new byte[length];
        for (int i = 0; i < length; i ++) {
            outputBytes[i] = readBytes[i];
        }

        return outputBytes;
    }

    /**
     * Creates an octet for the specified value.
     *
     * @param value
     *        byte holding the value of the octet to create
     * @return array of bytes containing the octet characters
     */
    public static byte[] createOctet(byte value) {
        int intValue = toUnsignedInt(value);

        byte[] octet = new byte[3];
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
     * @return byte containing the octet value
     * @throws IllegalQuotedPrintableOctetException
     *         if illegal characters follow the encoding prefix
     */
    public static byte decodeOctet(byte[] octetBytes)
    throws IllegalQuotedPrintableOctetException {
        try {
            return parseHexNumberAsByte(octetBytes, 1);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalQuotedPrintableOctetException(octetBytes[1], octetBytes[2]);
        }
    }

}
