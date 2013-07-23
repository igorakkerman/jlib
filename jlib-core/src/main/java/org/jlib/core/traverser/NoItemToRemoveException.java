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

/**
 * {@link InvalidTraverserStateException} thrown when there is Item to remove by
 * a {@link Traverser}.
 *
 * @author Igor Akkerman
 */
public class NoItemToRemoveException
extends InvalidTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5330769541839992129L;

    /**
     * Creates a new {@link NoItemToRemoveException}.
     *
     * @param traversable
     *        traversed {@link Traversable}
     */
    public NoItemToRemoveException(final Traversable<?> traversable) {
        super(traversable);
    }

    /**
     * Creates a new {@link NoItemToRemoveException} with the specified cause.
     *
     * @param traversable
     *        traversed {@link Traversable}
     *
     * @param cause
     *        {@link Exception} that caused this {@link NoItemToRemoveException}
     */
    public NoItemToRemoveException(final Traversable<?> traversable, final Exception cause) {
        super(traversable, cause);
    }
}
