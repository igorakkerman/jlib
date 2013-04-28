package org.jlib.container.binaryrelation.bijection;

import org.jlib.container.binaryrelation.Association;
import org.jlib.container.binaryrelation.BinaryRelation;
import org.jlib.container.binaryrelation.IllegalAssociationException;

/**
 * {@link IllegalAssociationException} thrown when trying to illegaly add an
 * {@link Association} to a {@link BinaryRelation}.
 * 
 * @author Igor Akkerman
 */
public class AssociationAlreadyContainedException
extends IllegalAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = -1416174523765702421L;

    /**
     * Creates a new {@link AssociationAlreadyContainedException}.
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
    public AssociationAlreadyContainedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                                final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
