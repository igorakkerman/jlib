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

import org.jlib.core.value.Named;

public class ParametrizedMessage
implements Serializable {

    private static final int EXPECTED_ARGUMENTS_COUNT = 5;

    private static final int EXPECTED_ARGUMENT_LENGTH = 64;

    private static final int EXPECTED_ADDITIONAL_LENGTH = 64;

    private static final NamedValueFormatter formatter = new PrintfNamedValueFormatter<>();

    private final StringBuilder textBuilder = new StringBuilder(EXPECTED_ARGUMENTS_COUNT * EXPECTED_ARGUMENT_LENGTH +
                                                                EXPECTED_ADDITIONAL_LENGTH);

    public ParametrizedMessage(final CharSequence text) {
        textBuilder.append(text);
    }

    public ParametrizedMessage with(final CharSequence argumentName, final Object argumentValue) {
        textBuilder.append(argumentName);
        textBuilder.append(": ");
        textBuilder.append(argumentValue);
        textBuilder.append(". ");

        return this;
    }

    public ParametrizedMessage with(final Named<?>... arguments) {
        for (final Named<?> argument : arguments)
            with(argument.getName(), argument.get());

        return this;
    }

    @Override
    public String toString() {
        return textBuilder.toString();
    }
}
