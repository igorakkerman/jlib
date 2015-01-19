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

package org.jlib.core.text.message;

import java.util.Formatter;

import java.text.MessageFormat;

import static org.jlib.core.text.TextUtility.camelCaseToLowerCaseWords;
import static org.jlib.core.text.TextUtility.removeOnce;

public final class MessageUtility {

    public static ParametrizedMessage autoMessage(final Exception exception) {
        return message(autoMessageText(exception));
    }

    public static String autoMessageText(final Exception exception) {
        return camelCaseToLowerCaseWords(removeOnce(exception.getClass().getSimpleName(), "Exception"));
    }

    public static ParametrizedMessage message() {
        return new ParametrizedMessage();
    }

    public static ParametrizedMessage message(final Object object) {
        return new ParametrizedMessage(object.toString());
    }

    public static ParametrizedMessage message(final Object object, final ParametrizedMessageConfiguration configuration) {
        return new ParametrizedMessage(object.toString(), configuration);
    }

    public static ParametrizedMessage messageMf(final CharSequence messageTemplate, final Object... messageArguments) {
        return new ParametrizedMessage(MessageFormat.format(messageTemplate.toString(), messageArguments));
    }

    public static ParametrizedMessage messagePf(final CharSequence messageTemplate, final Object... messageArguments) {
        final StringBuilder messageBuilder = new StringBuilder(messageTemplate.length() + messageArguments.length * 50 +
                                                               100);
        new Formatter(messageBuilder).format(messageTemplate.toString(), messageArguments);
        return new ParametrizedMessage(messageBuilder);
    }

    private MessageUtility() {
        // no visible constructor
    }
}
