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

import org.jlib.core.language.InvalidStateException;
import org.jlib.core.language.ParametrizedMessage;

import static org.jlib.core.language.ParametrizedMessageUtility.message;

/**
 * {@link InvalidIteratorStateException} thrown when the traversed {@link Iterable} claims a state error.
 *
 * @author Igor Akkerman
 */
public class InvalidIterableArgumentException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    public InvalidIterableArgumentException(final Iterable<?> iterable) {
        super(message().with(iterable));
    }

    public InvalidIterableArgumentException(final Iterable<?> iterable, final Exception cause) {
        super(message().with(iterable), cause);
    }

    public InvalidIterableArgumentException(final Iterable<?> iterable, final ParametrizedMessage message) {
        super(message.with(iterable));
    }

    public InvalidIterableArgumentException(final Iterable<?> iterable, final ParametrizedMessage message,
                                            final Exception cause) {
        super(message.with(iterable), cause);
    }
}