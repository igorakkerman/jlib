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

package org.jlib.core.digital;

import java.util.NoSuchElementException;

import org.jlib.core.collections.relation.ModifiableBijection;
import org.jlib.core.collections.relation.ModifiableHashBijection;

/**
 * PrototypeDigitalObjectsStorage backed by a Bijection.
 * 
 * @author Igor Akkerman
 */
public class BijectionPrototypeDigitalObjects
implements PrototypeDigitalObjects {

    /** association of DigitalObjects with their corresponding value Objects */
    private ModifiableBijection<DigitalObject, Object> association = new ModifiableHashBijection<DigitalObject, Object>();

    // @see org.jlib.core.common.digital.PrototypeDigitalObjects#associate(java.lang.Object, org.jlib.core.common.digital.DigitalObject)
    @Override
    public void associate(Object object, DigitalObject digitalObject) {
        association.add(digitalObject, object);
    }

    // @see org.jlib.core.common.digital.PrototypeDigitalObjects#getDigitalObject(java.lang.Object)
    @Override
    public DigitalObject getDigitalObject(Object object)
    throws NoSuchDigitalObjectException {
        try {
            return association.left(object);
        }
        catch (NoSuchElementException e) {
            throw new NoSuchDigitalObjectException(object);
        }
    }

    // @see org.jlib.core.common.digital.PrototypeDigitalObjects#getValue(org.jlib.core.common.digital.DigitalObject)
    @Override
    public Object getValue(DigitalObject digitalObject)
    throws UnknownDigitalObjectException {
        try {
            return association.right(digitalObject);
        }
        catch (NoSuchElementException e) {
            throw new UnknownDigitalObjectException(digitalObject);
        }
    }

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        return association.toString();
    }
}
