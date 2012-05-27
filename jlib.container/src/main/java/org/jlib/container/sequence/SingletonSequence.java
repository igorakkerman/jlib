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

    /** beginning of the {@link SingletonSequence} {@link SequenceTraverserState} */
    private final SequenceTraverserState<Item> beginningOfSequenceState =
        new BeginningOfSequenceTraverserState<Item, SingletonSequence<Item>>(this) {

            @Override
            public Item next() {
                return item;
            }

            @Override
            public SequenceTraverserState<Item> getNextState() {
                return endOfSequenceState;
            }
        };

    /** end of the {@link SingletonSequence} {@link SequenceTraverserState} */
    private final SequenceTraverserState<Item> endOfSequenceState =
        new EndOfSequenceTraverserState<Item, SingletonSequence<Item>>(this) {

            @Override
            public Item previous() {
                return item;
            }

            @Override
            public SequenceTraverserState<Item> getPreviousState() {
                return beginningOfSequenceState;
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
        return new InitializedSequenceStateTraverser<Item, SingletonSequence<Item>>(this, beginningOfSequenceState);
    }

    @Override
    public int getSize() {
        return 1;
    }
}
