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

package org.jlib.core.language;

import static org.jlib.core.language.ExceptionUtility.withNamedValue;

/**
 * {@link InvalidArgumentException} referencing a named targeted {@link Object}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidNamedObjectArgumentException
extends InvalidArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 207300032064585595L;

    /**
     * Creates a new {@link InvalidNamedObjectArgumentException}.
     *
     * @param targetObjectName
     *        {@link CharSequence} specifying the name of the targeted {@link Object}
     *
     * @param targetObject
     *        targeted {@link Object}
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the template of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public InvalidNamedObjectArgumentException(final CharSequence targetObjectName, final Object targetObject,
                                               final CharSequence messageTemplate, final Object... messageArguments) {

        super(withNamedValue(messageTemplate, targetObjectName, targetObject), messageArguments);
    }

    /**
     * Creates a new {@link InvalidNamedObjectArgumentException}.
     *
     * @param targetObjectName
     *        {@link CharSequence} specifying the name of the targeted {@link Object}
     *
     * @param targetObject
     *        targeted {@link Object}
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidNamedObjectArgumentException}
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the template of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    protected InvalidNamedObjectArgumentException(final CharSequence targetObjectName, final Object targetObject,
                                                  final Exception cause, final CharSequence messageTemplate,
                                                  final Object... messageArguments) {

        super(cause, withNamedValue(messageTemplate, targetObjectName, targetObject), messageArguments);
    }
}
