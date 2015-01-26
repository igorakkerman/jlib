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

import static org.jlib.core.property.PropertyUtility.getOptionalProperty;
import static org.jlib.object_spi.apachecommons.ApacheCommonsObjectMethodForwarder.DEFAULT_TO_STRING_STYLE;
import static org.jlib.object_spi.apachecommons.ApacheCommonsObjectMethodForwarder.TO_STRING_STYLE_NAME_PROPERTY_NAME;
import static org.jlib.object_spi.apachecommons.ClassNameToStringStyleSupplier.getToStringStyleByClassName;
import static org.jlib.object_spi.apachecommons.IdentifiedToStringStyleSupplier.getIdentifiedToStringStyle;

class IdentifierOrClassNamePropertyToStringStyleSupplier {

    public ToStringStyle getToStringStyle()
    throws ToStringStyleClassNotFoundException {

        String propertyValue = null;

        try {
            propertyValue = getOptionalProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME);

            return getIdentifiedToStringStyle(propertyValue);
        }
        catch (final OptionalPropertyNotSetException exception) {
            return DEFAULT_TO_STRING_STYLE;
        }
        catch (final IdentifiedToStringStyleNotFoundException exception) {
            return getToStringStyleByClassName(propertyValue);
        }
    }
}
