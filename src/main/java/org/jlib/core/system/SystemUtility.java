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
     * Returns the value of the system property with the specified name. The
     * difference to the {@link System#getProperty(String)} method is that this
     * method throws a RuntimeException if the specified key is not set, whereas
     * the other method would return {@code null}.
     * 
     * @param propertyName
     *        String specifying the name of the system property
     * @return String specifying the value of the system property with {@code
     *         propertyName}
     * @throws PropertyNotSetException
     *         if the specified system property is not set
     * @throws SecurityException
     *         if a security manager exists and its
     *         {@link SecurityManager#checkPropertyAccess(String)
     *         checkPropertyAccess} method does not allow access to the
     *         specified system property
     * @throws IllegalArgumentException
     *         if {@code propertyName} is null or an empty String
     */
    public static String getProperty(String propertyName)
    throws PropertyNotSetException {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue == null)
            throw new PropertyNotSetException(propertyName);
        return propertyValue;
    }
}
