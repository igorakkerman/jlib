package org.jlib.container.sequence;

/**
 * Sequence containing exactly one Item.
 * 
 * @param <Item>
 *        type of the item held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
class SingletonSequence<Item>
extends AbstractNonEmptySequence<Item> {

    /** sole item of this {@link SingletonSequence} */
    private final Item item;

    /** current {@link SequenceTraverser} state */
    private SequenceTraverser<Item> currentTraverserState;

    /** {@link SequenceTraverser} state at the {@link SingletonSequence} head */
    private final SequenceTraverser<Item> headTraverserState =
        new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(this) {

            @Override
            public boolean isPreviousItemAccessible() {
                return false;
            }

            @Override
            public Item getPreviousItem()
            throws NoPreviousSequenceItemException {
                throw new NoPreviousSequenceItemException(getSequence());
            }

            @Override
            public boolean isNextItemAccessible() {
                return true;
            }

            @Override
            public Item getNextItem() {
                currentTraverserState = tailTraverserState;

                return item;
            }
        };

    /** {@link SequenceTraverser} state at the {@link SingletonSequence} tail */
    private final SequenceTraverser<Item> tailTraverserState =
        new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(this) {

            @Override
            public boolean isPreviousItemAccessible() {
                return true;
            }

            @Override
            public Item getPreviousItem()
            throws NoPreviousSequenceItemException {
                currentTraverserState = headTraverserState;

                return item;
            }

            @Override
            public boolean isNextItemAccessible() {
                return false;
            }

            @Override
            public Item getNextItem() {
                throw new NoPreviousSequenceItemException(getSequence());
            }
        };

    /**
     * Creates a new {@link SingletonSequence} with the specified Item.
     * 
     * @param item
     *        sole Item in this {@link SingletonSequence}
     */
    public SingletonSequence(final Item item) {
        this.item = item;
    }

    @Override
    public SequenceTraverser<Item> createTraverser() {
        return new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(this) {

            @Override
            public boolean isPreviousItemAccessible() {
                return currentTraverserState.isPreviousItemAccessible();
            }

            @Override
            public Item getPreviousItem()
            throws NoPreviousSequenceItemException {
                return currentTraverserState.getPreviousItem();
            }

            @Override
            public boolean isNextItemAccessible() {
                return currentTraverserState.isNextItemAccessible();
            }

            @Override
            public Item getNextItem()
            throws NoNextSequenceItemException {
                return currentTraverserState.getNextItem();
            }

        };
    }

    @Override
    public int getItemsCount() {
        return 1;
    }
}
