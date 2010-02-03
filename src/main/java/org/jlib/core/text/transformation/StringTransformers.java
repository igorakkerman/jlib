package org.jlib.core.text.transformation;

import java.util.Formatter;
import java.util.Locale;

/**
 * Package facade providing access to various {@link StringTransformer
 * StringTransformers}.
 * 
 * @author Igor Akkerman
 */
public final class StringTransformers {

    /** No visible default constructor. */
    private StringTransformers() {}

    /**
     * Returns a new {@link StringTransformer} centering a substring in a String
     * of the specified length. The String is padded using blanks before and
     * after the substring. If the number of characters to pad is odd, the back
     * will be padded with one character more than the front.
     * 
     * @param finalStringLength
     *        integer specifying the length of the String to return by the
     *        {@link StringTransformer}
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer center(int finalStringLength) {
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
     * @param paddingCharacter
     *        character used for padding
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer center(int finalStringLength, char paddingCharacter) {
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
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer centerRight(int finalStringLength) {
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
     * @param paddingCharacter
     *        character used for padding
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer centerRight(int finalStringLength, char paddingCharacter) {
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
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer leftAlign(int finalStringLength) {
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
     * @param paddingCharacter
     *        character used for padding
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer leftAlign(int finalStringLength, char paddingCharacter) {
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
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer rightAlign(int finalStringLength) {
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
     * @param paddingCharacter
     *        character used for padding
     * @return the newly created {@link StringTransformer}
     */
    public static StringTransformer rightAlign(int finalStringLength, char paddingCharacter) {
        return new RightAligningStringTransformer(finalStringLength, paddingCharacter);
    }

    /**
     * Returns a new {@link StringTransformer} using the specified format (as
     * defined by {@link Formatter}) to transform the String. The content of the
     * used {@link StringBuilder} will be used as sole formatted value.
     * 
     * @param format
     *        {@link String} specifying the format
     * @return the newly created {@link StringTransformer}
     */
    public StringTransformer format(String format) {
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
     * @param originalStringValueIndex
     *        integer specifying the index in the formatted values of the
     *        original String
     * @param values
     *        argument list of {@link Object Objects} specifying the values to
     *        format
     * @return the newly created {@link StringTransformer}
     * @throws IndexOutOfBoundsException
     *         if {@code originalStringValueIndex < 0 ||
     *         originalStringValueIndex > values.length}
     */
    public StringTransformer format(String format, int originalStringValueIndex, Object... values) {
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
     *        argument list of {@link Object Objects} specifying the values to
     *        format
     * @return the newly created {@link StringTransformer}
     * @throws IndexOutOfBoundsException
     *         if {@code originalStringValueIndex < 0 ||
     *         originalStringValueIndex > values.length}
     */
    public StringTransformer format(Locale locale, String format, int originalStringValueIndex, Object... values) {
        return new FormattingStringTransformer(locale, format, originalStringValueIndex, values);
    }
}
