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

package org.jlib.basefunctions.apachecommons.tostring;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.core.property.OptionalPropertyValueSupplier;

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_FIELD_NAMES_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
import org.jlib.reflect.reflector.defaults.DefaultReflectorService;

public final class DefaultToStringStylesConfiguration {

    public static final String TO_STRING_STYLE_NAME_PROPERTY_NAME =
    /*    */ "org.jlib.basefunctions.apachecommons.toStringStyle";

    public static final OptionalPropertyValueSupplier
    /**/ TO_STRING_STYLE_IDENTIFIER_OR_CLASS_NAME_SUPPLIER =
    /*    */ new OptionalPropertyValueSupplier(TO_STRING_STYLE_NAME_PROPERTY_NAME);

    public static final Map<String, ToStringStyle> TO_STRING_STYLES;

    static {
        TO_STRING_STYLES = new HashMap<>();
        TO_STRING_STYLES.put("DEFAULT_STYLE", DEFAULT_STYLE);
        TO_STRING_STYLES.put("MULTI_LINE_STYLE", MULTI_LINE_STYLE);
        TO_STRING_STYLES.put("NO_FIELD_NAMES_STYLE", NO_FIELD_NAMES_STYLE);
        TO_STRING_STYLES.put("SHORT_PREFIX_STYLE", SHORT_PREFIX_STYLE);
        TO_STRING_STYLES.put("SIMPLE_STYLE", SIMPLE_STYLE);
    }

    public static final ToStringStyle DEFAULT_TO_STRING_STYLE = DEFAULT_STYLE;

    public static final MapNamedToStringStyleSupplier NAMED_STYLE_SUPPLIER =
    /**/ new MapNamedToStringStyleSupplier(TO_STRING_STYLES);

    public static final ClassNameToStringStyleSupplier CLASS_NAME_STYLE_SUPPLIER;

    static {
        final ReflectorClassNameToStringStyleSupplier classNameStyleSupplier =
        /**/ new ReflectorClassNameToStringStyleSupplier();
        classNameStyleSupplier.setReflectorService(DefaultReflectorService.getInstance());
        CLASS_NAME_STYLE_SUPPLIER = classNameStyleSupplier;
    }

    private DefaultToStringStylesConfiguration() {}
}
