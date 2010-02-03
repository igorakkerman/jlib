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
 * {@link StringTransformer} centering a substring in a String of the specified
 * length. The String is padded using a specified padding character before and
 * after the substring. If the number of characters to pad is odd, the back will
 * be padded with one character more than the front.
 * 
 * @author Igor Akkerman
 */
public class CenteringStringTransformer
extends PaddingStringTransformer {

    /**
     * Creates a new CenteringStringTransformer.
     * 
     * @param finalStringLength
     *        integer specifying the length of the String to return by this
     *        CenteringStringTransformer
     * @param paddingCharacter
     *        character used for padding
     */
    public CenteringStringTransformer(int finalStringLength, char paddingCharacter) {
        super(finalStringLength, paddingCharacter);
    }

    // @see org.jlib.core.text.transformation.PaddingStringTransformer#pad(java.lang.StringBuilder)
    @Override
    public void pad(StringBuilder stringBuilder, StringBuilder halfPadBuilder, boolean additionalPaddingCharacterRequired) {
        stringBuilder.insert(0, halfPadBuilder);
        stringBuilder.append(halfPadBuilder);

        if (additionalPaddingCharacterRequired)
            stringBuilder.append(getPaddingCharacter());
    }
}
