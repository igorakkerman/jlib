/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.core.text.message;

import java.io.Serializable;

import org.jlib.core.value.formatter.NamedValueFormatter;

public class MessageConfiguration
implements Serializable {

    private static final long serialVersionUID = 4551938257105373490L;

    private NamedValueFormatter<Object> argumentFormatter;

    private String textArgumentsSeparator;

    private String argumentsSeparator;

    public NamedValueFormatter<Object> getArgumentFormatter() {
        return argumentFormatter;
    }

    public void setArgumentFormatter(final NamedValueFormatter<Object> argumentFormatter) {
        this.argumentFormatter = argumentFormatter;
    }

    public void setTextArgumentsSeparator(final String textArgumentsSeparator) {
        this.textArgumentsSeparator = textArgumentsSeparator;
    }

    public String getTextArgumentsSeparator() {
        return textArgumentsSeparator;
    }

    public void setTextArgumentsSeparator(final CharSequence textArgumentsSeparator) {
        this.textArgumentsSeparator = textArgumentsSeparator.toString();
    }

    public void setArgumentsSeparator(final String argumentsSeparator) {
        this.argumentsSeparator = argumentsSeparator;
    }

    public String getArgumentsSeparator() {
        return argumentsSeparator;
    }

    public void setArgumentsSeparator(final CharSequence argumentsSeparator) {
        this.argumentsSeparator = argumentsSeparator.toString();
    }
}
