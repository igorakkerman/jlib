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

package org.jlib.core.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.core.number.NumberUtility.parseHexDigit;
import org.junit.Test;

public class NumberUtilityParseHexDigitTest {

    @Test
    public void oarseHexDigit0() {
        assertThat(parseHexDigit('0')).isEqualTo((byte) 0);
    }

    @Test
    public void parseHexDigit1() {
        assertThat(parseHexDigit('1')).isEqualTo((byte) 1);
    }

    @Test
    public void parseHexDigit2() {
        assertThat(parseHexDigit('2')).isEqualTo((byte) 2);
    }

    @Test
    public void parseHexDigit3() {
        assertThat(parseHexDigit('3')).isEqualTo((byte) 3);
    }

    @Test
    public void parseHexDigit4() {
        assertThat(parseHexDigit('4')).isEqualTo((byte) 4);
    }

    @Test
    public void parseHexDigit5() {
        assertThat(parseHexDigit('5')).isEqualTo((byte) 5);
    }

    @Test
    public void parseHexDigit6() {
        assertThat(parseHexDigit('6')).isEqualTo((byte) 6);
    }

    @Test
    public void parseHexDigit7() {
        assertThat(parseHexDigit('7')).isEqualTo((byte) 7);
    }

    @Test
    public void parseHexDigit8() {
        assertThat(parseHexDigit('8')).isEqualTo((byte) 8);
    }

    @Test
    public void parseHexDigit9() {
        assertThat(parseHexDigit('9')).isEqualTo((byte) 9);
    }

    @Test
    public void parseHexDigitA() {
        assertThat(parseHexDigit('A')).isEqualTo((byte) 10);
    }

    @Test
    public void parseHexDigitB() {
        assertThat(parseHexDigit('B')).isEqualTo((byte) 11);
    }

    @Test
    public void parseHexDigitC() {
        assertThat(parseHexDigit('C')).isEqualTo((byte) 12);
    }

    @Test
    public void parseHexDigitD() {
        assertThat(parseHexDigit('D')).isEqualTo((byte) 13);
    }

    @Test
    public void parseHexDigitE() {
        assertThat(parseHexDigit('E')).isEqualTo((byte) 14);
    }

    @Test
    public void parseHexDigitF() {
        assertThat(parseHexDigit('F')).isEqualTo((byte) 15);
    }

    @Test(expected = NumberFormatException.class)
    public void parseHexDigitG() {
        parseHexDigit('G');
    }

    @Test
    public void parseHexDigitSmallA() {
        assertThat(parseHexDigit('a')).isEqualTo((byte) 10);
    }

    @Test
    public void parseHexDigitSmallB() {
        assertThat(parseHexDigit('b')).isEqualTo((byte) 11);
    }

    @Test
    public void parseHexDigitSmallC() {
        assertThat(parseHexDigit('c')).isEqualTo((byte) 12);
    }

    @Test
    public void parseHexDigitSmallD() {
        assertThat(parseHexDigit('d')).isEqualTo((byte) 13);
    }

    @Test
    public void parseHexDigitSmallE() {
        assertThat(parseHexDigit('e')).isEqualTo((byte) 14);
    }

    @Test
    public void parseHexDigitSmallF() {
        assertThat(parseHexDigit('f')).isEqualTo((byte) 15);
    }

    @Test(expected = NumberFormatException.class)
    public void parseHexDigitSmallG() {
        parseHexDigit('g');
    }

    @Test(expected = NumberFormatException.class)
    public void parseHexDigitPlus() {
        parseHexDigit('+');
    }

    @Test(expected = NumberFormatException.class)
    public void parseHexDigitMinus() {
        parseHexDigit('-');
    }
}
