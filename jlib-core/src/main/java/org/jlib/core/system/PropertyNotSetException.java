/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.system;

import static org.jlib.core.language.ParametrizedMessageUtility.message;

import org.jlib.core.language.ApplicationException;

/**
 * Exception thrown when trying to retrieve the value of a property that is not set.
 *
 * @author Igor Akkerman
 */
public class PropertyNotSetException
extends ApplicationException {

    /** serialVersionUID */
    private static final long serialVersionUID = 902825184458130007L;

    /** name of the property that is not set */
    private final String propertyName;

    /**
     * Creates a new PropertyNotSetException.
     *
     * @param propertyName
     *        {@link String} specifying the name of the property that is not set
     */
    public PropertyNotSetException(final String propertyName) {
        super(message(propertyName));

        this.propertyName = propertyName;
    }

    /**
     * Returns the name of the property that is not set.
     *
     * @return {@link String} specifying the name of the property that is not set
     */
    public String getPropertyName() {
        return propertyName;
    }
}
