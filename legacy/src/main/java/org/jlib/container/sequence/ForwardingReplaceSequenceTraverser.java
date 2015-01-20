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

import org.jlib.core.iterator.InvalidIteratorStateException;
import org.jlib.core.iterator.ReplaceIterator;

/**
 * {@link SequenceIterator} delegating its calls to another {@link SequenceIterator}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ForwardingReplaceSequenceIterator<Item>
extends ForwardingSequenceIterator<Item>
implements SequenceIterator<Item>,
           ReplaceIterator<Item> {

    private final ReplaceIterator<Item> delegateReplaceIterator;

    public <DelegateIterator extends SequenceIterator<Item> & ReplaceIterator<Item>> /*
        */ ForwardingReplaceSequenceIterator(final DelegateIterator delegateIterator) {

        super(delegateIterator);

        delegateReplaceIterator = delegateIterator;
    }

    @Override
    public void replace(final Item newItem)
    throws InvalidIteratorStateException {
        delegateReplaceIterator.replace(newItem);
    }
}
