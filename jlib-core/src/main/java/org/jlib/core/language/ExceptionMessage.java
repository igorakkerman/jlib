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

import org.jlib.core.text.ParametrizedTextUtility;
import org.jlib.core.text.templateengine.TemplateEngine;

import static org.jlib.core.language.ExceptionMessageUtility.appendNamedObject;

public class ExceptionMessage
extends ParametrizedTextUtility<Object> {

    public ExceptionMessage(final TemplateEngine<Object> templateEngine, final CharSequence template,
                            final Object... arguments) {
        super(templateEngine, template, arguments);
    }

    public ExceptionMessage with(final Object object) {

        getTemplateBuilder().append(';').append(' ').append(object);

        return this;
    }

    public ExceptionMessage with(final CharSequence objectName, final Object object) {

        appendNamedObject(getTemplateBuilder().append(';').append(' '), objectName, object);

        return this;
    }

    public ExceptionMessage append(final Object object) {
        super.append(object);

        return this;
    }

    public ExceptionMessage append(final char character) {
        super.append(character);

        return this;
    }

    public ExceptionMessage append(final boolean bool) {
        super.append(bool);

        return this;
    }

    public ExceptionMessage append(final byte number) {
        super.append(number);

        return this;
    }

    public ExceptionMessage append(final int number) {
        super.append(number);

        return this;
    }

    public ExceptionMessage append(final long number) {
        super.append(number);

        return this;
    }

    public ExceptionMessage append(final float number) {
        super.append(number);

        return this;
    }

    public ExceptionMessage append(final double number) {
        super.append(number);

        return this;
    }
}
