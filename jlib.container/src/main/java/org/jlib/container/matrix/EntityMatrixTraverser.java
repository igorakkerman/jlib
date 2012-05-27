/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.matrix;

import java.util.Traverser;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;

/**
 * AbstractIndexMatrixTraverser traversing the items of a
 * {@link RandomTraversalMatrix} entity-wise. An entity can be defined by
 * the concrete implementation, examples would be columns, rows or other
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
    public EntityMatrixTraverser(final RandomTraversalMatrix<Entry> matrix,
                                final Sequence<? extends Sequence<Entry>> entities) {
        super(matrix);

        entitiesTraverser = entities.createTraverser();
        gotoNextEntity();
    }

    @Override
    public boolean hasNextEntity() {
        return entitiesTraverser.hasNext();
    }

    @Override
    public void gotoNextEntity()
    throws IllegalStateException {
        entityTraverser = entitiesTraverser.next().createTraverser();
    }

    @Override
    public boolean hasNext() {
        return entityTraverser.hasNext() || hasNextEntity();
    }

    @Override
    public Entry next() {
        if ( !entityTraverser.hasNext())
            gotoNextEntity();

        return entityTraverser.next();
    }
}
