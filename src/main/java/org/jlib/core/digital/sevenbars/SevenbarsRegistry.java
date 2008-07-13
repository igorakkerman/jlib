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

package org.jlib.core.digital.sevenbars;

import org.jlib.core.digital.DigitMapper;
import org.jlib.core.digital.DigitMapperRegistry;
import org.jlib.core.digital.DigitalObjectsFactoryRegistry;
import org.jlib.core.digital.ObjectMapper;
import org.jlib.core.digital.ObjectMapperRegistry;

/**
 * @author Igor Akkerman
 */
public class SevenbarsRegistry
implements DigitalObjectsFactoryRegistry, ObjectMapperRegistry, DigitMapperRegistry {

    /** sole instance of this class */
    private static final SevenbarsRegistry INSTANCE = new SevenbarsRegistry();

    /**
     * Returns the sole instance of this class.
     * 
     * @return the sole instance of this class
     */
    public static SevenbarsRegistry instance() {
        return INSTANCE;
    }

    /** DigitalObjectsFactory */
    private final DigitalObjectsFactory digitalObjectsFactory;

    /** ObjectMapper */
    private final ObjectMapper<Object> objectMapper;

    /** DigitMapper */
    private final DigitMapper digitMapper;

    /**
     * Creates a new PackageRegistry.
     */
    private SevenbarsRegistry() {
        super();
        digitalObjectsFactory = new DigitalObjectsFactory();
        objectMapper = new ObjectMapper<Object>(digitalObjectsFactory.getPrototypeDigitalObjects());
        digitMapper = new DigitMapper(digitalObjectsFactory.getPrototypeDigitalObjects());
    }

    // @see org.jlib.core.common.digital.DigitalObjectsFactoryRegistry#getDigitalObjectsFactory()
    @Override
    public org.jlib.core.digital.DigitalObjectsFactory getDigitalObjectsFactory() {
        return digitalObjectsFactory;
    }

    // @see org.jlib.core.common.digital.DigitUtilityRegistry#getObjectUtility()
    @Override
    @SuppressWarnings("unchecked")
    // thanks to type erasure only one instance needs to be stored
    public <ValueObject> ObjectMapper<ValueObject> getObjectUtility() {
        return (ObjectMapper<ValueObject>) objectMapper;
    }

    // @see org.jlib.core.common.digital.DigitUtilityRegistry#getDigitUtility()
    @Override
    public DigitMapper getDigitUtility() {
        return digitMapper;
    }
}
