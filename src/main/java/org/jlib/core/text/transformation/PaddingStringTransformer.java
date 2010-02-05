package org.jlib.core.text.transformation;

import static org.jlib.core.number.NumberUtility.isOdd;

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
    protected PaddingStringTransformer(int finalStringLength, char paddingCharacter) {
        super();
        this.finalStringLength = finalStringLength;
        this.paddingCharacter = paddingCharacter;
    }

    // @see org.jlib.core.text.transformation.StringTransformer#transform(java.lang.StringBuilder)
    @Override
    public void transform(StringBuilder stringBuilder) {
        if (stringBuilder.length() >= finalStringLength)
            return;

        stringBuilder.ensureCapacity(finalStringLength);

        int originalLength = stringBuilder.length();
        int padLength = finalStringLength - originalLength;
        int halfPadLength = padLength / 2;

        StringBuilder halfPadBuilder = new StringBuilder(halfPadLength);
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

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[finalStringLength=" + finalStringLength + ", paddingCharacter='" +
               paddingCharacter + "']";
    }

    // @see java.lang.Object#equals(java.lang.Object)
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || !getClass().equals(otherObject.getClass()))
            return false;

        PaddingStringTransformer otherPaddingStringTransformer = (PaddingStringTransformer) otherObject;

        return finalStringLength == otherPaddingStringTransformer.finalStringLength &&
               paddingCharacter == otherPaddingStringTransformer.paddingCharacter;
    }
    
    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return finalStringLength << 16 + paddingCharacter;
    }
}
