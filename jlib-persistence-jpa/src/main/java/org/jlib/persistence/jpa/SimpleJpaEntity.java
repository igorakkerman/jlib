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

package org.jlib.persistence.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.AUTO;
import org.jlib.persistence.IdEntity;

/**
 * <p>
 * Basic {@link IdEntity}.
 * </p>
 * <p>
 * Annotate the entity class with
 * {@code @AttributeOverride(name = JpaEntity.FIELD_NAME_ID, column = @Column(name = "myentity_id"))}
 * </p>

 * @param <ID>
 *        type of the id
 */
@MappedSuperclass
public abstract class SimpleJpaEntity<ID extends Serializable>
    implements IdEntity<ID> {

    @Id
    @GeneratedValue(strategy = AUTO)
    private ID id;

    @Override
    public ID getId() {
        return id;
    }
}
