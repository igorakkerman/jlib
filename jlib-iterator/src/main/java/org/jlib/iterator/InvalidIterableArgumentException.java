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

package org.jlib.iterator;

import org.jlib.exception.InvalidArgumentException;
import org.jlib.message.Message;

import static org.jlib.message.MessageUtility.message;

/**
 * {@link InvalidIteratorStateException} thrown when the traversed {@link Iterable} claims a state error.
 *
 * @author Igor Akkerman
 */
public class InvalidIterableArgumentException
extends InvalidArgumentException {

    private static final long serialVersionUID = - 1098504358095886664L;

    public InvalidIterableArgumentException(final Iterable<?> iterable) {
        super(buildMessage(iterable, message()));
    }

    public InvalidIterableArgumentException(final Iterable<?> iterable, final Exception cause) {
        super(buildMessage(iterable, message()), cause);
    }

    public InvalidIterableArgumentException(final Iterable<?> iterable, final Message message) {
        super(buildMessage(iterable, message));
    }

    public InvalidIterableArgumentException(final Iterable<?> iterable, final Message message,
                                            final Exception cause) {
        super(buildMessage(iterable, message), cause);
    }

    private static Message buildMessage(final Iterable<?> iterable, final Message message) {
        return message.with("iterable", iterable);
    }
}
