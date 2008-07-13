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

import java.util.ArrayList;
import java.util.Iterator;

import org.jlib.core.collections.AbstractCollection;

/**
 * Skeletal implementation of the List interface.
 *
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public abstract class AbstractList<Element>
extends AbstractCollection<Element>
implements List<Element> {

    /**
     * Creates a new empty List.
     */
    public AbstractList() {
        super();
    }

    // @see org.jlib.core.collections.list.List#toJavaList()
    public java.util.List<Element> toJavaList() {
        java.util.List<Element> list = new ArrayList<Element>(size());
        for (Element element : this)
            list.add(element);
        return list;
    }

    // @see java.util.AbstractCollection#iterator()
    @Override
    public Iterator<Element> iterator() {
        return new LegacyListIterator<Element>(this);
    }
}
