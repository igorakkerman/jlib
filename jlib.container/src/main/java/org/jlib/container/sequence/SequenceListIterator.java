package org.jlib.container.sequence;

import java.util.ListIterator;

/**
 * {@link SequenceIterator} that can be used as {@link ListIterator}.
 *
 * @param <Element> type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface SequenceListIterator<Element>
extends ReplaceIndexSequenceIterator<Element>, InsertIndexSequenceIterator<Element>, ListIterator<Element> {
    // unifying interface
}
