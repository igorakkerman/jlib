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
public abstract class AbstractReplaceAddRemoveContainer<Element>
extends AbstractReplaceAddContainer<Element>
implements RemoveContainer<Element> {

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
    public void removeAll(Container<? extends Element> elements) {
        removeAll((Iterable<? extends Element>) elements);
    }

    @Override
    public void removeAll(Collection<? extends Element> elements) {
        removeAll((Iterable<? extends Element>) elements);
    }

    /**
     * Removes all Elements provided by the specified {@link Iterable} from this
     * {@link AddContainer}.
     * 
     * @param elements
     *        {@link Iterable} providing the Elements to remove
     */
    private void removeAll(final Iterable<? extends Element> elements) {
        for (Element element : elements)
            remove(element);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        ContainerUtility.removeAll(this, elements);
    }

    @Override
    public void retainAll(final Container<? extends Element> elements) {
        ContainerUtility.retainAll(this, elements);
    }
    
    @Override
    public void retainAll(final Collection<? extends Element> elements) {
        ContainerUtility.retainAll(this, elements);
    }
    
    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        ContainerUtility.retainAll(this, elements);
    }
}
