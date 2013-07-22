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

import static org.apache.commons.lang3.StringUtils.EMPTY;

import static org.jlib.core.text.TextUtility.camelCaseToLowerCaseWords;
import static org.jlib.core.text.TextUtility.removeOnce;

import org.jlib.core.text.templateengine.MessageFormatTemplateEngine;
import org.jlib.core.text.templateengine.PrintfTemplateEngine;

public final class ExceptionMessageUtility {

    public static String createMessageFromExceptionName(final Exception exception) {
        return camelCaseToLowerCaseWords(removeOnce(exception.getClass().getSimpleName(), "Exception"));
    }

    public static String namedObject(final CharSequence objectName, final Object object) {
        return appendNamedObject(new StringBuilder(objectName.length() + 50), objectName, object).toString();
    }

    public static StringBuilder appendNamedObject(final StringBuilder namedObjectBuilder, final CharSequence objectName,
                                                  final Object object) {
        return namedObjectBuilder.append(objectName).append('=').append(object);
    }

    public static ParametrizedMessage message() {
        return message(EMPTY);
    }

    public static ParametrizedMessage message(final CharSequence messageTemplate, final Object... messageArguments) {
        return new ParametrizedMessage(MessageFormatTemplateEngine.getInstance(), messageTemplate, messageArguments);
    }

    public static ParametrizedMessage message(final int value) {
        return message(Integer.toString(value));
    }

    public static ParametrizedMessage printf() {
        return printf(EMPTY);
    }

    public static ParametrizedMessage printf(final CharSequence messageTemplate, final Object... messageArguments) {
        return new ParametrizedMessage(PrintfTemplateEngine.getInstance(), messageTemplate, messageArguments);
    }

    public static ParametrizedMessage printf(final int value) {
        return printf(Integer.toString(value));
    }

    private ExceptionMessageUtility() {
        // no visible constructor
    }
}
