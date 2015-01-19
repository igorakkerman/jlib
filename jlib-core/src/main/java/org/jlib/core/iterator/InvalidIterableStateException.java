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

import org.jlib.core.exception.InvalidStateException;
import org.jlib.core.text.message.Message;

import static org.jlib.core.text.message.MessageUtility.message;

/**
 * {@link InvalidIteratorStateException} thrown when the traversed {@link Iterable} claims a state error.
 *
 * @author Igor Akkerman
 */
public class InvalidIterableStateException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    public InvalidIterableStateException(final Iterable<?> iterable) {
        super(buildMessage(message(), iterable));
    }

    public InvalidIterableStateException(final Iterable<?> iterable, final Exception cause) {
        super(buildMessage(message(), iterable), cause);
    }

    public InvalidIterableStateException(final Iterable<?> iterable, final Message message) {
        super(buildMessage(message, iterable));
    }

    public InvalidIterableStateException(final Iterable<?> iterable, final Message message,
                                         final Exception cause) {
        super(buildMessage(message, iterable), cause);
    }

    private static Message buildMessage(final Message message, final Iterable<?> iterable) {
        return message.with("iterable", iterable);
    }
}
