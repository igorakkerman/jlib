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

import org.jlib.core.language.Valid;

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_FIELD_NAMES_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
import static org.jlib.object_spi.apachecommons.ApacheCommonsObjectMethodForwarder.getToStringStyles;
import static org.jlib.object_spi.apachecommons.ToStringStyleIdentifierAssert.assertThatIdentifier;
import org.junit.Test;

class MapIdentifiedToStringStyleSupplierTest {

    private static final IdentifiedToStringStyleSupplier SUPPLIER = /*
     */ new MapIdentifiedToStringStyleSupplier(getToStringStyles());

    @Test
    public void defaultStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("DEFAULT_STYLE").in(SUPPLIER).isValid().mapsTo(DEFAULT_STYLE);
    }

    @Test
    public void multiLineStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("MULTI_LINE_STYLE").in(SUPPLIER).isValid().mapsTo(MULTI_LINE_STYLE);
    }

    @Test
    public void noFieldNamesStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("NO_FIELD_NAMES_STYLE").in(SUPPLIER).isValid().mapsTo(NO_FIELD_NAMES_STYLE);
    }

    @Test
    public void shortPrefixStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("SHORT_PREFIX_STYLE").in(SUPPLIER).isValid().mapsTo(SHORT_PREFIX_STYLE);
    }

    @Test
    public void simpleStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("SIMPLE_STYLE").in(SUPPLIER).isValid().mapsTo(SIMPLE_STYLE);
    }

    @Test
    public void emptyIdentifierShouldBeInvalid() {
        assertThatIdentifier("").in(SUPPLIER).isInvalid();
    }

    @Test
    public void blankIdentifierShouldBeInvalid() {
        assertThatIdentifier("").in(SUPPLIER).isInvalid();
    }

    @Test
    public void anyIdentifierOnOwnSupplierShouldMapCorrectly() {
        assertThatIdentifier("").in(new IdentifiedToStringStyleSupplier() {
            @Override
            public boolean isValidIdentifier(final String identifier) {
                return true;
            }

            @Override
            public ToStringStyle getIdentifiedToStringStyle(@Valid final String identifier) {
                return DEFAULT_STYLE;
            }
        }).isValid().mapsTo(DEFAULT_STYLE);
    }
}

