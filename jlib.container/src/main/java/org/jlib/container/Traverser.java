package org.jlib.container;

/**
 * Traverser of a {@link Container}.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface Traverser<Item> {

    // TODO: rename to getNextItem
    public Item next();

    // TODO: rename to hasNextItem
    public boolean hasNext();
}
