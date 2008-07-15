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

package org.jlib.core.collections.list;

import java.util.Iterator;

/**
 * Iterator over a ModifiableList.
 * 
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface ModifiableListIterator<Element>
extends EditableListIterator<Element>, Iterator<Element> {

    /**
     * <p>
     * Inserts the specified Element into the list at the current position of
     * this Iterator.
     * </p>
     * <p>
     * The Element is inserted immediately before the next Element that would
     * have been returned by {@link #next()} and immediately after the previous
     * Element that would have been returned by {@link #previous()}.
     * </p>
     * <p>
     * A subsequent call to {@link #next()} would be unaffected, and a
     * subsequent call to {@link #previous()} would return the new element.
     * </p>
     * 
     * @param element
     *        Element to add
     * @throws IllegalStateException
     *         if {@link #next()} or {@link #previous()} have not been called
     *         initially or after the last call to {@link #add(Object)} or
     *         {@link #remove()}
     */
    public void add(Element element)
    throws IllegalStateException;

    /**
     * <p>
     * Removes the last Element returned by {@link #previous()} or
     * {@link #next()}.
     * </p>
     * <p>
     * This call cannot be made after a call to {@link #add(Object)} or
     * {@link #remove()} before a call to {@link #previous()} or {@link #next()}
     * </p>
     * 
     * @throws IllegalStateException
     *         if {@link #next()} or {@link #prev()} have not been called
     *         initially or after the last call to {@link #add(Object)} or
     *         {@link #remove()}
     */
    public void remove()
    throws IllegalStateException;
}
