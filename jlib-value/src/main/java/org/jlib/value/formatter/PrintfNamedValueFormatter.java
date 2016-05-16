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

package org.jlib.value.formatter;

import java.util.Formatter;

import lombok.Data;

@Data
public class PrintfNamedValueFormatter
    implements NamedValueFormatter<Object> {

    private final String template;

    @Override
    public void append(final StringBuilder builder, final String name, final Object value) {
        new Formatter(builder).format(template, name, value);
    }
}
