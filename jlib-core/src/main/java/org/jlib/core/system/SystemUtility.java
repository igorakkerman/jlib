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

/**
 * Utility class providing static methods for system operations.
 *
 * @author Igor Akkerman
 */
// TODO: review thrown exceptions
public final class SystemUtility {

    /**
     * Returns the value of the system property indicated by the specified key.
     * The difference to the {@link System#getProperty(String)} method is that
     * this method throws an {@link Exception} if the specified key is not set,
     * whereas the other method would return {@code null}.
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
     * @throws PropertyNotSetException
     *         if the specified system property is not set
     */
    public static String getProperty(final String propertyName)
    throws PropertyNotSetException {

        final String propertyValue = System.getProperty(propertyName);

        if (propertyValue == null)
            throw new PropertyNotSetException(propertyName);

        return propertyValue;
    }

    /**
     * Returns the value of the application system property indicated by the
     * specified key. The difference to the {@link System#getProperty(String)}
     * method is that this method throws a {@link RuntimeException} if the
     * specified key is not set, whereas the JDK method would return
     * {@code null}.
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
     * @throws ApplicationPropertyNotSetException
     *         if the specified system property is not set
     */
    public static String getApplicationProperty(final String propertyName)
    throws ApplicationPropertyNotSetException {

        final String propertyValue = System.getProperty(propertyName);

        if (propertyValue == null)
            throw new ApplicationPropertyNotSetException(propertyName);

        return propertyValue;
    }

    /**
     * Compares the specified {@link Object}s for mutual equality. Two {@link Object}s {@code object1}, {@code object2}
     * are considered equal if {@code object1.equals(object2)}. Returns {@code true} for an empty sequence of
     * {@link Object}s.
     *
     * @param objects
     *        comma separated sequence of {@link Object}s to compare
     *
     * @return {@code true} if all specified {@link Object}s are equal or if the specified sequence of {@link Object}s
     *         is empty; {@code false} otherwise
     */
    public static boolean equal(final Object... objects) {
        if (objects.length == 0)
            return true;

        final Object firstObject = objects[0];

        for (int index = 1; index < objects.length; index++)
            if (! firstObject.equals(objects[index]))
                return false;

        return true;
    }

    /** no visible constructor */
    private SystemUtility() {
    }
}
