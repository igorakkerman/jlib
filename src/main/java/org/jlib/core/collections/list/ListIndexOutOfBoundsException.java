package org.jlib.core.collections.list;

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
 * Exception thrown when a jlib List is accessed with an illegal index.
 * 
 * @author Igor Akkerman
 */
public class ListIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    /** illegal index */
    private int index;

    /**
     * Creates a new ListIndexOutOfBoundsException for the specified illegal
     * index.
     * 
     * @param index
     *        integer specifying the illegal index
     */
    public ListIndexOutOfBoundsException(int index) {
        super(String.valueOf(index));
        this.index = index;
    }

    /**
     * Creates a new ListIndexOutOfBoundsException for the specified illegal
     * index and the specified message.
     * 
     * @param index
     *        integer specifying the illegal index
     * @param message
     *        String specifying the message
     */
    public ListIndexOutOfBoundsException(int index, String message) {
        super(message + "[" + index + "]");
    }

    /**
     * Returns the illegal index of this ListIndexOutOfBoundsException.
     * 
     * @return integer specifying the illegal index
     */
    public int getIndex() {
        return index;
    }
}
