package org.jlib.text.transformer;

import static org.jlib.core.math.NumberUtility.isOdd;

/**
 * Skeletal implementation of a {@link StringTransformer} padding a String.
 *
 * @author Igor Akkerman
 */
public abstract class PaddingStringTransformer
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
        for (int halfPadIndex = 0; halfPadIndex < halfPadLength; halfPadIndex ++)
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
     * @param halfPadBuilder
     *        {@link StringBuilder}
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


    @Override
    public String toString() {
        return getClass().getSimpleName() + "[finalStringLength=" + finalStringLength + ", paddingCharacter='" +
               paddingCharacter + "']";
    }


    @Override
    public boolean equals(final Object otherObject) {
        if (otherObject == null || !getClass().equals(otherObject.getClass()))
            return false;

        final PaddingStringTransformer otherPaddingStringTransformer = (PaddingStringTransformer) otherObject;

        return finalStringLength == otherPaddingStringTransformer.finalStringLength &&
               paddingCharacter == otherPaddingStringTransformer.paddingCharacter;
    }


    @Override
    public int hashCode() {
        return finalStringLength << 16 + paddingCharacter;
    }
}
