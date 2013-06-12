/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core.observer;

/**
 * {@link ValueObserverException} thrown during a
 * {@link ValueObserver#handleBefore(Object)} operation.
 *
 * @author Igor Akkerman
 */
public abstract class AfterSuccessHandlerValueObserverException
extends ObserverException {

    /** serialVersionUID */
    private static final long serialVersionUID = 3230285545341500553L;

    /**
     * Creates a new {@link AfterSuccessHandlerValueObserverException}.
     *
     * @param item
     *        Item removed from {@code container}
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code item}
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link AfterSuccessHandlerValueObserverException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public AfterSuccessHandlerValueObserverException(final Object item, final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, item, messageArguments);
    }
}
