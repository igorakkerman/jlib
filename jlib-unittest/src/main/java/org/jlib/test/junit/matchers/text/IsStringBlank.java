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
