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

import org.jlib.core.exception.IllegalJlibStateException;
import org.jlib.core.exception.JlibException;

/**
 * {@link JlibException} thrown during the operation of an observer.
 *
 * @author Igor Akkerman
 */
public abstract class ObserverException
extends IllegalJlibStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 7621231395096897078L;

    /**
     * Creates a new {@link ObserverException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param cause
     *        {@link Throwable} that caused this {@link ObserverException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ObserverException(final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, messageArguments);
    }
}
