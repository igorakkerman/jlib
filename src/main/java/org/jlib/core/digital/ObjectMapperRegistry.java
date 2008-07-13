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
 * Registry providing access to the general ObjectMapper.
 * 
 * @author Igor Akkerman
 */
public interface ObjectMapperRegistry {

    /**
     * Returns the ObjectMapper used to retrieve the general value represented
     * by a DigitalObject.
     * 
     * @param <ValueObject>
     *        type of the Objects specifying the values represented by the
     *        DigitalObjects
     * @return the ObjectMapper
     */
    public <ValueObject> ObjectMapper<ValueObject> getObjectUtility();
}
