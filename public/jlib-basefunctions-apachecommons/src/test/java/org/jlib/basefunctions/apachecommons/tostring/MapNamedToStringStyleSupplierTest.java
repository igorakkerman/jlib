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

import static java.util.Optional.of;
import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_FIELD_NAMES_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
import static org.jlib.basefunctions.apachecommons.tostring.ToStringStyleIdentifierAssert.assertThatIdentifier;
import org.junit.Test;

public class MapNamedToStringStyleSupplierTest {

    private static final NamedToStringStyleSupplier SUPPLIER = /*
     */ new MapNamedToStringStyleSupplier(DefaultToStringStylesConfiguration.TO_STRING_STYLES);

    @Test
    public void defaultStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("DEFAULT_STYLE").in(SUPPLIER).mapsTo(DEFAULT_STYLE);
    }

    @Test
    public void multiLineStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("MULTI_LINE_STYLE").in(SUPPLIER).mapsTo(MULTI_LINE_STYLE);
    }

    @Test
    public void noFieldNamesStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("NO_FIELD_NAMES_STYLE").in(SUPPLIER).mapsTo(NO_FIELD_NAMES_STYLE);
    }

    @Test
    public void shortPrefixStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("SHORT_PREFIX_STYLE").in(SUPPLIER).mapsTo(SHORT_PREFIX_STYLE);
    }

    @Test
    public void simpleStyleNameShouldBeValidAndMapCorrectly() {
        assertThatIdentifier("SIMPLE_STYLE").in(SUPPLIER).mapsTo(SIMPLE_STYLE);
    }

    @Test
    public void emptyIdentifierShouldBeInvalid() {
        assertThatIdentifier("").in(SUPPLIER).isInvalid();
    }

    @Test
    public void blankIdentifierShouldBeInvalid() {
        assertThatIdentifier(" ").in(SUPPLIER).isInvalid();
    }

    @Test
    public void anyIdentifierOnOwnSupplierShouldMapCorrectly() {
        assertThatIdentifier("").in(identifier -> of(DEFAULT_STYLE)).mapsTo(DEFAULT_STYLE);
    }
}

