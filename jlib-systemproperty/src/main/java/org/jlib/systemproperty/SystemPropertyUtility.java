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

package org.jlib.systemproperty;

import java.util.Optional;

/**
 * Utility class providing static methods for system properties.
 *
 * @author Igor Akkerman
 */
public final class SystemPropertyUtility {

    /**
     * Returns the {@link Optional} value of the system property indicated by the specified key.
     *
     * @param propertyName
     *        String specifying the name of the system property
     *
     * @return {@link Optional} of {@link String} specifying the value of the system property with
     *         {@code propertyName};
     *         {@link Optional#empty()} if the system property is not set
     *
     * @throws SecurityException
     *         if a security manager exists and its
     *         {@link SecurityManager#checkPropertyAccess} method doesn't allow
     *         access to the specified system property
     *
     * @throws IllegalArgumentException
     *         if {@code propertyName} is an empty String
     */
    public static Optional<String> getOptionalProperty(final String propertyName) {
        return Optional.ofNullable(System.getProperty(propertyName));
    }

    /**
     * Returns the value of the optional system property indicated by the specified key or fails, throwing a
     * <em>checked</em> {@link OptionalSystemPropertyNotSetException}.
     *
     * @param propertyName
     *        String specifying the name of the system property
     *
     * @return {@link Optional} of {@link String} specifying the value of the system property with
     *         {@code propertyName}
     *
     * @throws OptionalSystemPropertyNotSetException
     *         if the system property is not set
     *
     * @throws SecurityException
     *         if a security manager exists and its
     *         {@link SecurityManager#checkPropertyAccess} method doesn't allow
     *         access to the specified system property
     *
     * @throws IllegalArgumentException
     *         if {@code propertyName} is an empty String
     */
    public static String getOptionalPropertyOrFail(final String propertyName)
    throws OptionalSystemPropertyNotSetException {
        final String value = System.getProperty(propertyName);

        if (value == null)
            throw new OptionalSystemPropertyNotSetException(propertyName);

        return value;
    }

    /**
     * Returns the value of the system property indicated by the specified key or fails,
     * throwing an <em>unchecked</em> {@link MandatorySystemPropertyNotSetException} if the specified key is not set.
     *
     * @param propertyName
     *        String specifying the name of the system property
     *
     * @return String specifying the value of the system property with
     *         {@code propertyName}
     *
     * @throws SecurityException
     *         if a security manager exists and its
     *         {@link SecurityManager#checkPropertyAccess} method doesn't allow
     *         access to the specified system property
     *
     * @throws IllegalArgumentException
     *         if {@code propertyName} is an empty String
     *
     * @throws MandatorySystemPropertyNotSetException
     *         if the specified system property is not set
     */
    public static String getMandatoryProperty(final String propertyName)
    throws MandatorySystemPropertyNotSetException {

        final String propertyValue = System.getProperty(propertyName);

        if (propertyValue == null)
            throw new MandatorySystemPropertyNotSetException(propertyName);

        return propertyValue;
    }

    private SystemPropertyUtility() {}
}
