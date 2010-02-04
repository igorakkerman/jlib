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
 * Class providing mapping methods between the digital representation of some
 * well-defined kind of Objects and the Objects.
 * 
 * @param <ValueObject>
 *        type of the Objects specifying the values represented by the
 *        DigitalObjects
 * @author Igor Akkerman
 */
public class ObjectMapper<ValueObject> {

    /** Association of Objects with their corresponding prototype DigitalObjects */
    private PrototypeDigitalObjects prototypeDigitalObjects;

    /**
     * Creates a new ObjectMapper.
     * 
     * @param prototypeDigitalObjects
     *        PrototypeDigitalObjects of this ObjectMapper
     */
    public ObjectMapper(PrototypeDigitalObjects prototypeDigitalObjects) {
        super();
        this.prototypeDigitalObjects = prototypeDigitalObjects;
    }

    /**
     * Returns the ValueObject represented by the specified DigitalObject if it
     * represents a value of the kind of values for which this ObjectMapper
     * provides utility methods.
     * 
     * @param digitalObject
     *        DigitalObject representing the value
     * @return ValueObject specifying the value represented by
     *         {@code digitalObject}
     * @throws InvalidValueKindException
     *         if {@code digitalObject} does not represent a value of the valid
     *         kind
     */
    // TODO: check if the Exception catching can't be avoided in favor to an earlier verification
    @SuppressWarnings("unchecked")
    public ValueObject valueOf(DigitalObject digitalObject)
    throws InvalidValueKindException {
        try {
            return (ValueObject) prototypeDigitalObjects.getValue(digitalObject);
        }
        catch (UnknownDigitalObjectException exception) {
            throw new InvalidValueKindException(digitalObject);
        }
    }

    /**
     * Verifies whether the specified DigitalObject represents the value of the
     * kind for which this ObjectMapper provides utility methods.
     * 
     * @param digitalObject
     *        the DigitalObject to verify
     * @return {@code true} if {@code digitalObject} represents the valid kind;
     *         {@code false} otherwise
     */
    public boolean hasValidKind(DigitalObject digitalObject) {
        try {
            valueOf(digitalObject);
            return true;
        }
        catch (InvalidValueKindException exception) {
            return false;
        }
    }
}
