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

package org.jlib.container;

import org.jlib.core.exception.InvalidStateException;

/**
 * {@link InvalidStateException} caused by a {@link Container}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidContainerStateException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5372709827038391318L;

    /** referenced {@link Container} */
    private Container<?> container;

    /**
     * Creates a new {@link InvalidContainerStateException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public InvalidContainerStateException(final Container<?> container, final String messageTemplate, final Object... messageArguments) {
        super(messageTemplate, container, messageArguments);

        this.container = container;
    }

    /**
     * Creates a new {@link InvalidContainerStateException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link InvalidContainerStateException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public InvalidContainerStateException(final Container<?> container, final String messageTemplate, final Throwable cause, final Object... messageArguments) {
        super(messageTemplate, cause, container, messageArguments);

        this.container = container;
    }

    /**
     * Returns the referenced {@link Container}.
     *
     * @return referenced {@link Container}
     */
    public Container<?> getContainer() {
        return container;
    }
}
