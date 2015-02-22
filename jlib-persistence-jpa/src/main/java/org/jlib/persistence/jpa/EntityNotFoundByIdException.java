package org.jlib.persistence.jpa;

import java.io.Serializable;

import static org.jlib.core.message.MessageUtility.message;

public class EntityNotFoundByIdException
extends JpaPersistenceException {

    private static final long serialVersionUID = - 1759980190869513392L;

    public <Id extends Serializable> /*
        */ EntityNotFoundByIdException(final Class<? extends SimpleJpaEntity<Id>> entityClass, final Id id) {
        super(message().with("class", entityClass)
                       .with("id", id));
    }
}
