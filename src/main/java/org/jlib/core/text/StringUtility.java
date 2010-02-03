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

import org.jlib.core.text.transformation.StringTransformer;

// TODO: create method String transform(String, StringTransformer...)

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
    public static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_PROPERTYNAME);

    /** no visible constructor */
    private StringUtility() {}

    /**
     * Transforms the specified {@link String} using the specified
     * {@link StringTransformer}.
     * 
     * @param string
     *        {@link String} to transform
     * @param stringTransformer
     *        {@link StringTransformer} used for transformation
     * @return the transformed String
     */
    public static String transform(String string, StringTransformer stringTransformer) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringTransformer.transform(stringBuilder);
        return stringBuilder.toString();
    }
}
