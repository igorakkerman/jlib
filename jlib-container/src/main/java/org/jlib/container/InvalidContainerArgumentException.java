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

import com.google.common.base.Optional;
import org.jlib.core.language.ExceptionUtility;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;

/**
 * {@link InvalidTraversibleArgumentException} referencing a {@link Container}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidContainerArgumentException
extends InvalidTraversibleArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 4325711014434407944L;

    /** referenced {@link Container} */
    @SuppressWarnings("NonSerializableFieldInSerializableClass")
    private final Container<?> container;

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param messageTemplate
     *        String specifying the template of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public <Cont extends Container<?>> /*
        */ InvalidContainerArgumentException(final Container<?> container, final String messageTemplate,
                                             final Object... messageArguments) {

        this(container, Optional.absent(), messageTemplate, messageArguments);
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param messageTemplate
     *        String specifying the template of the error message
     *
     * @param cause
     *        Throwable that caused this
     *        {@link InvalidContainerArgumentException}
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public InvalidContainerArgumentException(final Container<?> container, final String messageTemplate,
                                             final Throwable cause, final Object... messageArguments) {

        super(container, messageTemplate, cause, messageArguments);
    }

    protected InvalidContainerArgumentException(final String containerTypeName, final Container<?> container,
                                                final Optional<Object> cause, final String messageTemplate,
                                                final Object[] messageArguments) {
        super(messageTemplate + "{0}")

        this.container = container;
    }

    /**
     * Returns the {@link Container} reference by this
     * {@link InvalidContainerArgumentException}.
     *
     * @return referenced {@link Container}
     */
    public Container<?> getContainer() {
        return container;
    }
}
