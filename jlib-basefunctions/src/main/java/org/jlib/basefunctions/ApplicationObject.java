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

package org.jlib.basefunctions;

import java.util.function.Predicate;

import static org.jlib.core.array.ArrayUtility.emptyArray;

/**
 * Abstract {@link Object} implementing {@link #toString()}, {@link #equals(Object)} and {@link #hashCode()} using the
 * correspondent reflective builders provided by a jlib Core Functions SPI implementation.
 *
 * @author Igor Akkerman
 */
public abstract class ApplicationObject
implements SuperEquals {

    private static final BaseFunctionsDispatcher CORE_FUNCTIONS_DISPATCHER =
    /**/ BaseFunctionsService.getInstance().getBaseFunctionsDispatcher();

    protected ApplicationObject() {}

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object otherObject) {
        return equalsStrategy().areEqual(this, otherObject);
    }

    @Override
    public int hashCode() {
        return hashCodeStrategy().hashCode(this);
    }

    @Override
    public String toString() {
        return toStringStrategy().toString(this);
    }

    protected <Obj> Equals<Obj> equalsStrategy() {
        return CORE_FUNCTIONS_DISPATCHER.genericEquals(getExcludedFieldNames());
    }

    protected <Obj> HashCode<Obj> hashCodeStrategy() {
        return CORE_FUNCTIONS_DISPATCHER.genericHashCode(getExcludedFieldNames());
    }

    protected <Obj> ToString<Obj> toStringStrategy() {
        return CORE_FUNCTIONS_DISPATCHER.genericToString();
    }

    protected EqualsEngine<ApplicationObject> equalsEngine() {
        return CORE_FUNCTIONS_DISPATCHER.equalsEngine(this);
    }

    protected HashCodeEngine<ApplicationObject> hashCodeEngine() {
        return CORE_FUNCTIONS_DISPATCHER.hashCodeEngine(this);
    }

    protected ToStringEngine<ApplicationObject> toStringEngine() {
        return CORE_FUNCTIONS_DISPATCHER.toStringEngine(this);
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
    protected String[] getExcludedFieldNames() {
        return emptyArray();
    }

    @Override
    public Predicate<SuperEquals> superEquals() {
        return super::equals;
    }
}
