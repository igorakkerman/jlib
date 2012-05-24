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

import org.jlib.container.ReplaceContainer;

/**
 * <p>
 * Sequence that allows its Elements to be modified using an
 * ReplaceSequenceIterator.
 * </p>
 * <p>
 * It does not necessarily allow modification of the sequence, that is, this
 * interface does not provide methods for adding and removing Elements. See
 * {@link AddSequence} for this functionality.
 * </p>
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceSequence<Element>
extends ReplaceContainer<Element>, Sequence<Element> {

    /**
     * <p>
     * Returns an ReplaceSequenceIterator traversing the Elements of this
     * Sequence in proper order.
     * </p>
     * <p>
     * The {@link ReplaceSequenceIterator#replace(Object) set} method of the
     * {@link SequenceIterator} can be used to modify Elements in this Sequence.
     * </p>
     * 
     * @return ReplaceSequenceIterator traversing the Elements of this Sequence
     *         in proper order
     */
    @Override
    public ReplaceSequenceIterator<Element> createIterator();
}
