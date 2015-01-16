/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.core.number.NumberUtility.isEven;
import static org.jlib.core.number.NumberUtility.isOdd;
import static org.jlib.core.number.NumberUtility.parseHexDigit;
import org.junit.Test;

public class NumberUtilityTest {

    @Test
    public void testParseHexDigit0() {
        assertThat(parseHexDigit('0')).isEqualTo((byte) 0);
    }

    @Test
    public void testParseHexDigit1() {
        assertThat(parseHexDigit('1')).isEqualTo((byte) 1);
    }

    @Test
    public void testParseHexDigit2() {
        assertThat(parseHexDigit('2')).isEqualTo((byte) 2);
    }

    @Test
    public void testParseHexDigit3() {
        assertThat(parseHexDigit('3')).isEqualTo((byte) 3);
    }

    @Test
    public void testParseHexDigit4() {
        assertThat(parseHexDigit('4')).isEqualTo((byte) 4);
    }

    @Test
    public void testParseHexDigit5() {
        assertThat(parseHexDigit('5')).isEqualTo((byte) 5);
    }

    @Test
    public void testParseHexDigit6() {
        assertThat(parseHexDigit('6')).isEqualTo((byte) 6);
    }

    @Test
    public void testParseHexDigit7() {
        assertThat(parseHexDigit('7')).isEqualTo((byte) 7);
    }

    @Test
    public void testParseHexDigit8() {
        assertThat(parseHexDigit('8')).isEqualTo((byte) 8);
    }

    @Test
    public void testParseHexDigit9() {
        assertThat(parseHexDigit('9')).isEqualTo((byte) 9);
    }

    @Test
    public void testParseHexDigitA() {
        assertThat(parseHexDigit('A')).isEqualTo((byte) 10);
    }

    @Test
    public void testParseHexDigitB() {
        assertThat(parseHexDigit('B')).isEqualTo((byte) 11);
    }

    @Test
    public void testParseHexDigitC() {
        assertThat(parseHexDigit('C')).isEqualTo((byte) 12);
    }

    @Test
    public void testParseHexDigitD() {
        assertThat(parseHexDigit('D')).isEqualTo((byte) 13);
    }

    @Test
    public void testParseHexDigitE() {
        assertThat(parseHexDigit('E')).isEqualTo((byte) 14);
    }

    @Test
    public void testParseHexDigitF() {
        assertThat(parseHexDigit('F')).isEqualTo((byte) 15);
    }

    @Test
    public void testParseHexDigitSmallA() {
        assertThat(parseHexDigit('a')).isEqualTo((byte) 10);
    }

    @Test
    public void testParseHexDigitSmallB() {
        assertThat(parseHexDigit('b')).isEqualTo((byte) 11);
    }

    @Test
    public void testParseHexDigitSmallC() {
        assertThat(parseHexDigit('c')).isEqualTo((byte) 12);
    }

    @Test
    public void testParseHexDigitSmallD() {
        assertThat(parseHexDigit('d')).isEqualTo((byte) 13);
    }

    @Test
    public void testParseHexDigitSmallE() {
        assertThat(parseHexDigit('e')).isEqualTo((byte) 14);
    }

    @Test
    public void testParseHexDigitSmallF() {
        assertThat(parseHexDigit('f')).isEqualTo((byte) 15);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseHexDigitG() {
        parseHexDigit('G');
    }

    @Test(expected = NumberFormatException.class)
    public void testParseHexDigitSmallG() {
        parseHexDigit('g');
    }

    @Test(expected = NumberFormatException.class)
    public void testParseHexDigitPlus() {
        parseHexDigit('+');
    }

    @Test(expected = NumberFormatException.class)
    public void testParseHexDigitMinus() {
        parseHexDigit('-');
    }

    @Test
    public final void testIsEven0() {
        assertThat(isEven(0)).isTrue();
    }

    @Test
    public final void testIsEven1() {
        assertThat(isEven(1)).isFalse();
    }

    @Test
    public final void testIsEven2() {
        assertThat(isEven(2)).isTrue();
    }

    @Test
    public final void testIsEvenMinus1() {
        assertThat(isEven(- 1)).isFalse();
    }

    @Test
    public final void testIsEvenMinus2() {
        assertThat(isEven(- 2)).isTrue();
    }

    @Test
    public final void testIsOdd() {
        assertThat(isOdd(0)).isFalse();
    }

    @Test
    public final void testIsOdd1() {
        assertThat(isOdd(1)).isTrue();
    }

    @Test
    public final void testIsOdd2() {
        assertThat(isOdd(2)).isFalse();
    }

    @Test
    public final void testIsOddMinus1() {
        assertThat(isOdd(- 1)).isTrue();
    }

    @Test
    public final void testIsOddMinus2() {
        assertThat(isOdd(- 2)).isFalse();
    }
}
