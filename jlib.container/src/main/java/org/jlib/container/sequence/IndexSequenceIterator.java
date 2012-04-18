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
     * @return the previous Element of this Iterator; returns
     *         {@code getFirstIndex() - 1} if there is no previous Element
     */
    public int previousIndex();

    /**
     * Returns the next Element of this Iterator.
     * 
     * @return the next Element of this Iterator; returns
     *         {@code getLastIndex() + 1} if there is no next Element
     * 
     * @throws IllegalStateException
     *         if no Element has been returned by this
     *         {@link IndexSequenceIterator}
     */
    public int nextIndex();
}
