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

package org.jlib.corefunctions;

import java.util.function.Predicate;

/**
 * Abstract {@link Object} implementing {@link #toString()}, {@link #equals(Object)} and {@link #hashCode()} using the
 * correspondent reflective builders provided by a jlib Core Functions SPI implementation.
 *
 * @author Igor Akkerman
 */
public abstract class ApplicationObject
implements SuperEquals {

    private static final CoreFunctionsDispatcher CORE_FUNCTIONS_DISPATCHER =
    /**/ CoreFunctionsService.getInstance().getCoreFunctionsDispatcher();

    protected ApplicationObject() {}

    @Override
    public String toString() {
        return getToStringStrategy().toString(this);
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object otherObject) {
        return getEqualsStrategy().areEqual(this, otherObject);
    }

    @Override
    public int hashCode() {
        return getHashCodeStrategy().hashCode(this);
    }

    protected <Obj> Equals<Obj> getEqualsStrategy() {
        return CORE_FUNCTIONS_DISPATCHER.genericEquals(getExcludedFieldNames());
    }

    protected <Obj> HashCode<Obj> getHashCodeStrategy() {
        return CORE_FUNCTIONS_DISPATCHER.genericHashCode(getExcludedFieldNames());
    }

    protected <Obj> ToString<Obj> getToStringStrategy() {
        return CORE_FUNCTIONS_DISPATCHER.genericToString();
    }

    /**
     * <p>
     * Returns the names of the fields excluded from the operations in {@link #equals(Object)} and {@link #hashCode()}.
     * </p>
     * <p>
     * The implementation in the class {@link ApplicationObject} returns an empty array. It may be overridden to specify
     * a set of excluded fields.
     * </p>
     *
     * @return array of {@link String}s specifying the names of the excluded fields
     */
    @SuppressWarnings("SameReturnValue")
    protected String[] getExcludedFieldNames() {
        return new String[0];
    }

    @Override
    public Predicate<SuperEquals> superEquals() {
        return super::equals;
    }
}
