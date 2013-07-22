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

import org.junit.Test;

import static org.jlib.core.number.NumberUtility.isEven;
import static org.jlib.core.number.NumberUtility.isOdd;
import static org.jlib.core.number.NumberUtility.parseHexDigit;
import static org.junit.Ensure.ensureEquals;
import static org.junit.Ensure.ensureFalse;
import static org.junit.Ensure.ensureTrue;

public class NumberUtilityTest {

    @Test
    public void testParseHexDigit0() {
        ensureEquals(0, parseHexDigit('0'));
    }

    @Test
    public void testParseHexDigit1() {
        ensureEquals(1, parseHexDigit('1'));
    }

    @Test
    public void testParseHexDigit2() {
        ensureEquals(2, parseHexDigit('2'));
    }

    @Test
    public void testParseHexDigit3() {
        ensureEquals(3, parseHexDigit('3'));
    }

    @Test
    public void testParseHexDigit4() {
        ensureEquals(4, parseHexDigit('4'));
    }

    @Test
    public void testParseHexDigit5() {
        ensureEquals(5, parseHexDigit('5'));
    }

    @Test
    public void testParseHexDigit6() {
        ensureEquals(6, parseHexDigit('6'));
    }

    @Test
    public void testParseHexDigit7() {
        ensureEquals(7, parseHexDigit('7'));
    }

    @Test
    public void testParseHexDigit8() {
        ensureEquals(8, parseHexDigit('8'));
    }

    @Test
    public void testParseHexDigit9() {
        ensureEquals(9, parseHexDigit('9'));
    }

    @Test
    public void testParseHexDigitA() {
        ensureEquals(10, parseHexDigit('A'));
    }

    @Test
    public void testParseHexDigitB() {
        ensureEquals(11, parseHexDigit('B'));
    }

    @Test
    public void testParseHexDigitC() {
        ensureEquals(12, parseHexDigit('C'));
    }

    @Test
    public void testParseHexDigitD() {
        ensureEquals(13, parseHexDigit('D'));
    }

    @Test
    public void testParseHexDigitE() {
        ensureEquals(14, parseHexDigit('E'));
    }

    @Test
    public void testParseHexDigitF() {
        ensureEquals(15, parseHexDigit('F'));
    }

    @Test
    public void testParseHexDigitSmallA() {
        ensureEquals(10, parseHexDigit('a'));
    }

    @Test
    public void testParseHexDigitSmallB() {
        ensureEquals(11, parseHexDigit('b'));
    }

    @Test
    public void testParseHexDigitSmallC() {
        ensureEquals(12, parseHexDigit('c'));
    }

    @Test
    public void testParseHexDigitSmallD() {
        ensureEquals(13, parseHexDigit('d'));
    }

    @Test
    public void testParseHexDigitSmallE() {
        ensureEquals(14, parseHexDigit('e'));
    }

    @Test
    public void testParseHexDigitSmallF() {
        ensureEquals(15, parseHexDigit('f'));
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
        ensureTrue(isEven(0));
    }

    @Test
    public final void testIsEven1() {
        ensureFalse(isEven(1));
    }

    @Test
    public final void testIsEven2() {
        ensureTrue(isEven(2));
    }

    @Test
    public final void testIsEvenMinus1() {
        ensureFalse(isEven(- 1));
    }

    @Test
    public final void testIsEvenMinus2() {
        ensureTrue(isEven(- 2));
    }

    @Test
    public final void testIsOdd() {
        ensureFalse(isOdd(0));
    }

    @Test
    public final void testIsOdd1() {
        ensureTrue(isOdd(1));
    }

    @Test
    public final void testIsOdd2() {
        ensureFalse(isOdd(2));
    }

    @Test
    public final void testIsOddMinus1() {
        ensureTrue(isOdd(- 1));
    }

    @Test
    public final void testIsOddMinus2() {
        ensureFalse(isOdd(- 2));
    }
}
