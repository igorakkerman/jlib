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

package org.jlib.core.language;

/**
 * {@link IllegalArgumentException} using a parametrized message.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidArgumentException
extends IllegalArgumentException {

    private static final long serialVersionUID = 5894034302749387338L;

    /**
     * Creates a new {@link InvalidArgumentException}.
     */
    protected InvalidArgumentException(final ParametrizedMessage message) {
        super(message.toString());
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidArgumentException}
     */
    protected InvalidArgumentException(final ParametrizedMessage message, final Exception cause) {
        super(message.toString(), cause);
    }
}
