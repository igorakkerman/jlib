/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.text.transformer;

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
    public CenteringStringTransformer(final int finalStringLength, final char paddingCharacter) {
        super(finalStringLength, paddingCharacter);
    }


    @Override
    public void pad(final StringBuilder stringBuilder, final StringBuilder halfPadBuilder, final boolean additionalPaddingCharacterRequired) {
        stringBuilder.insert(0, halfPadBuilder);
        stringBuilder.append(halfPadBuilder);

        if (additionalPaddingCharacterRequired)
            stringBuilder.append(getPaddingCharacter());
    }
}
