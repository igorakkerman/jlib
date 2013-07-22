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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.Ensure.ensureThat;

public class TextUtilityTest {

    @Test
    public void testRemoveOnceEmptyFromEmpty() {
        ensureThat(removeOnce(EMPTY, EMPTY), isEmptyString());
    }

    @Test
    public void testRemoveOnceEmptyFromFull() {
        ensureThat(removeOnce("Blubber", EMPTY), is(equalTo("Blubber")));
    }

    @Test
    public void testRemoveOnceAll() {
        ensureThat(removeOnce("Blub", "Blub"), isEmptyString());
    }

    @Test
    public void testRemoveOnceBeginning() {
        ensureThat(removeOnce("Blubber", "Blub"), is(equalTo("ber")));
    }

    @Test
    public void testRemoveOnceEnd() {
        ensureThat(removeOnce("Blubber", "ber"), is(equalTo("Blub")));
    }

    @Test
    public void testRemoveOnceBeginningFromDouble() {
        ensureThat(removeOnce("BlaBlubBla", "Bla"), is(equalTo("BlubBla")));
    }

    @Test
    public void testRemoveOnceMiddleFromDouble() {
        ensureThat(removeOnce("BlaBlubBlub", "Blub"), is(equalTo("BlaBlub")));
    }

    public void unCamelCaseAllLowerCase() {
        ensureThat(camelCaseToLowerCaseWords("abcdefgeh"), is(equalTo("abcdefgeh")));
    }

    public void unCamelCaseEmptyString() {
        ensureThat(camelCaseToLowerCaseWords(EMPTY), is(equalTo(EMPTY)));
    }

    public void unCamelCaseLowerCaseStart() {
        ensureThat(camelCaseToLowerCaseWords("aBcdEfg"), is(equalTo("a bcd efg")));
    }

    public void unCamelCaseUpperCaseStart() {
        ensureThat(camelCaseToLowerCaseWords("AbcdEfg"), is(equalTo("abcd efg")));
    }

    public void unCamelCaseDoubleUpperCase() {
        ensureThat(camelCaseToLowerCaseWords("ABcdEfg"), is(equalTo("a bcd efg")));
    }

    public void unCamelCaseAllUpperCase() {
        ensureThat(camelCaseToLowerCaseWords("ABCDEFG"), is(equalTo("a b c d e f g")));
    }
}
