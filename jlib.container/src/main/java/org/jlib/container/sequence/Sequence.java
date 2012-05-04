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

import org.jlib.container.Container;

/**
 * Ordered sequence of elements.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface Sequence<Element>
extends Container<Element> {

    /**
     * Returns a {@link SequenceIterator} traversing the Elements of this
     * Sequence in proper sequence. The Element returned by the first call to
     * {@link SequenceIterator#next()} is the first Element in the Sequence.
     * 
     * @return SequenceIterator over this Sequence
     */
    @Override
    public SequenceIterator<Element> createIterator();

    /**
     * <p>
     * Verifies whether the specified Object is a Sequence containing equal
     * Elements as this Sequence.
     * </p>
     * <p>
     * Two Elements {@code element1} and {@code element2} are equal if and only
     * if both are {@code null} or both are equal by the {@link #equals(Object)}
     * method.
     * </p>
     * 
     * @param otherObject
     *        Object to compare to this Sequence
     * @return {@code true} if {@code otherObject} is equal to this Sequence;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(final Object otherObject);

    /**
     * <p>
     * Returns a {@link List} containing all Elements stored in this Sequence in
     * proper sequence.
     * </p>
     * <p>
     * The method duplicates the functionality of the {@link #toList()} method.
     * </p>
     * 
     * @return {@link List} containing the Elements stored in this Sequence
     */
    @Override
    public List<Element> toCollection();

    /**
     * <p>
     * Returns a {@link List} containing all Elements stored in this Sequence in
     * proper sequence.
     * </p>
     * <p>
     * The method provides the same functionality as the {@link #toCollection()}
     * method and has been introduced .
     * </p>
     * 
     * @return {@link List} containing the Elements stored in this Sequence
     */
    public List<Element> toList();
}
