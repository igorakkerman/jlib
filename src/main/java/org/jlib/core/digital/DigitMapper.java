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
 * ObjectMapper for digits, that is, numbers from 0 to 9, specified by
 * Integers.
 * 
 * @author Igor Akkerman
 */
public class DigitMapper
extends ObjectMapper<Number> {

    /**
     * Creates a new DigitMapper instance.
     * 
     * @param prototypeDigitalObjects
     *        PrototypeDigitalObjects of this DigitMapper.
     */
    public DigitMapper(PrototypeDigitalObjects prototypeDigitalObjects) {
        super(prototypeDigitalObjects);
    }

    // @see org.jlib.core.common.digital.AbstractObjectUtility#valueOf(org.jlib.core.common.digital.DigitalObject)
    @Override
    public Integer valueOf(DigitalObject digitalObject)
    throws InvalidValueKindException {
        Object valueObject = super.valueOf(digitalObject);
        if (valueObject instanceof Number) {
            int intValue = ((Number) valueObject).intValue();
            if (intValue >= 0 && intValue <= 9)
                return intValue;
        }
        throw new InvalidValueKindException(digitalObject);
    }
}
