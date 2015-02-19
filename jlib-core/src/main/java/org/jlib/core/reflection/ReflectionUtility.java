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

import java.lang.reflect.Method;

import org.jlib.core.classinstance.ClassInstanceException;
import org.jlib.core.classinstance.ClassInstantiationException;
import org.jlib.core.classinstance.InvalidMethodException;
import org.jlib.core.classinstance.WrongTypedInstanceException;
import org.jlib.core.language.Valid;
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
     * @throws ClassInstanceException
     *         if the instantiation of the specified class fails
     */
    public static <Obj> Obj newInstanceOf(final Class<? extends Obj> clazz)
    throws ClassInstanceException {
        return ReflectionService.getInstance()
                                .instanceOf(clazz);
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
     * @param expectedSuperTypes
     *        comma separated sequence of expected parent {@link Class}es (classes or interfaces) of the instantiated
     *        class
     *
     * @return a new instance of the specified class
     *
     * @throws WrongTypedInstanceException
     *         if the instantiated {@link Object} is not an instance of {@code expectedSuperType} or a descendant
     *         subclass
     *
     * @throws ClassInstantiationException
     *         if the instantiation of the specified class fails
     */
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public static <Obj> Obj newInstanceOf(final String className, final Class<? super Obj>... expectedSuperTypes)
    throws ClassInstanceException {
        return ReflectionService.getInstance()
                                .instanceOf(className, expectedSuperTypes);
    }

    @SuppressWarnings("unchecked")
    public static <Obj> Obj newInstanceOf(final String className, final Class<? super Obj> expectedSuperType)
    throws ClassInstanceException {
        return ReflectionService.getInstance()
                                .instanceOf(className, expectedSuperType);
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
     * @param expectedSuperTypes
     *        comma separated sequence of expected parent {@link Class}es (classes or interfaces) of the instantiated
     *        class
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
     * @throws ClassInstantiationException
     *         if the instantiation of the specified class fails;
     *         its cause is one of the exceptions thrown by {@link Class#forName(String)})

     * @throws WrongTypedInstanceException
     *         if the instantiated {@link Object} is not an instance of {@code expectedSuperType} or a descendant
     *         subclass
     */
    @SafeVarargs
    public static <Obj> Obj newInstanceByOptionalProperty(final String propertyName,
                                                          final Class<? super Obj>... expectedSuperTypes)
    throws OptionalPropertyNotSetException, ClassInstanceException {
        return newInstanceOf(getOptionalPropertyOrFail(propertyName), expectedSuperTypes);
    }

    @SafeVarargs
    public static <Obj> Class<Obj> findClass(final String className, final Class<? super Obj>... expectedSuperTypes)
    throws ClassInstanceException {
        return ReflectionService.getInstance()
                                .findClass(className, expectedSuperTypes);
    }

    @SuppressWarnings("unchecked")
    public static <Obj> Class<Obj> findClass(final String className, final Class<? super Obj> expectedSuperType)
    throws ClassInstanceException {
        return ReflectionService.getInstance()
                                .findClass(className, expectedSuperType);
    }

    @SuppressWarnings("unchecked")
    public static <ReturnValue, Argument>/*
               */ ReturnValue invokeStaticMethod(final Class<?> methodClass, final String methodName,
                                                 final Class<? super ReturnValue> expectedReturnValueSuperType,
                                                 final Argument... arguments)
    throws InvalidMethodException, WrongTypedInstanceException {
        return ReflectionService.getInstance()
                                .invokeStaticMethod(methodClass, methodName, expectedReturnValueSuperType, arguments);
    }

    @SafeVarargs
    public static <ReturnValue, Argument>/*
               */ ReturnValue invokeStaticMethod(final Class<?> methodClass, final String methodName,
                                                 final Class<? super ReturnValue>[] expectedReturnValueSuperTypes,
                                                 final Argument... arguments)
    throws InvalidMethodException, WrongTypedInstanceException {
        return ReflectionService.getInstance()
                                .invokeStaticMethod(methodClass, methodName, expectedReturnValueSuperTypes, arguments);
    }

    // precondition method types match
    @SuppressWarnings("unchecked")
    public static <ReturnValue, Argument> /*
               */ ReturnValue invokeStaticMethod(@Valid final Method method,
                                                 final Class<ReturnValue>[] expectedReturnValueSuperTypes,
                                                 final Argument... arguments)
    throws InvalidMethodException, WrongTypedInstanceException {
        return ReflectionService.getInstance()
                                .invokeStaticMethod(method, expectedReturnValueSuperTypes, arguments);
    }

    public static <Argument> /*
               */ Method findMethod(final Class<?> methodClass, final String methodName,
                                    final Class<?> expectedReturnValueSuperType, final Class<Argument> argumentType)
    throws InvalidMethodException, WrongTypedInstanceException {
        return ReflectionService.getInstance()
                                .findMethod(methodClass, methodName, expectedReturnValueSuperType, argumentType);
    }

    public static <Argument> /*
               */ Method findMethod(final Class<?> methodClass, final String methodName,
                                    final Class<?>[] expectedReturnValueSuperTypes, final Class<Argument> argumentType)
    throws InvalidMethodException, WrongTypedInstanceException {
        return ReflectionService.getInstance()
                                .findMethod(methodClass, methodName, expectedReturnValueSuperTypes, argumentType);
    }

    public static void ensureSubtype(final Class<?> actualType, final Class<?>... expectedSuperTypes)
    throws WrongTypedInstanceException {
        ReflectionService.getInstance()
                         .ensureSubtype(actualType, expectedSuperTypes);
    }

    public static void ensureSubtype(final Class<?> actualType, final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        ReflectionService.getInstance()
                         .ensureSubtype(actualType, expectedSuperType);
    }

    public static Class<?>[] typesOf(final Object... values) {
        return ReflectionService.getInstance()
                                .typesOf(values);
    }

    private ReflectionUtility() {}
}
