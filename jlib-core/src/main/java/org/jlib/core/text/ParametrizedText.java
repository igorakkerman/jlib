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

    private final TemplateEngine templateEngine;

    private CharSequence template;

    private Object[] arguments;

    public ParametrizedText(final TemplateEngine templateEngine, final CharSequence template,
                            final Object... arguments) {
        super();

        this.templateEngine = templateEngine;
        this.template = template;
        this.arguments = arguments;
    }

    public String getTemplate() {
        return template.toString();
    }

    protected void setTemplate(final CharSequence template) {
        this.template = template;
    }

    public Object[] getArguments() {
        return arguments;
    }

    protected void setArguments(final Object[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return templateEngine.applyArguments(template, arguments);
    }
}
