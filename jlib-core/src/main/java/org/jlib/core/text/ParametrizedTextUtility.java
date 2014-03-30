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

import org.jlib.core.text.templateengine.TemplateEngine;

public final class ParametrizedTextUtility {

    public static final int EXPECTED_ARGUMENT_LENGTH = 50;

    public static final int EXPECTED_ADDITIONAL_LENGTH = 50;

    public static <Value> NamedValue arg(final CharSequence name, final Value value) {
        return new NamedValue<>(name, value);
    }

    @SafeVarargs
    public static <Argument> /*
               */ String toString(final TemplateEngine<Argument> templateEngine, final CharSequence template,
                                  final Argument... arguments) {
        return buildString(templateEngine, template, arguments).toString();
    }

    @SafeVarargs
    public static <Argument> /*
               */ String toString(final TemplateEngine<Argument> templateEngine, final int bufferSize,
                                  final CharSequence template, final Argument... arguments) {

        return buildString(templateEngine, bufferSize, template, arguments).toString();
    }

    @SafeVarargs
    public static <Argument> /*
               */ StringBuilder buildString(final TemplateEngine<Argument> templateEngine, final CharSequence template,
                                            final Argument... arguments) {

        return buildString(templateEngine, computeExpectedBufferSize(template, arguments), template, arguments);
    }

    @SafeVarargs
    public static <Argument> /*
               */ StringBuilder buildString(final TemplateEngine<Argument> templateEngine, final int bufferSize,
                                            final CharSequence template, final Argument... arguments) {

        final String createdText = templateEngine.applyArguments(template, arguments);

        return new StringBuilder(bufferSize).append(createdText);
    }

    private static int computeExpectedBufferSize(final CharSequence template, final Object[] arguments) {
        return template.length() + arguments.length * EXPECTED_ARGUMENT_LENGTH + EXPECTED_ADDITIONAL_LENGTH;
    }

    // no visible default constructor
    private ParametrizedTextUtility() {
    }
}
