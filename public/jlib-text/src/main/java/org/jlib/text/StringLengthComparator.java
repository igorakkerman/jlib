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

package org.jlib.text;

import java.util.Comparator;

/**
 * <p>
 * Comparator performing the comparison of two objects by comparing the lengths
 * of their String representations as returned by the {@code toString()} method.
 * Null String representations are assumed to have length -1.
 * </p>
 * <p>
 * Implemented as a singleton.
 * </p>
 *
 * @param <ComparisonObject>
 *        type of the objects to compare
 * @author Igor Akkerman
 */
public class StringLengthComparator<ComparisonObject>
implements Comparator<ComparisonObject> {

    private static final StringLengthComparator<?> INSTANCE = new StringLengthComparator<>();

    @SuppressWarnings("unchecked")
    public static <ComparisonObject> /*
               */ StringLengthComparator<ComparisonObject> getInstance() {
        return (StringLengthComparator<ComparisonObject>) INSTANCE;
    }

    private StringLengthComparator() {}

    @Override
    public int compare(final ComparisonObject object1, final ComparisonObject object2) {
        return object1.toString().length() - object2.toString().length();
    }
}
