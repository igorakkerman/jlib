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

package org.jlib.core.property;

import org.jlib.core.exception.ApplicationException;

import static org.jlib.core.message.MessageUtility.message;

/**
 * {@link ApplicationException} thrown when trying to retrieve the value of an optional system property that is not set.
 *
 * @author Igor Akkerman
 */
public class OptionalPropertyNotSetException
extends ApplicationException {

    private static final long serialVersionUID = 3031895042066549688L;

    private final String propertyName;

    public OptionalPropertyNotSetException(final String propertyName) {
        super(message(propertyName));

        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
