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

import org.apache.commons.lang3.builder.ToStringStyle;

import org.assertj.core.api.AbstractAssert;

public class ToStringStyleIdentifierAssert
    extends AbstractAssert<ToStringStyleIdentifierAssert, String> {

    private final NamedToStringStyleSupplier supplier;

    protected ToStringStyleIdentifierAssert(final String actual, final NamedToStringStyleSupplier supplier) {
        super(actual, ToStringStyleIdentifierAssert.class);

        this.supplier = supplier;
    }

    @SuppressWarnings("UnnecessarilyQualifiedInnerClassAccess")
    static Initializer assertThatIdentifier(final String actual) {
        return new Initializer(actual);
    }

    public ToStringStyleIdentifierAssert isInvalid() {
        isNotNull();

        if (supplier.get(actual).isPresent())
            failWithMessage("Expected invalid identifier but <%s> is valid", actual);

        return this;
    }

    public ToStringStyleIdentifierAssert isNotValid() {
        return isInvalid();
    }

    public ToStringStyleIdentifierAssert mapsTo(final ToStringStyle expectedToStringStyle) {
        isNotNull();

        final ToStringStyle actualToStringStyle = supplier.get(actual).orElseThrow(() -> new IllegalStateException("actualToStringStyle not set"));

        if (actualToStringStyle != expectedToStringStyle)
            failWithMessage("Identifier <%s> expected to map to <%s> but maps to <%s>.", actual, expectedToStringStyle,
                            actualToStringStyle);

        return this;
    }

    static class Initializer {

        private final String actual;

        public Initializer(final String actual) {
            this.actual = actual;
        }

        public ToStringStyleIdentifierAssert in(final NamedToStringStyleSupplier supplier) {
            return new ToStringStyleIdentifierAssert(actual, supplier);
        }
    }
}
