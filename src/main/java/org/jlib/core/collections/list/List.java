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

import org.jlib.core.collections.Collection;

/**
 * Ordered sequence of elements.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface List<Element>
extends Collection<Element> {

    /**
     * Returns an Iterator traversing the Elements of this List in proper sequence.
     * The Element returned by the first call to {@code next()} is the first Element in the List.
     *
     * @return Iterator over this List
     */
    public Iterator<Element> iterator();

    /**
     * Returns a ListIterator traversing the Elements of this List in proper sequence.
     * The Element returned by the first call to {@code next()} is the first Element in the List.
     *
     * @return ListIterator over this List
     */
    public ListIterator<Element> listIterator();

    /**
     * <p>
     * Returns whether the specified Object is a List containing equal Elements as this List.
     * </p>
     * <p>
     * Two Elements {@code element1} and {@code element2} are equal if and only if both are
     * {@code null} or both are equal by the {@code equals()} method.
     * </p>
     *
     * @param list
     *        Object to compare to this List
     * @return {@code true} if {@code list} is equal to this List; {@code false} otherwise
     */
    public boolean equals(Object list);

    /**
     * Returns a Java List containing all Elements stored in this List in proper sequence.
     *
     * @return Java List containing the Elements stored in this List
     */
    public java.util.List<Element> toJavaList();
}
