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

package org.jlib.container.storage;

import static org.jlib.message.MessageUtility.message;

/**
 * {@link InvalidStorageArgumentException} thrown when an invalid capacity of an {@link LinearIndexStorage} is
 * specified.
 *
 * @author Igor Akkerman
 */
public class InvalidStorageCapacityException
extends InvalidStorageArgumentException {

    private static final long serialVersionUID = - 701812048814999842L;

    InvalidStorageCapacityException(final LinearIndexStorage<?> storage, final String capacityName,
                                    final int invalidCapacity) {
        super(storage, message().with(capacityName, invalidCapacity));
    }
}
