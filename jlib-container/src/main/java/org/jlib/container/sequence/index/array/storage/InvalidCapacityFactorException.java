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

package org.jlib.container.sequence.index.array.storage;

import org.jlib.core.exception.InvalidArgumentException;

/**
 * {@link InvalidArgumentException} thrown when an invalid capacity
 * factor is specified.
 *
 * @author Igor Akkerman
 */
class InvalidCapacityFactorException
extends InvalidArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 655924593848562967L;

    /**
     * Creates a new {@link InvalidCapacityFactorException}.
     *
     * @param invalidFactorName
     *        String specifying the name of the invalid factor
     *
     * @param invaldFactorValue
     *        integer specifying the invalid factor value
     */
    public InvalidCapacityFactorException(final String invalidFactorName, final int invaldFactorValue) {
        super("{0}: {1}", invalidFactorName, invaldFactorValue);
    }
}
