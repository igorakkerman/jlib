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

package org.jlib.core.value;

import org.jlib.core.exception.ApplicationException;

/**
 * {@link ApplicationException} thrown when a requested {@link Accessor} value is not set.
 *
 * @author Igor Akkerman
 */
public class NotInitializedException
extends NotAccessibleException {

    private static final long serialVersionUID = 4844161228178575622L;

    /**
     * Creates a new {@link NotInitializedException}.
     */
    public NotInitializedException() {
    }

    /**
     * Creates a new {@link NotInitializedException}.
     *
     * @param valueName
     *        {@link CharSequence} specifying a descriptive name of the Accessor
     */
    public NotInitializedException(final CharSequence valueName) {
        super(valueName);
    }
}
