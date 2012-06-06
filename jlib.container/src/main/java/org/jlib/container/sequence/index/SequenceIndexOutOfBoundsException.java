package org.jlib.container.sequence.index;

import org.jlib.container.sequence.IllegalSequenceArgumentException;

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
 * {@link IllegalSequenceArgumentException} thrown when a {@link IndexSequence}
 * is accessed with an invalid index.
 * 
 * @author Igor Akkerman
 */
public class SequenceIndexOutOfBoundsException
extends IllegalSequenceArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1501618255867836784L;

    /** invalid index */
    private final int invalidIndex;

    /**
     * Creates a new SequenceIndexOutOfBoundsException for the specified invalid
     * invalidIndex and the specified message.
     * 
     * @param sequence
     *        {@link IndexSequence} accessed with the invalid index
     * 
     * @param invalidIndex
     *        integer specifying the invalid invalidIndex
     * 
     * @param message
     *        {@link String} specifying the message explaining the invalid
     *        access
     */
    public SequenceIndexOutOfBoundsException(final IndexSequence<?> sequence, final int invalidIndex,
                                             final String message) {
        super(sequence, "{1}: {3}[{2}]", invalidIndex, message);

        this.invalidIndex = invalidIndex;
    }

    /**
     * Returns the invalid index of this SequenceIndexOutOfBoundsException.
     * 
     * @return integer specifying the invalid index
     */
    public int getInvalidIndex() {
        return invalidIndex;
    }
}
