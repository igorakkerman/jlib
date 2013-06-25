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

import java.util.Iterator;

/**
 * {@link RemoveTraverser} over an {@link Iterable}.
 *
 * @author Igor Akkerman
 */
public class RemoveIterableTraverser<Item>
extends IterableTraverser<Item>
implements RemoveTraverser<Item> {

    /** referenced {@link Traversible} in case of an error */
    private final Traversible<Item> traversible = new ConstantTraverserTraversible<>(this);

    /**
     * Creates a new {@link RemoveIterableTraverser} for the specified delegate
     * {@link Iterator}.
     *
     * @param iterable
     *        {@link Iterable} to traverse
     */
    public RemoveIterableTraverser(final Iterable<Item> iterable) {
        super(iterable);
    }

    @Override
    public void remove()
    throws NoItemToRemoveException, InvalidTraversibleStateException {
        try {
            getDelegateIterator().remove();
        }
        catch (final IllegalStateException exception) {
            throw new NoItemToRemoveException(traversible, exception);
        }
        catch (final UnsupportedOperationException exception) {
            throw new InvalidTraversibleStateException(traversible, exception);
        }
    }
}
