/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.system;

/**
 * Utility class providing static methods for system operations.
 * 
 * @author Igor Akkerman
 */
public final class SystemUtility {

    /** no visible constructor */
    private SystemUtility() {}

    /**
     * Returns the value of the system property indicated by the specified key.
     * The difference to the {@link System#getProperty(String)} method is that
     * this method throws an Exception if the specified key is not set, whereas
     * the other method would return {@code null}.
     * 
     * @param propertyName
     *        String specifying the name of the system property
     * @return String specifying the value of the system property with {@code
     *         propertyName}
     * @throws SecurityException
     *         if a security manager exists and its
     *         {@link SecurityManager#checkPropertyAccess} method doesn't allow
     *         access to the specified system property
     * @throws NullPointerException
     *         if {@code key} is null
     * @throws IllegalArgumentException
     *         if {@code key} is an empty String
     * @throws PropertyNotSetException
     *         if the specified system property is not set
     */
    public static String getProperty(String propertyName)
    throws PropertyNotSetException {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue == null)
            throw new PropertyNotSetException(propertyName);
        return propertyValue;
    }

    /**
     * Returns the value of the application system property indicated by the
     * specified key. The difference to the {@link System#getProperty(String)}
     * method is that this method throws a RuntimeException if the specified key
     * is not set, whereas the JDK method would return {@code null}.
     * 
     * @param propertyName
     *        String specifying the name of the system property
     * @return String specifying the value of the system property with {@code
     *         propertyName}
     * @throws SecurityException
     *         if a security manager exists and its
     *         {@link SecurityManager#checkPropertyAccess} method doesn't allow
     *         access to the specified system property
     * @throws NullPointerException
     *         if {@code key} is null
     * @throws IllegalArgumentException
     *         if {@code key} is an empty String
     * @throws ApplicationPropertyNotSetException
     *         if the specified system property is not set
     */
    public static String getApplicationProperty(String propertyName)
    throws ApplicationPropertyNotSetException {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue == null)
            throw new ApplicationPropertyNotSetException(propertyName);
        return propertyValue;
    }
}
