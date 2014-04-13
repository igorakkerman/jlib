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

import org.jlib.core.language.AbstractObject;

public abstract class AbstractAccessible<Value>
extends AbstractObject
implements Accessible<Value> {

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     * <p>
     * All instances of {@link AbstractAccessible} guarantee the {@link Value} to be accessible, hence always returns
     * {@code true}.
     * </p>
     *
     * @return {@code true} always
     */
    @Override
    public final boolean canGet() {
        return Accessible.super.canGet();
    }

    @Override
    public final String toString() {
        return get().toString();
    }
}
