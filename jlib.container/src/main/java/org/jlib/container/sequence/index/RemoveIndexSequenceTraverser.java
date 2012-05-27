package org.jlib.container.sequence.index;

import org.jlib.container.sequence.RemoveSequenceTraverser;

@SuppressWarnings("javadoc")
public interface RemoveIndexSequenceTraverser<RemoveIndexSequenceItem>
extends RemoveSequenceTraverser<RemoveIndexSequenceItem>, IndexSequenceTraverser<RemoveIndexSequenceItem> {
// unifying interface to satisfy the Eclipse compiler
}
