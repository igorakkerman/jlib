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

package org.jlib.core.reflection;

import org.jlib.core.exception.ApplicationException;

import static org.jlib.core.text.message.MessageUtility.message;

/**
 * Exception thrown when a class cannot be instantiated. This Exception type may
 * be used by factories as a wrapper for any kind of Exceptions occurring when
 * trying to instantiate a class.
 *
 * @author Igor Akkerman
 */
public class ClassInstantiationException
extends ApplicationException {

    /** serialVersionUID */
    private static final long serialVersionUID = 324704714378755280L;

    /** class name */
    private final String className;

    /**
     * Creates a new ClassInstantiationException.
     *
     * @param className
     *        name of the class that cannot be instantiated
     *
     * @param cause
     *        original {@link Exception} that caused this {@link ClassInstantiationException}
     */
    public ClassInstantiationException(final CharSequence className, final Exception cause) {
        super(message().with("className", className), cause);

        this.className = className.toString();
    }

    /**
     * Creates a new {@link ClassInstantiationException} if the specified class cannot be instantiated.
     *
     * @param clazz
     *        {@link Class} that cannot be instantiated
     *
     * @param cause
     *        {@link Exception} that caused this {@link ClassInstantiationException}
     */
    public ClassInstantiationException(final Class<?> clazz, final Exception cause) {
        this(clazz.getName(), cause);
    }

    /**
     * Returns the name of the class that cannot be instantiated.
     *
     * @return {@link String} specifying the name of the class
     */
    public String getClassName() {
        return className;
    }
}
