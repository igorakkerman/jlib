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
 * Registry for the associations of the prototype DigitalObjects with their
 * corresponding Objects.
 * 
 * @author Igor Akkerman
 */
public interface PrototypeDigitalObjects {

    /**
     * Associates a DigitalObject with an Object.
     * 
     * @param object
     *        Object to associate with {@code digitalObject}
     * @param digitalObject
     *        DigitalObject to associate with {@code object}
     */
    public void associate(Object object, DigitalObject digitalObject);

    /**
     * Returns the value Object associated with the specified DigitalObject.
     * 
     * @param digitalObject
     *        the DigitalObject
     * @return Object associated with {@code digitalObject}
     * @throws UnknownDigitalObjectException
     *         if {@code digitalObject} is not associated with any value
     */
    public Object getValue(DigitalObject digitalObject)
    throws UnknownDigitalObjectException;

    /**
     * Returns the DigitalObject associated with the specified Object.
     * 
     * @param value
     *        the value Object
     * @return DigitalObject associated with {@code object}
     * @throws NoSuchDigitalObjectException
     *         if no DigitalObject is associated with {@code value}
     */
    public DigitalObject getDigitalObject(Object value)
    throws NoSuchDigitalObjectException;
}
