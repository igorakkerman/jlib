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

import org.jlib.basefunctions.ApplicationObject;
import static org.jlib.shared.NumericUtility.isOdd;

/**
 * Skeletal implementation of a {@link StringTransformer} padding a String.
 *
 * @author Igor Akkerman
 */
public abstract class PaddingStringTransformer
extends ApplicationObject
implements StringTransformer {

    /** length of the String to return by this PaddingStringTransformer */
    private final int finalStringLength;

    /** character used for padding */
    private final char paddingCharacter;

    /**
     * Creates a new PaddingStringTransformer.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by this
     *        PaddingStringTransformer
     *
     * @param paddingCharacter
     *        character used for padding
     */
    protected PaddingStringTransformer(final int finalStringLength, final char paddingCharacter) {
        this.finalStringLength = finalStringLength;
        this.paddingCharacter = paddingCharacter;
    }

    @Override
    public void transform(final StringBuilder stringBuilder) {
        if (stringBuilder.length() >= finalStringLength)
            return;

        stringBuilder.ensureCapacity(finalStringLength);

        final int originalLength = stringBuilder.length();
        final int padLength = finalStringLength - originalLength;
        final int halfPadLength = padLength / 2;

        final StringBuilder halfPadBuilder = new StringBuilder(halfPadLength);
        for (int halfPadIndex = 0; halfPadIndex < halfPadLength; halfPadIndex++)
            halfPadBuilder.append(paddingCharacter);

        pad(stringBuilder, halfPadBuilder, isOdd(padLength));
    }

    /**
     * Performs the padding, assuming that the String contained by the specified
     * {@link StringBuilder} is shorter than the String to return and the
     * specified {@link StringBuilder} has a sufficient capacity.
     *
     * @param stringBuilder
     *        {@link StringBuilder} containing the String to transform
     *
     * @param halfPadBuilder
     *        {@link StringBuilder}
     *
     * @param additionalPaddingCharacterRequired
     *        {@code true} if an additional padding character should be used;
     *        {@code false} otherwise
     */
    protected abstract void pad(StringBuilder stringBuilder, StringBuilder halfPadBuilder,
                                boolean additionalPaddingCharacterRequired);

    /**
     * Returns the padding character used by this PaddingStringTransformer.
     *
     * @return the padding character
     */
    protected char getPaddingCharacter() {
        return paddingCharacter;
    }
}
