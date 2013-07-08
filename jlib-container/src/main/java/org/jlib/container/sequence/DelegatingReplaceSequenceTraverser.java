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

import org.jlib.core.traverser.InvalidTraverserStateException;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * {@link SequenceTraverser} delegating its calls to another {@link SequenceTraverser}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class DelegatingReplaceSequenceTraverser<Item>
extends DelegatingSequenceTraverser<Item>
implements SequenceTraverser<Item>,
           ReplaceTraverser<Item> {

    private final ReplaceTraverser<Item> delegateReplaceTraverser;

    public <DelegateTraverser extends SequenceTraverser<Item> & ReplaceTraverser<Item>> /*
        */ DelegatingReplaceSequenceTraverser(final DelegateTraverser delegateTraverser) {

        super(delegateTraverser);

        delegateReplaceTraverser = delegateTraverser;
    }

    @Override
    public void replace(final Item newItem)
    throws InvalidTraverserStateException {
        delegateReplaceTraverser.replace(newItem);
    }
}
