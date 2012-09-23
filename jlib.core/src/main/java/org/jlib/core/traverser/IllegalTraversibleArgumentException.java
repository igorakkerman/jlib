/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

package org.jlib.core.traverser;

import org.jlib.core.IllegalJlibArgumentException;

/**
 * {@link IllegalArgumentException} referencing a {@link Traversible}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalTraversibleArgumentException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -207300032064585595L;

    /** referenced {@link Traversible} */
    private final Traversible<?> traversible;

    /**
     * Creates a new {@link IllegalTraversibleArgumentException}.
     * 
     * @param traversible
     *        referenced {@link Traversible}
     */
    public IllegalTraversibleArgumentException(final Traversible<?> traversible) {
        this(traversible, "{1}");
    }

    /**
     * Creates a new {@link IllegalTraversibleArgumentException}.
     * 
     * @param traversible
     *        referenced {@link Traversible}
     * 
     * @param messagePattern
     *        String specifying the pattern of the error message
     * 
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public IllegalTraversibleArgumentException(final Traversible<?> traversible, final String messagePattern,
                                               final Object... messageArguments) {

        this(traversible, messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalTraversibleArgumentException}.
     * 
     * @param traversible
     *        referenced {@link Traversible}
     * 
     * @param messagePattern
     *        String specifying the pattern of the error message
     * 
     * @param cause
     *        Throwable that caused this
     *        {@link IllegalTraversibleArgumentException}
     * 
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public IllegalTraversibleArgumentException(final Traversible<?> traversible, final String messagePattern,
                                               final Throwable cause, final Object... messageArguments) {

        super(messagePattern, cause, traversible, messageArguments);

        this.traversible = traversible;
    }

    /**
     * Returns the {@link Traversible} referenced by this
     * {@link IllegalTraversibleArgumentException}.
     * 
     * @return referenced {@link Traversible}
     */
    public Traversible<?> getTraversible() {
        return traversible;
    }
}
