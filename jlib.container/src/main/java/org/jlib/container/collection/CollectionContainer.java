package org.jlib.container.collection;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.AbstractContainer;
import org.jlib.container.Container;

/**
 * Adapter allowing a {@link Collection} to be used as a {@link Container}. A
 * {@link CollectionContainer} is backed by a {@link Collection} specified at
 * initialization.
 * 
 * @param <Element>
 *        type of elements held in the {@link Container}
 * @author Igor Akkerman
 */
public class CollectionContainer<Element>
extends AbstractContainer<Element> {

    /** adapted and backed {@link Collection} */
    private final Collection<Element> delegateCollection;

    /**
     * Creates a new {@link ContainerCollection} backed by the specified
     * {@link Collection}.
     * 
     * @param delegateCollection
     *        {@link Collection} backing this {@link CollectionContainer}
     */
    public CollectionContainer(final Collection<Element> delegateCollection) {
        this.delegateCollection = delegateCollection;
    }

    // implemented for efficiency
    @Override
    public int getSize() {
        return delegateCollection.size();
    }

    // implemented for efficiency
    @Override
    public Iterator<Element> createIterator() {
        return delegateCollection.iterator();
    }
    
    // implemented for efficiency
    @Override
    public boolean contains(Element element) {
        return delegateCollection.contains(element);
    }

    // implemented for efficiency
    @Override
    public boolean containsAll(Collection<? extends Element> collection) {
        return delegateCollection.containsAll(collection);
    }

    // implemented for efficiency
    @Override
    @SuppressWarnings("unchecked")
    public Element[] toArray() {
        return (Element[]) delegateCollection.toArray();
    }

    /**
     * Returns the {@link Collection} adapted and backed by this
     * {@link CollectionContainer}.
     * 
     * @return delegate {@link Collection} of this {@link CollectionContainer}
     */
    protected Collection<Element> getDelegateCollection() {
        return delegateCollection;
    }
}
