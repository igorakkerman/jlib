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

package org.jlib.codec.base64;

/**
 * Exception thrown if at least one character was expected in a base64 encoded stream.
 * 
 * @author Igor Akkerman
 */
public class UnexpectedEndOfBase64StreamException
extends InvalidBase64StreamException {

    /** serialVersionUID */
    private static final long serialVersionUID = -569144262427735939L;

    /**
     * Creates a new UnexpectedEndOfBase64StreamException.
     */
    protected UnexpectedEndOfBase64StreamException() {
        super();
    }
}
