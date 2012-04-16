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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/**
 * Ordered random access sequence with minimum and maximum indices.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface IndexSequence<Element>
extends Sequence<Element>, RandomAccess {

    /**
     * Returns the Element stored at the specified index in this IndexSequence.
     * 
     * @param index
     *        integer specifying the index of the stored Element
     * @return Element stored at {@code index}
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getMinimumIndex() || index > getMaximumIndex()}
     */
    public Element get(final int index)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns the minimum index of this IndexSequence.
     * 
     * @return integer specifying the minimum index
     */
    public int getMinimumIndex();

    /**
     * Returns the maximum index of this IndexSequence.
     * 
     * @return integer specifying the maximum index
     */
    public int getMaximumIndex();

    /**
     * Returns an IndexSequenceIterator traversing the Elements of this
     * IndexSequence in proper sequence. Initially, the Iterator points to the
     * beginning of this IndexSequence, that is, the Element returned by the
     * first call to {@code nextIndex()} is the Element stored at
     * {@code getMinimumIndex()}.
     * 
     * @return {@link IndexSequenceIterator} over this IndexSequence initially
     *         pointing to the beginning of this IndexSequence
     */
    @Override
    public IndexSequenceIterator<Element> createIterator();

    /**
     * Returns an {@link IndexSequenceIterator} traversing the Elements of this
     * IndexSequence in proper sequence. That is, the Element returned by the
     * first call to {@code nextIndex()} is the Element stored at the specified
     * start index.
     * 
     * @param startIndex
     *        integer specifying the index of the first Element returned by the
     *        Iterator
     * 
     * @return IndexSequenceIterator over this IndexSequence initially pointing to
     *         the beginning of this IndexSequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getMinimumIndex() || startIndex > getMaximumIndex()}
     */
    public IndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns the index of the first occurrence of the specified Element in
     * this IndexSequence.
     * 
     * @param element
     *        Element to find
     * @return integer specifying the index of the first occurrence of
     *         {@code element}
     * @throws NoSuchElementException
     *         if this IndexSequence does not contain {@code element}
     */
    public int indexOf(final Element element)
    throws NoSuchElementException;

    /**
     * Returns the index of the first occurrence of the specified Element in
     * this IndexSequence.
     * 
     * @param element
     *        Element to find
     * @return integer specifying the index of the first occurrence of
     *         {@code element}
     * @throws NoSuchElementException
     *         if this IndexSequence does not contain {@code element}
     */
    public int lastIndexOf(final Element element)
    throws NoSuchElementException;

    /**
     * Returns a {@link List} containing the Elements stored in this
     * IndexSequence in the specified index range in proper sequence.
     * 
     * @param fromIndex
     *        integer specifying the index of the first Element
     * @param toIndex
     *        integer specifying the index of the last Element
     * @return Sequence containing the specified Elements
     * @throws IllegalArgumentException
     *         if {@code fromIndex > toIndex}
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code fromIndex < getMinimumIndex() || toIndex > getMaximumIndex()}
     */
    public List<Element> subList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException;

    /**
     * Returns an IndexSequence containing the Elements stored in this
     * IndexSequence in the specified index range. The Elements in the result
     * IndexSequence will have the same index as they had in this IndexSequence.
     * 
     * @param fromIndex
     *        integer specifying the index of the first Element
     * @param toIndex
     *        integer specifying the index of the last Element
     * @return IndexSequence containing the specified Elements
     * @throws IllegalArgumentException
     *         if {@code fromIndex > toIndex}
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code fromIndex < getMinimumIndex() || toIndex > getMaximumIndex()}
     */
    public IndexSequence<Element> subSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException;

    /**
     * Verifies whether the specified Object is an IndexSequence with the same
     * minimum and maximum indices and contains equal Elements at the same
     * indices. Two Elements {@code element1} and {@code element2} are equal if
     * and only if both are {@code null} or both are equal by the
     * {@code equals()} method.
     * 
     * @param otherIndexSequence
     *        Object to compare to this IndexSequence
     * @return {@code true} if {@code indexSequence} is equal to this
     *         IndexSequence; {@code false} otherwise
     */
    @Override
    public boolean equals(final Object otherIndexSequence);
}
