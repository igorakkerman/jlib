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
 * Exception thrown when an attempt is made to add illegal DigitalElements to
 * the DigitalObject. The set of legal DigitalElements is defined by the
 * concrete DigitalObject class.
 * 
 * @author Igor Akkerman
 */
public class IllegalDigitalElementException
extends RuntimeException {

    /** DigitalObject not accepting the illegal DigitalElement */
    private DigitalObject digitalObject;

    /** DigitalElement not accepted by the DigitalObject */
    private DigitalElement illegalDigitalElement;

    /**
     * Creates a new IllegalDigitalElementException for the specified
     * DigitalObject and the specified DigitalElement.
     * 
     * @param digitalObject
     *        DigitalObject not accepting the illegal DigitalElement
     * @param illegalDigitalElement
     *        DigitalElement not accepted by {@code digitalObject}
     */
    public IllegalDigitalElementException(DigitalObject digitalObject, DigitalElement illegalDigitalElement) {
        super();
        this.digitalObject = digitalObject;
        this.illegalDigitalElement = illegalDigitalElement;
    }

    /**
     * Returns the DigitalObject of this IllegalDigitalElementException.
     * 
     * @return DigitalObject not accepting the illegal DigitalElement
     */
    public DigitalObject getDigitalObject() {
        return digitalObject;
    }

    /**
     * Returns the illegal DigitalElement of this
     * IllegalDigitalElementException.
     * 
     * @return DigitalElement not accepted by the DigitalObject
     */
    public DigitalElement getIllegalDigitalElement() {
        return illegalDigitalElement;
    }
}
