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

import org.jlib.core.value.Named;

/**
 * {@link Message} building the final text by concatenating the specified text and the named arguments, using the
 * parameters set in a {@link MessageStyle} instance. If no such instance is specified, the parameters returned
 * by {@link MessageStyleRegistry#getDefaultMessageStyle()} are used.
 *
 * @author Igor Akkerman
 */
public class EagerMessage
extends StyledMessage {

    private static final long serialVersionUID = - 1625043299945178724L;

    private static final int EXPECTED_ARGUMENTS_COUNT = 5;
    private static final int EXPECTED_ARGUMENT_LENGTH = 64;

    protected static StringBuilder createBuilder(final String text) {
        return new StringBuilder(text.length() + EXPECTED_ARGUMENTS_COUNT * EXPECTED_ARGUMENT_LENGTH);
    }

    private final StringBuilder builder;
    private int argumentsCount = 0;

    public EagerMessage() {
        this("");
    }

    public EagerMessage(final String text) {
        this(text, MessageStyleRegistry.getInstance().getDefaultMessageStyle());
    }

    public EagerMessage(final String text, final MessageStyle messageStyle) {
        this(createBuilder(text), messageStyle);

        builder.append(text);
    }

    public EagerMessage(final StringBuilder builder) {
        this(builder, MessageStyleRegistry.getInstance().getDefaultMessageStyle());
    }

    public EagerMessage(final StringBuilder builder, final MessageStyle style) {
        super(style);

        this.builder = builder;
    }

    @Override
    public Message with(final String argumentName, final Object argumentValue) {
        appendSeparator();
        getMessageStyle().getArgumentFormatter().append(builder, argumentName, argumentValue);
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
            builder.append(getMessageStyle().getBeforeArguments());
        else if (builder.length() != 0 && argumentsCount == 0)
            builder.append(getMessageStyle().getBetweenTextAndArguments()).append(getMessageStyle().getBeforeArguments());
        else if (builder.length() != 0)
            builder.append(getMessageStyle().getBetweenArguments());
    }

    @Override
    public String toString() {
        if (argumentsCount != 0)
            builder.append(getMessageStyle().getAfterArguments());

        return builder.toString();
    }
}
