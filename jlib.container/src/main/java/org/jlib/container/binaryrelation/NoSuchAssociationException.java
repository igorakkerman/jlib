package org.jlib.container.binaryrelation;

/**
 * {@link IllegalAssociationException} thrown when referencing an
 * {@link Association} not contained by the specified {@link BinaryRelation}.
 * 
 * @author Igor Akkerman
 */
public class NoSuchAssociationException
extends IllegalAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5774667231932174427L;

    /**
     * Creates a new {@link NoSuchAssociationException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     */
    public NoSuchAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                      final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
