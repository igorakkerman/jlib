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

package org.jlib.core.text;

import java.util.Formatter;

import org.jlib.core.value.Named;

public class PrintfNamedValueFormatter
implements ValueFormatter<Object, Named<Object>> {

    private final String format;

    public PrintfNamedValueFormatter(final CharSequence format) {
        this.format = format.toString();
    }

    @Override
    public void append(final Appendable appendable, final Named<Object> value) {
        new Formatter(appendable).format(format, value.getName(), value.get());
    }
}
