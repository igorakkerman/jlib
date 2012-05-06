package org.jlib.container.collection;

import java.util.ListIterator;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;
import org.jlib.container.sequence.insert.InsertIndexSequenceIterator;
import org.jlib.container.sequence.replace.ReplaceIndexSequenceIterator;

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
