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

package org.jlib.core.text;

import java.io.Serializable;

import org.jlib.core.value.InitializedNamed;
import org.jlib.core.value.Named;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class ParametrizedMessage
implements Serializable {

    public static final String DEFAULT_ARGUMENT_TEMPLATE = "%s='%s'";

    public static final String DEFAULT_TEXT_ARGUMENT_SEPARATOR = " ";

    public static final String DEFAULT_ARGUMENT_SEPARATOR = " ";

    private static final int EXPECTED_ARGUMENTS_COUNT = 5;

    private static final int EXPECTED_ARGUMENT_LENGTH = 64;

    private static final int EXPECTED_ADDITIONAL_LENGTH = 64;

    private static StringBuilder createBuilder(final CharSequence text) {
        return new StringBuilder(text.length() + EXPECTED_ARGUMENTS_COUNT * EXPECTED_ARGUMENT_LENGTH +
                                 EXPECTED_ADDITIONAL_LENGTH);
    }

    private final ValueFormatter<Object, Named<?>> argumentFormatter;

    private final String textArgumentSeparator;

    private final String argumentSeparator;

    private final StringBuilder builder;

    private int argumentsCount = 0;

    public ParametrizedMessage() {
        this(EMPTY);
    }

    public ParametrizedMessage(final CharSequence text) {
        this(text, DEFAULT_ARGUMENT_TEMPLATE, DEFAULT_TEXT_ARGUMENT_SEPARATOR, DEFAULT_ARGUMENT_SEPARATOR);
    }

    public ParametrizedMessage(final CharSequence text, final CharSequence argumentTemplate,
                               final CharSequence textArgumentSeparator, final CharSequence argumentSeparator) {
        this(createBuilder(text), argumentTemplate, textArgumentSeparator, argumentSeparator);

        builder.append(text);
    }

    public ParametrizedMessage(final StringBuilder builder, final CharSequence argumentTemplate,
                               final CharSequence textArgumentSeparator, final CharSequence argumentSeparator) {
        this.builder = builder;
        argumentFormatter = new PrintfNamedValueFormatter(argumentTemplate);
        this.textArgumentSeparator = textArgumentSeparator.toString();
        this.argumentSeparator = argumentSeparator.toString();
    }

    public ParametrizedMessage with(final CharSequence argumentName, final Object argumentValue) {
        return with(new InitializedNamed<>(argumentName, argumentValue));
    }

    public ParametrizedMessage with(final Named<?>... arguments) {
        for (final Named<?> argument : arguments) {

            appendSeparator();

            argumentFormatter.append(builder, argument);

            argumentsCount++;
        }

        return this;
    }

    private void appendSeparator() {
        if (builder.length() == 0)
            return;

        builder.append(argumentsCount == 0 ?
                       textArgumentSeparator :
                       argumentSeparator);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
