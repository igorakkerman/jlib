package org.jlib.container.collection;

import java.util.Collection;

import org.jlib.container.AddContainer;
import org.jlib.container.RemoveContainer;

/**
 * Adapter allowing a {@link AddContainer} to be used as a {@link Collection}. A
 * {@link AddRemoveContainerCollection} is backed by a {@link AddContainer}
 * specified at initialization.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Collection}
 * @author Igor Akkerman
 */
public class AddRemoveContainerCollection<Element>
extends ContainerCollection<Element> {

    /** adapted and backed {@link AddContainer} */
    private final AddContainer<Element> delegateAddContainer;

    /** adapted and backed {@link RemoveContainer} */
    private final RemoveContainer<Element> delegateRemoveContainer;

    /**
     * Creates a new {@link AddRemoveContainerCollection} backed by the
     * specified {@link AddContainer}.
     * 
     * @param delegateContainer
     *        {@link AddContainer} backing this
     *        {@link AddRemoveContainerCollection}
     */
    public <DelegateContainer extends AddContainer<Element> & RemoveContainer<Element>> AddRemoveContainerCollection(final DelegateContainer delegateContainer) {
        super(delegateContainer);

        delegateAddContainer = delegateContainer;
        delegateRemoveContainer = delegateContainer;
    }

    @Override
    public boolean add(final Element element) {
        delegateAddContainer.add(element);

        // TODO: implement modification listener model
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Element> elements) {
        delegateAddContainer.addAll(elements);

        // TODO: implement modification listener model
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(final Object element) {
        delegateRemoveContainer.remove((Element) element);

        // TODO: implement modification listener model
        return true;
    }
}
