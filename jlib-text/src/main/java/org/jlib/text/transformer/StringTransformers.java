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

import java.util.Formatter;
import java.util.Locale;

import lombok.experimental.UtilityClass;

/**
 * Package facade providing access to various {@link StringTransformer
 * StringTransformers}.
 *
 * @author Igor Akkerman
 */
@UtilityClass
public final class StringTransformers {

    /**
     * Returns a new {@link StringTransformer} centering a substring in a String
     * of the specified length. The String is padded using blanks before and
     * after the substring. If the number of characters to pad is odd, the back
     * will be padded with one character more than the front.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer center(final int finalStringLength) {
        return center(finalStringLength, ' ');
    }

    /**
     * Returns a new {@link StringTransformer} centering a substring in a String
     * of the specified length. The String is padded using a specified padding
     * character before and after the substring. If the number of characters to
     * pad is odd, the back will be padded with one character more than the
     * front.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @param paddingCharacter
     *        character used for padding
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer center(final int finalStringLength, final char paddingCharacter) {
        return new CenteringStringTransformer(finalStringLength, paddingCharacter);
    }

    /**
     * Returns a new {@link StringTransformer} centering a substring in a String
     * of the specified length. The String is padded using blanks before and
     * after the substring. If the number of characters to pad is odd, the front
     * will be padded with one character more than the back.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer centerRight(final int finalStringLength) {
        return centerRight(finalStringLength, ' ');
    }

    /**
     * Returns a new {@link StringTransformer} centering a substring in a String
     * of the specified length. The String is padded using a specified padding
     * character before and after the substring. If the number of characters to
     * pad is odd, the front will be padded with one character more than the
     * back.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @param paddingCharacter
     *        character used for padding
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer centerRight(final int finalStringLength, final char paddingCharacter) {
        return new RightCenteringStringTransformer(finalStringLength, paddingCharacter);
    }

    /**
     * Returns a new {@link StringTransformer} left-aligning a substring in a
     * String of the specified length. The String is padded using blanks after
     * the substring.
     *
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer leftAlign(final int finalStringLength) {
        return leftAlign(finalStringLength, ' ');
    }

    /**
     * Returns a new {@link StringTransformer} left-aligning a substring in a
     * String of the specified length. The String is padded using a specified
     * padding character after the substring.
     *
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @param paddingCharacter
     *        character used for padding
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer leftAlign(final int finalStringLength, final char paddingCharacter) {
        return new LeftAligningStringTransformer(finalStringLength, paddingCharacter);
    }

    /**
     * Returns a new {@link StringTransformer} right-aligning a substring in a
     * String of the specified length. The String is padded using blanks before
     * the substring.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer rightAlign(final int finalStringLength) {
        return rightAlign(finalStringLength, ' ');
    }

    /**
     * Returns a new {@link StringTransformer} right-aligning a substring in a
     * String of the specified length. The String is padded using a specified
     * padding character before the substring.
     *
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     *
     * @param paddingCharacter
     *        character used for padding
     *
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer rightAlign(final int finalStringLength, final char paddingCharacter) {
        return new RightAligningStringTransformer(finalStringLength, paddingCharacter);
    }

    public static StringTransformer camelCaseToLowerCaseWords() {
        return new CamelCaseToLowerCaseWordsTransformer();
    }

    /**
     * Returns a new {@link StringTransformer} using the specified format (as
     * defined by {@link Formatter}) to transform the String. The content of the
     * used {@link StringBuilder} will be used as sole formatted value.
     *
     * @param format
     *        {@link String} specifying the format
     *
     * @return the newly created {@link StringTransformer}
     */
    public StringTransformer format(final String format) {
        return new FormattingStringTransformer(format);
    }

    /**
     * Returns a new {@link StringTransformer} using the specified format (as
     * defined by {@link Formatter}) to transform the String applying the
     * current {@link Locale}. The original String will be used as the value
     * with the specified index.
     *
     * @param format
     *        {@link String} specifying the format
     *
     * @param originalStringValueIndex
     *        integer specifying the index in the formatted values of the
     *        original String
     *
     * @param values
     *        argument sequence of {@link Object Objects} specifying the values to
     *        format
     *
     * @return the newly created {@link StringTransformer}
     *
     * @throws IndexOutOfBoundsException
     *         if {@code originalStringValueIndex < 0 || originalStringValueIndex > values.length}
     */
    public StringTransformer format(final String format, final int originalStringValueIndex, final Object... values) {
        return new FormattingStringTransformer(format, originalStringValueIndex, values);
    }

    /**
     * Returns a new {@link StringTransformer} using the specified format (as
     * defined by {@link Formatter}) to transform the String applying the
     * specified {@link Locale}. The original String will be used as the value
     * with the specified index.
     *
     * @param locale
     *        {@link Locale} to apply; {@code null} if no {@link Locale} should
     *        be applied
     * @param format
     *        {@link String} specifying the format
     * @param originalStringValueIndex
     *        integer specifying the index in the formatted values of the
     *        original String
     * @param values
     *        argument sequence of {@link Object Objects} specifying the values to
     *        format
     * @return the newly created {@link StringTransformer}
     * @throws IndexOutOfBoundsException
     *         if {@code originalStringValueIndex < 0 ||
     *         originalStringValueIndex > values.length}
     */
    public StringTransformer format(final Locale locale, final String format, final int originalStringValueIndex, final Object... values) {
        return new FormattingStringTransformer(locale, format, originalStringValueIndex, values);
    }
}
