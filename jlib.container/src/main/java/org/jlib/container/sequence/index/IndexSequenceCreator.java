package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * Creator of instances of a specific subtype of {@link Sequence}.
 * 
 * @param <Sequenze>
 *        type of the created {@link Sequence} instances
 * 
 * @author Igor Akkerman
 */
public interface IndexSequenceCreator<Element, Sequenze extends InitializeableIndexSequence<Element>> {

    /**
     * Creates the {@link IndexSequence} with the specified first and last
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
     * @throws IllegalArgumentException 
     */
    public Sequenze createSequence(int firstIndex, int lastIndex)
    throws IllegalArgumentException;
}
