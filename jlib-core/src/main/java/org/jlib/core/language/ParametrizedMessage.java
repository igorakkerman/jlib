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

import org.jlib.core.text.templateengine.TemplateEngine;

import static org.jlib.core.language.ExceptionMessageUtility.appendNamedObject;

public class ParametrizedMessage {

    private final StringBuilder textBuilder;

    private static <Argument> /*
                */ StringBuilder textBuilder(final TemplateEngine<Argument> templateEngine, final CharSequence template,
                                             final Argument[] arguments) {
        return append(new StringBuilder(computeExpectedBufferSize(template, arguments)), templateEngine, template,
                      arguments);
    }

    private static <Argument> /*
                */ StringBuilder textBuilder(final TemplateEngine<Argument> templateEngine, final int bufferSize,
                                             final CharSequence template, final Argument[] arguments) {
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

    public ParametrizedMessage with(final Object object) {

        getTemplateBuilder().append(';').append(' ').append(object);

        return this;
    }

    public ParametrizedMessage with(final CharSequence objectName, final Object object) {

        appendNamedObject(getTemplateBuilder().append(';').append(' '), objectName, object);

        return this;
    }

    public ParametrizedMessage append(final Object object) {
        super.append(object);

        return this;
    }

    public ParametrizedMessage append(final char character) {
        super.append(character);

        return this;
    }

    public ParametrizedMessage append(final boolean bool) {
        super.append(bool);

        return this;
    }

    public ParametrizedMessage append(final byte number) {
        super.append(number);

        return this;
    }

    public ParametrizedMessage append(final int number) {
        super.append(number);

        return this;
    }

    public ParametrizedMessage append(final long number) {
        super.append(number);

        return this;
    }

    public ParametrizedMessage append(final float number) {
        super.append(number);

        return this;
    }

    public ParametrizedMessage append(final double number) {
        super.append(number);

        return this;
    }
}
