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

package org.jlib.container;

import java.util.Collection;

/**
 * Skeletal implementation of a AddContainer.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * @author Igor Akkerman
 */
public abstract class AbstractReplaceAddContainer<Item>
extends AbstractContainer<Item>
implements AddContainer<Item> {

    /**
     * Creates a new AddContainer.
     */
    protected AbstractReplaceAddContainer() {
        super();
    }

    @Override
    public void add(Collection<? extends Item> items) {
        addAll((Iterable<? extends Item>) items);
    }

    @Override
    public void add(Container<? extends Item> items) {
        addAll((Iterable<? extends Item>) items);
    }

    @Override
    public void add(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        for (Item item : items)
            add(item);
    }

    /**
     * Adds all Items provided by the specified {@link Iterable} to this
     * {@link AddContainer}.
     * 
     * @param items
     *        {@link Iterable} providing the Items to add
     */
    private void addAll(final Iterable<? extends Item> items) {
        for (Item item : items)
            add(item);
    }
}
