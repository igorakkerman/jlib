package org.jlib.core.digital.sevenbars;

import org.jlib.core.digital.DigitalElement;

/**
 * Element of the seven-bar digital representation of symbols.
 * 
 * @author Igor Akkerman
 */
public enum Bar
implements DigitalElement {

    /** horizontal top bar */
    TOP_BAR,

    /** vertical top left bar */
    TOP_LEFT_BAR,

    /** vertical top right bar */
    TOP_RIGHT_BAR,

    /** horizontal middle bar */
    MIDDLE_BAR,

    /** vertical bottom left bar */
    BOTTOM_LEFT_BAR,

    /** vertical bottom right bar */
    BOTTOM_RIGHT_BAR,

    /** horizontal bottom bar */
    BOTTOM_BAR
}
