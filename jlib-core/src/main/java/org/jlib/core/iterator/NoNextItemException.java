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

package org.jlib.core.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.jlib.core.language.ExceptionMessage;

/**
 * {@link InvalidIteratorStateException} thrown when there is no next Item to
 * return by a {@link Iterator}.
 *
 * @author Igor Akkerman
 */
public class NoNextItemException
extends NoSuchElementException {

    /** serialVersionUID */
    private static final long serialVersionUID = 328216916169684024L;

    private final Iterable<?> iterable;

    private final Optional<ExceptionMessage> message;

    /**
     * Creates a new {@link NoNextItemException}.
     *
     * @param iterable
     *        traversed {@link Iterable}
     */
    public NoNextItemException(final Iterable<?> iterable, final Optional<ExceptionMessage> message,
                               final Optional<Throwable> cause) {
        super(message.toString());

        this.iterable = iterable;
        this.message = message;

        if (cause.isPresent())
            initCause(cause.get());
    }

    @Override
    public String getMessage() {
        return message.isPresent() ?
               message.get().toString() :
               super.getMessage();
    }

    public Iterable<?> getIterable() {
        return iterable;
    }
}
