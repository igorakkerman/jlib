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
 * Registry providing access to the DigitalObjectsFactory.
 * 
 * @author Igor Akkerman
 */
public interface DigitalObjectsFactoryRegistry {

    /**
     * Returns the DigitalObjectsFactory used to construct new DigitalObjects.
     * 
     * @return the DigitalObjectsFactory
     */
    public DigitalObjectsFactory getDigitalObjectsFactory();
}
