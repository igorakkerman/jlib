package org.jlib.container.sequence;

import org.jlib.container.AbstractIterator;

/**
 * Skeletal implementation of a {@link SequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceIterator<Element>
extends AbstractIterator<Element>
implements SequenceIterator<Element> {
    // join AbstractIterator with SequenceIterator
}
