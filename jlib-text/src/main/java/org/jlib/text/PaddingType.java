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

package org.jlib.text;

/**
 * String padding type.
 * 
 * @author Igor Akkerman
 */
public enum PaddingType {

    /** front padding */
    FRONT,

    /** back padding */
    BACK,

    /**
     * equal front and back padding. If the number of characters to pad is odd,
     * the front will be padded with one character more than the back
     */
    FRONTBACK,

    /**
     * equal front and back padding. If the number of characters to pad is odd,
     * the back will be padded with one character more than the front
     */
    BACKFRONT
}
