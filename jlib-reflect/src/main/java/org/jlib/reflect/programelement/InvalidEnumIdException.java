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

package org.jlib.reflect.programelement;

import static org.jlib.core.message.MessageUtility.message;

/**
 * Exception thrown when trying to select an {@link Enum} value using some identifier, like a discriminator character in
 * a database context, for example.
 *
 * @author Igor Akkerman
 */
public class InvalidEnumIdException
extends ClassException {

    private static final long serialVersionUID = 1248871337527197565L;

    private final String idName;
    private final Object id;

    public InvalidEnumIdException(final Class<? extends Enum<?>> enumClass, final String idName, final Object id) {
        super(message().with(idName, id), enumClass.getName());

        this.idName = idName;
        this.id = id;
    }

    public String getIdName() {
        return idName;
    }

    public Object getId() {
        return id;
    }
}
