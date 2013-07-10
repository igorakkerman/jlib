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

import org.jlib.core.language.InvalidArgumentException;

public class StorageIndexOutOfBoundsException
extends InvalidArgumentException {

    private static final long serialVersionUID = 2164701656211361191L;

    private final LinearIndexStorage<?> storage;

    private final int invalidIndex;

    public StorageIndexOutOfBoundsException(final LinearIndexStorage<?> storage, final int invalidIndex,
                                            String errorMessage) {
        super("[{1}]: {2} {0}", storage, invalidIndex, errorMessage);

        this.storage = storage;
        this.invalidIndex = invalidIndex;
    }

    public LinearIndexStorage<?> getStorage() {
        return storage;
    }

    public int getInvalidIndex() {
        return invalidIndex;
    }
}
