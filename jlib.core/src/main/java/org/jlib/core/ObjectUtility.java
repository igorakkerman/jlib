/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core;

/**
 * Utility class providing static methods for Object operations.
 * 
 * @author Igor Akkerman
 */
public final class ObjectUtility {

    /** no visible constructor */
    private ObjectUtility() {}

    /**
     * Compares the specified Objects for mutual equality. Two Objects
     * {@code object1}, {@code object2} are considered equal if
     * {@code object1 == object2 == null} or {@code object1.equals(object2)}.
     * 
     * @param objects
     *        comma separated sequence of Objects to compare
     * @return {@code true} if all specified Objects are equal or if the
     *         specified sequence of Objects is empty; {@code false} otherwise
     */
    public static final boolean equal(Object... objects) {
        if (objects.length == 0)
            return true;
        Object firstObject = objects[0];
        if (firstObject != null) {
            for (int index = 1; index < objects.length; index ++)
                if (!firstObject.equals(objects[index]))
                    return false;
        }
        else {
            for (int index = 1; index < objects.length; index ++)
                if (objects[index] != null)
                    return false;
        }
        return true;
    }

    /**
     * Returns the hash code of the specified Object as returned by its
     * {@link Object#hashCode() hashCode} method or {@code 0} if the specified
     * Object is {@code null}.
     * 
     * @param object
     *        Object of which the hash code is returned
     * @return integer specifying the hash code of Object; {@code 0} if
     *         {@code object} is {@code null}
     */
    public static int hashCode(Object object) {
        return object != null ? object.hashCode() : 0;
    }
}
