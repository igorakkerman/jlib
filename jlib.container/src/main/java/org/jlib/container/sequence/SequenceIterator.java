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

package org.jlib.container.sequence;

import java.util.Iterator;

/**
 * {@link Iterator} over the Elements of a {@link Sequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceIterator<Element>
extends Iterator<Element> {

    /**
     * Verifies whether this {@link SequenceIterator} has a previous Element.
     * 
     * @return {@code true} if this {@link SequenceIterator} has a previous
     *         Element; {@code false} otherwise
     */
    public boolean hasPrevious();

    /**
     * Returns the previous Element of this {@link SequenceIterator}.
     * 
     * @return the previous Element
     * 
     * @throws NoSuchSequenceElementException
     *         if there is no previous Element
     */
    public Element previous()
    throws NoSuchSequenceElementException;

    /**
     * Verifies whether this {@link SequenceIterator} has a next Element.
     * 
     * @return {@code true} if this {@link SequenceIterator} has a next Element;
     *         {@code false} otherwise
     */
    @Override
    public boolean hasNext();

    /**
     * Returns the next Element of this {@link SequenceIterator}.
     * 
     * @return the next Element
     * 
     * @throws NoSuchSequenceElementException
     *         if there is no next Element
     */
    @Override
    public Element next()
    throws NoSuchSequenceElementException;

    /**
     * Returns the traversed {@link Sequence}
     * 
     * @return traversed {@link Sequence}
     */
    public Sequence<Element> getSequence();
}
