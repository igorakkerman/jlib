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

import static org.jlib.core.message.MessageUtility.message;

import org.jlib.core.exception.InvalidStateException;

/**
 * {@link InvalidStateException} thrown when trying to retrieve the value of a
 * property that is not set.
 *
 * @author Igor Akkerman
 */
public class ApplicationPropertyNotSetException
extends InvalidStateException {

    private static final long serialVersionUID = 8781400138384560958L;

    /**
     * Creates a new ApplicationPropertyNotSetException.
     *
     * @param propertyName
     *        {@link CharSequence} specifying the name of the property that is not set
     */
    public ApplicationPropertyNotSetException(final CharSequence propertyName) {
        super(message(propertyName));
    }
}
