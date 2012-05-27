package org.jlib.container.sequence;

/**
 * Facade utility for {@link Sequence} creation and operations.
 * 
 * @author Igor Akkerman
 */
public final class SequenceUtility {

    /** no visible default constructor */
    private SequenceUtility() {}

    /**
     * Creates a new {@link Sequence} containing solely the specified Item.
     * 
     * @param item
     *        sole Item of the new {@link Sequence}
     * 
     * @return new singleton {@link Sequence}
     */
    public static <Item> Sequence<Item> singleton(final Item item) {
        return new SingletonSequence<Item>(item);
    }
}
