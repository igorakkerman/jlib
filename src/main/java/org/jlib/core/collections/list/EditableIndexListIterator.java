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

package org.jlib.core.collections.list;

/**
 * <p>
 * ListIterator over an EditableIndexList.
 * </p>
 * <p>
 * This interface simply unites the capabilities of the interfaces EditableListIterator and
 * IndexListIterator.
 * </p>
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface EditableIndexListIterator<Element>
extends EditableListIterator<Element>, IndexListIterator<Element> {
    // intentionally left blank
}
