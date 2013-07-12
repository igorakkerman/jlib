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

package org.jlib.core.value;

import org.jlib.core.system.AbstractObject;

/**
 * {@link Value} of a {@link Val} that is guaranteed to be accessible.
 *
 * @param <Val>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public abstract class Accessible<Val>
extends AbstractObject
implements Value<Val> {

    /**
     * Returns the {@link Val}. Since the {@link Val} is guaranteed to be accessible, <em>no</em>
     * {@link ValueNotAccessibleException} will be thrown.
     *
     * @return registered {@link Val}
     */
    @Override
    public abstract Val getValue();

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     * <p>
     * In this implementation the {@link Val} is guaranteed to be accessible, hence always returned is {@code true}.
     * </p>
     *
     * @return {@code true} always
     */
    @Override
    public final boolean isValueAccessible() {
        return true;
    }

    @Override
    public final String toString() {
        return getValue().toString();
    }
}
