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
 * Exception thrown when a DigitalObject has no known value.
 * 
 * @author Igor Akkerman
 */
public class UnknownDigitalObjectException
extends Exception {

    /** the unknown DigitalObject */
    private DigitalObject unknownDigitalObject;

    /**
     * Creates a new UnknownDigitalObjectException for the specified unknown
     * DigitalObject.
     * 
     * @param unknownDigitalObject
     *        the unknown DigitalObject
     */
    UnknownDigitalObjectException(DigitalObject unknownDigitalObject) {
        super();
        this.unknownDigitalObject = unknownDigitalObject;
    }
    
    /**
     * Returns the unknown DigitalObject of this UnknownDigitalObjectException.
     *
     * @return the unknown DigitalObject
     */
    public DigitalObject getUnknownDigitalObject() {
        return unknownDigitalObject;
    }
    
    // @see java.lang.Throwable#toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + unknownDigitalObject + "]";
    }
}
