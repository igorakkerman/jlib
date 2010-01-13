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

import java.util.RandomAccess;

/**
 * <p>
 * Ordered random access sequence with minimum and maximum indices.
 * <p>
 * <p>
 * Since the {@link java.util.List} interface of the Java Collections Framework is zero-based, this
 * interface extends {@code org.jlib.core.collections.list.List} instead.
 * </p>
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface IndexList<Element>
extends List<Element>, RandomAccess {

    /**
     * Returns the Element stored at the specified index in this IndexList.
     *
     * @param index
     *        integer specifying the index of the stored Element
     * @return Element stored at {@code index}
     * @throws ListIndexOutOfBoundsException
     *         if {@code index < getMinIndex() || index > getMaxIndex()}
     */
    public Element get(int index)
    throws ListIndexOutOfBoundsException;

    /**
     * Returns the minimum index of this IndexList.
     *
     * @return integer specifying the minimum index
     */
    public int minIndex();

    /**
     * Returns the maximum index of this IndexList.
     *
     * @return integer specifying the maximum index
     */
    public int maxIndex();

    /**
     * Returns an IndexListIterator traversing the Elements of this IndexList in proper sequence.
     * Initially, the Iterator points to the beginning of this IndexList, that is, the Element
     * returned by the first call to {@code nextIndex()} is the Element stored at
     * {@code getMinIndex()}.
     *
     * @return IndexListIterator over this IndexList initially pointing to the beginning of this
     *         IndexList
     */
    public IndexListIterator<Element> indexListIterator();

    /**
     * Returns an IndexListIterator traversing the Elements of this IndexList in proper sequence.
     * That is, the Element returned by the first call to {@code nextIndex()} is the Element stored
     * at the specified start index.
     *
     * @param startIndex
     *        integer specifying the index of the first Element returned by the Iterator
     * @return IndexListIterator over this IndexList initially pointing to the beginning of this
     *         IndexList
     * @throws ListIndexOutOfBoundsException
     *         if {@code startIndex < minIndex() || startIndex > maxIndex()}
     */
    public IndexListIterator<Element> indexListIterator(int startIndex)
    throws ListIndexOutOfBoundsException;

    /**
     * Returns the index of the first occurrence of the specified Element in this IndexList.
     *
     * @param element
     *        Element to find
     * @return integer specifying the index of the first occurrence of {@code element}
     */
    public int indexOf(Element element);

    /**
     * Returns the index of the first occurrence of the specified Element in this IndexList.
     *
     * @param element
     *        Element to find
     * @return integer specifying the index of the first occurrence of {@code element}
     */
    public int lastIndexOf(Element element);

    /**
     * Returns a Java List containing the Elements stored in this IndexList in the specified index
     * range in proper sequence.
     *
     * @param fromIndex
     *        integer specifying the index of the first Element
     * @param toIndex
     *        integer specifying the index of the last Element
     * @return List containing the specified Elements
     * @throws IllegalArgumentException
     *         if {@code fromIndex > toIndex}
     * @throws ListIndexOutOfBoundsException
     *         if {@code fromIndex < getMinIndex() || toIndex > getMaxIndex()}
     */
    public java.util.List<Element> subJavaList(int fromIndex, int toIndex)
    throws IllegalArgumentException, ListIndexOutOfBoundsException;

    /**
     * Returns an IndexList containing the Elements stored in this IndexList in the specified index
     * range. The Elements in the result IndexList will have the same index as they had in this
     * IndexList.
     *
     * @param fromIndex
     *        integer specifying the index of the first Element
     * @param toIndex
     *        integer specifying the index of the last Element
     * @return IndexList containing the specified Elements
     * @throws IllegalArgumentException
     *         if {@code fromIndex > toIndex}
     * @throws ListIndexOutOfBoundsException
     *         if {@code fromIndex < getMinIndex() || toIndex > getMaxIndex()}
     */
    public IndexList<Element> subList(int fromIndex, int toIndex)
    throws IllegalArgumentException, ListIndexOutOfBoundsException;

    /**
     * Returns whether the specified Object is an IndexList with the same minimum and maximum
     * indices and contains equal Elements at the same indices. Two Elements {@code element1} and
     * {@code element2} are equal if and only if both are {@code null} or both are equal by the
     * {@code equals()} method.
     *
     * @param otherIndexList
     *        Object to compare to this IndexList
     * @return {@code true} if {@code indexList} is equal to this IndexList; {@code false} otherwise
     */
    @Override
    public boolean equals(Object otherIndexList);
    
}
