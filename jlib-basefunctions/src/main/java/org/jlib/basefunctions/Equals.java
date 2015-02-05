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

package org.jlib.basefunctions;

import org.checkerframework.checker.nullness.qual.Nullable;

@FunctionalInterface
public interface Equals<Obj> {

    /**
     * Verifies whether the specified object1 {@link Obj} is equal to the specified object2 {@link Object}.
     * When two values are called equal is defined by the concrete implementation of this interface.
     *
     * @param object1
     *        object1 {@link Obj}
     *
     * @param object2
     *        object2 {@link Object}
     *
     * @return {@code true} if all of the conditions stated above are satisfied;
     *         {@code false} otherwise
     */
    boolean areEqual(Obj object1, @Nullable Object object2);
}
