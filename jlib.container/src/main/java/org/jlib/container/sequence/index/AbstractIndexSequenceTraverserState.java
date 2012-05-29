package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AbstractSequenceTraverser;
import org.jlib.container.sequence.NoItemAccessedException;
import org.jlib.container.sequence.NoNextSequenceItemException;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;

/**
 * Skeletal implementation of an {@link IndexSequenceTraverserState}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link IndexSequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /**
     * Holder of an {@link IndexSequence} index.
     * 
     * @author Igor Akkerman
     */
    private static interface IndexHolder {

        /**
         * Returns the registered index.
         * 
         * @return integer specifying the registered index
         * 
         * @throws NoItemAccessedException
         *         if no index has been registered
         */
        int getIndex()
        throws NoItemAccessedException;

        /**
         * Registers the lastAccessedItemIndexHolder.
         * 
         * @param index
         *        integer specifying the index
         */
        void setIndex(final int index);
    }

    /** {@link IndexHolder} of the index of the last accessed Item */
    private IndexHolder lastAccessedItemIndexHolder;

    /**
     * Creates a new {@link AbstractIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public AbstractIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);

        lastAccessedItemIndexHolder = new IndexHolder() {

            @Override
            public int getIndex()
            throws NoItemAccessedException {
                throw new NoItemAccessedException();
            }

            @Override
            public void setIndex(final int index) {
                lastAccessedItemIndexHolder = new IndexHolder() {

                    int index;

                    @Override
                    public int getIndex() {
                        return index;
                    }

                    @Override
                    public void setIndex(final int index) {
                        this.index = index;
                    }
                };

                lastAccessedItemIndexHolder.setIndex(index);
            }
        };
    }

    /**
     * Returns the index of the last Item accessed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @return {@link IndexHolder} specifying the lastAccessedItemIndexHolder
     * 
     * @throws NoItemAccessedException
     *         if no Item has been accessed yet
     */
    protected int getLastAccessedItemIndex()
    throws NoItemAccessedException {
        return lastAccessedItemIndexHolder.getIndex();
    }

    /**
     * Registers the index of the last Item accessed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @param lastAccessedItemIndex
     *        integer specifying the index
     */
    protected void setLastAccessedItemIndex(final int lastAccessedItemIndex) {
        lastAccessedItemIndexHolder.setIndex(lastAccessedItemIndex);
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        setLastAccessedItemIndex(getPreviousItemIndex());

        return doGetPreviousItem();
    }

    /**
     * Returns the previous Item in the {@link IndexSequence} traversed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @return previous Item in the {@link IndexSequence}
     * 
     * @throws NoPreviousSequenceItemException
     *         if there is no previous Item
     */
    protected abstract Item doGetPreviousItem()
    throws NoPreviousSequenceItemException;

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        setLastAccessedItemIndex(getNextItemIndex());

        return doGetNextItem();
    }

    /**
     * Returns the next Item in the {@link IndexSequence} traversed by this
     * {@link AbstractIndexSequenceTraverserState}.
     * 
     * @return next Item in the {@link IndexSequence}
     * 
     * @throws NoNextSequenceItemException
     *         if there is no next Item
     */
    protected abstract Item doGetNextItem()
    throws NoNextSequenceItemException;
}
