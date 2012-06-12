package org.jlib.container.sequence;

/**
 * {@link Sequence} allowing its head Item to be removed.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface RemoveHeadSequence<Item>
extends Sequence<Item> {

    /**
     * Removes the first Item of this {@link RemoveHeadSequence}.
     */
    public void removeFirstItem();
}
