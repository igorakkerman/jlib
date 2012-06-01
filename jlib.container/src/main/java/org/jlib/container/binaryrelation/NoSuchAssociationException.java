package org.jlib.container.binaryrelation;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link IllegalContainerArgumentException} thrown when a
 * {@link BinaryRelation} does not contain a requested {@link Association}.
 * 
 * @author Igor Akkerman
 */
public class NoSuchAssociationException
extends IllegalContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -6717984941514100227L;

    /** requested {@link Association} */
    private final Association<?, ?> association;

    /**
     * Creates a new {@link NoSuchAssociationException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param association
     *        requested Association
     */
    public NoSuchAssociationException(final Container<?> container, final Association<?, ?> association) {
        super(container);

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
