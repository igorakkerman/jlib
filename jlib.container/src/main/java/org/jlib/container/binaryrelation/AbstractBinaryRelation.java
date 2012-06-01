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

import org.jlib.container.AbstractContainer;
import org.jlib.core.traverser.Traverser;

/**
 * Skeletal implementation of a {@link BinaryRelation}.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the
 *        {@link BinaryRelation}
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the
 *        {@link BinaryRelation}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractBinaryRelation<LeftValue, RightValue>
extends AbstractContainer<Association<LeftValue, RightValue>>
implements BinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new {@link AbstractBinaryRelation}.
     */
    protected AbstractBinaryRelation() {
        super();
    }

    @Override
    public Traverser<Association<LeftValue, RightValue>> createTraverser() {
        return new DefaultBinaryRelationTraverser<LeftValue, RightValue, BinaryRelation<LeftValue, RightValue>>(this);
    }

    @Override
    public boolean contains(final LeftValue leftValue, final RightValue rightValue) {
        return hasLeft(leftValue) && rightSet(leftValue).contains(rightValue);
    }

    @Override
    public boolean contains(final Association<LeftValue, RightValue> association) {
        return contains(association.left(), association.right());
    }
}
