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

import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.core.language.Valid;

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_FIELD_NAMES_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

class DefaultIdentifiedToStringStyleSupplier
implements IdentifiedToStringStyleSupplier {

    private static final DefaultIdentifiedToStringStyleSupplier INSTANCE = new DefaultIdentifiedToStringStyleSupplier();

    public static DefaultIdentifiedToStringStyleSupplier getInstance() {
        return INSTANCE;
    }

    private static final Map<String, ToStringStyle> TO_STRING_STYLES;

    static {
        TO_STRING_STYLES = new HashMap<>();
        TO_STRING_STYLES.put("DEFAULT_STYLE", DEFAULT_STYLE);
        TO_STRING_STYLES.put("MULTI_LINE_STYLE", MULTI_LINE_STYLE);
        TO_STRING_STYLES.put("NO_FIELD_NAMES_STYLE", NO_FIELD_NAMES_STYLE);
        TO_STRING_STYLES.put("SHORT_PREFIX_STYLE", SHORT_PREFIX_STYLE);
        TO_STRING_STYLES.put("SIMPLE_STYLE", SIMPLE_STYLE);
    }

    private DefaultIdentifiedToStringStyleSupplier() {}

    @Override
    public boolean isValidIdentifier(final String identifier) {
        return TO_STRING_STYLES.containsKey(identifier);
    }

    @Override
    public ToStringStyle getIdentifiedToStringStyle(@Valid final String identifier) {
        return TO_STRING_STYLES.get(identifier);
    }
}