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

import org.jlib.core.text.message.ParametrizedMessage;

import static org.jlib.core.text.message.ParametrizedMessageUtility.message;

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

    /**
     * Creates a new {@link NoNextItemException}.
     *
     * @param iterable
     *        traversed {@link Iterable}
     */
    public NoNextItemException(final Iterable<?> iterable) {
        this(iterable, message());
    }

    public NoNextItemException(final Iterable<?> iterable, final ParametrizedMessage message) {
        super(message.with("iterable", iterable).toString());

        this.iterable = iterable;
    }

    public NoNextItemException(final Iterable<?> iterable, final ParametrizedMessage message, final Exception cause) {
        this(iterable, message);

        initCause(cause);
    }

    public Iterable<?> getIterable() {
        return iterable;
    }
}
