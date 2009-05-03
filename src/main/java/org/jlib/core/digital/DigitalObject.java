package org.jlib.core.digital;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Digital representation of an object, for instance, a digit of a digital
 * clock. A DigitalObject is formed by DigitalElements which may be set active
 * or inactive. The set of DigitalElements forming a DigitalObject is only
 * restricted by the number of existing instances of the DigitalElement
 * interface. Commonly, this class is parameterized by an enumeration type
 * defining the DigitalElements forming the DigitalObjects.
 * 
 * @author Igor Akkerman
 */
public abstract class DigitalObject
implements Cloneable {

    /** Set of DigitalElements set active in this Digit */
    private Set<DigitalElement> activeDigitalElements;

    /**
     * Creates a new DigitalObject in which no DigitalElements are set active
     * initially.
     */
    protected DigitalObject() {
        super();
        activeDigitalElements = new HashSet<DigitalElement>();
    }

    /**
     * Returns whether the specified DigitalElement in this DigitalObject is
     * active.
     * 
     * @param digitalElement
     *        DigitalElement to test
     * @return {@code true} if {@code digitalElement} is set active;
     *         {@code false} otherwise
     * @throws IllegalDigitalElementException
     *         if {@code digitalElement} is illegal
     */
    public boolean isDigitalElementActive(DigitalElement digitalElement)
    throws IllegalDigitalElementException {
        assertDigitalElementLegal(digitalElement);
        return activeDigitalElements.contains(digitalElement);
    }

    /**
     * Sets active or inactive the specified DigitalElement in this
     * DigitalObject. If the specified DigitalElement
     * 
     * @param digitalElement
     *        DigitalElement to register in this DigitalObject
     * @param active
     *        {@code true} to set {@code digitalElement} active; {@code false}
     *        to set {@code digitalElement} inactive
     * @throws IllegalDigitalElementException
     *         if {@code digitalElement} is illegal
     */
    public void setDigitalElementActive(DigitalElement digitalElement, boolean active)
    throws IllegalDigitalElementException {
        assertDigitalElementLegal(digitalElement);
        if (active)
            activeDigitalElements.add(digitalElement);
        else
            activeDigitalElements.remove(digitalElement);
    }

    /**
     * Returns the Collection of the active DigitalElements in this DigitalObject.
     * 
     * @return Set of the active DigitalElements in this DigitalObject; the
     *         returned Set is an unmodifiable view on the actual Set
     */
    public Collection<DigitalElement> getActiveDigitalElements() {
        return Collections.unmodifiableSet(activeDigitalElements);
    }

    /**
     * Registers the Collection of the active DigitalElements in this
     * DigitalObject.
     * 
     * @param activeDigitalElements
     *        Collection of the active DigitalElements in this DigitalObject;
     * @throws IllegalDigitalElementException
     *         if at least one DigitalElement in {@code activeDigitalElements}
     *         is illegal
     */
    public void setActiveDigitalElements(Collection<? extends DigitalElement> activeDigitalElements)
    throws IllegalDigitalElementException {
        this.activeDigitalElements.clear();
        for (DigitalElement activeDigitalElement : activeDigitalElements)
            setDigitalElementActive(activeDigitalElement, true);
    }

    /**
     * Returns the Collection of DigitalElements that are legal for this
     * DigitalObject.
     * 
     * @return Collection of legal DigitalElements
     */
    public abstract Collection<? extends DigitalElement> getLegalDigitalElements();

    /**
     * Verifies whether the specified DigitalElement is legal for this
     * DigitalObject. Template method implemented in the concrete DigitalObject
     * class.
     * 
     * @param digitalElement
     *        DigitalElement to accept
     * @throws IllegalDigitalElementException
     *         if {@code digitalElement} is illegal
     */
    private void assertDigitalElementLegal(DigitalElement digitalElement)
    throws IllegalDigitalElementException {
        if (!getLegalDigitalElements().contains(digitalElement))
            throw new IllegalDigitalElementException(this, digitalElement);
    }

    // @see java.lang.Object#clone()
    @Override
    public DigitalObject clone() {
        try {
            DigitalObject newDigit = (DigitalObject) super.clone();
            newDigit.activeDigitalElements = new HashSet<DigitalElement>();
            newDigit.setActiveDigitalElements(activeDigitalElements);
            return newDigit;
        }
        catch (CloneNotSupportedException exception) {
            // impossible to occur here
            throw new RuntimeException(exception);
        }
    }

    // @see java.lang.Object#equals(java.lang.Object)
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof DigitalObject))
            return false;

        DigitalObject otherDigitalObject = (DigitalObject) otherObject;
        return activeDigitalElements.equals(otherDigitalObject.activeDigitalElements);
    }

    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return activeDigitalElements.hashCode();
    }

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() + activeDigitalElements;
    }
}
