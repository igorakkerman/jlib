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

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link Sequence} to which Items can be prepended.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface PrependSequence<Item>
extends Sequence<Item> {

    /**
     * Prepends the specified Item to this {@link PrependSequence}.
     * 
     * @param item
     *        Item to prepend
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code item} prevents it from being
     *         prepended, for instance, if it is already contained
     */
    public void prepend(final Item item)
    throws IllegalSequenceArgumentException;

    /**
     * Prepends all Items contained by the specified {@link Container} to this
     * {@link PrependSequence}.
     * 
     * @param items
     *        {@link Container} containing the Items to prepend
     * 
     * @throws IllegalContainerArgumentException
     *         if {@code items}
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     */
    public void prepend(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException;

    /**
     * Prepends all Items contained by the specified {@link Collection} to this
     * {@link PrependSequence}.
     * 
     * @param items
     *        {@link Collection} containing the Items to prepend
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     */
    public void prepend(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException;

    /**
     * Prepends all specified Items to this {@link PrependSequence}.
     * 
     * @param items
     *        comma separated sequence of Items to prepend
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     */
    public void prepend(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalSequenceArgumentException;
}
