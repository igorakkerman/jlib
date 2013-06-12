/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core.reflection;

/**
 * Exception thrown when a class cannot be instantiated. This Exception type may
 * be used by factories as a wrapper for any kind of Exceptions occurring when
 * trying to instantiate a class.
 *
 * @author Igor Akkerman
 */
public class ClassInstantiationException
extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = 324704714378755280L;

    /** class name */
    private final String className;

    /**
     * Creates a new ClassInstantiationException.
     *
     * @param className
     *        name of the class that cannot be instantiated
     * @param cause
     *        original Throwable that caused this Exception
     */
    public ClassInstantiationException(final String className, final Throwable cause) {
        super(cause);
        this.className = className;
    }

    /**
     * Creates a new ClassInstantiationException if the specified class cannot
     * be instantiated.
     *
     * @param clazz
     *        Class that cannot be instantiated
     * @param cause
     *        original Throwable that caused this Exception
     */
    public ClassInstantiationException(final Class<?> clazz, final Throwable cause) {
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
     * @return String containing the class name and the error text of the
     *         Throwable that caused this Exception
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + className + "][" + getCause() + "]";
    }
}
