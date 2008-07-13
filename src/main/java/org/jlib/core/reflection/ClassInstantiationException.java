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

package org.jlib.core.reflection;

/**
 * Exception thrown when a class cannot be instantiated. This Exception type may be used by factories as a wrapper for
 * any kind of Exceptions occuring when trying to instantiate a class.
 *
 * @author Igor Akkerman
 */
public class ClassInstantiationException
extends Exception {

    /** class name */
    private String className;

    /**
     * Creates a new ClassInstantiationException if a class with the specified name cannot be instantiated.
     *
     * @param className
     *        name of the class that cannot be instantiated
     * @param cause
     *        original Throwable that caused this Exception
     */
    public ClassInstantiationException(String className, Throwable cause) {
        super(cause);
        this.className = className;
    }

    /**
     * Creates a new ClassInstantiationException if the specified class cannot be instantiated.
     *
     * @param clazz
     *        Class that cannot be instantiated
     * @param cause
     *        original Throwable that caused this Exception
     */
    public ClassInstantiationException(Class<?> clazz, Throwable cause) {
        this(clazz.getSimpleName(), cause);
    }

    /**
     * Returns the name of the class that cannot be instantiated.
     *
     * @return String specifying the name of the class
     */
    public String getClassName() {
        return className;
    }

    /**
     * Returns a String representation of this Exception.
     *
     * @return String containing the class name and the error text of the Throwable that caused this Exception
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + className + "][" + getCause() + "]";
    }
}
