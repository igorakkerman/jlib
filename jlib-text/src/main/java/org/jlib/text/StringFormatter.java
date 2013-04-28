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
 * Formatter of a String using the strategy defined by the implementation of this interface.
 * 
 * @author Igor Akkerman
 */
public interface StringFormatter {

    // TODO: replace by format(Appendable)
    //       create static methods in StringPadUtility class formatting a String or Appendable
    //       using the strategy defined by an implementation of this interface
    
    /**
     * Formats the specified String.
     * 
     * @param string
     *        String to format
     * @return formatted String
     */
    public String format(String string);
}
