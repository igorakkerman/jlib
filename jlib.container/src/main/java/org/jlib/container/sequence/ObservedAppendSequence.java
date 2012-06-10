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
import org.jlib.core.observer.ValueObserver;

/**
 * {@link AppendSequence} to which Items can be appended.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedAppendSequence<Item>
extends AppendSequence<Item> {

    /**
     * Appends the specified Item to this {@link ObservedAppendSequence}.
     * 
     * @param item
     *        Item to add
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of {@code item} prevents it from being added,
     *         for instance, if it is already contained
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    public void append(final Item item,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException;

    /**
     * Appends all Items contained by the specified {@link Container} to this
     * {@link ObservedAppendSequence}.
     * 
     * @param items
     *        {@link Container} containing the Items to add
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws IllegalContainerArgumentException
     *         if {@code items}
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being added, for instance, if it is already contained
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    public void append(final Container<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException;

    /**
     * Appends all Items contained by the specified {@link Collection} to this
     * {@link ObservedAppendSequence}.
     * 
     * @param items
     *        {@link Collection} containing the Items to add
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being added, for instance, if it is already contained
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    public void append(final Collection<? extends Item> items,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException;

    /**
     * Appends all specified Items to this {@link ObservedAppendSequence}.
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the operation
     * 
     * @param items
     *        comma separated sequence of Items to add
     * 
     * @throws IllegalContainerArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being added, for instance, if it is already contained
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    public void append(ValueObserver<Item>[] observers,
                       @SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items)
    throws IllegalContainerArgumentException;
}
