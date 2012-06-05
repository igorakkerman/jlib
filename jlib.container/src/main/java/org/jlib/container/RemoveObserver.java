package org.jlib.container;

/**
 * Observer for Item removal.
 * 
 * @param <Item>
 *        type of removed item
 * 
 * @author Igor Akkerman
 */
public interface RemoveObserver<Item> {

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link RemoveContainer} from which {@code item} is removed
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @throws RemoveObserverException
     *         if an error occurs registering the Item removal
     */
    void handleBeforeRemove(final RemoveContainer<Item> container, final Item item)
    throws RemoveObserverException;

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link RemoveContainer} from which {@code item} is removed
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @throws RemoveObserverException
     *         if an error occurs registering the Item removal
     */
    void handleRemoved(final RemoveContainer<Item> container, final Item item)
    throws RemoveObserverException;

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link RemoveContainer} from which {@code item} is removed
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @throws RemoveObserverException
     *         if an error occurs registering the Item removal
     */
    void handleNotRemoved(final RemoveContainer<Item> container, final Item item)
    throws RemoveObserverException;
}
