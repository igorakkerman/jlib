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

package org.jlib.core.io.encoding.base64;

import java.io.IOException;

/**
 * Exception thrown if a stream is an invalid base64 stream.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidBase64StreamException
extends IOException {

    /**
     * Creates a new InvalidBase64StreamException.
     */
    protected InvalidBase64StreamException() {
        super();
    }
}
