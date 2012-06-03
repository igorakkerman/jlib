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
 * {@link AbstractReplaceAddContainer} implementing a {@link RemoveContainer}.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
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
        remove(this);
    }

    @Override
    public void remove(final Container<? extends Item> items) {
        remove((Iterable<? extends Item>) items);
    }

    @Override
    public void remove(final Collection<? extends Item> items) {
        remove((Iterable<? extends Item>) items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items) {
        for (final Item item : items)
            remove(item);
    }

    @Override
    public void remove(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.remove(this, items);
    }

    @Override
    public void retain(final Container<? extends Item> items) {
        ContainerUtility.retain(this, items);
    }

    @Override
    public void retain(final Collection<? extends Item> items) {
        ContainerUtility.retain(this, items);
    }

    @Override
    public void retain(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        ContainerUtility.retain(this, items);
    }
}
