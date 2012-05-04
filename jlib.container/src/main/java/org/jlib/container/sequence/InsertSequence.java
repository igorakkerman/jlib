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

import org.jlib.container.AddContainer;

/**
 * {@link Sequence} that allows Elements to be inserted.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertSequence<Element>
extends Sequence<Element> {

    /**
     * Returns a InsertSequenceIterator traversing the Elements of this Sequence in
     * proper order.
     * 
     * @return InsertSequenceIterator traversing the Elements of this Sequence in
     *         proper order
     */
    @Override
    public InsertSequenceIterator<Element> createIterator();
}
