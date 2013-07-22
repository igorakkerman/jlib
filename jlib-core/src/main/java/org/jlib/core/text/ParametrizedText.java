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

import org.jlib.core.language.AbstractObject;
import org.jlib.core.text.templateengine.TemplateEngine;

public class ParametrizedText
extends AbstractObject {

    public static final int EXPECTED_ARGUMENT_LENGTH = 30;

    public static final int EXPECTED_ADDITIONAL_LENGTH = 50;

    private static int computeExpectedBufferSize(final CharSequence template, final Object[] arguments) {
        return template.length() + arguments.length * EXPECTED_ARGUMENT_LENGTH + EXPECTED_ADDITIONAL_LENGTH;
    }

    private final TemplateEngine templateEngine;

    private final StringBuilder templateBuilder;

    private Object[] arguments;

    public ParametrizedText(final TemplateEngine templateEngine, final CharSequence template,
                            final Object... arguments) {
        this(templateEngine, computeExpectedBufferSize(template, arguments), template, arguments);
    }

    public ParametrizedText(final TemplateEngine templateEngine, final int bufferSize, final CharSequence template,
                            final Object... arguments) {
        super();

        this.templateEngine = templateEngine;

        templateBuilder = new StringBuilder(bufferSize).append(template);

        this.arguments = arguments;
    }

    protected StringBuilder getTemplateBuilder() {
        return templateBuilder;
    }

    public Object[] getArguments() {
        return arguments;
    }

    protected void setArguments(final Object[] arguments) {
        this.arguments = arguments;
    }

    public ParametrizedText append(final Object object) {
        templateBuilder.append(object);

        return this;
    }

    public ParametrizedText append(final char character) {
        templateBuilder.append(character);

        return this;
    }

    public ParametrizedText append(final int integer) {
        templateBuilder.append(integer);

        return this;
    }

    @Override
    public String toString() {
        return templateEngine.applyArguments(templateBuilder.toString(), arguments);
    }
}
