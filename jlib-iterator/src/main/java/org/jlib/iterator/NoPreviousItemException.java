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

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.jlib.message.Message;
import static org.jlib.message.Messages.message;

/**
 * {@link InvalidIteratorStateException} thrown when there is no previous item to return by an {@link Iterator}.
 *
 * @author Igor Akkerman
 */
public class NoPreviousItemException
    extends NoSuchElementException {

    private static final long serialVersionUID = 314294681315664677L;

    public NoPreviousItemException(final String iteratedName, final Object iterated) {
        this(iteratedName, iterated, message());
    }

    public NoPreviousItemException(final String iteratedName, final Object iterated, final Message message) {
        super(message.with(iteratedName, iterated).toString());
    }

    public NoPreviousItemException(final String iteratedName, final Object iterated, final Message message, final Exception cause) {
        this(iteratedName, iterated, message);

        initCause(cause);
    }
}
