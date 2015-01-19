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

package org.jlib.core.iterator;

import java.util.Iterator;

import org.jlib.core.text.message.Message;

/**
 * {@link InvalidIteratorStateException} thrown when there is no next Item to
 * return by a {@link Iterator}.
 *
 * @author Igor Akkerman
 */
public class NoPreviousItemException
extends InvalidIteratorStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1747026481047589428L;

    /**
     * Creates a new {@link NoPreviousItemException}.
     *
     * @param iterable
     *        traversed {@link Iterable}
     */
    public NoPreviousItemException(final Iterable<?> iterable) {
        super(iterable);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     *
     * @param iterable
     *        traversed {@link Iterable}
     *
     * @param cause
     *        {@link Exception} that caused this {@link NoPreviousItemException}
     */
    public NoPreviousItemException(final Iterable<?> iterable, final Exception cause) {
        super(iterable, cause);
    }

    public NoPreviousItemException(final Iterable<?> iterable, final Message message) {
        super(iterable, message);
    }

    public NoPreviousItemException(final Iterable<?> iterable, final Message message,
                                   final Exception cause) {
        super(iterable, message, cause);
    }
}
