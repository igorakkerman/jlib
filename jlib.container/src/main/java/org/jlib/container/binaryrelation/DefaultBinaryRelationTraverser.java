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

package org.jlib.container.binaryrelation;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.jlib.core.traverser.NoNextItemException;
import org.jlib.core.traverser.Traverser;

/**
 * Default implementation of a {@link Traverser} over the {@link Association}
 * items of a {@link BinaryRelation}.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the binaryRelation
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the binaryRelation
 * 
 * @param <Relation>
 *        type of the traversed {@link BinaryRelation}
 * 
 * @author Igor Akkerman
 */
public class DefaultBinaryRelationTraverser<LeftValue, RightValue, Relation extends BinaryRelation<LeftValue, RightValue>>
implements Traverser<Association<LeftValue, RightValue>> {

    /** traversed {@link BinaryRelation} */
    private final Relation binaryRelation;

    /** {@link Iterator} over the LeftValues of the {@link BinaryRelation} */
    private final Iterator<LeftValue> leftValuesIterator;

    /** {@link Iterator} over the RightValues of the {@link BinaryRelation} */
    private Iterator<RightValue> rightValuesIterator;

    /** current LeftValue */
    private LeftValue leftValue;

    /**
     * Creates a new {@link DefaultBinaryRelationTraverser} for the specified
     * {@link BinaryRelation}.
     * 
     * @param binaryRelation
     *        traversed {@link BinaryRelation}
     */
    protected DefaultBinaryRelationTraverser(final Relation binaryRelation) {
        super();

        this.binaryRelation = binaryRelation;

        leftValuesIterator = binaryRelation.leftValues().iterator();

        if (leftValuesIterator.hasNext())
            readNextLeftValue();
        else
            rightValuesIterator = Collections.<RightValue> emptySet().iterator();
    }

    /**
     * Retrieves the next LeftValue.
     */
    private void readNextLeftValue() {
        leftValue = leftValuesIterator.next();
        rightValuesIterator = binaryRelation.rightSet(leftValue).iterator();
    }

    @Override
    public boolean isNextItemAccessible() {
        return rightValuesIterator.hasNext() || leftValuesIterator.hasNext();
    }

    @Override
    public Association<LeftValue, RightValue> getNextItem()
    throws NoNextItemException {
        try {
            if (!rightValuesIterator.hasNext())
                readNextLeftValue();

            return new Association<LeftValue, RightValue>(leftValue, rightValuesIterator.next());
        }
        catch (final NoSuchElementException exception) {
            throw new NoNextItemException(binaryRelation, exception);
        }
    }

    /**
     * Returns the traversed {@link BinaryRelation}. .
     * 
     * @return traversed {@link BinaryRelation}
     */
    public Relation getBinaryRelation() {
        return binaryRelation;
    }
}
