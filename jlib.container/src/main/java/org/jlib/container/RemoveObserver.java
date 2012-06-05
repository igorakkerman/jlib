package org.jlib.container;

/**
 * Listener for Item removal.
 * 
 * @param <Item>
 *        type of removed item
 * 
 * @param <Conteener>
 *        type of the {@link Container} from which the Item is removed
 * 
 * @author Igor Akkerman
 */
public interface RemoveObserver<Item, Conteener extends Container<Item>> {

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link Container} from which {@code item} is removed
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @throws RemoveObserverException
     *         if an error occurs registering the Item removal
     */
    void handleBeforeRemove(final Conteener container, final Item item)
    throws RemoveObserverException;

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link Container} from which {@code item} is removed
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @throws RemoveObserverException
     *         if an error occurs registering the Item removal
     */
    void handleRemoved(final Conteener container, final Item item)
    throws RemoveObserverException;

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link Container} from which {@code item} is removed
     * 
     * @param item
     *        Item removed from {@code container}
     * 
     * @throws RemoveObserverException
     *         if an error occurs registering the Item removal
     */
    void handleNotRemoved(final Conteener container, final Item item)
    throws RemoveObserverException;
}
