package org.jlib.container.sequence;

/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

/**
 * Exception thrown when a {@link IndexSequence} is accessed with an invalid
 * index.
 * 
 * @author Igor Akkerman
 */
public class SequenceIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1501618255867836784L;

    /** {@link IndexSequence} accessed with the invalid index */
    private final IndexSequence<?> sequence;

    /** invalid index */
    private final int invalidIndex;

    /**
     * Creates a new SequenceIndexOutOfBoundsException for the specified invalid
     * invalidIndex.
     * 
     * @param sequence
     *        {@link IndexSequence} accessed with the invalid index
     * @param invalidIndex
     *        integer specifying the invalid invalidIndex
     */
    public SequenceIndexOutOfBoundsException(final IndexSequence<?> sequence, final int invalidIndex) {
        super(String.valueOf(invalidIndex));
        this.sequence = sequence;
        this.invalidIndex = invalidIndex;
    }

    /**
     * Creates a new SequenceIndexOutOfBoundsException for the specified invalid
     * invalidIndex and the specified message.
     * 
     * @param sequence
     *        {@link IndexSequence} accessed with the invalid index
     * @param invalidIndex
     *        integer specifying the invalid invalidIndex
     * @param message
     *        String specifying the message
     */
    public SequenceIndexOutOfBoundsException(final IndexSequence<?> sequence, final int invalidIndex,
                                             final String message) {
        super(message + "[" + invalidIndex + "]");
        this.sequence = sequence;
        this.invalidIndex = invalidIndex;
    }

    /**
     * Returns the invalid invalidIndex of this
     * SequenceIndexOutOfBoundsException.
     * 
     * @return integer specifying the invalid invalidIndex
     */
    public int getInvalidIndex() {
        return invalidIndex;
    }

    /**
     * Returns the {@link IndexSequence} accessed with the invalid index
     * 
     * @return {@link IndexSequence} accessed with the invalid index
     */
    public IndexSequence<?> getSequence() {
        return sequence;
    }
}
