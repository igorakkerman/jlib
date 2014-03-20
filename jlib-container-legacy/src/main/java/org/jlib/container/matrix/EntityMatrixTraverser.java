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

package org.jlib.container.operation.matrix;

import org.jlib.core.language.InvalidStateException;
import org.jlib.core.iterator.Iterator;

import org.jlib.container.operation.sequence.Sequence;
import org.jlib.container.operation.sequence.SequenceIterator;

/**
 * AbstractIndexMatrixIterator traversing the items of a
 * {@link RandomTraversalMatrix} entity-wise. An entity can be defined by the
 * concrete implementation, examples would be columns, rows or other
 * submatrixes.
 *
 * @param <Entry>
 *        type of items stored in the {@link Matrix}
 *
 * @author Igor Akkerman
 */
public class EntityMatrixIterator<Entry>
extends AbstractMatrixIterator<Entry> {

    /**
     * {@link Iterator} traversing the {@link Sequence} of all {@link Matrix}
     * entities
     */
    private final SequenceIterator<? extends Sequence<Entry>> entitiesIterator;

    /** {@link Iterator} of a {@link Matrix} entity */
    private SequenceIterator<Entry> entityIterator;

    /**
     * Creates a new {@link EntityMatrixIterator} for the specified
     * {@link RandomTraversalMatrix}.
     *
     * @param matrix
     *        {@link RandomTraversalMatrix} to traverse
     *
     * @param entities
     *        {@link Sequence} of all entities, each specified as a
     *        {@link Sequence} of entries of the {@link Matrix}
     */
    public EntityMatrixIterator(final RandomTraversalMatrix<Entry> matrix,
                                 final Sequence<? extends Sequence<Entry>> entities) {
        super(matrix);

        entitiesIterator = entities.iterator();
        gotoNextEntity();
    }

    @Override
    public boolean hasNextEntity() {
        return entitiesIterator.hasNext();
    }

    @Override
    public void gotoNextEntity()
    throws InvalidStateException {
        entityIterator = entitiesIterator.getNextItem().iterator();
    }

    @Override
    public boolean hasNext() {
        return entityIterator.hasNext() || hasNextEntity();
    }

    @Override
    public Entry getNextItem() {
        if (! entityIterator.hasNext())
            gotoNextEntity();

        return entityIterator.next();
    }
}
