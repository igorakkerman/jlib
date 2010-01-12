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

package org.jlib.core.string;

/**
 * Formatter of a String to fit in fixed width lines.
 * 
 * @author Igor Akkerman
 */
public interface StringFormatter {

    /**
     * Formats the specified String to fit in lines with the specified width.
     * 
     * @param string
     *        String to format
     * @return formatted String
     */
    public String format(String text);
}
