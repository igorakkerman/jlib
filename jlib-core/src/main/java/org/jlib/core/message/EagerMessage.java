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

import java.io.Serializable;

import org.jlib.core.value.Named;

/**
 * {@link Message} building the final text by concatenating the specified text and the named arguments, using the
 * parameters set in a {@link MessageConfiguration} instance. If no such instance is specified, the parameters returned
 * by {@link MessageConfigurationRegistry#getDefaultConfiguration()} are used.
 *
 * @author Igor Akkerman
 */
public class EagerMessage
implements Message,
           Serializable {

    private static final long serialVersionUID = - 1625043299945178724L;

    private static final int EXPECTED_ARGUMENTS_COUNT = 5;
    private static final int EXPECTED_ARGUMENT_LENGTH = 64;

    protected static StringBuilder createBuilder(final String text) {
        return new StringBuilder(text.length() + EXPECTED_ARGUMENTS_COUNT * EXPECTED_ARGUMENT_LENGTH);
    }

    private final MessageConfiguration configuration;
    private final StringBuilder builder;
    private int argumentsCount = 0;

    public EagerMessage() {
        this("");
    }

    public EagerMessage(final String text) {
        this(text, MessageConfigurationRegistry.getInstance().getDefaultConfiguration());
    }

    public EagerMessage(final String text, final MessageConfiguration configuration) {
        this(createBuilder(text), configuration);

        builder.append(text);
    }

    public EagerMessage(final StringBuilder builder) {
        this(builder, MessageConfigurationRegistry.getInstance().getDefaultConfiguration());
    }

    public EagerMessage(final StringBuilder builder, final MessageConfiguration configuration) {
        this.builder = builder;
        this.configuration = configuration;
    }

    @Override
    public Message with(final String argumentName, final Object argumentValue) {
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

    protected void appendSeparator() {
        if (builder.length() == 0 && argumentsCount == 0)
            builder.append(configuration.getBeforeArguments());
        else if (builder.length() != 0 && argumentsCount == 0)
            builder.append(configuration.getBetweenTextAndArguments()).append(configuration.getBeforeArguments());
        else if (builder.length() != 0)
            builder.append(configuration.getBetweenArguments());
    }

    @Override
    public String toString() {
        if (argumentsCount != 0)
            builder.append(configuration.getAfterArguments());

        return builder.toString();
    }
}
