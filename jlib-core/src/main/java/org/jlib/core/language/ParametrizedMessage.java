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

import static org.jlib.core.language.ExceptionUtility.withNamedObject;
import static org.jlib.core.language.ExceptionUtility.withObject;

import org.jlib.core.text.ParametrizedText;

public class ParametrizedMessage extends ParametrizedText {

    public ParametrizedMessage(final CharSequence template, final Object... arguments) {
        super(template, arguments);
    }

    public ParametrizedMessage with(final Object object) {

        setTemplate(withObject(getTemplate(), object));

        return this;
    }

    public ParametrizedMessage with(final CharSequence objectName, final Object object) {

        setTemplate(withNamedObject(getTemplate(), objectName, object));

        return this;
    }
}
