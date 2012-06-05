package org.jlib.container;

/**
 * {@link RemoveObserver} implemented with no functionality allowing simple
 * extension.
 * 
 * @param <Item>
 *        type of the items held in the {@link Container}
 * 
 * @param <Conteener>
 *        type of the {@link Container}
 * 
 * @author Igor Akkerman
 */
public class SimpleRemoveHandler<Item, Conteener extends Container<Item>>
implements RemoveObserver<Item, Conteener> {

    @Override
    public void handleBeforeRemove(final Conteener container, final Item item) {
        // intentionally without functionality
    }

    @Override
    public void handleRemoved(final Conteener container, final Item item) {
        // intentionally without functionality
    }

    @Override
    public void handleNotRemoved(final Conteener container, final Item item) {
        // intentionally without functionality
    }
}
