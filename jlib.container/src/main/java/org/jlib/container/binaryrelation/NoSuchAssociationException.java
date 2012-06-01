package org.jlib.container.binaryrelation;

import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link IllegalContainerArgumentException} thrown when a
 * {@link BinaryRelation} does not contain a requested {@link Association}.
 * 
 * @author Igor Akkerman
 */
public class NoSuchAssociationException
extends IllegalBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -6717984941514100227L;

    /** requested {@link Association} */
    private final Association<?, ?> association;

    /**
     * Creates a new {@link NoSuchAssociationException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param association
     *        requested {@link Association}
     */
    public NoSuchAssociationException(final BinaryRelation<?, ?> binaryRelation, final Association<?, ?> association) {
        super(binaryRelation, "{1}: {2}", association);

        this.association = association;
    }

    /**
     * Returns the requested {@link Association} causing this
     * {@link NoSuchAssociationException}.
     * 
     * @return requested {@link Association}
     */
    public Association<?, ?> getAssociation() {
        return association;
    }
}
