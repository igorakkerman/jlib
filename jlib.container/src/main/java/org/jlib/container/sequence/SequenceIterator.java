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
import java.util.NoSuchElementException;

/**
 * TODO: how about using the name Traverser instead of Iterator? Iterator of a
 * sequence.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface SequenceIterator<Element>
extends Iterator<Element> {

    /**
     * Verifies whether this Iterator has a previous Element.
     * 
     * @return {@code true} if this Iterator has a previous Element;
     *         {@code false} otherwise
     */
    public boolean hasPrevious();

    /**
     * Returns the previous Element of this Iterator.
     * 
     * @return the previous Element of this Iterator
     * @throws NoSuchElementException
     *         if there is no previous Element
     */
    public Element previous()
    throws NoSuchElementException;

    /**
     * Verifies whether this Iterator has a next Element.
     * 
     * @return {@code true} if this Iterator has a next Element; {@code false}
     *         otherwise
     */
    @Override
    public boolean hasNext();

    /**
     * Returns the next Element of this Iterator.
     * 
     * @return the next Element of this Iterator
     * @throws NoSuchElementException
     *         if there is no next Element
     */
    @Override
    public Element next()
    throws NoSuchElementException;
}
