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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.jlib.core.classinstance.ClassInstanceService;
import org.jlib.core.classinstance.ClassInstantiationException;
import org.jlib.core.classinstance.InvalidMethodException;
import org.jlib.core.classinstance.WrongTypedInstanceException;
import org.jlib.core.language.Valid;

import static org.jlib.core.array.ArrayUtility.asArray;
import static org.jlib.core.message.MessageUtility.message;

public class ReflectionService
implements ClassInstanceService {

    private static final ReflectionService INSTANCE = new ReflectionService();

    public static ReflectionService getInstance() {
        return INSTANCE;
    }

    private ReflectionService() {}

    @Override
    public <Obj> Obj instanceOf(final Class<? extends Obj> clazz)
    throws ClassInstantiationException {
        try {
            return clazz.newInstance();
        }
        catch (final InstantiationException | IllegalAccessException exception) {
            throw new ClassInstantiationException(clazz.getName(), exception);
        }
    }

    @Override
    public <Obj> Obj instanceOf(final String className, final Class<Obj> expectedSuperType)
    throws ClassInstantiationException,
           WrongTypedInstanceException {

        return instanceOf(className, asArray(expectedSuperType));
    }

    @Override
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public <Obj> Obj instanceOf(final String className, final Class<Obj>... expectedSuperTypes)
    throws ClassInstantiationException,
           WrongTypedInstanceException {

        return instanceOf((Class<? extends Obj>) findClass(className, expectedSuperTypes));
    }

    @Override
    public <Obj> Class<Obj> findClass(final String className, final Class<? super Obj> expectedSuperType)
    throws ClassInstantiationException, WrongTypedInstanceException {
        return findClass(className, asArray(expectedSuperType));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Obj> Class<Obj> findClass(final String className, final Class<? super Obj>... expectedSuperTypes)
    throws ClassInstantiationException, WrongTypedInstanceException {
        try {
            final Class<?> clazz = Class.forName(className);

            ensureSubtype(clazz, expectedSuperTypes);

            return (Class<Obj>) clazz;
        }
        catch (final ClassNotFoundException exception) {
            throw new ClassInstantiationException(message(), className, exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <ReturnValue, Argument>/*
         */ ReturnValue invokeStaticMethod(final Class<?> methodClass, final String methodName, final Argument argument,
                                           final Class<ReturnValue> expectedReturnValueSuperType)
    throws InvalidMethodException, WrongTypedInstanceException {
        try {
            final Method method = /*
             */ findMethod(methodClass, methodName, argument.getClass(), expectedReturnValueSuperType);

            return invokeStaticMethod(method, argument, expectedReturnValueSuperType);
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
            throw new InvalidMethodException(message(), methodClass.getName(), methodName, exception);
        }
    }

    // precondition method types match
    @Override
    @SuppressWarnings("unchecked")
    public <ReturnValue, Argument> /*
         */ ReturnValue invokeStaticMethod(@Valid final Method method, final Argument argument,
                                           final Class<ReturnValue> expectedReturnValueSuperType)
    throws IllegalAccessException,
           InvocationTargetException,
           WrongTypedInstanceException {

        return (ReturnValue) method.invoke(/* static == null */ null, argument);
    }

    public <Argument> /*
        */ Method findMethod(final Class<?> methodClass, final String methodName, final Class<Argument> argumentType,
                             final Class<?> expectedReturnValueSuperType)
    throws NoSuchMethodException,
           WrongTypedInstanceException {
        return findMethod(methodClass, methodName, argumentType, asArray(expectedReturnValueSuperType));
    }

    @SuppressWarnings("unchecked")
    public <Argument> /*
        */ Method findMethod(final Class<?> methodClass, final String methodName, final Class<Argument> argumentType,
                             final Class<?>... expectedReturnValueSuperTypes)
    throws NoSuchMethodException,
           WrongTypedInstanceException {

        final Method method = methodClass.getMethod(methodName, argumentType);

        ensureSubtype(method.getReturnType(), expectedReturnValueSuperTypes);

        return method;
    }

    @Override
    public void ensureSubtype(final Class<?> actualType, final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        ensureSubtype(actualType, asArray(expectedSuperType));
    }

    @Override
    public void ensureSubtype(final Class<?> actualType, final Class<?>... expectedSuperTypes)
    throws WrongTypedInstanceException {
        for (final Class<?> expectedReturnValueSuperType : expectedSuperTypes)
            if (! expectedReturnValueSuperType.isAssignableFrom(actualType))
                throw new WrongTypedInstanceException(actualType, expectedReturnValueSuperType);
    }
}
