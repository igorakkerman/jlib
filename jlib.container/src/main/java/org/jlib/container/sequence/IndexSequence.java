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
 * Non-empty {@link Sequence} allowing random access to its Elements using their
 * index. The index may range from a specified minimum to a specified maximum.
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
     * 
     * @return Element stored at {@code index}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index < getFirstIndex() || index > getLastIndex()}
     */
    public Element get(final int index)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns the first index of this indexSequence.
     * 
     * @return integer specifying the minimum index
     */
    public int getFirstIndex();

    /**
     * Returns the last index of this indexSequence.
     * 
     * @return integer specifying the maximum index
     */
    public int getLastIndex();

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
    public int getFirstIndexOf(final Element element)
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
    public int getLastIndexOf(final Element element)
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
     * @throws InvalidSequenceIndexRangeException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     */
    public List<Element> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, InvalidSequenceIndexRangeException;

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
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     */
    public IndexSequence<Element> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException;

    /**
     * Returns an IndexSequenceIterator traversing the Elements of this
     * IndexSequence in proper sequence. Initially, the Iterator points to the
     * beginning of this IndexSequence, that is, the Element returned by the
     * first call to {@code nextIndex()} is the Element stored at
     * {@code getFirstIndex()}.
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
     * @return IndexSequenceIterator over this IndexSequence initially pointing
     *         to the beginning of this IndexSequence
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code startIndex < getFirstIndex() || startIndex > getLastIndex()}
     */
    public IndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException;

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
