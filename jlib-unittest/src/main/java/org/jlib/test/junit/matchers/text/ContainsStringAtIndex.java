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

package org.jlib.test.junit.matchers.text;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.core.SubstringMatcher;

public class ContainsStringAtIndex
extends SubstringMatcher {

    private static class SubstringIndex
    extends IndexContainer {

        public SubstringIndex(int index) {
            super(index);
        }
    }

    @Factory
    public static ContainsStringAtIndex containsString(String substring, SubstringIndex substringIndex) {
        return new ContainsStringAtIndex(substring, substringIndex.getIndex());
    }

    @Factory
    public static SubstringIndex at(int substringIndex) {
        return new SubstringIndex(substringIndex);
    }

    @Factory
    public static SubstringIndex atIndex(int substringIndex) {
        return new SubstringIndex(substringIndex);
    }

    private final int substringIndex;

    private String actualSubstring;

    public ContainsStringAtIndex(String substring, int substringIndex) {
        super(substring);
        this.substringIndex = substringIndex;
    }

    @Override
    public boolean evalSubstringOf(String containingString) {
        actualSubstring = containingString.substring(substringIndex, substringIndex + substring.length());
        return actualSubstring.equals(substring);
    }

    @Override
    public void describeTo(Description description) {
        super.describeTo(description);
        description.appendText(" at index " + substringIndex);

        // TODO: using hamcrest 1.2, move the following lines to the new method describeMismatchSafely
        description.appendText(", found ");
        description.appendValue(actualSubstring);
    }

    @Override
    protected String relationship() {
        return "containing";
    }
}
