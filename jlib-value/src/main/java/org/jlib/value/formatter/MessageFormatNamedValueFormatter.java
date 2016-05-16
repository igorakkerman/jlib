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

import java.text.MessageFormat;

import lombok.Data;
import org.jlib.value.Named;

/**
 * <p>
 * {@link MessageFormat} based ValueFormatter of {@link Named} values.
 * </p>
 * <p>
 * Since {@link MessageFormat} uses a {@link StringBuffer} instead of a {@link StringBuilder} internally,
 * this implementation cannot operate directly on the specified {@link StringBuilder} and needs to perform various copy
 * operations, which affect its performance.
 * </p>
 */
@Data
public class MessageFormatNamedValueFormatter
    implements NamedValueFormatter<Object> {

    private final String template;

    @Override
    public void append(final StringBuilder builder, final String name, final Object value) {
        builder.append(MessageFormat.format(template, name, value));
    }
}
