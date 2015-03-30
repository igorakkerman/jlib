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

package org.jlib.shared;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Utility class providing static methods for {@link Nullable} {@link Object} operations.
 *
 * @author Igor Akkerman
 */
public final class NullableUtility {

    /**
     * Returns the hash code of the specified {@link Object} as returned by its
     * {@link Object#hashCode()} method or {@code 0} if the specified
     * {@link Object} is {@code null}.
     *
     * @param object
     *        {@link Object} of which the hash code is returned
     *
     * @return integer specifying the hash code of {@code object}; {@code 0} if
     *         {@code object} is {@code null}
     */
    public static int hashCodeOrZero(final @Nullable Object object) {
        return object != null ?
               object.hashCode() :
               0;
    }

    private NullableUtility() {}
}
