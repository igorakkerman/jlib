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

/**
 * Iterator over an IndexList.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface IndexListIterator<Element>
extends ListIterator<Element> {

    /**
     * Returns the previous Element of this Iterator.
     *
     * @return the previous Element of this Iterator; returns {@code getMinIndex() - 1} if there is
     *         no previous Element
     */
    public int previousIndex();

    /**
     * Returns the next Element of this Iterator.
     *
     * @return the next Element of this Iterator; returns {@code getMaxIndex() + 1} if there is no
     *         next Element
     */
    public int nextIndex();
}
