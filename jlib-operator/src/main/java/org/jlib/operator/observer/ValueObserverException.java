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

package org.jlib.operator.observer;

import org.jlib.core.message.Message;

/**
 * {@link ObserverException} thrown during an {@link ValueObserver} operation.
 *
 * @author Igor Akkerman
 */
public abstract class ValueObserverException
extends ObserverException {

    private static final long serialVersionUID = - 2860634081042322384L;

    /**
     * Creates a new {@link ValueObserverException}.
     *
     * @param value
     *        observed {@link Object} value
     *
     * @param cause
     *        {@link Exception} that caused this {@link ValueObserverException}
     */
    protected ValueObserverException(final Object value, final Message message, final Exception cause) {

        super(message.with("value", value), cause);
    }
}
