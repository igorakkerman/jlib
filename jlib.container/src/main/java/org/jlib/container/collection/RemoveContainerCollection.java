package org.jlib.container.collection;

import java.util.Collection;

import org.jlib.container.RemoveContainer;

/**
 * Adapter allowing a {@link RemoveContainer} to be used as a {@link Collection}
 * . A {@link RemoveContainerCollection} is backed by a {@link RemoveContainer}
 * specified at initialization.
 * 
 * @param <Item>
 *        type of the items held in the {@link Collection}
 * 
 * @author Igor Akkerman
 */
public class RemoveContainerCollection<Item>
extends ContainerCollection<Item> {

    /** adapted and backed {@link RemoveContainer} */
    private final RemoveContainer<Item> delegateRemoveContainer;

    /**
     * Creates a new {@link RemoveContainerCollection} backed by the specified
     * {@link RemoveContainer}.
     * 
     * @param delegateContainer
     *        {@link RemoveContainer} backing this
     *        {@link RemoveContainerCollection}
     */
    public <DelegateContainer extends RemoveContainer<Item>> RemoveContainerCollection(final DelegateContainer delegateContainer) {
        super(delegateContainer);

        delegateRemoveContainer = delegateContainer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(final Object item) {
        delegateRemoveContainer.remove((Item) item);

        // TODO: implement modification listener model
        return true;
    }
}
