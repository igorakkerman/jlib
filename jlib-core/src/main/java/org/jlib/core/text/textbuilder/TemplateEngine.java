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

package org.jlib.core.text.textbuilder;

import org.jlib.core.text.ParametrizedText;

/**
 * Routine applying arguments to a textual template, usually substituting placeholders. Each {@link TemplateEngine}
 * implementation defines the individual format of the template and the algorithm applying the arguments to this
 * template, for example, substituting its placeholders.
 *
 * @author Igor Akkerman
 */
public interface TemplateEngine {

    /**
     * Applies the specified arguments to the specified template containing placeholders.
     *
     * @param template
     *        {@link CharSequence} specifying the template containing the placeholders
     *
     * @param arguments
     *        {@link CharSequence} specifying the arguments applied on {@code template};
     *        the arguments are passed to the replacing routine in the correct
     *        order without any transformation
     *
     * @return {@link String} specifying the formatted text
     */
    public String applyArguments(CharSequence template, Object... arguments);

    public String applyArguments(ParametrizedText parametrizedText);
}
