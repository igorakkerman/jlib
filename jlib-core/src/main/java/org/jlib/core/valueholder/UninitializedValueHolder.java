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

package org.jlib.core.valueholder;

import org.jlib.core.exception.ValueNotAccessibleException;

/**
 * Skeletal implementation of a not initialized {@link ModifiableValueHolder}.
 *
 * @param <Value>
 *        type of the value
 *
 * @author Igor Akkerman
 */
public abstract class UninitializedValueHolder<Value>
implements ModifiableValueHolder<Value> {

    /**
     * Creates a new {@link UninitializedValueHolder}.
     */
    public UninitializedValueHolder() {
        super();
    }

    @Override
    public Value getValue()
    throws ValueNotAccessibleException {
        throw new ValueNotAccessibleException();
    }
}
