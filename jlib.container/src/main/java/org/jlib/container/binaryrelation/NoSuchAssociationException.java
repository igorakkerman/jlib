package org.jlib.container.binaryrelation;

import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link IllegalContainerArgumentException} thrown when a
 * {@link BinaryRelation} does not contain a requested {@link Association}.
 * 
 * @author Igor Akkerman
 */
public abstract class NoSuchAssociationException
extends IllegalBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -6717984941514100227L;

    /** left or right value of the missing {@link Association} */
    private Object associationValue;

    /**
     * Creates a new {@link NoSuchAssociationException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param associationValue
     *        left or right value of the missing {@link Association}
     */
    public NoSuchAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object associationValue) {
        super(binaryRelation, "{1}: {2}", associationValue);
    }

    /**
     * Returns the left or right value of the missing {@link Association}.
     * 
     * @return {@link Object} specifying the value
     */
    public Object getAssociationValue() {
        return associationValue;
    }
}
