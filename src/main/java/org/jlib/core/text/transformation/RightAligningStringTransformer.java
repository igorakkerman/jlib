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
 * {@link StringTransformer} right-aligning a substring in a String of the
 * specified length. The String is padded using a specified padding character
 * after the substring.
 * 
 * @author Igor Akkerman
 */
public class RightAligningStringTransformer
extends PaddingStringTransformer {

    /**
     * Creates a new RightAligningStringTransformer.
     * 
     * @param finalStringLength
     *        integer specifying the length of the String to return by this
     *        CenteringStringTransformer
     * @param paddingCharacter
     *        character used for padding
     */
    public RightAligningStringTransformer(int finalStringLength, char paddingCharacter) {
        super(finalStringLength, paddingCharacter);
    }

    // @see org.jlib.core.text.transformation.PaddingStringTransformer#pad(java.lang.StringBuilder)
    @Override
    public void pad(StringBuilder stringBuilder, StringBuilder halfPadBuilder, boolean additionalPaddingCharacterRequired) {
        StringBuilder padBuilder = halfPadBuilder;
        padBuilder.append(halfPadBuilder);
        if (additionalPaddingCharacterRequired)
            padBuilder.append(getPaddingCharacter());

        stringBuilder.insert(0, padBuilder);
    }
}
