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

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import org.jlib.core.text.templateengine.IgnoreArgumentsTemplateEngine;
import org.jlib.core.text.templateengine.TemplateEngine;
import org.jlib.core.value.InitializedNamed;
import org.jlib.core.value.Named;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class ParametrizedMessage
implements Serializable {

    public static final ParametrizedMessage NO_MESSAGE = /*
     */ new ParametrizedMessage(IgnoreArgumentsTemplateEngine.getInstance(), EMPTY);

    private static final int EXPECTED_ARGUMENT_LENGTH = 32;

    private static final int EXPECTED_ADDITIONAL_LENGTH = 64;

    @Deprecated
    private static StringBuilder textBuilder(final TemplateEngine<Object> templateEngine, final CharSequence template,
                                             final List<Object> arguments) {
        return append(new StringBuilder(computeExpectedBufferSize(template, arguments)), templateEngine, template,
                      arguments);
    }

    @Deprecated
    private static StringBuilder textBuilder(final TemplateEngine<Object> templateEngine, final int bufferSize,
                                             final CharSequence template, final List<Object> arguments) {
        return append(new StringBuilder(bufferSize), templateEngine, template, arguments);
    }

    @Deprecated
    public static StringBuilder append(final StringBuilder stringBuilder, final TemplateEngine<Object> templateEngine,
                                       final CharSequence template, final Object... arguments) {

        return stringBuilder.append(templateEngine.applyArguments(template, arguments));
    }

    @Deprecated
    private static int computeExpectedBufferSize(final CharSequence template, final List<Object> arguments) {
        return template.length() + arguments.size() * EXPECTED_ARGUMENT_LENGTH + EXPECTED_ADDITIONAL_LENGTH;
    }

    private final TemplateEngine<Object> templateEngine;

    private final CharSequence rawTemplate;

    private final List<Object> arguments = new ArrayList<>();

    private final List<Named<Object>> namedArguments = new ArrayList<>();

    public ParametrizedMessage(final TemplateEngine<Object> templateEngine, final CharSequence rawTemplate) {
        this.templateEngine = templateEngine;
        this.rawTemplate = rawTemplate;
    }

    public ParametrizedMessage with(final Object argument) {
        arguments.add(argument);

        return this;
    }

    public ParametrizedMessage with(final CharSequence argumentName, final Object argument) {
        namedArguments.add(new InitializedNamed<>(argumentName, argument));

        return this;
    }

    @Override
    public String toString() {
        final StringBuilder templateBuilder = new StringBuilder(rawTemplate);

        if (! namedArguments.isEmpty()) {
            templateBuilder.append(' ');

            for (final Named<Object> namedArgument : namedArguments) {
                templateBuilder.append(namedArgument.getName());
                templateBuilder.append(": ");
                templateBuilder.append(namedArgument.get());
                templateBuilder.append("; ");
            }
        }

        templateEngine.applyArguments(templateBuilder, arguments);

        return templateBuilder.toString();
    }
}
