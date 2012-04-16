package org.jlib.container.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.jlib.container.AddContainer;
import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.RemoveContainer;
import org.jlib.container.RemoveContainerIterator;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link AddContainer}. A
 * {@link CollectionAddRemoveContainer} is backed by a {@link Collection}
 * specified at initialization.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Container}
 * @author Igor Akkerman
 */
public class CollectionAddRemoveContainer<Element>
extends CollectionContainer<Element>
implements AddContainer<Element>, RemoveContainer<Element> {

    /**
     * Creates a new {@link CollectionAddRemoveContainer} backed by the
     * specified {@link Collection}.
     * 
     * @param delegateCollection
     *        {@link Collection} backing this
     *        {@link CollectionAddRemoveContainer}
     */
    public CollectionAddRemoveContainer(final Collection<Element> delegateCollection) {
        super(delegateCollection);
    }

    @Override
    public void add(final Element element) {
        getDelegateCollection().add(element);
    }

    @Override
    public void addAll(final Collection<? extends Element> elements) {
        getDelegateCollection().addAll(elements);
    }

    @Override
    public void addAll(final Container<? extends Element> elements) {
        getDelegateCollection().addAll(getDelegateCollection());
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        Collections.addAll(getDelegateCollection(), elements);
    }

    @Override
    public void removeAll() {
        getDelegateCollection().clear();
    }

    @Override
    public void remove(final Element element)
    throws IllegalArgumentException {
        boolean removed = getDelegateCollection().remove(element);

        if (!removed)
            throw new IllegalArgumentException(element.toString());
    }

    @Override
    public void removeAll(final Collection<? extends Element> elements) {
        getDelegateCollection().removeAll(elements);
    }

    @Override
    public void removeAll(final Container<? extends Element> elements) {
        CollectionUtility.removeAll(getDelegateCollection(), elements);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        ContainerUtility.removeAll(this, elements);
    }

    @Override
    public void retainAll(final Collection<? extends Element> elements) {
        getDelegateCollection().retainAll(elements);
    }

    @Override
    public void retainAll(final Container<? extends Element> elements) {
        ContainerUtility.retainAll(this, elements);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        ContainerUtility.retainAll(this, elements);
    }

    @Override
    public RemoveContainerIterator<Element> createIterator() {
        final Iterator<Element> delegateIterator = getDelegateCollection().iterator();
        return new RemoveContainerIterator<Element>() {
            @Override
            public boolean hasNext() {
                return delegateIterator.hasNext();
            }

            @Override
            public Element next() {
                return delegateIterator.next();
            }

            @Override
            public void remove() {
                delegateIterator.remove();
            }
        };
    }
}
