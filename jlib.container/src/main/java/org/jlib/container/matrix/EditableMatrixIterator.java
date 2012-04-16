package org.jlib.container.matrix;

import org.jlib.container.sequence.ReplaceSequenceIterator;

public interface ReplaceMatrixIterator<Element>
extends MatrixIterator<Element> {

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
    public void set(final Element element)
    throws IllegalStateException;

}
