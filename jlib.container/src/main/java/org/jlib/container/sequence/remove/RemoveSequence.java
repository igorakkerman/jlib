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

package org.jlib.container.sequence.remove;

import org.jlib.container.RemoveContainer;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.replace.ReplaceSequence;

/**
 * {@link ReplaceSequence} that allows Elements to be added and removed.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface RemoveSequence<Element>
extends Sequence<Element>, RemoveContainer<Element> {

    /**
     * Returns a {@link RemoveSequenceIterator} traversing the Elements of this
     * Sequence in proper order.
     * 
     * @return InsertSequenceIterator traversing the Elements of this Sequence in
     *         proper order
     */
    @Override
    public RemoveSequenceIterator<Element> createIterator();
}
