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

package org.jlib.core.storage;

public class InvalidAdditionalCapacityException
extends LinearIndexStorageException {

    private static final long serialVersionUID = 8571768940498236393L;

    /**
     * Creates a new {@link LinearIndexStorageException}.
     *
     * @param storage
     *        referenced {@link LinearIndexStorage}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param messageArguments
     *        array of {@link Object} message arguments
     */
    public InvalidAdditionalCapacityException(final LinearIndexStorage<?> storage, final int additionalCapacity) {
        super(storage, "{0}", additionalCapacity);
    }
}
