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

/**
 * Skeletal implementation of a {@link SequenceTraverser}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 *
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceTraverser<Item, Sequenze extends Sequence<Item>>
implements SequenceTraverser<Item> {

    /** traversed {@link Sequence} */
    private final Sequenze sequence;

    /**
     * Creates a new {@link AbstractSequenceTraverser}.
     *
     * @param sequence
     *        traversed {@link Sequence}
     */
    public AbstractSequenceTraverser(final Sequenze sequence) {
        super();

        this.sequence = sequence;
    }

    /**
     * Returns the traversed {@link Sequence}.
     *
     * @return traversed {@link Sequence}
     */
    protected Sequenze getSequence() {
        return sequence;
    }
}
