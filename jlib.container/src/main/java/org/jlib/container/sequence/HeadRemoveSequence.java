package org.jlib.container.sequence;

/**
 * {@link Sequence} allowing its head Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface HeadRemoveSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the first Item of this {@link HeadRemoveSequence}.
     */
    public void removeFirstItem();
}
