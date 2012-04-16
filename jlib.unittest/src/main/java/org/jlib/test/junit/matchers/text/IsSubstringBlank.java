package org.jlib.test.junit.matchers.text;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class IsSubstringBlank
extends TypeSafeMatcher<String> {

    private static class BeginIndexContainer
    extends IndexContainer {

        public BeginIndexContainer(int index) {
            super(index);
        }
    }

    private static class EndIndexContainer
    extends IndexContainer {

        public EndIndexContainer(int index) {
            super(index);
        }
    }

    @Factory
    public static BeginIndexContainer from(int beginIndex) {
        return new BeginIndexContainer(beginIndex);
    }

    @Factory
    public static EndIndexContainer to(int endIndex) {
        return new EndIndexContainer(endIndex);
    }

    @Factory
    public static IsSubstringBlank blank(BeginIndexContainer beginIndexContainer, EndIndexContainer endIndexContainer) {
        return new IsSubstringBlank(beginIndexContainer.getIndex(), endIndexContainer.getIndex());
    }

    private final Integer beginIndex;

    private final Integer endIndex;

    private String substring;

    public IsSubstringBlank(int beginIndex, int endIndex) {
        if ((beginIndex < 0) || (beginIndex > endIndex)) {
            throw new IllegalArgumentException();
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
}
