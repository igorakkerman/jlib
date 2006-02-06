/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * File:    InvalidQuotedPrintableStreamException.java
 * Project: jlib.core
 * 
 * Copyright (c) 2006 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.io.encoding;

import java.io.IOException;

/**
 * Exception thrown if a stream is an invalid quoted-printable stream.
 * 
 * @author Igor Akkerman
 */
abstract class InvalidQuotedPrintableStreamException
extends IOException {

    /**
     * Creates a new InvalidQuotedPrintableStreamException.
     */
    protected InvalidQuotedPrintableStreamException() {
        super();
    }
}