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

package org.jlib.core.collections.relation;

/**
 * Bijection allowing to add new associations.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the bijection
 * @param <RightObject>
 *        type of the objects on the right hand side of the bijection
 * @author Igor Akkerman
 */
public interface ModifiableBijection<LeftObject, RightObject>
extends Bijection<LeftObject, RightObject>, ModifiableBinaryRelation<LeftObject, RightObject> {
    // intentionally left blank
}
