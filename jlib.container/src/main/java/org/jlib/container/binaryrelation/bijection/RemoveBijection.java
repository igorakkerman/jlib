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

package org.jlib.container.binaryrelation.bijection;

import org.jlib.container.binaryrelation.NoSuchAssociationException;
import org.jlib.container.binaryrelation.RemoveBinaryRelation;

/**
 * Bijection allowing to add new associations.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the bijection
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the bijection
 * 
 * @author Igor Akkerman
 */
public interface RemoveBijection<LeftValue, RightValue>
extends Bijection<LeftValue, RightValue>, RemoveBinaryRelation<LeftValue, RightValue> {

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue)
    throws NoSuchAssociationException;
}
