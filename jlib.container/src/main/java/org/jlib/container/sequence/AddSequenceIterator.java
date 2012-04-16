/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence;

/**
 * Iterator over a {@link AddSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface AddSequenceIterator<Element>
extends SequenceIterator<Element> {

    /**
     * <p>
     * Inserts the specified Element into the sequence at the current position
     * of this Iterator.
     * </p>
     * <p>
     * The Element is inserted immediately before the next Element that would
     * have been returned by {@link #next()} and immediately after the previous
     * Element that would have been returned by {@link #previous()}.
     * </p>
     * <p>
     * A subsequent call to {@link #next()} would be unaffected, and a
     * subsequent call to {@link #previous()} would return the new element.
     * </p>
     * 
     * @param element
     *        Element to add
     * 
     * @throws IllegalStateException
     *         if {@link #next()} or {@link #previous()} have not been called
     *         initially or after the last call to {@link #add(Object)} or
     *         {@link #remove()}
     */
    public void add(Element element)
    throws IllegalStateException;
}
