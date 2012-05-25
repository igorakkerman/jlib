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

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoSuchSequenceElementException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * Iterator over an IndexSequence.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface IndexSequenceIterator<Element>
extends SequenceIterator<Element> {

    /**
     * Returns the previous Element of this Iterator.
     * 
     * @return the previous Element of this Iterator
     * 
     * @throws NoSuchSequenceElementException
     *         sif there is no previous Element
     */
    public int getPreviousElementIndex()
    throws NoSuchSequenceElementException;

    /**
     * Returns the next Element of this Iterator.
     * 
     * @return the next Element of this Iterator; returns
     *         {@code getLastIndex() + 1} if there is no next Element
     * 
     * @throws NoSuchSequenceElementException
     *         sif there is no next Element
     */
    public int getNextElementIndex()
    throws NoSuchSequenceElementException;

    /**
     * Returns the traversed {@link IndexSequence}
     * 
     * @return traversed {@link IndexSequence}
     */
    @Override
    public IndexSequence<Element> getSequence();
}
