package org.jlib.text.transformer;

import java.util.Formatter;
import java.util.Locale;

import static java.lang.System.arraycopy;

/**
 * {@link StringTransformer} using the specified format (as defined by
 * {@link Formatter}) to transform the String.
 *
 * @author Igor Akkerman
 */
public class FormattingStringTransformer
implements StringTransformer {

    /** {@link Locale} applied when formatting the String */
    private final Locale locale;

    /** format {@link String} to use */
    private final String format;

    /** array of {@link Object Objects} specifying the values to format */
    private final Object[] values;

    /** integer specifying the index in the formatted values of the original String */
    private final int originalStringValueIndex;

    /**
     * Creates a new FormattingStringTransformer for the specified format (as
     * defined by {@link Formatter}). The content of the used
     * {@link StringBuilder} will be used as sole formatted value.
     *
     * @param format
     *        {@link String} specifying the format
     */
    public FormattingStringTransformer(final String format) {
        this(null, format, 0);
    }

    /**
     * Creates a new FormattingStringTransformer for the specified format (as
     * defined by {@link Formatter}) and the specified values to be formatted
     * applying the current {@link Locale}. The original String will be used as
     * the value with the specified index.
     *
     * @param format
     *        {@link String} specifying the format
     * @param originalStringValueIndex
     *        integer specifying the index in the formatted values of the
     *        original String
     * @param values
     *        argument sequence of {@link Object Objects} specifying the values to
     *        format
     * @throws IndexOutOfBoundsException
     *         if {@code originalStringValueIndex < 0 ||
     *         originalStringValueIndex > values.length}
     */
    public FormattingStringTransformer(final String format, final int originalStringValueIndex, final Object... values) {
        this(null, format, originalStringValueIndex, values);
    }

    /**
     * Creates a new FormattingStringTransformer for the specified format (as
     * defined by {@link Formatter}) and the specified values to be formatted
     * applying the specified {@link Locale}. The original String will be used
     * as the value with the specified index.
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
     * @throws IndexOutOfBoundsException
     *         if {@code originalStringValueIndex < 0 ||
     *         originalStringValueIndex > values.length}
     */
    public FormattingStringTransformer(final Locale locale, final String format, final int originalStringValueIndex, final Object... values) {
        final int valuesCount = values.length;

        if (originalStringValueIndex < 0 || originalStringValueIndex > valuesCount)
            throw new IndexOutOfBoundsException(Integer.toString(originalStringValueIndex));

        this.locale = locale;
        this.format = format;
        this.originalStringValueIndex = originalStringValueIndex;

        this.values = new Object[valuesCount + 1];
        arraycopy(values, 0, this.values, 0, originalStringValueIndex);
        arraycopy(values, originalStringValueIndex, this.values, originalStringValueIndex + 1,
                  valuesCount - originalStringValueIndex);
    }


    @Override
    public void transform(final StringBuilder stringBuilder) {
        values[originalStringValueIndex] = stringBuilder.toString();
        stringBuilder.setLength(0);
        new Formatter(stringBuilder).format(locale, format, values);
    }

}
