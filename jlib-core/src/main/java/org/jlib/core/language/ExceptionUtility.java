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

import static org.jlib.core.text.TextUtility.camelCaseToLowerCaseWords;
import static org.jlib.core.text.TextUtility.removeOnce;

import org.jlib.core.text.textbuilder.MessageFormatTemplateEngine;
import org.jlib.core.text.textbuilder.TemplateEngine;

public final class ExceptionUtility {

    /** default {@link TemplateEngine} used */
    public static final TemplateEngine DEFAULT_MESSAGE_TEMPLATE_ENGINE = MessageFormatTemplateEngine.getInstance();

    private ExceptionUtility() {
        // no visible constructor
    }

    public static String createMessageFromExceptionName(final Exception exception) {
        return camelCaseToLowerCaseWords(removeOnce(exception.getClass().getSimpleName(), "Exception"));
    }

    public static String namedObjectToString(final CharSequence objectName, final Object object) {
        return objectName.toString() + '=' + object;
    }

    public static String withObject(final CharSequence message, final Object object) {

        return message.toString() + ';' + ' ' + object;
    }

    public static String withNamedObject(final CharSequence message, final CharSequence objectName,
                                         final Object object) {

        return message.toString() + ';' + ' ' + objectName + '=' + object;
    }
}
