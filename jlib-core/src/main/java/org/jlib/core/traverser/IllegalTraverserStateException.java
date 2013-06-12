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

import org.jlib.core.IllegalJlibStateException;

/**
 * {@link IllegalJlibStateException} thrown when an illegal state has been
 * reached in a {@link Traverser}.
 *
 * @author Igor Akkerman
 */
public abstract class IllegalTraverserStateException
extends IllegalJlibStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    /** traversed {@link Traversible} */
    private final Traversible<?> traversible;

    /**
     * Creates a new {@link IllegalTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     */
    public IllegalTraverserStateException(final Traversible<?> traversible) {
        this(traversible, null);
    }

    /**
     * Creates a new {@link IllegalTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalThreadStateException}
     */
    public IllegalTraverserStateException(final Traversible<?> traversible, final Throwable cause) {
        this(traversible, "{1}", cause);
    }

    /**
     * Creates a new {@link IllegalTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public IllegalTraverserStateException(final Traversible<?> traversible, final String messagePattern, final Object... messageArguments) {
        this(traversible, messagePattern, (Throwable) null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalThreadStateException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public IllegalTraverserStateException(final Traversible<?> traversible, final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, traversible, messageArguments);

        this.traversible = traversible;
    }

    /**
     * Returns the traversed {@link Traversible}.
     *
     * @return traversed {@link Traversible}
     */
    public Traversible<?> getTraversible() {
        return traversible;
    }
}
