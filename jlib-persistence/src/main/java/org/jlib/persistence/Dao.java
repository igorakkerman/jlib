package org.jlib.persistence;

import java.util.List;
import java.util.function.Consumer;

import java.io.Serializable;

public interface Dao<Entity extends IdEntity<Id>, Id extends Serializable> {

    Entity find(Id id);

    Entity find(Id id, Consumer<Entity> postFind);

    List<Entity> find(Iterable<Id> ids);

    List<Entity> findAll();

    void persist(Entity entity);

    void persist(Iterable<Entity> entities);

    Entity merge(Entity entity);

    void remove(Id id);

    void remove(Entity entity);

    long count();
}
