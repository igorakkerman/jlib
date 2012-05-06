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

package org.jlib.container.sequence.replace;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequenceIterator;

/**
 * <p>
 * SequenceIterator over an ReplaceIndexSequence.
 * </p>
 * <p>
 * This interface simply unites the capabilities of the interfaces
 * {@link ReplaceSequenceIterator} and {@link IndexSequenceIterator}.
 * </p>
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceIndexSequenceIterator<Element>
extends ReplaceSequenceIterator<Element>, IndexSequenceIterator<Element> {
    // intentionally left blank
}
