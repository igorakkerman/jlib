package org.jlib.container;

/**
 * Listener for Item addition.
 * 
 * @param <Item>
 *        type of added item
 * 
 * @param <Conteener>
 *        type of the {@link Container} to which the Item is added
 * 
 * @author Igor Akkerman
 */
public interface ItemAddedListener<Item, Conteener extends Container<Item>> {

    /**
     * Handles the addition of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link Container} to which {@code item} is added
     * 
     * @param item
     *        Item added to {@code container}
     * 
     * @throws ItemAddedListenerException
     *         if an error occurs registering the Item addition
     */
    void handleAddItem(final Conteener container, final Item item)
    throws ItemAddedListenerException;
}
