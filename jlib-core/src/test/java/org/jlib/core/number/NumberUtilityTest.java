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
        assertThat((byte) 0).isEqualTo(parseHexDigit('0'));
    }

    @Test
    public void testParseHexDigit1() {
        assertThat((byte) 1).isEqualTo(parseHexDigit('1'));
    }

    @Test
    public void testParseHexDigit2() {
        assertThat((byte) 2).isEqualTo(parseHexDigit('2'));
    }

    @Test
    public void testParseHexDigit3() {
        assertThat((byte) 3).isEqualTo(parseHexDigit('3'));
    }

    @Test
    public void testParseHexDigit4() {
        assertThat((byte) 4).isEqualTo(parseHexDigit('4'));
    }

    @Test
    public void testParseHexDigit5() {
        assertThat((byte) 5).isEqualTo(parseHexDigit('5'));
    }

    @Test
    public void testParseHexDigit6() {
        assertThat((byte) 6).isEqualTo(parseHexDigit('6'));
    }

    @Test
    public void testParseHexDigit7() {
        assertThat((byte) 7).isEqualTo(parseHexDigit('7'));
    }

    @Test
    public void testParseHexDigit8() {
        assertThat((byte) 8).isEqualTo(parseHexDigit('8'));
    }

    @Test
    public void testParseHexDigit9() {
        assertThat((byte) 9).isEqualTo(parseHexDigit('9'));
    }

    @Test
    public void testParseHexDigitA() {
        assertThat((byte) 10).isEqualTo(parseHexDigit('A'));
    }

    @Test
    public void testParseHexDigitB() {
        assertThat((byte) 11).isEqualTo(parseHexDigit('B'));
    }

    @Test
    public void testParseHexDigitC() {
        assertThat((byte) 12).isEqualTo(parseHexDigit('C'));
    }

    @Test
    public void testParseHexDigitD() {
        assertThat((byte) 13).isEqualTo(parseHexDigit('D'));
    }

    @Test
    public void testParseHexDigitE() {
        assertThat((byte) 14).isEqualTo(parseHexDigit('E'));
    }

    @Test
    public void testParseHexDigitF() {
        assertThat((byte) 15).isEqualTo(parseHexDigit('F'));
    }

    @Test
    public void testParseHexDigitSmallA() {
        assertThat((byte) 10).isEqualTo(parseHexDigit('a'));
    }

    @Test
    public void testParseHexDigitSmallB() {
        assertThat((byte) 11).isEqualTo(parseHexDigit('b'));
    }

    @Test
    public void testParseHexDigitSmallC() {
        assertThat((byte) 12).isEqualTo(parseHexDigit('c'));
    }

    @Test
    public void testParseHexDigitSmallD() {
        assertThat((byte) 13).isEqualTo(parseHexDigit('d'));
    }

    @Test
    public void testParseHexDigitSmallE() {
        assertThat((byte) 14).isEqualTo(parseHexDigit('e'));
    }

    @Test
    public void testParseHexDigitSmallF() {
        assertThat((byte) 15).isEqualTo(parseHexDigit('f'));
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
