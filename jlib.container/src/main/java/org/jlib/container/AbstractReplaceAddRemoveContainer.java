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
public abstract class AbstractReplaceAddRemoveContainer<Item>
extends AbstractReplaceAddContainer<Item>
implements RemoveContainer<Item> {

    /**
     * Creates a new AddContainer.
     */
    protected AbstractReplaceAddRemoveContainer() {
        super();
    }

    @Override
    public void removeAll() {
        removeAll(this);
    }

    @Override
    public void removeAll(final Container<? extends Item> items) {
        removeAll((Iterable<? extends Item>) items);
    }

    @Override
    public void removeAll(final Collection<? extends Item> items) {
        removeAll((Iterable<? extends Item>) items);
    }

    @Override
    public void removeAll(final Iterable<? extends Item> items) {
        for (final Item item : items)
            remove(item);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.removeAll(this, items);
    }

    @Override
    public void retainAll(final Container<? extends Item> items) {
        ContainerUtility.retainAll(this, items);
    }

    @Override
    public void retainAll(final Collection<? extends Item> items) {
        ContainerUtility.retainAll(this, items);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.retainAll(this, items);
    }
}
