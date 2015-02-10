package org.jlib.text;


/**
 * Exception thrown when a {@link CharSequence} begin index is negative.
 *
 * @author Igor Akkerman
 */
public class CharSequenceBeginIndexNegativeException
extends CharSequenceIndexOutOfBoundsException {

    private static final long serialVersionUID = -8810867805346253806L;

    public CharSequenceBeginIndexNegativeException(final CharSequence charSequence, final int beginIndex) {
        super(charSequence, beginIndex);
    }
}
