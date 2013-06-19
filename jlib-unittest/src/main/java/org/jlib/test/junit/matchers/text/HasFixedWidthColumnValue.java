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
import org.hamcrest.TypeSafeMatcher;
import org.jlib.core.valueholder.ValueHolder;

public class HasFixedWidthColumnValue
extends TypeSafeMatcher<String> {

    private static class Column {

        private final int beginIndex;

        private final int endIndex;

        protected Column(int beginIndex, int endIndex) {
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
        }

        int getBeginIndex() {
            return beginIndex;
        }

        int getEndIndex() {
            return endIndex;
        }
    }

    @Factory
    public static HasFixedWidthColumnValue hasValue(Object expectedColumnValue, Column column) {
        return new HasFixedWidthColumnValue(expectedColumnValue, column.getBeginIndex(), column.getEndIndex());
    }

    @Factory
    public static Column inColumn(int columnBeginIndex, int columnEndIndex) {
        return new Column(columnBeginIndex, columnEndIndex);
    }

    @Factory
    public static Column inColumn(int columnBeginIndex, int columnEndIndex) {
        return new Column(columnBeginIndex, columnEndIndex);
    }

    @Factory
    public static Column inColumn(int columnBeginIndex, ColumnWidth columnWidth) {
        return new Column(columnBeginIndex.get(), columnBeginIndex.get() + columnWidth.get() - 1);
    }

    @Factory
    public static Index beginningAtIndex(int columnBeginIndex) {
        return new Index(columnBeginIndex);
    }

    @Factory
    public static Index endingAtIndex(int columnEndIndex) {
        return new Index(columnEndIndex);
    }

    @Factory
    public static Index fromIndex(int columnBeginIndex) {
        return new Index(columnBeginIndex);
    }

    @Factory
    public static Index toIndex(int columnEndIndex) {
        return new Index(columnEndIndex);
    }

    @Factory
    public static ColumnWidth withWidth(int columnWidth) {
        return new ColumnWidth(columnWidth);
    }

    private static boolean isBlank(String string) {
        for (char character : iterable(string))
            // only the real space character is relevant, tabs and newline characters are not
            if (character != ' ')
                return false;
        return true;
    }

    private final Object expectedValue;

    private final int columnBeginIndex;

    private final int columnEndIndex;

    private boolean columnStartsWithValue;

    private boolean columnBlankAfterValue;

    private String actualValue;

    private String actualStringAfterValue;

    public HasFixedWidthColumnValue(Object expectedValue, int columnBeginIndex, int columnEndIndex) {
        this.expectedValue = expectedValue;
        this.columnBeginIndex = columnBeginIndex;
        this.columnEndIndex = columnEndIndex;
    }

    @Override
    public boolean matchesSafely(String containingString) {
        String expectedColumnValueString = expectedValue != null
                                           ? expectedValue.toString()
                                           : "";

        actualValue = containingString.substring(columnBeginIndex,
                                                 columnBeginIndex + expectedColumnValueString.length());

        columnStartsWithValue = actualValue.equals(expectedColumnValueString);
        actualStringAfterValue = containingString.substring(columnBeginIndex + expectedColumnValueString.length(),
                                                            columnEndIndex + 1);
        columnBlankAfterValue = isBlank(actualStringAfterValue);

        return columnStartsWithValue && columnBlankAfterValue;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("string containing ");
        description.appendValue(expectedValue);
        description.appendText(" in column [" + columnBeginIndex + ", " + columnEndIndex + "]");

        // TODO: using hamcrest 1.2, move the following lines to the new method describeMismatchSafely

        // if column doesn't begin with the expected value
        if (! columnStartsWithValue) {
            description.appendText(", column does not begin with the expected value but with ");
            description.appendValue(actualValue);
        }

        // if column DOES begin with the expected value but is not followed by blanks
        else if (! columnBlankAfterValue) {
            description.appendText(", value is correct but is not followed by blanks");
            description.appendValue(actualStringAfterValue);
        }
    }
}
