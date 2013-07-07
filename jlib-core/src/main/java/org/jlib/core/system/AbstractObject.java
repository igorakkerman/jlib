/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.system;

import org.apache.commons.lang3.builder.ToStringStyle;

import static org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.getDefaultStyle;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

/**
 * Abstract {@link Object} implementing {@link #toString()}, {@link #equals(Object)} and {@link #hashCode()} using
 * the correspondent builders provided by
 * <a href="http://commons.apache.org/proper/commons-lang/">Apache Commons Lang</a>.
 *
 * @author Igor Akkerman
 */
public abstract class AbstractObject {

    private ToStringStyle toStringStyle;

    /**
     * Creates a new {@link AbstractObject}.
     */
    protected AbstractObject() {
        super();
    }

    @Override
    public String toString() {
        return reflectionToString(this, getToStringStyle());
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object otherObject) {
        return reflectionEquals(this, otherObject, getExcludedFields());
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, getExcludedFields());
    }

    protected String[] getExcludedFields() {
        return EMPTY_STRING_ARRAY;
    }

    protected ToStringStyle getToStringStyle() {
        return getDefaultStyle();
    }
}
