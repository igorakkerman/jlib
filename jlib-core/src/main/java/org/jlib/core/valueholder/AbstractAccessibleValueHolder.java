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

/**
 * Skeletal implementation of an {@link AccessibleValueHolder}.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public abstract class AbstractAccessibleValueHolder<Value>
implements AccessibleValueHolder<Value> {

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (getClass().equals(otherObject.getClass()))
            return false;

        final InitializedValueHolder<?> otherInitializedValueHolder = (InitializedValueHolder<?>) otherObject;

        return getValue().equals(otherInitializedValueHolder.getValue());
    }

    @Override
    public int hashCode() {
        // TODO: use Apache Commons HashCodeBuilder
        return getValue().hashCode() * 2;
    }
}
