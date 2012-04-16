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
import java.util.Iterator;
import java.util.Set;

import org.jlib.container.collection.CollectionUtility;

/**
 * Utility class providing methods operating on {@link Container Containers}.
 * 
 * @author Igor Akkerman
 */
public final class ContainerUtility {

    /** no visible constructor */
    private ContainerUtility() {}

    /**
     * Removes all specified Elements from the specified {@link AddContainer}.
     * 
     * @param container
     *        {@link AddContainer} containing the Elements
     * 
     * @param elements
     *        vararg list of Elements to remove
     */
    public static <Element> void removeAll(final RemoveContainer<Element> container,
                                           @SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        for (Element element : elements)
            container.remove(element);
    }

    /**
     * Removes all Elements from the specified {@link AddContainer}
     * <i>except</i> the Elements provided by the specified {@link Iterable}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Elements to remove
     * 
     * @param elements
     *        {@link Iterable} providing the Elements to retain
     */
    public static <Element> void retainAll(final RemoveContainer<Element> container,
                                           final Iterable<? extends Element> elements) {
        final Set<Element> retainedElementsSet = CollectionUtility.toSet(elements);

        final Iterator<Element> containerIterator = container.iterator();
        while (containerIterator.hasNext())
            if (!retainedElementsSet.contains(containerIterator.next()))
                containerIterator.remove();
    }

    /**
     * Removes all Elements from the specified {@link AddContainer}
     * <i>except</i> for the Elements contained by the specified
     * {@link Collection}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Elements to remove
     * 
     * @param elements
     *        {@link Collection} containing the Elements to retain
     */
    public static <Element> void retainAll(final RemoveContainer<Element> container,
                                           final Collection<? extends Element> elements) {
        final Iterator<Element> elementsIterator = container.iterator();
        while (elementsIterator.hasNext())
            if (!elements.contains(elementsIterator.next()))
                elementsIterator.remove();
    }

    /**
     * Removes all Elements from the specified {@link AddContainer}
     * <i>except</i> for the Elements contained by the specified
     * {@link Collection}.
     * 
     * @param container
     *        {@link RemoveContainer} containing the Elements to remove
     * 
     * @param elements
     *        {@link Collection} containing the Elements to retain
     */
    public static <Element, RetainedElement extends Element> void retainAll(final RemoveContainer<Element> container,
                                                                            @SuppressWarnings({ "unchecked", /* "varargs" */}) RetainedElement... elements) {
        // necessary as we need the contains() method fot the elements sequence
        retainAll(container, CollectionUtility.toSet(elements));
    }
}
