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

package org.jlib.core.traverser;

import org.jlib.core.exception.InvalidArgumentException;

/**
 * {@link IllegalArgumentException} referencing a {@link Traversible}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidTraversibleArgumentException
extends InvalidArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 207300032064585595L;

    /** referenced {@link Traversible} */
    private final Traversible<?> traversible;

    /**
     * Creates a new {@link InvalidTraversibleArgumentException}.
     *
     * @param traversible
     *        referenced {@link Traversible}
     */
    public InvalidTraversibleArgumentException(final Traversible<?> traversible) {
        this(traversible, "{1}");
    }

    /**
     * Creates a new {@link InvalidTraversibleArgumentException}.
     *
     * @param traversible
     *        referenced {@link Traversible}
     *
     * @param messageTemplate
     *        String specifying the template of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public InvalidTraversibleArgumentException(final Traversible<?> traversible, final String messageTemplate, final Object... messageArguments) {

        this(traversible, messageTemplate, null, messageArguments);
    }

    /**
     * Creates a new {@link InvalidTraversibleArgumentException}.
     *
     * @param traversible
     *        referenced {@link Traversible}
     *
     * @param messageTemplate
     *        String specifying the template of the error message
     *
     * @param cause
     *        Throwable that caused this
     *        {@link InvalidTraversibleArgumentException}
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public InvalidTraversibleArgumentException(final Traversible<?> traversible, final String messageTemplate, final Throwable cause, final Object... messageArguments) {

        super(messageTemplate, cause, traversible, messageArguments);

        this.traversible = traversible;
    }

    /**
     * Returns the {@link Traversible} referenced by this
     * {@link InvalidTraversibleArgumentException}.
     *
     * @return referenced {@link Traversible}
     */
    public Traversible<?> getTraversible() {
        return traversible;
    }
}
