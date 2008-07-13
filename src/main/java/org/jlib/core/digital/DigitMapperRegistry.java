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
 * Registry providing access to the DigitMapper.
 * 
 * @author Igor Akkerman
 */
public interface DigitMapperRegistry {

    /**
     * Returns the DigitMapper used to retrieve the digit represented by a
     * DigitalObject.
     * 
     * @return the DigitMapper
     */
    public DigitMapper getDigitUtility();
}
