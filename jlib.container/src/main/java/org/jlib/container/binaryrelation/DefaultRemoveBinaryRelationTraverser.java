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

import org.jlib.core.traverser.NoItemToRemoveException;
import org.jlib.core.traverser.RemoveTraverser;
import org.jlib.core.traverser.Traverser;
import org.jlib.core.valueholder.ValueNotAccessibleException;

/**
 * Default implementation of a {@link Traverser} over the Associations of a
 * {@link RemoveBinaryRelation}.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the binaryRelation
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the binaryRelation
 * 
 * @param <Relation>
 *        type of the traversed {@link RemoveBinaryRelation}
 * 
 * @author Igor Akkerman
 */
public class DefaultRemoveBinaryRelationTraverser<LeftValue, RightValue, Relation extends RemoveBinaryRelation<LeftValue, RightValue>>
extends DefaultBinaryRelationTraverser<LeftValue, RightValue, Relation>
implements RemoveTraverser<Association<LeftValue, RightValue>> {

    /**
     * Creates a new RemoveBinaryRelationTraverser.
     * 
     * @param binaryRelation
     *        RemoveBinaryRelation traversed by this Traverser
     */
    public DefaultRemoveBinaryRelationTraverser(final Relation binaryRelation) {
        super(binaryRelation);
    }

    @Override
    public void remove()
    throws NoItemToRemoveException {
        try {
            getBinaryRelation().remove(getLastAccessedItem());

            unsetLastAccessedItem();
        }
        catch (final ValueNotAccessibleException exception) {
            throw new NoItemToRemoveException(getBinaryRelation(), exception);
        }
    }
}
