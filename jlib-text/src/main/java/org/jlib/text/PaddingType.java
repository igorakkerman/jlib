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
 * String padding type.
 * 
 * @author Igor Akkerman
 */
public enum PaddingType {

    /** front padding */
    FRONT,

    /** back padding */
    BACK,

    /**
     * equal front and back padding. If the number of characters to pad is odd,
     * the front will be padded with one character more than the back
     */
    FRONTBACK,

    /**
     * equal front and back padding. If the number of characters to pad is odd,
     * the back will be padded with one character more than the front
     */
    BACKFRONT
}
