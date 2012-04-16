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

package org.jlib.core.text;

import org.jlib.core.system.SystemUtility;

/**
 * Utility class providing static methods for String operations and
 * manipulations.
 * 
 * @author Igor Akkerman
 */
public final class StringUtility {

    /** property name of the system's line separator */
    public static final String LINE_SEPARATOR_PROPERTYNAME = "line.separator";

    /** the system's line separator */
    public static final String LINE_SEPARATOR = SystemUtility.getApplicationProperty(LINE_SEPARATOR_PROPERTYNAME);

    /** no visible constructor */
    private StringUtility() {}
}
