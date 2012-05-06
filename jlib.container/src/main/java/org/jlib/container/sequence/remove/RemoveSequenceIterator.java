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

package org.jlib.container.sequence.remove;

import org.jlib.container.RemoveContainerIterator;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * Iterator over a {@link RemoveSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveSequenceIterator<Element>
extends SequenceIterator<Element>, RemoveContainerIterator<Element> {

    @Override
    public void remove()
    throws IllegalStateException;
}
