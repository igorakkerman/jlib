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
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.jlib.core.text.StringUtility.removeOnce;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class StringUtilityTest {

    @Test
    public void testRemoveOnceEmptyFromEmpty() {
        assertThat(removeOnce(EMPTY, EMPTY), isEmptyString());
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
}
