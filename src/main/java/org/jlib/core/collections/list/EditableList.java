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
 * List that allows its Elements to be modified using an EditableListIterator.
 * </p>
 * <p>
 * It does not necessarily allow modification of the list, that is, this interface does not provide
 * methods for adding and removing Elements. See {@link ModifiableList} for this functionality.
 * </p>
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public interface EditableList<Element>
extends List<Element> {

    /**
     * <p>
     * Returns an EditableListIterator traversing the Elements of this List in proper order.
     * </p>
     * <p>
     * The {@link EditableListIterator#set(Object) set} method of the Iterator can be used to modify
     * Elements in this List.
     * </p>
     *
     * @return EditableListIterator traversing the Elements of this List in proper order
     */
    public EditableListIterator<Element> editableListIterator();
}
