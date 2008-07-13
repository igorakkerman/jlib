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
 * Iterator over an EditableList.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface EditableListIterator<Element>
extends ListIterator<Element> {

    /**
     * Replaces the last Element returned by {@code previous()} or {@code next()} by the specified
     * value.
     *
     * @param element
     *        Element by which the former Element is replaced
     */
    public void set(Element element);
}
