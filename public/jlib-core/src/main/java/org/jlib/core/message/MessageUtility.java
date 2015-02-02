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

package org.jlib.core.message;

import java.util.Formatter;

import java.text.MessageFormat;

import org.jlib.core.value.formatter.PrintfNamedValueFormatter;

public final class MessageUtility {

    public static Message message() {
        return new EagerMessage();
    }

    public static Message message(final Object object) {
        return new EagerMessage(object.toString());
    }

    public static Message message(final Object object, final MessageStyle messageStyle) {
        return new EagerMessage(object.toString(), messageStyle);
    }

    public static Message mfmessage(final String messageTemplate, final Object... messageArguments) {
        return new EagerMessage(MessageFormat.format(messageTemplate, messageArguments));
    }

    public static Message pfmessage(final String messageTemplate, final Object... messageArguments) {
        final StringBuilder messageBuilder = new StringBuilder(messageTemplate.length() + messageArguments.length * 50 +
                                                               100);
        new Formatter(messageBuilder).format(messageTemplate, messageArguments);
        return new EagerMessage(messageBuilder);
    }

    public static MessageStyle createInitialDefaultMessageStyle() {
        final MessageStyle defaultMessageStyle = new MessageStyle();

        defaultMessageStyle.setArgumentFormatter(new PrintfNamedValueFormatter("%s='%s'"));
        defaultMessageStyle.setBetweenTextAndArguments(" ");
        defaultMessageStyle.setBetweenArguments(" ");

        return defaultMessageStyle;
    }

    private MessageUtility() {}
}
