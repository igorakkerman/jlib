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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.core.property.OptionalPropertyValueSupplier;
import org.jlib.core.reflection.ReflectionService;

import static java.util.Collections.unmodifiableMap;
import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_FIELD_NAMES_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
import org.jlib.object_spi.CoreFunctionDispatcher;
import org.jlib.object_spi.Equals;
import org.jlib.object_spi.EqualsHashCode;
import org.jlib.object_spi.ForwardingEqualsHashCode;
import org.jlib.object_spi.HashCode;
import org.jlib.object_spi.HashCodeEngine;
import org.jlib.object_spi.ToString;

public class ApacheCommonsCoreFunctionDispatcher
implements CoreFunctionDispatcher {

    public static final String TO_STRING_STYLE_NAME_PROPERTY_NAME = "org.jlib.object_spi.apachecommons.toStringStyle";
    public static final ToStringStyle DEFAULT_TO_STRING_STYLE = DEFAULT_STYLE;

    private static final OptionalPropertyValueSupplier
    /**/ TO_STRING_STYLE_IDENTIFIER_OR_CLASS_NAME_SUPPLIER =
    /*    */ new OptionalPropertyValueSupplier(TO_STRING_STYLE_NAME_PROPERTY_NAME);

    private static final Map<String, ToStringStyle> TO_STRING_STYLES;

    static {
        TO_STRING_STYLES = new HashMap<>();
        TO_STRING_STYLES.put("DEFAULT_STYLE", DEFAULT_STYLE);
        TO_STRING_STYLES.put("MULTI_LINE_STYLE", MULTI_LINE_STYLE);
        TO_STRING_STYLES.put("NO_FIELD_NAMES_STYLE", NO_FIELD_NAMES_STYLE);
        TO_STRING_STYLES.put("SHORT_PREFIX_STYLE", SHORT_PREFIX_STYLE);
        TO_STRING_STYLES.put("SIMPLE_STYLE", SIMPLE_STYLE);
    }

    public static final MapNamedToStringStyleSupplier NAMED_STYLE_SUPPLIER =
    /**/ new MapNamedToStringStyleSupplier(TO_STRING_STYLES);

    public static Map<String, ToStringStyle> getToStringStyles() {
        return unmodifiableMap(TO_STRING_STYLES);
    }

    private final ToStringStyle toStringStyle;

    public ApacheCommonsCoreFunctionDispatcher() {
        final Optional<String> optionalIdentifierOrClassName = TO_STRING_STYLE_IDENTIFIER_OR_CLASS_NAME_SUPPLIER.get();

        if (! optionalIdentifierOrClassName.isPresent()) {
            toStringStyle = DEFAULT_STYLE;
            return;
        }

        final IdentifierOrClassNameToStringStyleSupplier toStringStyleSupplier =
        /**/ new IdentifierOrClassNameToStringStyleSupplier();
        toStringStyleSupplier.setNamedStyleSupplier(NAMED_STYLE_SUPPLIER);
        toStringStyleSupplier.setIdentifierOrClassName(optionalIdentifierOrClassName.get());
        toStringStyleSupplier.setInstanceService(ReflectionService.getInstance());

        toStringStyle = toStringStyleSupplier.get();
    }

    @Override
    public <Obj> Equals<Obj> reflectionEquals() {
        return EqualsBuilder::reflectionEquals;
    }

    @Override
    public <Obj> Equals<Obj> reflectionEquals(final String... excludedFields) {
        return (object1, object2) -> EqualsBuilder.reflectionEquals(object1, object2, excludedFields);
    }

    @Override
    public <Obj> HashCode<Obj> reflectionHashCode() {
        return HashCodeBuilder::reflectionHashCode;
    }

    @Override
    public <Obj> HashCode<Obj> reflectionHashCode(final String... excludedFields) {
        return object -> HashCodeBuilder.reflectionHashCode(object, excludedFields);
    }

    @Override
    public <Obj> EqualsHashCode<Obj> reflectionEqualsHashCode() {
        return new ForwardingEqualsHashCode<>(reflectionEquals(), reflectionHashCode());
    }

    @Override
    public <Obj> EqualsHashCode<Obj> reflectionEqualsHashCode(final String... excludedFields) {
        return new ForwardingEqualsHashCode<>(reflectionEquals(excludedFields), reflectionHashCode(excludedFields));
    }

    @Override
    public <Obj> ToString<Obj> reflectionToString() {
        return object -> ToStringBuilder.reflectionToString(object, toStringStyle);
    }

    @Override
    public HashCodeEngine hashCodeEngine() {
        return new ApacheCommonsHashCodeEngine();
    }
}