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

import org.jlib.container.ReplaceContainerIterator;

/**
 * Iterator of an ReplaceSequence.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceSequenceIterator<Element>
extends ReplaceContainerIterator<Element>, SequenceIterator<Element> {

    /**
     * Replaces the last Element returned by {@code previous()} or
     * {@code next()} with the specified value.
     * 
     * @param element
     *        Element by which the former Element is replaced
     * 
     * @throws NoElementToReplaceException
     *         if no Element has been returned by this
     *         {@link ReplaceSequenceIterator}
     */
    @Override
    public void replace(final Element element)
    throws NoElementToReplaceException;

    /**
     * Returns the traversed {@link ReplaceSequence}
     * 
     * @return traversed {@link ReplaceSequence}
     */
    @Override
    public ReplaceSequence<Element> getSequence();
}
