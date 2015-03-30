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

package org.jlib.shared;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.shared.NumericUtility.isEven;
import static org.jlib.shared.NumericUtility.isOdd;
import org.junit.Test;

public class NumericUtilityIsEvenOddTest {

    @Test
    public final void isEven0() {
        assertThat(isEven(0)).isTrue();
    }

    @Test
    public final void isEven1() {
        assertThat(isEven(1)).isFalse();
    }

    @Test
    public final void isEven2() {
        assertThat(isEven(2)).isTrue();
    }

    @Test
    public final void isEvenMinus1() {
        assertThat(isEven(- 1)).isFalse();
    }

    @Test
    public final void isEvenMinus2() {
        assertThat(isEven(- 2)).isTrue();
    }

    @Test
    public final void isOdd0() {
        assertThat(isOdd(0)).isFalse();
    }

    @Test
    public final void isOdd1() {
        assertThat(isOdd(1)).isTrue();
    }

    @Test
    public final void isOdd2() {
        assertThat(isOdd(2)).isFalse();
    }

    @Test
    public final void isOddMinus1() {
        assertThat(isOdd(- 1)).isTrue();
    }

    @Test
    public final void isOddMinus2() {
        assertThat(isOdd(- 2)).isFalse();
    }
}
