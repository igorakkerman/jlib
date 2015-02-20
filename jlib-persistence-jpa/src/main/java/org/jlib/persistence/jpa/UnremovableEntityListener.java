package org.jlib.persistence.jpa;

import javax.persistence.PreRemove;

public class UnremovableEntityListener {

    @PreRemove
    public void forbidRemoval(final JpaEntity<?> entity)
    throws EntityNotRemovableException {
        throw new EntityNotRemovableException(entity);
    }
}
