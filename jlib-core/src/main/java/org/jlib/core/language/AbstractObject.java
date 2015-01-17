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

package org.jlib.core.language;

import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.getDefaultStyle;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

/**
 * Abstract {@link Object} implementing {@link #toString()}, {@link #equals(Object)} and {@link #hashCode()} using
 * the correspondent reflective builders provided by
 * <a href="http://commons.apache.org/proper/commons-lang/">Apache Commons Lang</a>.
 *
 * @author Igor Akkerman
 */
public abstract class AbstractObject {

    /**
     * Creates a new {@link AbstractObject}.
     */
    protected AbstractObject() {
    }

    /**
     * <p>
     * Returns a {@link String} providing a textual representation of this {@link AbstractObject}, according to the
     * specification in {@link Object#toString()}.
     * </p>
     * <p>
     * The implementation in the class {@link AbstractObject} uses
     * {@link ToStringBuilder#reflectionToString(Object, ToStringStyle)} to build the {@link String} with the
     * {@link ToStringStyle} specified by {@link #getToStringStyle()}.
     * </p>
     *
     * @return {@link String} representation of this {@link AbstractObject}
     */
    @Override
    public String toString() {
        return reflectionToString(this, getToStringStyle());
    }

    /**
     * <p>
     * Returns the {@link ToStringStyle} used by {@link #toString()}.
     * </p>
     * <p>
     * The implementation in the class {@link AbstractObject} returns the result of
     * {@link ToStringBuilder#getDefaultStyle()}. It may be overridden to specify a more suitable {@link ToStringStyle}.
     * An application-wide {@link ToStringStyle} may be registered using
     * {@link ToStringBuilder#setDefaultStyle(ToStringStyle)}.
     * </p>
     *
     * @return {@link ToStringStyle} used by {@link #toString()}
     */
    protected ToStringStyle getToStringStyle() {
        return getDefaultStyle();
    }

    /**
     * <p>
     * Returns whether the specified {@link Object} is equal to this {@link AbstractObject}, according to the
     * specification in {@link Object#equals(Object)}.
     * </p>
     * <p>
     * The implementation in the class {@link AbstractObject} uses
     * {@link EqualsBuilder#reflectionEquals(Object, Object, Collection)} to perform the verification.
     * The fields provided by {@link #getExcludedFields()} are excluded from the verification.
     * </p>
     *
     * @param otherObject
     *        {@link Object} to be compared for equality to this {@link AbstractObject}
     *
     * @return {@code true} if {@code otherObject} is equal to this {@link AbstractObject};
     *         {@code false} otherwise
     */
    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object otherObject) {
        return reflectionEquals(this, otherObject, getExcludedFields());
    }

    /**
     * <p>
     * Returns a hash code value for this {@link AbstractObject}, according to the specification in
     * {@link Object#hashCode()}.
     * </p>
     * <p>
     * The implementation in the class {@link AbstractObject} uses
     * {@link HashCodeBuilder#reflectionHashCode(Object, String...)} to perform the verification.
     * The fields provided by {@link #getExcludedFields()} are excluded from the verification.
     * </p>
     *
     * @return integer specifying the hash code
     */
    @Override
    public int hashCode() {
        return reflectionHashCode(this, getExcludedFields());
    }

    /**
     * <p>
     * Reuturns the names of the fields excluded from the operations in {@link #equals(Object)} and {@link #hashCode()}.
     * </p>
     * <p>
     * The implementation in the class {@link AbstractObject} returns an empty array. It may be overridden to specify
     * a set of excluded fields.
     * </p>
     *
     *
     * @return array of {@link String}s specifying the names of the excluded fields
     */
    protected String[] getExcludedFields() {
        return EMPTY_STRING_ARRAY;
    }
}
