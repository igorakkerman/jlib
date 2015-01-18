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

package org.jlib.core.observer;

import org.jlib.core.language.exception.ApplicationException;
import org.jlib.core.text.message.ParametrizedMessage;
import org.jlib.core.language.exception.InvalidStateException;

/**
 * {@link ApplicationException} thrown during the operation of an observer.
 *
 * @author Igor Akkerman
 */
public abstract class ObserverException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 7621231395096897078L;

    /**
     * Creates a new {@link ObserverException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link ObserverException}
     */
    protected ObserverException(final ParametrizedMessage message, final Exception cause) {
        super(message, cause);
    }
}
