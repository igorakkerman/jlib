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

package org.jlib.container.sequence.add;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequence;

/**
 * {@link IndexSequence} that allows Elements to be added.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface AddIndexSequence<Element>
extends AddSequence<Element>, IndexSequence<Element> {
    // unifying AddSequence and IndexSequence
}
