package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * Creator of instances of a specific subtype of {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the created {@link IndexSequence} instances
 * 
 * @author Igor Akkerman
 */
public interface IndexSequenceCreator<Item, Sequenze extends InitializeableIndexSequence<Item>> {

    /**
     * Creates a new {@link IndexSequence} with the specified first and last
     * indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @return newly created {@link IndexSequence}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    public Sequenze createSequence(int firstIndex, int lastIndex)
    throws InvalidSequenceIndexRangeException;
}
