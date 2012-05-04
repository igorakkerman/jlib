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
 * <p>
 * {@link SequenceIterator} over a {@link ReplaceIndexSequence} and
 * {@link InsertIndexSequence}.
 * </p>
 * <p>
 * This interface simply unites the capabilities of the interfaces
 * {@link ReplaceIndexSequenceIterator} and {@link InsertIndexSequenceIterator}.
 * </p>
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface InsertReplaceIndexSequenceIterator<Element>
extends ReplaceIndexSequenceIterator<Element>, InsertIndexSequenceIterator<Element> {
    // intentionally left blank
}
