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
 * {@link StringTransformer} centering a substring in a String of the specified
 * length. The String is padded using a specified padding character before and
 * after the substring. If the number of characters to pad is odd, the front will
 * be padded with one character more than the back.
 * 
 * @author Igor Akkerman
 */
public class RightCenteringStringTransformer
extends PaddingStringTransformer {

    /**
     * Creates a new RightCenteringStringTransformer.
     * 
     * @param finalStringLength
     *        integer specifying the length of the String to return by this
     *        RightCenteringStringTransformer
     * @param paddingCharacter
     *        character used for padding
     */
    public RightCenteringStringTransformer(int finalStringLength, char paddingCharacter) {
        super(finalStringLength, paddingCharacter);
    }

    // @see org.jlib.core.string.transform.PaddingStringTransformer#pad(java.lang.StringBuilder)
    @Override
    public void pad(StringBuilder stringBuilder, StringBuilder halfPadBuilder, boolean additionalPaddingCharacter) {
        if (additionalPaddingCharacter)
            halfPadBuilder.append(getPaddingCharacter());

        stringBuilder.insert(0, halfPadBuilder);
        stringBuilder.append(halfPadBuilder);
    }
}
