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
import org.jlib.container.ItemPrependAware;

/**
 * {@link Sequence} to which Items can be prepended.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface PrependSequence<Item>
extends Sequence<Item>, ItemPrependAware<Item> {

    /**
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code item} prevents it from being
     *         prepended, for instance, if it is already contained
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    public void prepend(final Item item)
    throws IllegalSequenceArgumentException;

    /**
     * @throws IllegalSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    public void prepend(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException;

    /**
     * @throws IllegalSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    public void prepend(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException;

    /**
     * @throws IllegalSequenceArgumentException
     *         if some property of an Item in {@code items} prevents it from
     *         being prepended, for instance, if it is already contained
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs during the operation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void prepend(final Item... items)
    throws IllegalSequenceArgumentException;
}
