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

import java.util.Iterator;

/**
 * <p>
 * Iterator of a List implementing the Java Iterator interface.
 * </p>
 * <p>
 * The {@code remove()} method of this implementation throws an
 * {@link UnsupportedOperationException}.
 * </p>
 * 
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
class LegacyListIterator<Element>
implements Iterator<Element> {

    /** backing Iterator */
    protected ListIterator<Element> backingIterator;

    /**
     * Creates a new Iterator over the Elements of the specified List.
     * 
     * @param list
     *        List to traverse
     */
    LegacyListIterator(List<Element> list) {
        super();
        backingIterator = list.listIterator();
    }

    // @see java.util.Iterator#hasNext()
    @Override
    public boolean hasNext() {
        return backingIterator.hasNext();
    }

    // @see java.util.Iterator#next()
    @Override
    public Element next() {
        return backingIterator.next();
    }

    // @see java.util.Iterator#remove()
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
