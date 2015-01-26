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

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.jlib.core.message.MessageUtility.message;
import static org.jlib.core.property.PropertyUtility.getOptionalProperty;
import org.jlib.object_spi.ObjectMethodForwarder;

public class IdentifierOrClassNamePropertyToStringStyleSupplier
implements ToStringStyleSupplier {

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

    @Override
    public ToStringStyle getToStringStyle()
    throws ToStringStyleNotFoundException {
        try {
            return getFromSuppliers(getOptionalProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME));
        }
        catch (final OptionalPropertyNotSetException exception) {
            return DEFAULT_STYLE;
        }
    }

    private ToStringStyle getFromSuppliers(final String propertyValue)
    throws ToStringStyleNotFoundException {
        for (final ToStringStyleSupplier supplier : suppliers(propertyValue))
            try {
                return supplier.getToStringStyle();
            }
            catch (final ToStringStyleNotFoundException exception) {
                // continue
            }

        throw new ToStringStyleNotFoundException(message().with("propertyValue", propertyValue));
    }

    private ToStringStyleSupplier[] suppliers(final String propertyValue) {
        return new ToStringStyleSupplier[]{ new IdentifierToStringStyleSupplier(propertyValue), //
                                            new ClassNameToStringStyleSupplier(propertyValue) };
    }
}
