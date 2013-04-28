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

import org.jlib.container.RemoveAllContainer;

/**
 * {@link RemoveSequence} and {@link RemoveAllContainer}.
 * 
 * @param <Item>
 *        type of items held in the {@link RemoveAllSequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveAllSequence<Item>
extends RemoveSequence<Item>, RemoveAllContainer<Item> {
    // unifying interface
}
