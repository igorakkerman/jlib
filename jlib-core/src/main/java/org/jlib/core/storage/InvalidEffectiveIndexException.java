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

/**
 * Exception thrown when an invalid effective index is specified.
 *
 * @author Igor Akkerman
 */
class InvalidEffectiveIndexException
extends InvalidArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 7606042021315378835L;

    /**
     * Creates a new {@link InvalidEffectiveIndexException} .
     *
     * @param invalidEffectiveIndex
     *        integer specifying the invalid effective index
     *
     * @param firstValidEffectiveIndex
     *        integer specifying the first valid effective index
     *
     * @param lastValidEffectiveIndex
     *        integer specifying the last valid effective index
     */
    public InvalidEffectiveIndexException(final int invalidEffectiveIndex, final int firstValidEffectiveIndex, final int lastValidEffectiveIndex) {
        super("effectiveIndex: {0} [{1}, {2}]", invalidEffectiveIndex, firstValidEffectiveIndex,
              lastValidEffectiveIndex);
    }
}
