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

import static org.jlib.core.string.StringUtility.LINE_SEPARATOR;

/**
 * Exception thrown when a DigitalObject does not represent a value of a certain
 * kind.
 * 
 * @author Igor Akkerman
 */
public class InvalidValueKindException
extends Exception {

    /** DigitalObject not representing a value of a certain kind */
    private DigitalObject digitalObject;

    /**
     * Creates a new NoValueException for the specified DigitalObject.
     * 
     * @param digitalObject
     *        DigitalObject not representing a value of a certain kind
     */
    protected InvalidValueKindException(DigitalObject digitalObject) {
        super();
        this.digitalObject = digitalObject;
    }

    /**
     * Creates a new NoValueException for the specified DigitalObject and the
     * original Throwable that caused this Exception.
     * 
     * @param digitalObject
     *        DigitalObject not representing a value of a certain kind
     * @param cause
     *        original Throwable that caused this Exception
     */
    public InvalidValueKindException(DigitalObject digitalObject, Throwable cause) {
        super(cause);
        this.digitalObject = digitalObject;
    }

    /**
     * Returns the DigitalObject not representing a value of a certain kind.
     * 
     * @return DigitalObject not representing a value of a certain kind
     */
    public DigitalObject getDigitalObject() {
        return digitalObject;
    }

    // @see java.lang.Throwable#toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() + LINE_SEPARATOR + digitalObject;
    }
}