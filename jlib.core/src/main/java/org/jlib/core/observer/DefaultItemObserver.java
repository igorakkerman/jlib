package org.jlib.core.observer;

/**
 * {@link ItemObserver} implemented with no functionality allowing simple
 * extension.
 * 
 * @param <Item>
 *        type of the items
 * 
 * @author Igor Akkerman
 */
public class DefaultItemObserver<Item>
implements ItemObserver<Item> {

    @Override
    public void handleBefore(final Item item, final Object... arguments)
    throws ItemObserverException /* by subclasses */{
        // intentionally without functionality
    }

    @Override
    public void handleAfterSuccess(final Item item, final Object... arguments)
    throws ItemObserverException /* by subclasses */{
        // intentionally without functionality
    }

    @Override
    public void handleAfterFailure(final Item item, final Object... arguments)
    throws ItemObserverException /* by subclasses */{
        // intentionally without functionality
    }
}
