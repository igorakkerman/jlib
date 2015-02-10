package org.jlib.text;

/**
 * Exception thrown when an end index of a {@link CharSequence} is above its
 * upper bound.
 *
 * @author Igor Akkerman
 */
public class CharSequenceEndIndexAboveBoundException
extends CharSequenceIndexOutOfBoundsException {

    private static final long serialVersionUID = -1052579867414829092L;

    public CharSequenceEndIndexAboveBoundException(final CharSequence charSequence, final int endIndex) {
        super(charSequence, endIndex);
    }
}
