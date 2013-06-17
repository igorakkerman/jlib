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

package org.jlib.container.matrix;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;
import org.jlib.core.traverser.Traverser;

/**
 * AbstractIndexMatrixTraverser traversing the items of a
 * {@link RandomTraversalMatrix} entity-wise. An entity can be defined by the
 * concrete implementation, examples would be columns, rows or other
 * submatrixes.
 *
 * @param <Entry>
 *        type of items stored in the {@link Matrix}
 *
 * @author Igor Akkerman
 */
public class EntityMatrixTraverser<Entry>
extends AbstractMatrixTraverser<Entry> {

    /**
     * {@link Traverser} traversing the {@link Sequence} of all {@link Matrix}
     * entities
     */
    private final SequenceTraverser<? extends Sequence<Entry>> entitiesTraverser;

    /** {@link Traverser} of a {@link Matrix} entity */
    private SequenceTraverser<Entry> entityTraverser;

    /**
     * Creates a new {@link EntityMatrixTraverser} for the specified
     * {@link RandomTraversalMatrix}.
     *
     * @param matrix
     *        {@link RandomTraversalMatrix} to traverse
     *
     * @param entities
     *        {@link Sequence} of all entities, each specified as a
     *        {@link Sequence} of entries of the {@link Matrix}
     */
    public EntityMatrixTraverser(final RandomTraversalMatrix<Entry> matrix, final Sequence<? extends Sequence<Entry>> entities) {
        super(matrix);

        entitiesTraverser = entities.createTraverser();
        gotoNextEntity();
    }

    @Override
    public boolean hasNextEntity() {
        return entitiesTraverser.isNextItemAccessible();
    }

    @Override
    public void gotoNextEntity()
    throws InvalidStateException {
        entityTraverser = entitiesTraverser.getNextItem().createTraverser();
    }

    @Override
    public boolean isNextItemAccessible() {
        return entityTraverser.isNextItemAccessible() || hasNextEntity();
    }

    @Override
    public Entry getNextItem() {
        if (! entityTraverser.isNextItemAccessible())
            gotoNextEntity();

        return entityTraverser.getNextItem();
    }
}
