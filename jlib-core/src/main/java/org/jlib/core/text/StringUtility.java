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
import static org.apache.commons.lang3.StringUtils.replaceOnce;
import org.jlib.core.system.SystemUtility;

/**
 * Utility class providing static methods for String operations and
 * manipulations.
 *
 * @author Igor Akkerman
 */
public final class StringUtility {

    /** property name of the system's line separator */
    public static final String LINE_SEPARATOR_PROPERTY_NAME = "line.separator";

    /** the system's line separator */
    public static final String LINE_SEPARATOR = SystemUtility.getApplicationProperty(LINE_SEPARATOR_PROPERTY_NAME);

    /** no visible constructor */
    private StringUtility() {}

    public static String removeOnce(final String containingString, final String removedString) {
        return replaceOnce(containingString, removedString, EMPTY);
    }
}
