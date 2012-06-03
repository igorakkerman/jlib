package org.jlib.container.binaryrelation;

/**
 * {@link IllegalAssociationException} thrown when trying to add an
 * {@link Association} to a {@link BinaryRelation} that already exists.
 * 
 * @author Igor Akkerman
 */
public class AssociationAlreadyExistsException
extends IllegalAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1090527595338576596L;

    /**
     * Creates a new {@link AssociationAlreadyExistsException}.
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
    public AssociationAlreadyExistsException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                             final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
