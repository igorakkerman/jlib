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

package org.jlib.unittest.junit.matchers.text;

public class IsSubstringBlank
/* extends TypeSafeMatcher<String> */ {
/*
    private static class BeginIndex
    extends Index {

        public BeginIndex(int index) {
            super(index);
        }
    }

    private static class EndIndex
    extends Index {

        public EndIndex(int index) {
            super(index);
        }
    }

    @Factory
    public static BeginIndex from(int beginIndex) {
        return new BeginIndex(beginIndex);
    }

    @Factory
    public static EndIndex to(int endIndex) {
        return new EndIndex(endIndex);
    }

    @Factory
    public static IsSubstringBlank blank(BeginIndex beginIndexContainer, EndIndex endIndexContainer) {
        return new IsSubstringBlank(beginIndexContainer.getIndex(), endIndexContainer.getIndex());
    }

    private final Integer beginIndex;

    private final Integer endIndex;

    private String substring;

    public IsSubstringBlank(int beginIndex, int endIndex) {
        if ((beginIndex < 0) || (beginIndex > endIndex)) {
            // TODO: add correct error message
            throw new InvalidArgumentException("beginIndex: {0}", beginIndex);
        }

        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    @Override
    public boolean matchesSafely(String string) {
        substring = string.substring(beginIndex, endIndex + 1);

        return StringUtils.isBlank(substring);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("string with a blank substring from " + beginIndex + " to " + endIndex);

        // TODO: using hamcrest 1.2, move the following lines to the new method describeMismatchSafely
        description.appendText(", found ");
        description.appendText(substring);
    }
*/
}
