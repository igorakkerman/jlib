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
import java.util.NoSuchElementException;

/**
 * {@link Traverser} over an {@link Iterable}.
 *
 * @param <Item>
 *        type of the items of the {@link Iterable}
 *
 * @author Igor Akkerman
 */
public class IterableTraverser<Item>
implements Traverser<Item> {

    /** delegate {@link Iterator} */
    private final Iterator<Item> delegateIterator;

    /** referenced {@link Traversible} in case of an error */
    private final Traversible<Item> traversible = new ConstantTraverserTraversible<>(this);

    /**
     * Creates a new {@link IterableTraverser} for the specified delegate
     * {@link Iterator}.
     *
     * @param iterable
     *        {@link Iterable} to traverse
     */
    public IterableTraverser(final Iterable<Item> iterable) {
        super();

        delegateIterator = iterable.iterator();
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        try {
            return delegateIterator.next();
        }
        catch (final NoSuchElementException exception) {
            throw new NoNextItemException(traversible, exception);
        }
    }

    @Override
    public boolean isNextItemAccessible() {
        return delegateIterator.hasNext();
    }

    /**
     * Returns the delegate {@link Iterator} of this {@link IterableTraverser}.
     *
     * @return delegate {@link Iterator}
     */
    public Iterator<Item> getDelegateIterator() {
        return delegateIterator;
    }
}
