package org.jlib.container;

import java.util.Iterator;

import org.jlib.container.sequence.ReplaceSequenceIterator;

/**
 * {@link Iterator} over an {@link ReplaceContainer} allowing
 * the modification of the last traversed Element.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceContainerIterator<Element>
extends Iterator<Element> {

    /**
     * Replaces the last Element returned by {@code next()} with the specified
     * value.
     * 
     * @param element
     *        Element by which the former Element is replaced
     * 
     * @throws IllegalStateException
     *         if no Element has been returned by this
     *         {@link ReplaceSequenceIterator}
     */
    public void replace(final Element element)
    throws IllegalStateException;
}

