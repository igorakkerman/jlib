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

import org.jlib.core.traverser.IllegalTraversibleArgumentException;

/**
 * {@link IllegalArgumentException} referencing a {@link Container}.
 *
 * @author Igor Akkerman
 */
public abstract class IllegalContainerArgumentException
extends IllegalTraversibleArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 4325711014434407944L;

    /** referenced {@link Container} */
    private final Container<?> container;

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     *
     * @param container
     *        referenced {@link Container}
     */
    public IllegalContainerArgumentException(final Container<?> container) {
        this(container, "{1}");
    }

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param messagePattern
     *        String specifying the pattern of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public IllegalContainerArgumentException(final Container<?> container, final String messagePattern, final Object... messageArguments) {

        this(container, messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param messagePattern
     *        String specifying the pattern of the error message
     *
     * @param cause
     *        Throwable that caused this
     *        {@link IllegalContainerArgumentException}
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public IllegalContainerArgumentException(final Container<?> container, final String messagePattern, final Throwable cause, final Object... messageArguments) {

        super(container, messagePattern, cause, messageArguments);

        this.container = container;
    }

    /**
     * Returns the {@link Container} reference by this
     * {@link IllegalContainerArgumentException}.
     *
     * @return referenced {@link Container}
     */
    public Container<?> getContainer() {
        return container;
    }
}
