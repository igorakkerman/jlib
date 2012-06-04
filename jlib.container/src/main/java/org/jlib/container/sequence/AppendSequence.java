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
 * {@link ReplaceSequence} to which Items can be appended.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface AppendSequence<Item>
extends Sequence<Item> {

    /**
     * Appends the specified Item to this {@link AppendSequence}.
     * 
     * @param item
     *        Item to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it from being added,
     *         for instance, if it is already contained
     */
    public void append(final Item item)
    throws IllegalContainerArgumentException;

    /**
     * Appends all Items contained by the specified {@link Container} to this
     * {@link AppendSequence}.
     * 
     * @param items
     *        {@link Container} containing the Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if {@code items}
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being added, for instance, if it is already contained
     */
    public void append(final Container<? extends Item> items)
    throws IllegalContainerArgumentException;

    /**
     * Appends all Items contained by the specified {@link Collection} to this
     * {@link AppendSequence}.
     * 
     * @param items
     *        {@link Collection} containing the Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being added, for instance, if it is already contained
     */
    public void append(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException;

    /**
     * Appends all specified Items to this {@link AppendSequence}.
     * 
     * @param items
     *        comma separated sequence of Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being added, for instance, if it is already contained
     */
    public void append(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException;
}
