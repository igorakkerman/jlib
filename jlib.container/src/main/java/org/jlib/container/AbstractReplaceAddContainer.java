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
 * @param <Element>
 *        type of elements held in the {@link Container}
 * @author Igor Akkerman
 */
public abstract class AbstractReplaceAddContainer<Element>
extends AbstractContainer<Element>
implements AddContainer<Element> {

    /**
     * Creates a new AddContainer.
     */
    protected AbstractReplaceAddContainer() {
        super();
    }

    @Override
    public void addAll(Collection<? extends Element> elements) {
        addAll((Iterable<? extends Element>) elements);
    }

    @Override
    public void addAll(Container<? extends Element> elements) {
        addAll((Iterable<? extends Element>) elements);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        for (Element element : elements)
            add(element);
    }

    /**
     * Adds all Elements provided by the specified {@link Iterable} to this
     * {@link AddContainer}.
     * 
     * @param elements
     *        {@link Iterable} providing the Elements to add
     */
    private void addAll(final Iterable<? extends Element> elements) {
        for (Element element : elements)
            add(element);
    }
}
