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

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.jlib.core.collections.CollectionsUtility;
import org.jlib.core.digital.DigitalElement;

import static org.jlib.core.system.SystemUtility.LINE_SEPARATOR;

/**
 * DigitalObject in the seven-bars representation.
 * 
 * @author Igor Akkerman
 */
// not final, must be extended to create prototype DigitalObjects
class DigitalObject
extends org.jlib.core.digital.DigitalObject {

    /** Set of legal DigitalElements for this Digit */
    private Set<? extends DigitalElement> legalDigitalElements;

    /**
     * Creates a new DigitalObject in which no DigitalElements are set active
     * initially.
     */
    DigitalObject() {
        super();
        legalDigitalElements = Collections.unmodifiableSet(CollectionsUtility.asSet(Bar.values()));
    }

    // @see org.jlib.core.common.digital.DigitalObject#getLegalDigitalElements()
    @Override
    public Collection<? extends DigitalElement> getLegalDigitalElements() {
        return legalDigitalElements;
    }

    // @see org.jlib.core.common.digital.DigitalObject#clone()
    @Override
    public DigitalObject clone() {
        return (DigitalObject) super.clone();
    }

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LINE_SEPARATOR);
        stringBuffer.append(isDigitalElementActive(Bar.TOP_BAR) ? " -" : "");
        stringBuffer.append(LINE_SEPARATOR);
        stringBuffer.append(isDigitalElementActive(Bar.TOP_LEFT_BAR) ? "| " : "  ");
        stringBuffer.append(isDigitalElementActive(Bar.TOP_RIGHT_BAR) ? "|" : "");
        stringBuffer.append(LINE_SEPARATOR);
        stringBuffer.append(isDigitalElementActive(Bar.MIDDLE_BAR) ? " -" : "");
        stringBuffer.append(LINE_SEPARATOR);
        stringBuffer.append(isDigitalElementActive(Bar.BOTTOM_LEFT_BAR) ? "| " : "  ");
        stringBuffer.append(isDigitalElementActive(Bar.BOTTOM_RIGHT_BAR) ? "|" : "");
        stringBuffer.append(LINE_SEPARATOR);
        stringBuffer.append(isDigitalElementActive(Bar.BOTTOM_BAR) ? " - " : "  ");
        stringBuffer.append(LINE_SEPARATOR);
        return stringBuffer.toString();
    }
}
