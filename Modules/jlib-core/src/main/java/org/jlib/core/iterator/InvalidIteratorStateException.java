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

import org.jlib.core.exception.InvalidStateException;
import org.jlib.core.message.Message;

import static org.jlib.core.message.MessageUtility.message;

/**
 * {@link InvalidIteratorStateException} thrown when the traversed {@link Iterator} claims a state error.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidIteratorStateException
extends InvalidStateException {

    private static final long serialVersionUID = 1706750148627927636L;

    protected InvalidIteratorStateException(final Object iterated) {
        super(buildMessage(message(), iterated));
    }

    protected InvalidIteratorStateException(final Object iterated, final Message message) {
        super(buildMessage(message, iterated));
    }

    protected InvalidIteratorStateException(final Object iterated, final Exception cause) {
        super(buildMessage(message(), iterated), cause);
    }

    protected InvalidIteratorStateException(final Object iterated, final Message message, final Exception cause) {
        super(buildMessage(message, iterated), cause);
    }

    private static Message buildMessage(final Message message, final Object iterated) {
        return message.with("iterated", iterated);
    }
}
