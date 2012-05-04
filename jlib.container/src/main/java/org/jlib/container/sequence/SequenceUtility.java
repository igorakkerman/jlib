package org.jlib.container.sequence;

/**
 * Facade utility for {@link Sequence} creation and operations.
 * 
 * @author Igor Akkerman
 */
public final class SequenceUtility {

    /** no visible default constructor */
    private SequenceUtility() {}

    /**
     * Creates a new {@link Sequence} containing solely the specified Element.
     * 
     * @param element
     *        sole Element of the new {@link Sequence}
     * 
     * @return new singleton {@link Sequence}
     */
    public static <Element> Sequence<Element> singleton(final Element element) {
        return new SingletonSequence<Element>(element);
    }
}
