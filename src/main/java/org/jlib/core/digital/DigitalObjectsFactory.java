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

import java.util.Collection;

/**
 * Factory constructing objects holding a digital representation of symbols such
 * as digits and letters. Subclasses of this class define the actual type of the
 * representation.
 * 
 * @author Igor Akkerman
 */
public interface DigitalObjectsFactory {

    /**
     * Creates a new DigitalObject in which no DigitalElements are set active
     * initially.
     * 
     * @return the new DigitalObject
     */
    public DigitalObject newDigitalObject();

    /**
     * Creates a new DigitalObject in which only the DigitalElements contained
     * by the specified Collection are set active initially.
     * 
     * @param activeDigitalElements
     *        Collection of DigitalElements to set active initially
     * @return the new DigitalObject
     */
    public DigitalObject newDigitalObject(Collection<DigitalElement> activeDigitalElements);

    /**
     * Creates a new DigitalObject in which only the DigitalElements contained
     * by the specified list are set active initially.
     * 
     * @param activeDigitalElements
     *        comma separated list of DigitalElements to set active initially
     * @return the new DigitalObject
     */
    public DigitalObject newDigitalObject(DigitalElement... activeDigitalElements);

    /**
     * Creates a new DigitalObject representing the specified Object.
     * 
     * @param object
     *        Object to represent by a DigitalObject
     * @return the new DigitalObject
     * @throws NoSuchDigitalObjectException
     *         if a digital representation of {@code object} does not exist
     */
    public DigitalObject newDigitalObject(Object object)
    throws NoSuchDigitalObjectException;
}
