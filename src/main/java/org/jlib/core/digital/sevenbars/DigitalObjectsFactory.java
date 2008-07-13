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

import org.jlib.core.digital.AbstractDigitalObjectsFactory;
import org.jlib.core.digital.BijectionPrototypeDigitalObjects;
import org.jlib.core.digital.DigitalElement;
import org.jlib.core.digital.PrototypeDigitalObjects;

import static org.jlib.core.digital.sevenbars.Bar.BOTTOM_BAR;
import static org.jlib.core.digital.sevenbars.Bar.BOTTOM_LEFT_BAR;
import static org.jlib.core.digital.sevenbars.Bar.BOTTOM_RIGHT_BAR;
import static org.jlib.core.digital.sevenbars.Bar.MIDDLE_BAR;
import static org.jlib.core.digital.sevenbars.Bar.TOP_BAR;
import static org.jlib.core.digital.sevenbars.Bar.TOP_LEFT_BAR;
import static org.jlib.core.digital.sevenbars.Bar.TOP_RIGHT_BAR;

/**
 * Factory constructing objects holding a seven-bars digital representation of
 * symbols such as digits and letters. Implementation of this interface specify
 * the actual type of representation.
 * 
 * @author Igor Akkerman
 */
final class DigitalObjectsFactory
extends AbstractDigitalObjectsFactory {

    /** prototype DigitalObjects */
    // must be initialized in the constructor, otherwise legalDigitalElements is null 
    private PrototypeDigitalObjects prototypeDigitalObjects;

    /**
     * Creates a new DigitalObjectsFactory.
     */
    DigitalObjectsFactory() {
        super();
        initializePrototypeDigitalObjects();
    }

    // @see org.jlib.core.common.digital.DigitalObjectsFactory#newDigitalObject()
    @Override
    public DigitalObject newDigitalObject() {
        return new DigitalObject();
    }

    // @see org.jlib.core.common.digital.DigitalObjectFactory#getPrototypeDigitalObjects()
    @Override
    protected PrototypeDigitalObjects getPrototypeDigitalObjects() {
        return prototypeDigitalObjects;
    }

    /**
     * Initializes the PrototypeDigitalObjects association.
     */
    private void initializePrototypeDigitalObjects() {
        prototypeDigitalObjects = new BijectionPrototypeDigitalObjects();
        prototypeDigitalObjects.associate(0, newPrototypeDigitalObject(TOP_BAR, TOP_LEFT_BAR, TOP_RIGHT_BAR,
                                                                       BOTTOM_LEFT_BAR, BOTTOM_RIGHT_BAR, BOTTOM_BAR));
        prototypeDigitalObjects.associate(1, newPrototypeDigitalObject(TOP_RIGHT_BAR, BOTTOM_RIGHT_BAR));
        prototypeDigitalObjects.associate(2, newPrototypeDigitalObject(TOP_BAR, TOP_RIGHT_BAR, MIDDLE_BAR,
                                                                       BOTTOM_LEFT_BAR, BOTTOM_BAR));
        prototypeDigitalObjects.associate(3, newPrototypeDigitalObject(TOP_BAR, TOP_RIGHT_BAR, MIDDLE_BAR,
                                                                       BOTTOM_RIGHT_BAR, BOTTOM_BAR));
        prototypeDigitalObjects.associate(4, newPrototypeDigitalObject(TOP_LEFT_BAR, TOP_RIGHT_BAR, MIDDLE_BAR,
                                                                       BOTTOM_RIGHT_BAR));
        prototypeDigitalObjects.associate(5, newPrototypeDigitalObject(TOP_BAR, TOP_LEFT_BAR, MIDDLE_BAR,
                                                                       BOTTOM_RIGHT_BAR, BOTTOM_BAR));
        prototypeDigitalObjects.associate(6, newPrototypeDigitalObject(TOP_BAR, TOP_LEFT_BAR, MIDDLE_BAR,
                                                                       BOTTOM_LEFT_BAR, BOTTOM_RIGHT_BAR, BOTTOM_BAR));
        prototypeDigitalObjects.associate(7, newPrototypeDigitalObject(TOP_BAR, TOP_RIGHT_BAR, BOTTOM_RIGHT_BAR));
        prototypeDigitalObjects.associate(8, newPrototypeDigitalObject(TOP_BAR, TOP_LEFT_BAR, TOP_RIGHT_BAR,
                                                                       MIDDLE_BAR, BOTTOM_LEFT_BAR, BOTTOM_RIGHT_BAR,
                                                                       BOTTOM_BAR));
        prototypeDigitalObjects.associate(9, newPrototypeDigitalObject(TOP_BAR, TOP_LEFT_BAR, TOP_RIGHT_BAR,
                                                                       MIDDLE_BAR, BOTTOM_RIGHT_BAR, BOTTOM_BAR));
    }

    /**
     * Prototype DigitalObject.
     * 
     * @author Igor Akkerman
     */
    private class PrototypeDigitalObject
    extends DigitalObject {

        /**
         * Creates a new PrototypeDigitalObject.
         * 
         * @param activeBars
         *        comma separated list of active DigitalElements in this
         *        PrototypeDigitalObject
         */
        PrototypeDigitalObject(Bar... activeBars) {
            super();
            for (Bar bar : activeBars)
                super.setDigitalElementActive(bar, true);
        }

        @Override
        public void setDigitalElementActive(DigitalElement digitalElement, boolean active)
        throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Attempt to change the prototype " + this + ".");
        }

        @Override
        public DigitalObject clone() {
            throw new UnsupportedOperationException("Attempt to call the clone-Operation of the prototype " + this
                                                    + ".");
        }
    }

    /**
     * Creates a new prototype DigitalObject in which only the Bars contained by
     * the specified list are set active initially.
     * 
     * @param activeBars
     *        comma separated list of Bars to set active initially
     * @return the new DigitalObject
     */
    private DigitalObject newPrototypeDigitalObject(Bar... activeBars) {
        return new PrototypeDigitalObject(activeBars);
    }
}
