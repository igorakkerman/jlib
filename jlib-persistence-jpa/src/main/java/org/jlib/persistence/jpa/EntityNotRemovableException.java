package org.jlib.persistence.jpa;

import static org.jlib.core.message.MessageUtility.message;

public class EntityNotRemovableException
extends JpaPersistenceException {

    private static final long serialVersionUID = - 1447346532598234746L;

    public EntityNotRemovableException(final JpaEntity<?> entity) {
        super(message().with("entity", entity));
    }
}
