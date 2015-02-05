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

package org.jlib.container.operation.sequence;

import org.jlib.core.language.AbstractObject;

/**
 * {@link SequenceIterator} delegating its calls to another {@link SequenceIterator}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ForwardingSequenceIterator<Item>
extends AbstractObject
implements SequenceIterator<Item> {

    /** {@link SequenceIterator} to which all calls are delegated */
     private final SequenceIterator<Item> delegateIterator;

    /**
     * Creates a new {@link ForwardingSequenceIterator}.
     *
     * @param delegateIterator
     *        {@link SequenceIterator} used as delegate
     */
    public ForwardingSequenceIterator(final SequenceIterator<Item> delegateIterator) {
        super();

        this.delegateIterator = delegateIterator;
    }

    /**
     * Returns the {@link SequenceIterator} of this {@link ForwardingSequenceIterator}.
     *
     * @return the {@link SequenceIterator}
     */
    protected SequenceIterator getDelegateIterator() {
        return delegateIterator;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        return delegateIterator.getPreviousItem();
    }

    @Override
    public Item next()
    throws NoNextSequenceItemException {
        return delegateIterator.next();
    }

    @Override
    public boolean hasPreviousItem() {
        return delegateIterator.hasPreviousItem();
    }

    @Override
    public boolean hasNext() {
        return delegateIterator.hasNext();
    }
}
