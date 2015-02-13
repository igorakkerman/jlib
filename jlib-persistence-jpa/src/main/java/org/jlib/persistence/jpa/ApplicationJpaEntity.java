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

import org.jlib.basefunctions.ApplicationObject;
import org.jlib.persistence.IdEntity;

/**
 * JPA entity deriving from {@link ApplicationObject}.
 *
 * @param <Self>
 *        own type
 *
 * @param <ID>
 *        type of the id
 */
public abstract class ApplicationJpaEntity<Self extends ApplicationJpaEntity<Self, ID>, ID extends Serializable>
extends ApplicationObject
implements IdEntity<ID>{
    // unifying ApplicationObject and IdEntity
}
