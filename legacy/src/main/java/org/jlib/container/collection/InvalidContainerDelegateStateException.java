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

package org.jlib.container.operation.collection;

import org.jlib.core.language.Message;
import org.jlib.core.iterator.InvalidIteratorStateException;

/**
 * {@link InvalidContainerArgumentException} thrown when a delegate object
 * signals an error.
 *
 * @author Igor Akkerman
 */
public class InvalidContainerDelegateStateException
extends InvalidIteratorStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 8427879807874812907L;

    /**
     * Creates a new {@link InvalidContainerDelegateStateException}.
     *
     * @param container
     *        referenced {@link Object}
     *
     * @param delegate
     *        delegate Object
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param cause
     *        Exception that caused this
     *        {@link InvalidContainerDelegateStateException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public InvalidContainerDelegateStateException(final IterableContainer<?> container, final Object delegate,
                                                  final Message message, final Exception cause) {
        super(container, message.with(delegate), cause);
    }
}
