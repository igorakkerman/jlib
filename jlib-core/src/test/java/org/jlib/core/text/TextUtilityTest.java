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

package org.jlib.core.text;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import static org.jlib.core.text.TextUtility.camelCaseToLowerCaseWords;
import static org.jlib.core.text.TextUtility.removeOnce;

import org.junit.Test;

public class TextUtilityTest {

    @Test
    public void testRemoveOnceEmptyFromEmpty() {
        assertThat(removeOnce(EMPTY, EMPTY)); isEmptyString());
    }

    @Test
    public void testRemoveOnceEmptyFromFull() {
        assertThat(removeOnce("Blubber", EMPTY), is(equalTo("Blubber")));
    }

    @Test
    public void testRemoveOnceAll() {
        assertThat(removeOnce("Blub", "Blub"), isEmptyString());
    }

    @Test
    public void testRemoveOnceBeginning() {
        assertThat(removeOnce("Blubber", "Blub"), is(equalTo("ber")));
    }

    @Test
    public void testRemoveOnceEnd() {
        assertThat(removeOnce("Blubber", "ber"), is(equalTo("Blub")));
    }

    @Test
    public void testRemoveOnceBeginningFromDouble() {
        assertThat(removeOnce("BlaBlubBla", "Bla"), is(equalTo("BlubBla")));
    }

    @Test
    public void testRemoveOnceMiddleFromDouble() {
        assertThat(removeOnce("BlaBlubBlub", "Blub"), is(equalTo("BlaBlub")));
    }

    public void unCamelCaseAllLowerCase() {
        assertThat(camelCaseToLowerCaseWords("abcdefgeh"), is(equalTo("abcdefgeh")));
    }

    public void unCamelCaseEmptyString() {
        assertThat(camelCaseToLowerCaseWords(EMPTY), is(equalTo(EMPTY)));
    }

    public void unCamelCaseLowerCaseStart() {
        assertThat(camelCaseToLowerCaseWords("aBcdEfg"), is(equalTo("a bcd efg")));
    }

    public void unCamelCaseUpperCaseStart() {
        assertThat(camelCaseToLowerCaseWords("AbcdEfg"), is(equalTo("abcd efg")));
    }

    public void unCamelCaseDoubleUpperCase() {
        assertThat(camelCaseToLowerCaseWords("ABcdEfg"), is(equalTo("a bcd efg")));
    }

    public void unCamelCaseAllUpperCase() {
        assertThat(camelCaseToLowerCaseWords("ABCDEFG"), is(equalTo("a b c d e f g")));
    }
}
