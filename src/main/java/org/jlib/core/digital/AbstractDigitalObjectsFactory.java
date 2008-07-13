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

import java.util.Collection;

/**
 * Skeletal implementation of a DigitalObjectsFactory.
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractDigitalObjectsFactory
implements DigitalObjectsFactory {

    /**
     * Creates a new DigitalObjectsFactory.
     */
    protected AbstractDigitalObjectsFactory() {
        super();
    }

    // @see org.jlib.core.common.digital.DigitalObjectsFactory#newDigitalObject()
    public abstract DigitalObject newDigitalObject();

    // @see org.jlib.core.common.digital.DigitalObjectsFactory#newDigitalObject(java.util.Collection)
    public DigitalObject newDigitalObject(Collection<DigitalElement> activeDigitalElements) {
        DigitalObject digitalObject = newDigitalObject();
        digitalObject.setActiveDigitalElements(activeDigitalElements);
        return digitalObject;
    }

    // @see org.jlib.core.common.digital.DigitalObjectsFactory#newDigitalObject(org.jlib.core.common.digital.DigitalElement[])
    public DigitalObject newDigitalObject(DigitalElement... activeDigitalElements) {
        DigitalObject digitalObject = newDigitalObject();
        for (DigitalElement digitalElement : activeDigitalElements)
            digitalObject.setDigitalElementActive(digitalElement, true);
        return digitalObject;
    }

    // @see org.jlib.core.common.digital.DigitalObjectsFactory#newDigitalObject(java.lang.Object)
    public DigitalObject newDigitalObject(Object object)
    throws NoSuchDigitalObjectException {
        DigitalObject prototypeDigitalObject = getPrototypeDigitalObjects().getDigitalObject(object);
        DigitalObject newDigitalObject = newDigitalObject();
        newDigitalObject.setActiveDigitalElements(prototypeDigitalObject.getActiveDigitalElements());
        return newDigitalObject;
    }

    /**
     * Returns the PrototypeDigitalObjects of this DigitalObjectsFactory. The
     * contents depend upon the specific implementation of this factory and the
     * corresponding concrete Digit class. Template method implemented by the
     * concrete DigitalObjectsFactory.
     * 
     * @return The prototypes held in the Bijection and the Bijection itself are
     *         immutable, that is, a call to one of their
     *         {@linkplain DigitalObject#setDigitalElementActive},
     *         {@linkplain DigitalObject#setActiveDigitalElements} or
     *         {@linkplain DigitalObject#clone()} methods will throw an
     *         {@linkplain UnsupportedOperationException}.
     */
    protected abstract PrototypeDigitalObjects getPrototypeDigitalObjects();
    // '? extends DigitalObject' allows us to use subtypes of OUR DigitalObject class
    // prohibiting us here to put in an instance of OUR DigitalObject class.
    // that is not a problem since we don't put anything into the Bijection here
}
