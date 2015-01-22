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

public class BinaryUtility {

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

        for (int digitIndex = 7; digitIndex >= 0; digitIndex--)
            bitStringBuilder.append(bite >> digitIndex & 1);

        return bitStringBuilder.toString();
    }

    /**
     * Creates a binary 32-bit String representation of the specified integer
     * padded with zeroes. The bit order is big-endian, that is, the most
     * significant bit first. The
     *
     * @param value
     *        integer to represent as a binary String
     *
     * @return binary String representation of {@code integer}
     */
    public static String toBinaryString(final int value) {
        final StringBuilder bitStringBuilder = new StringBuilder(32);

        for (int digitIndex = 31; digitIndex >= 0; digitIndex--)
            bitStringBuilder.append(value >> digitIndex & 1);

        return bitStringBuilder.toString();
    }

    private BinaryUtility() {}
}
