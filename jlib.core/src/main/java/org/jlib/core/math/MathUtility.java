/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

package org.jlib.core.math;

/**
 * Utility providing mathematical operations.
 * 
 * @author Igor Akkerman
 */
public final class MathUtility {

    /** no visible constructor */
    private MathUtility() {}

    /**
     * Returns the number of numbers between a minimum and a maximum number,
     * both inclusive.
     * 
     * @param minimum
     *        integer specifying the minimum number
     * 
     * @param maximum
     *        integer specifying the maximum number
     * 
     * @return {@code maximum - minimum + 1}
     */
    public static int count(final int minimum, final int maximum) {
        return maximum - minimum + 1;
    }
}
