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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.jlib.core.number.NumberUtility.isEven;
import static org.jlib.core.number.NumberUtility.isOdd;
import static org.jlib.core.number.NumberUtility.parseHexDigit;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class NumberUtilityTest {

    @Test
    public void testParseHexDigit0() {
        assertThat((byte) 0, is(equalTo(parseHexDigit('0'))));
    }

    @Test
    public void testParseHexDigit1() {
        assertThat((byte) 1, is(equalTo(parseHexDigit('1'))));
    }

    @Test
    public void testParseHexDigit2() {
        assertThat((byte) 2, is(equalTo(parseHexDigit('2'))));
    }

    @Test
    public void testParseHexDigit3() {
        assertThat((byte) 3, is(equalTo(parseHexDigit('3'))));
    }

    @Test
    public void testParseHexDigit4() {
        assertThat((byte) 4, is(equalTo(parseHexDigit('4'))));
    }

    @Test
    public void testParseHexDigit5() {
        assertThat((byte) 5, is(equalTo(parseHexDigit('5'))));
    }

    @Test
    public void testParseHexDigit6() {
        assertThat((byte) 6, is(equalTo(parseHexDigit('6'))));
    }

    @Test
    public void testParseHexDigit7() {
        assertThat((byte) 7, is(equalTo(parseHexDigit('7'))));
    }

    @Test
    public void testParseHexDigit8() {
        assertThat((byte) 8, is(equalTo(parseHexDigit('8'))));
    }

    @Test
    public void testParseHexDigit9() {
        assertThat((byte) 9, is(equalTo(parseHexDigit('9'))));
    }

    @Test
    public void testParseHexDigitA() {
        assertThat((byte) 10, is(equalTo(parseHexDigit('A'))));
    }

    @Test
    public void testParseHexDigitB() {
        assertThat((byte) 11, is(equalTo(parseHexDigit('B'))));
    }

    @Test
    public void testParseHexDigitC() {
        assertThat((byte) 12, is(equalTo(parseHexDigit('C'))));
    }

    @Test
    public void testParseHexDigitD() {
        assertThat((byte) 13, is(equalTo(parseHexDigit('D'))));
    }

    @Test
    public void testParseHexDigitE() {
        assertThat((byte) 14, is(equalTo(parseHexDigit('E'))));
    }

    @Test
    public void testParseHexDigitF() {
        assertThat((byte) 15, is(equalTo(parseHexDigit('F'))));
    }

    @Test
    public void testParseHexDigitSmallA() {
        assertThat((byte) 10, is(equalTo(parseHexDigit('a'))));
    }

    @Test
    public void testParseHexDigitSmallB() {
        assertThat((byte) 11, is(equalTo(parseHexDigit('b'))));
    }

    @Test
    public void testParseHexDigitSmallC() {
        assertThat((byte) 12, is(equalTo(parseHexDigit('c'))));
    }

    @Test
    public void testParseHexDigitSmallD() {
        assertThat((byte) 13, is(equalTo(parseHexDigit('d'))));
    }

    @Test
    public void testParseHexDigitSmallE() {
        assertThat((byte) 14, is(equalTo(parseHexDigit('e'))));
    }

    @Test
    public void testParseHexDigitSmallF() {
        assertThat((byte) 15, is(equalTo(parseHexDigit('f'))));
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
        assertThat(isEven(0), is(true));
    }

    @Test
    public final void testIsEven1() {
        assertThat(isEven(1), is(false));
    }

    @Test
    public final void testIsEven2() {
        assertThat(isEven(2), is(true));
    }

    @Test
    public final void testIsEvenMinus1() {
        assertThat(isEven(- 1), is(false));
    }

    @Test
    public final void testIsEvenMinus2() {
        assertThat(isEven(- 2), is(true));
    }

    @Test
    public final void testIsOdd() {
        assertThat(isOdd(0), is(false));
    }

    @Test
    public final void testIsOdd1() {
        assertThat(isOdd(1), is(true));
    }

    @Test
    public final void testIsOdd2() {
        assertThat(isOdd(2), is(false));
    }

    @Test
    public final void testIsOddMinus1() {
        assertThat(isOdd(- 1), is(true));
    }

    @Test
    public final void testIsOddMinus2() {
        assertThat(isOdd(- 2), is(false));
    }
}
