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
public interface ItemRemovedListener<Item, Conteener extends Container<Item>> {

    /**
     * Handles the removal of the specified Item to the specified
     * {@link Container}.
     * 
     * @param container
     *        {@link Container} from which {@code item} is removeed
     * 
     * @param item
     *        Item removeed from {@code container}
     * 
     * @throws ItemAddedListenerException
     *         if an error occurs registering the Item removal
     */
    void handleAddItem(final Conteener container, final Item item)
    throws ItemAddedListenerException;
}
