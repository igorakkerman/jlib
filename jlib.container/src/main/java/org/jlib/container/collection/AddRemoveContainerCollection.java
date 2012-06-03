package org.jlib.container.collection;

import java.util.Collection;

import org.jlib.container.AddContainer;
import org.jlib.container.RemoveContainer;

/**
 * Adapter allowing a {@link AddContainer} to be used as a {@link Collection}. A
 * {@link AddRemoveContainerCollection} is backed by a {@link AddContainer}
 * specified at initialization.
 * 
 * @param <Item>
 *        type of the items held in the {@link Collection}
 * @author Igor Akkerman
 */
public class AddRemoveContainerCollection<Item>
extends ContainerCollection<Item> {

    /** adapted and backed {@link AddContainer} */
    private final AddContainer<Item> delegateAddContainer;

    /** adapted and backed {@link RemoveContainer} */
    private final RemoveContainer<Item> delegateRemoveContainer;

    /**
     * Creates a new {@link AddRemoveContainerCollection} backed by the
     * specified {@link AddContainer}.
     * 
     * @param delegateContainer
     *        {@link AddContainer} backing this
     *        {@link AddRemoveContainerCollection}
     */
    public <DelegateContainer extends AddContainer<Item> & RemoveContainer<Item>> AddRemoveContainerCollection(final DelegateContainer delegateContainer) {
        super(delegateContainer);

        delegateAddContainer = delegateContainer;
        delegateRemoveContainer = delegateContainer;
    }

    @Override
    public boolean add(final Item item) {
        delegateAddContainer.add(item);

        // TODO: implement modification listener model
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Item> items) {
        delegateAddContainer.add(items);

        // TODO: implement modification listener model
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(final Object item) {
        delegateRemoveContainer.remove((Item) item);

        // TODO: implement modification listener model
        return true;
    }
}
