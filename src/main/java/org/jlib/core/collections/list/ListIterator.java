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

package org.jlib.core.collections.list;

import java.util.NoSuchElementException;

/**
 * Iterator over a list.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface ListIterator<Element> {

    /**
     * Returns whether this Iterator has a previous Element.
     *
     * @return {@code true} if this Iterator has a previous Element; {@code false} otherwise
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
     * Returns whether this Iterator has a next Element.
     *
     * @return {@code true} if this Iterator has a next Element; {@code false} otherwise
     */
    public boolean hasNext();

    /**
     * Returns the next Element of this Iterator.
     *
     * @return the next Element of this Iterator
     * @throws NoSuchElementException
     *         if there is no next Element
     */
    public Element next()
    throws NoSuchElementException;
}
