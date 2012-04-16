package org.jlib.container;

import org.jlib.container.sequence.AddSequence;
import org.jlib.container.sequence.Sequence;

/**
 * <p>
 * Container that allows its Elements to be modified using an
 * {@link ReplaceContainerIterator}.
 * </p>
 * <p>
 * It does not necessarily allow modification of the {@link Container}, that is,
 * this interface does not provide methods for adding and removing Elements. See
 * {@link AddSequence} for this functionality.
 * </p>
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceContainer<Element>
extends Container<Element> {

    /**
     * Creates a new {@link ReplaceContainerIterator} over this {@link ReplaceContainer}.
     * 
     * @return newly created {@link ReplaceContainerIterator}
     */
    @Override
    public ReplaceContainerIterator<Element> createIterator();
}
