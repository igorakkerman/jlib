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

package org.jlib.container.sequence;

import org.jlib.core.language.AbstractObject;

/**
 * {@link SequenceTraverser} delegating its calls to another {@link SequenceTraverser}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class DelegatingSequenceTraverser<Item>
extends AbstractObject
implements SequenceTraverser<Item> {

    /** {@link SequenceTraverser} to which all calls are delegated */
     private final SequenceTraverser<Item> delegateTraverser;

    /**
     * Creates a new {@link DelegatingSequenceTraverser}.
     *
     * @param delegateTraverser
     *        {@link SequenceTraverser} used as delegate
     */
    public DelegatingSequenceTraverser(final SequenceTraverser<Item> delegateTraverser) {
        super();

        this.delegateTraverser = delegateTraverser;
    }

    /**
     * Returns the {@link SequenceTraverser} of this {@link DelegatingSequenceTraverser}.
     *
     * @return the {@link SequenceTraverser}
     */
    protected SequenceTraverser getDelegateTraverser() {
        return delegateTraverser;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        return delegateTraverser.getPreviousItem();
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        return delegateTraverser.getNextItem();
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return delegateTraverser.isPreviousItemAccessible();
    }

    @Override
    public boolean isNextItemAccessible() {
        return delegateTraverser.isNextItemAccessible();
    }
}
