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

import java.io.Serializable;

import org.jlib.core.value.Named;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class EagerMessage
implements Message,
           Serializable {

    private static final int EXPECTED_ARGUMENTS_COUNT = 5;

    private static final int EXPECTED_ARGUMENT_LENGTH = 64;

    private static final long serialVersionUID = - 7441157699026452815L;

    private static StringBuilder createBuilder(final CharSequence text) {
        return new StringBuilder(text.length() + EXPECTED_ARGUMENTS_COUNT * EXPECTED_ARGUMENT_LENGTH);
    }

    private final MessageConfiguration configuration;

    private final StringBuilder builder;

    private int argumentsCount = 0;

    public EagerMessage() {
        this(EMPTY);
    }

    public EagerMessage(final CharSequence text) {
        this(text, MessageConfigurationRegistry.getInstance().getDefaultConfiguration());
    }

    public EagerMessage(final CharSequence text, final MessageConfiguration configuration) {
        this(createBuilder(text), configuration);

        builder.append(text);
    }

    public EagerMessage(final StringBuilder builder, final MessageConfiguration configuration) {
        this.builder = builder;
        this.configuration = configuration;
    }

    @Override
    public Message with(final CharSequence argumentName, final Object argumentValue) {
        appendSeparator();
        configuration.getArgumentFormatter().append(builder, argumentName, argumentValue);
        argumentsCount++;

        return this;
    }

    @Override
    public Message with(final Named<?>... arguments) {
        for (final Named<?> argument : arguments)
            with(argument.getName(), argument.get());

        return this;
    }

    private void appendSeparator() {
        if (builder.length() == 0)
            return;

        builder.append(argumentsCount == 0 ?
                       configuration.getTextArgumentsSeparator() :
                       configuration.getArgumentsSeparator());
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
