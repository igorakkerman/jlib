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

package org.jlib.core.string.transform;

/**
 * {@link StringTransformer} left-aligning a substring in a String of the
 * specified length. The String is padded using a specified padding character
 * after the substring.
 * 
 * @author Igor Akkerman
 */
public class LeftAligningStringTransformer
extends PaddingStringTransformer {

    /**
     * Creates a new LeftAligningStringTransformer.
     * 
     * @param finalStringLength
     *        integer specifying the length of the String to return by this
     *        CenteringStringTransformer
     * @param paddingCharacter
     *        character used for padding
     */
    public LeftAligningStringTransformer(int finalStringLength, char paddingCharacter) {
        super(finalStringLength, paddingCharacter);
    }

    // @see org.jlib.core.string.transform.PaddingStringTransformer#pad(java.lang.StringBuilder)
    @Override
    public void pad(StringBuilder stringBuilder, StringBuilder halfPadBuilder, boolean additionalPaddingCharacter) {
        stringBuilder.append(halfPadBuilder);
        stringBuilder.append(halfPadBuilder);
        if (additionalPaddingCharacter)
            halfPadBuilder.append(getPaddingCharacter());
    }
}
