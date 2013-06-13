/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core.nullable;

import javax.annotation.Nullable;

import org.jlib.core.exception.ValueNotAccessibleException;

/**
 * Utility class providing static methods for {@link Nullable} {@link Object} operations.
 *
 * @author Igor Akkerman
 */
public final class NullableUtility {

    /** no visible constructor */
    private NullableUtility() {}

    /**
     * Returns the specified optional Value.
     *
     * @param <Value>
     *        type of the value
     *
     * @param valueName
     *        {@link String} specifying a descriptive name of the Value
     *
     * @param value
     *        Value to return or {@code null}
     *
     * @return {@code value}, if {@code value != null}
     *
     * @throws ValueNotAccessibleException
     *         if {@code value == null}
     */
    public static <Value> Value optional(final String valueName, final @Nullable Value value)
    throws ValueNotAccessibleException {

        if (value == null)
            throw new ValueNotAccessibleException(valueName);

        return value;
    }

    /**
     * Compares the specified Objects for mutual equality. Two Objects
     * {@code object1}, {@code object2} are considered equal if
     * {@code object1 == object2 == null} or {@code object1.equals(object2)}.
     *
     * @param objects
     *        comma separated sequence of Objects to compare
     *
     * @return {@code true} if all specified Objects are equal or if the
     *         specified sequence of Objects is empty; {@code false} otherwise
     */
    public static boolean equalOrNull(final Object... objects) {
        if (objects.length == 0)
            return true;

        final Object firstObject = objects[0];

        if (firstObject == null) {
            for (int index = 1; index < objects.length; index++)
                if (objects[index] != null)
                    return false;

            return true;
        }

        for (int index = 1; index < objects.length; index++)
            if (! firstObject.equals(objects[index]))
                return false;

        return true;
    }

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
    public static int getHashCodeOrZero(final @Nullable Object object) {
        return object != null
               ? object.hashCode()
               : 0;
    }
}
