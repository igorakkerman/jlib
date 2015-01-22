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

/**
 * Formatter of a String using the strategy defined by the implementation of this interface.
 *
 * @author Igor Akkerman
 */
public interface StringFormatter {

    // TODO: replace by format(StringBuilder)
    //       create static methods in StringPadUtility class formatting a String or Appendable
    //       using the strategy defined by an implementation of this interface

    /**
     * Formats the specified String.
     *
     * @param string
     *        String to format
     * @return formatted String
     */
    String format(String string);
}
