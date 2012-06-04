package org.jlib.container.sequence;

import org.jlib.core.array.ArrayUtility;

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

    /**
     * Adds the specified Item to the specified {@link AppendSequence} that does
     * not yet contain the Item.
     * 
     * @param sequence
     *        {@link AppendSequence} to which the Item is appended
     * 
     * @param item
     *        appended Item
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of {@code item} prevents it from being appended
     *         to {@code sequence}
     */
    public static <Item> void append(final AppendSequence<Item> sequence, final Item item)
    throws IllegalSequenceArgumentException {
        sequence.append(item);
    }

    /**
     * Adds all Items provided by the specified {@link Iterable} to the
     * specified {@link AppendSequence}.
     * 
     * @param sequence
     *        {@link AppendSequence} to which the Items are appended
     * 
     * @param items
     *        {@link Iterable} providing the Items to append
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being appended to {@code sequence}
     */
    public static <Item, Items extends Iterable<? extends Item>> void append(final AppendSequence<Item> sequence,
                                                                             final Items items) {
        for (final Item item : items)
            sequence.append(item);
    }

    /**
     * Adds all Items in the specified comma separated sequence to the specified
     * {@link AppendSequence}.
     * 
     * @param sequence
     *        {@link AppendSequence} to which the Items are appended
     * 
     * @param items
     *        {@link Iterable} providing the Items to append
     * 
     * @throws IllegalSequenceArgumentException
     *         if some property of one Item in {@code items} prevents it from
     *         being appended to {@code sequence}
     */
    @SafeVarargs
    public static <Item> void append(final AppendSequence<Item> sequence, final Item... items)
    throws IllegalSequenceArgumentException {
        append(sequence, ArrayUtility.iterable(items));
    }
}
