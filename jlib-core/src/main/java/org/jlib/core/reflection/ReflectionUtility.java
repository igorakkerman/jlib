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

package org.jlib.core.reflection;

import org.jlib.core.property.OptionalPropertyNotSetException;

import static org.jlib.core.property.PropertyUtility.getOptionalPropertyOrFail;

/**
 * <p>
 * Utility class providing an easy-to-use interface for creating objects using
 * reflection. It consists of static methods solely. Objects can be created
 * providing their class, an Object of their class, their class name or the name
 * of a system property specifying their class name.
 * </p>
 * <p>
 * Additionally, when using the methods of the class {@link Class} for
 * instantiating classes using reflection, many Exceptions have to be caught.
 * Usually, the application that uses these methods makes no difference why the
 * instantiation failed. They simply catch {@code Exception} to perform the
 * exception handling. This is not a clean way to handle this probli.
 * </p>
 * <p>
 * In contrast, the methods of this class throw one single checked exception,
 * {@link ClassInstantiationException}, so that the application only needs to
 * catch that single one. The {@code ClassInstantiationException} contains the
 * information about the original Exception that caused it so if the actual
 * reason is of interest, it still can be retrieved.
 * </p>
 *
 * @author Igor Akkerman
 */
//TODO: review thrown exceptions
public final class ReflectionUtility {

    /**
     * <p>
     * Creates a new instance of the specified class.
     * </p>
     * <p>
     * This method calls {@link Class#newInstance()}. If it throws an Exception,
     * it is wrapped into a {@code ClassInstantiationException} and thrown by
     * this method.
     * </p>
     *
     * @param <Obj>
     *        type of the object to create
     *
     * @param clazz
     *        Class to instantiate
     *
     * @return a new instance of {@code clazz}
     *
     * @throws ClassInstantiationException
     *         if the instantiation of the specified class fails
     */
    public static <Obj> Obj newInstanceOf(final Class<? extends Obj> clazz)
    throws ClassInstantiationException {
        try {
            return clazz.newInstance();
        }
        catch (final InstantiationException | IllegalAccessException exception) {
            throw new ClassInstantiationException(clazz, exception);
        }
    }

    /**
     * <p>
     * Creates a new instance of the class of the specified Object.
     * </p>
     * <p>
     * This method calls {@link Class#newInstance()}. If that method throws a
     * Exception of any kind, it is wrapped into a
     * {@code ClassInstantiationException}, which is then thrown by this method.
     * </p>
     *
     * @param <Obj>
     *        type of the object to create
     *
     * @param object
     *        Object instance of the class to instantiate
     *
     * @return a new instance of the specified class
     *
     * @throws ClassInstantiationException
     *         if the instantiation of the specified class fails
     */
    @SuppressWarnings("unchecked")
    public static <Obj> Obj newInstanceOfClassOf(final Obj object)
    throws ClassInstantiationException {
        return newInstanceOf((Class<? extends Obj>) object.getClass());
    }

    /**
     * <p>
     * Creates a new instance of the class specified by its name.
     * </p>
     * <p>
     * This method calls {@link Class#newInstance()}. If that method throws a
     * Exception of any kind, it is wrapped into a
     * {@code ClassInstantiationException}, which is then thrown by this method.
     * </p>
     *
     * @param <Obj>
     *        type of the object to create
     *
     * @param className
     *        String specifying the name of the class to instantiate
     *
     * @param expectedParentClass
     *        expected parent {@link Class} of the instantiated {@link Class};
     *
     * @return a new instance of the specified class
     *
     * @throws WrongTypedClassInstantiationException
     *         if the instantiated {@link Object} is not an instance of {@code expectedParentClass} or a descendant
     *         subclass
     *
     * @throws ClassInstantiationException
     *         if the instantiation of the specified class fails
     */
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public static <Obj> Obj newInstanceOf(final String className, final Class<Obj> expectedParentClass)
    throws WrongTypedClassInstantiationException, ClassInstantiationException {
        try {
            final Class<?> clazz = Class.forName(className);

            if (! expectedParentClass.isAssignableFrom(clazz))
                throw new WrongTypedClassInstantiationException(clazz, expectedParentClass);

            return newInstanceOf((Class<? extends Obj>) clazz);
        }
        catch (final ClassNotFoundException exception) {
            throw new ClassInstantiationException(className, exception);
        }
    }

    /**
     * Creates a new instance of the class defined in the specified system property.
     *
     * @param <Obj>
     *        type of the object to create
     *
     * @param propertyName
     *        String specifying the name of the system property in which the
     *        class name is defined
     *
     * @return a new instance of the specified class
     *
     * @throws SecurityException
     *         if a security manager exists and its {@code checkPropertyAccess}
     *         method doesn't allow access to the specified system property
     *
     * @throws IllegalArgumentException
     *         if (@code propertyName} is the empty {@link String}
     *
     * @throws OptionalPropertyNotSetException
     *         if the specified system property is not set
     *
     * @throws WrongTypedClassInstantiationException
     *         if the instantiated {@link Object} is not an instance of {@code expectedParentClass} or a descendant
     *         subclass
     *
     * @throws ClassInstantiationException
     *         if the instantiation of the specified class fails;
     *         its cause is one of the exceptions thrown by {@link Class#forName(String)})
     */
    public static <Obj> Obj newInstanceByOptionalProperty(final String propertyName,
                                                          final Class<Obj> expectedParentClass)
    throws SecurityException, OptionalPropertyNotSetException, ClassInstantiationException {
        return newInstanceOf(getOptionalPropertyOrFail(propertyName), expectedParentClass);
    }

    private ReflectionUtility() {}
}
