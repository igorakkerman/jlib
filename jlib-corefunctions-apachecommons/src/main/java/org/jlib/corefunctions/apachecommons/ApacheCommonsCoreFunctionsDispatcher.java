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

package org.jlib.corefunctions.apachecommons;

import java.util.Optional;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.core.reflection.ReflectionService;

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import org.jlib.corefunctions.CoreFunctionsDispatcher;
import org.jlib.corefunctions.Equals;
import org.jlib.corefunctions.HashCode;
import org.jlib.corefunctions.HashCodeEngine;
import org.jlib.corefunctions.ToString;

public class ApacheCommonsCoreFunctionsDispatcher
implements CoreFunctionsDispatcher {

    private ToStringStyle toStringStyle;

    public ApacheCommonsCoreFunctionsDispatcher() {
        final Optional<String> optionalIdentifierOrClassName = DefaultToStringStylesConfiguration.TO_STRING_STYLE_IDENTIFIER_OR_CLASS_NAME_SUPPLIER.get();

        if (! optionalIdentifierOrClassName.isPresent()) {
            toStringStyle = DEFAULT_STYLE;
            return;
        }

        final IdentifierOrClassNameToStringStyleSupplier toStringStyleSupplier =
        /**/ new IdentifierOrClassNameToStringStyleSupplier();
        toStringStyleSupplier.setNamedStyleSupplier(DefaultToStringStylesConfiguration.NAMED_STYLE_SUPPLIER);
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
    public <Obj> ToString<Obj> reflectionToString() {
        return object -> ToStringBuilder.reflectionToString(object, toStringStyle);
    }

    @Override
    public HashCodeEngine hashCodeEngine() {
        return new ApacheCommonsHashCodeEngine();
    }

    public void setToStringStyle(final ToStringStyle toStringStyle) {
        this.toStringStyle = toStringStyle;
    }
}
