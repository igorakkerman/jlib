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

package org.jlib.core.valueholder;

import org.jlib.core.language.ValueNotAccessibleException;

/**
 * Holder of a Value.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public interface ValueHolder<Value> {

    /**
     * Returns the provided Value.
     *
     * @return provided Value
     *
     * @throws ValueNotAccessibleException
     *         if no Value can be provided
     */
    public Value getValue()
    throws ValueNotAccessibleException;

    /**
     * Returns whether a Value can be provided.
     *
     * @return {@code true} if a Value can be provided;
     *         {@code false} otherwise
     */
    public boolean isValueAccessible();
}
