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

    /** current delegate {@link BidirectionalTraverser} */
    private SequenceTraverser<Item> currentDelegateTraverser;

    /** delegate {@link BidirectionalTraverser} at the {@link SingletonSequence} head */
    private final SequenceTraverser<Item> headTraverser = new AbstractSequenceTraverser<Item, Sequence<Item>>(this) {

        @Override
        public boolean isPreviousItemAccessible() {
            return false;
        }

        @Override
        public Item getPreviousItem()
        throws NoPreviousSequenceItemException {
            throw new NoPreviousSequenceItemException(SingletonSequence.this);
        }

        @Override
        public boolean isNextItemAccessible() {
            return true;
        }

        @Override
        public Item getNextItem() {
            currentDelegateTraverser = tailTraverser;

            return item;
        }
    };

    /**
     * delegate {@link BidirectionalTraverser} at the {@link SingletonSequence}
     * tailTraverser
     */
    private final SequenceTraverser<Item> tailTraverser = new AbstractSequenceTraverser<Item, Sequence<Item>>(this) {

        @Override
        public boolean isPreviousItemAccessible() {
            return true;
        }

        @Override
        public Item getPreviousItem()
        throws NoPreviousSequenceItemException {
            currentDelegateTraverser = headTraverser;

            return item;
        }

        @Override
        public boolean isNextItemAccessible() {
            return false;
        }

        @Override
        public Item getNextItem() {
            throw new NoPreviousSequenceItemException(SingletonSequence.this);
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
    public SequenceTraverser<Item> createSequenceTraverser() {
        return new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(this) {

            @Override
            public boolean isPreviousItemAccessible() {
                return currentDelegateTraverser.isPreviousItemAccessible();
            }

            @Override
            public Item getPreviousItem()
            throws NoPreviousSequenceItemException {
                return currentDelegateTraverser.getPreviousItem();
            }

            @Override
            public boolean isNextItemAccessible() {
                return currentDelegateTraverser.isNextItemAccessible();
            }

            @Override
            public Item getNextItem()
            throws NoNextSequenceItemException {
                return currentDelegateTraverser.getNextItem();
            }

        };
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public SequenceTraverser<Item> createTraverser() {
        return createSequenceTraverser();
    }
}
