package org.jlib.container.binaryrelation;

/**
 * Exception thrown when a {@link BinaryRelation} does not contain an
 * {@link Association} with the requested left value.
 * 
 * @author Igor Akkerman
 */
public class NoSuchLeftValueException
extends NoSuchAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = -723559454379105926L;

    /**
     * Creates a new {@link NoSuchLeftValueException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param leftValue
     *        {@link Object} specifying the left value
     */
    public NoSuchLeftValueException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue) {
        super(binaryRelation, leftValue);
    }
}