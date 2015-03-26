package org.jlib.persistence.jpa;

import static org.jlib.message.MessageUtility.message;

public class EntityNotRemovableException
extends JpaPersistenceException {

    private static final long serialVersionUID = - 1447346532598234746L;

    public EntityNotRemovableException(final SimpleJpaEntity<?> entity) {
        super(message().with("entity", entity));
    }
}
