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

import org.jlib.container.RemoveContainerIterator;

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

    /**
     * Returns the traversed {@link RemoveSequence}
     * 
     * @return traversed {@link RemoveSequence}
     */
    @Override
    public RemoveSequence<Element> getSequence();
}
