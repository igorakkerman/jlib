package org.jlib.core.observer;

import org.jlib.core.operator.OperatorException;

/**
 * {@link ValueObserver} implemented with no functionality allowing simple
 * extension.
 * 
 * @param <Item>
 *        type of the items
 * 
 * @author Igor Akkerman
 */
public class DefaultValueObserver<Item>
implements ValueObserver<Item> {

    @Override
    public void handleBefore(final Item value)
    throws RuntimeException /* by subclasses */{
        // intentionally without functionality
    }

    @Override
    public void handleAfterSuccess(final Item value)
    throws RuntimeException /* by subclasses */{
        // intentionally without functionality
    }

    @Override
    public void handleAfterFailure(final Item value, final OperatorException operatorException)
    throws RuntimeException /* by subclasses */{
        // intentionally without functionality
    }
}
