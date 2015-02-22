package org.jlib.persistence;

import java.util.List;
import java.util.function.Consumer;

import java.io.Serializable;

public interface Dao<Entity extends IdEntity<Id>, Id extends Serializable> {

    long count();

    Entity find(Id id);

    default Entity find(final Id id, final Consumer<Entity> postFind) {
        final Entity entity = find(id);
        postFind.accept(entity);
        return entity;
    }

    List<Entity> find(Iterable<Id> ids);

    default List<Entity> find(final Iterable<Id> ids, final Consumer<Entity> postFind) {
        final List<Entity> entities = find(ids);
        entities.forEach(postFind);
        return entities;
    }

    @SuppressWarnings("unchecked")
    List<Entity> find(Id... ids);

    default List<Entity> find(final Id[] ids, final Consumer<Entity> postFind) {
        final List<Entity> entities = find(ids);
        entities.forEach(postFind);
        return entities;
    }

    List<Entity> findAll();

    default List<Entity> findAll(final Consumer<Entity> postFind) {
        final List<Entity> entities = findAll();
        entities.forEach(postFind);
        return entities;
    }

    void persist(Entity entity);

    void persist(Iterable<Entity> entities);

    @SuppressWarnings("unchecked")
    void persist(Entity... entities);

    Entity merge(Entity entity);

    void remove(Id id);

    void removeBy(Iterable<Id> ids);

    @SuppressWarnings("unchecked")
    void remove(Id... id);

    void remove(Entity entity);

    void remove(Iterable<Entity> entities);

    @SuppressWarnings("unchecked")
    void remove(Entity... entities);
}
