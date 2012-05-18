package org.jlib.container.sequence.index;

public interface IndexSequenceCreator<Sequenze extends InitializeableIndexSequence<?>> {

    public Sequenze createSequence(int firstIndex, int lastIndex);
}
