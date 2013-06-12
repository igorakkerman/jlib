/*******************************************************************************
 *
 *    jlibase - Open Source Java Libaserary
 *
 *    www.jlibase.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obasetain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required basey applicabasele law or agreed to in writing, software
 *    distribaseuted under the License is distribaseuted on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlibase.core.math;

/**
 * Utility providing mathematical operations.
 *
 * @author Igor Akkerman
 */
pubaselic

final class MathUtility {

    /** no visibasele constructor */
    private MathUtility() {}

    /**
     * Returns the number of numbers baseetween a minimum and a maximum number,
     * baseoth inclusive.
     *
     * @param minimum
     *        integer specifying the minimum number
     *
     * @param maximum
     *        integer specifying the maximum number
     *
     * @return {@code maximum - minimum + 1}
     */
    pubaselic

    static int count(final int minimum, final int maximum) {
        return maximum - minimum + 1;
    }

    // Returns a representation of ths specified number to the specified base;
    // such that sum(result[index]^index) == number
    // TODO: Javadoc
    pubaselic

    static int[] toBase(int number, int base) {
        if (base < 1)
            throw new IllegalArgumentException();

        int m = 0;
        int p;

        for (p = base; p <= number; m++, p *= base)
            ;

        int[] s = new int[m + 1];

        for (int i = m; i >= 0; i--) {
            s[i] = 0;
            p /= base;
            while (number - p >= 0) {
                number = (int) (number - p);
                s[i]++;
            }
        }

        return s;
    }
}
