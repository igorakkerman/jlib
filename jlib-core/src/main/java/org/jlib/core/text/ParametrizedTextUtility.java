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
               */ String stringFrom(final TemplateEngine<Argument> templateEngine, final CharSequence template,
                                    final Argument... arguments) {
        return buildStringFrom(templateEngine, template, arguments).toString();
    }

    @SafeVarargs
    public static <Argument> /*
               */ String stringFrom(final TemplateEngine<Argument> templateEngine, final int bufferSize,
                                    final CharSequence template, final Argument... arguments) {

        return buildStringFrom(templateEngine, bufferSize, template, arguments).toString();
    }

    private static <Argument> StringBuilder buildStringFrom(final TemplateEngine<Argument> templateEngine, final CharSequence template,
                                                            final Argument[] arguments) {
        return append(new StringBuilder(computeExpectedBufferSize(template, arguments)), templateEngine, template, arguments);
    }

    private static <Argument> StringBuilder buildStringFrom(final TemplateEngine<Argument> templateEngine,
                                                            final int bufferSize, final CharSequence template,
                                                            final Argument[] arguments) {
        return append(new StringBuilder(bufferSize), templateEngine, template, arguments);
    }

    @SafeVarargs
    public static <Argument> /*
               */ StringBuilder append(final StringBuilder stringBuilder, final TemplateEngine<Argument> templateEngine,
                                       final CharSequence template, final Argument... arguments) {

        return stringBuilder.append(templateEngine.applyArguments(template, arguments));
    }

    private static int computeExpectedBufferSize(final CharSequence template, final Object[] arguments) {
        return template.length() + arguments.length * EXPECTED_ARGUMENT_LENGTH + EXPECTED_ADDITIONAL_LENGTH;
    }

    // no visible default constructor
    private ParametrizedTextUtility() {
    }
}
