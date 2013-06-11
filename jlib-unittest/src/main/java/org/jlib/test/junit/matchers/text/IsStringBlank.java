package org.jlib.test.junit.matchers.text;

import org.apache.commons.lang3.StringUtils;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class IsStringBlank
extends TypeSafeMatcher<String> {

    @Factory
    public static IsStringBlank blank() {
        return new IsStringBlank();
    }

    public IsStringBlank() {}

    @Override
    public boolean matchesSafely(String string) {
        return StringUtils.isBlank(string);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("blank string");
    }
}
