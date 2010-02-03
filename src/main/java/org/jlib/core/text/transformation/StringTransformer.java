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

package org.jlib.core.text.transformation;

/**
 * Transformer of a String using the strategy defined by the implementation of
 * this interface. The actual transformation is performed within a
 * {@link StringBuilder}, which is passed as an argument to the
 * {@link #transform} method.
 * 
 * @author Igor Akkerman
 */
public interface StringTransformer {

    /**
     * Transforms the String contained by the specified {@link StringBuilder}
     * using the strategy of this {@link StringTransformer}.
     * 
     * @param stringBuilder
     *        {@link StringBuilder} containing the String to transform
     */
    public void transform(StringBuilder stringBuilder);
}
