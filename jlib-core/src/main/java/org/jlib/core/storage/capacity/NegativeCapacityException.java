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

package org.jlib.core.storage.capacity;

import org.jlib.core.language.InvalidArgumentException;
import org.jlib.core.storage.LinearIndexStorage;
import org.jlib.core.storage.LinearIndexStorageException;

/**
 * {@link InvalidArgumentException} thrown when an invalid capacity of an {@link LinearIndexStorage} is specified.
 *
 * @author Igor Akkerman
 */
class NegativeCapacityException
extends LinearIndexStorageException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 701812048814999842L;

    /**
     * Creates a new {@link NegativeCapacityException}.
     *
     * @param storage
     *        referenced {@link LinearIndexStorage}
     *
     * @param invalidCapacity
     *        integer specifying the invalid capacity
     */
    public NegativeCapacityException(final LinearIndexStorage<?> storage, final String invalidCapacityName,
                                     final int invalidCapacity) {
        super(storage, "{1} = {2}", invalidCapacityName, invalidCapacity);
    }
}
