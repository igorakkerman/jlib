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

import java.util.Iterator;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * AbstractIndexMatrixIterator traversing the elements of a
 * {@link RandomTraversalMatrix} entity-wise. An entity can be defined by
 * the concrete implementation, examples would be columns, rows or other
 * submatrixes.
 * 
 * @param <Entry>
 *        type of elements stored in the {@link Matrix}
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

        entitiesIterator = entities.createIterator();
        gotoNextEntity();
    }

    @Override
    public boolean hasNextEntity() {
        return entitiesIterator.hasNext();
    }

    @Override
    public void gotoNextEntity()
    throws IllegalStateException {
        entityIterator = entitiesIterator.next().createIterator();
    }

    @Override
    public boolean hasNext() {
        return entityIterator.hasNext() || hasNextEntity();
    }

    @Override
    public Entry next() {
        if ( !entityIterator.hasNext())
            gotoNextEntity();

        return entityIterator.next();
    }
}
