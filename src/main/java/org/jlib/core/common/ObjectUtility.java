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

package org.jlib.core.common;

/**
 * Utility class providing static methods for Object operations.
 * 
 * @author Igor Akkerman
 */
public final class ObjectUtility {

    /** no default constructor */
    private ObjectUtility() {}

    /**
     * Compares the specified Objects for mutual equality. This method calls two
     * Objects {@code object1}, {@code object2} equal if
     * {@code object1 == object2 == null} or {@code object1.equals(object2)}.
     * 
     * @param objects
     *        comma separated list of Objects to compare
     * @return {@code true} if all specified Objects are equal or if the
     *         specified list of Objects is empty; {@code false} otherwise
     */
    public static final boolean equalOrNull(Object... objects) {
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
}
