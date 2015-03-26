/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

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
