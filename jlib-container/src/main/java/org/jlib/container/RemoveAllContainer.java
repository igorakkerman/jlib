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

package org.jlib.container;

/**
 * {@link RemoveContainer} allowing all Items to be removed.
 * 
 * @param <Item>
 *        type of items held in the {@link RemoveAllContainer}
 * 
 * @author Igor Akkerman
 */
public interface RemoveAllContainer<Item>
extends RemoveContainer<Item> {

    /**
     * Removes all Items of this {@link RemoveAllContainer}.
     * 
     * @throws IllegalContainerStateException
     *         if an error occurs during the operation
     */
    public void removeAll()
    throws IllegalContainerStateException;
}
