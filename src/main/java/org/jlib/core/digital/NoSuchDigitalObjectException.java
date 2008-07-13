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

/**
 * Exception thrown when trying to access the digital representation of an
 * Object for which one doesn't exist.
 * 
 * @author Igor Akkerman
 */
public class NoSuchDigitalObjectException
extends RuntimeException {

    /** Object for which a digital representation doesn't exist */
    private final Object object;

    /**
     * Creates a new NoSuchDigitalObjectException for the specified Object.
     * 
     * @param object
     *        Object for which a digital representation doesn't exist
     */
    public NoSuchDigitalObjectException(Object object) {
        super();
        this.object = object;
    }
    
    // @see java.lang.Throwable#toString()
    @Override
    public String toString() {
        return getClass().getSimpleName()+ "[" + object + "]";
    }
}
