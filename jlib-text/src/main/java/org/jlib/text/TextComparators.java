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

public class TextComparators {

    public static Comparator<?> STRING_LENGTH_COMPARATOR = /*
     */ (compared1, compared2) -> compared1.toString().length() - compared2.toString().length();

    @SuppressWarnings("unchecked")
    public static <Compared> Comparator<Compared> stringLength() {
        return (Comparator<Compared>) STRING_LENGTH_COMPARATOR;
    }

    private TextComparators() {}
}
