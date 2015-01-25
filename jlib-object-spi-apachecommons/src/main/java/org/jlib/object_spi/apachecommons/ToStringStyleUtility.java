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

package org.jlib.object_spi.apachecommons;

import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.core.property.OptionalPropertyNotSetException;
import org.jlib.core.property.PropertyUtility;
import org.jlib.core.reflection.ClassInstantiationException;

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_FIELD_NAMES_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
import static org.jlib.core.message.MessageUtility.message;
import static org.jlib.core.reflection.ReflectionUtility.newInstanceOf;
import org.jlib.object_spi.ObjectMethodForwarder;

public class ToStringStyleUtility {

    /**
     * <p>
     * Property name of the concrete {@link ToStringStyle} implementation's class name or short name.
     * Permitted values are:
     * </p>
     * <dl>
     *     <dt>DEFAULT_STYLE</dt><dd>{@link ToStringStyle#DEFAULT_STYLE}</dd>
     *     <dt>MULTI_LINE_STYLE</dt><dd>{@link ToStringStyle#MULTI_LINE_STYLE}</dd>
     *     <dt>NO_FIELD_NAMES_STYLE</dt><dd>{@link ToStringStyle#NO_FIELD_NAMES_STYLE}</dd>
     *     <dt>SHORT_PREFIX_STYLE</dt><dd>{@link ToStringStyle#SHORT_PREFIX_STYLE}</dd>
     *     <dt>SIMPLE_STYLE</dt><dd>{@link ToStringStyle#SIMPLE_STYLE}</dd>
     *     <dt>a fully qualified class name</dt><dd>Class extending {@link ToStringStyle} providing a public default
     *     constructor</dd>
     *     <dt>unset</dt><dd>{@link ToStringStyle#DEFAULT_STYLE}</dd>
     * </dl>
     * <p>
     * The values are evaluated in the order specified above.
     * The property is evaluated only once, when the {@link ObjectMethodForwarder} is initialized.
     * </p>
     */
    public static final String TO_STRING_STYLE_NAME_PROPERTY_NAME = "org.jlib.object-spi-apachecommons.toStringStyle";

    static ToStringStyle fetchToStringStyle()
    throws InvalidApacheCommonsToStringStyleClassException {
        try {
            final String toStringStyleIdentifier = /*
             */ PropertyUtility.getOptionalProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME);

            switch (toStringStyleIdentifier) {
                case "DEFAULT_STYLE":
                    return DEFAULT_STYLE;
                case "MULTI_LINE_STYLE":
                    return MULTI_LINE_STYLE;
                case "NO_FIELD_NAMES_STYLE":
                    return NO_FIELD_NAMES_STYLE;
                case "SHORT_PREFIX_STYLE":
                    return SHORT_PREFIX_STYLE;
                case "SIMPLE_STYLE":
                    return SIMPLE_STYLE;
                default:
                    return createToStringStyleInstance(toStringStyleIdentifier);
            }
        }
        catch (final OptionalPropertyNotSetException exception) {
            return DEFAULT_STYLE;
        }
    }

    static ToStringStyle createToStringStyleInstance(final String className) {
        try {
            return newInstanceOf(className, ToStringStyle.class);
        }
        catch (final ClassInstantiationException exception) {
            throw new InvalidApacheCommonsToStringStyleClassException(message().with("className", className),
                                                                      exception);
        }
    }

    private ToStringStyleUtility() {}
}
