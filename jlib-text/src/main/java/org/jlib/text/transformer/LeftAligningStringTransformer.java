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
    public LeftAligningStringTransformer(final int finalStringLength, final char paddingCharacter) {
        super(finalStringLength, paddingCharacter);
    }

    @Override
    public void pad(final StringBuilder stringBuilder, final StringBuilder halfPadBuilder,
                    final boolean additionalPaddingCharacterRequired) {
        stringBuilder.append(halfPadBuilder);
        stringBuilder.append(halfPadBuilder);
        if (additionalPaddingCharacterRequired)
            stringBuilder.append(getPaddingCharacter());
    }
}
