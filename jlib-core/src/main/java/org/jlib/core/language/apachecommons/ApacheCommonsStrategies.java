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

package org.jlib.core.language.apachecommons;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import org.jlib.core.language.Equals;
import org.jlib.core.language.EqualsHashCode;
import org.jlib.core.language.ForwardingEqualsHashCode;
import org.jlib.core.language.HashCode;
import org.jlib.core.language.ToString;

public class ApacheCommonsStrategies {

    public static <Obj> Equals<Obj> reflectionEquals() {
        return EqualsBuilder::reflectionEquals;
    }

    public static <Obj> Equals<Obj> reflectionEquals(final String... excludedFields) {
        return (object1, object2) -> EqualsBuilder.reflectionEquals(object1, object2, excludedFields);
    }

    public static <Obj> HashCode<Obj> reflectionHashCode() {
        return HashCodeBuilder::reflectionHashCode;
    }

    public static <Obj> HashCode<Obj> reflectionHashCode(final String... excludedFields) {
        return object -> HashCodeBuilder.reflectionHashCode(object, excludedFields);
    }

    public static <Obj> EqualsHashCode<Obj> reflectionEqualsHashCode() {
        return new ForwardingEqualsHashCode<>(reflectionEquals(), reflectionHashCode());
    }

    public static <Obj> EqualsHashCode<Obj> reflectionEqualsHashCode(final String... excludedFields) {
        return new ForwardingEqualsHashCode<>(reflectionEquals(excludedFields), reflectionHashCode(excludedFields));
    }

    public static <Obj> ToString<Obj> reflectionToString() {
        return ToStringBuilder::reflectionToString;
    }

    @SuppressWarnings("Convert2MethodRef")
    public static <Obj> ToString<Obj> reflectionToString(final ToStringStyle toStringStyle) {
        return object -> ToStringBuilder.reflectionToString(object);
    }

    private ApacheCommonsStrategies() {}
}
