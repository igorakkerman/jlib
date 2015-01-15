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
import org.jlib.core.value.InitializedNamed;

public final class ParametrizedTextUtility {

    public static final int EXPECTED_ARGUMENT_LENGTH = 50;

    public static final int EXPECTED_ADDITIONAL_LENGTH = 50;

    public static <Value> InitializedNamed<Value> arg(final CharSequence name, final Value value) {
        return new InitializedNamed<>(name, value);
    }

    @SafeVarargs
    public static <Argument> /*
               */ String text(final TemplateEngine templateEngine, final CharSequence template,
                              final Argument... arguments) {

        return textBuilder(templateEngine, template, arguments).toString();
    }

    @SafeVarargs
    public static <Argument> /*
               */ String text(final TemplateEngine templateEngine, final int bufferSize,
                              final CharSequence template, final Argument... arguments) {

        return textBuilder(templateEngine, bufferSize, template, arguments).toString();
    }

    // no visible default constructor
    private ParametrizedTextUtility() {
    }
}
