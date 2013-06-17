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

import org.jlib.core.operator.OperatorException;

/**
 * {@link ValueObserverException} thrown during a
 * {@link ValueObserver#handleAfterFailure(Object, OperatorException)}
 * operation.
 *
 * @author Igor Akkerman
 */
public abstract class AfterFailureHandlerValueObserverException
extends ObserverException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 2379268967139497379L;

    /**
     * Creates a new {@link AfterFailureHandlerValueObserverException}.
     *
     * @param item
     *        Item removed from {@code container}
     *
     * @param messageTemplate
     *        {@link String} specifying the message template; {1} references
     *        {@code item}
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link AfterFailureHandlerValueObserverException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public AfterFailureHandlerValueObserverException(final Object item, final String messageTemplate, final Throwable cause, final Object... messageArguments) {
        super(messageTemplate, cause, item, messageArguments);
    }
}
