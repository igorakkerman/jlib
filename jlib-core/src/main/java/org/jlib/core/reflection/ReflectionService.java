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

import static org.jlib.core.array.ArrayUtility.map;
import static org.jlib.core.message.MessageUtility.message;

public class ReflectionService
implements ClassInstanceService {

    private static final ReflectionService INSTANCE = new ReflectionService();

    public static ReflectionService getInstance() {
        return INSTANCE;
    }

    protected ReflectionService() {}

    @Override
    public <Obj> Obj getInstanceOf(final Class<? extends Obj> clazz)
    throws ClassInstantiationException {
        try {
            return clazz.newInstance();
        }
        catch (final InstantiationException | IllegalAccessException exception) {
            throw new ClassInstantiationException(clazz.getName(), exception);
        }
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
    public <ReturnValue>/*
        */ ReturnValue invokeStaticMethod(final Class<?> methodClass, final String methodName,
                                          final Class<? super ReturnValue>[] expectedReturnValueSuperTypes,
                                          final Object... arguments)
    throws InvalidMethodException, WrongTypedInstanceException {
        final Method method = /*
         */ findMethod(methodClass, methodName, expectedReturnValueSuperTypes, typesOf(arguments));

        return invokeStaticMethod(method, expectedReturnValueSuperTypes, arguments);
    }

    // precondition method types match
    @Override
    @SuppressWarnings("unchecked")
    public <ReturnValue> /*
        */ ReturnValue invokeStaticMethod(@Valid final Method method,
                                          final Class<? super ReturnValue>[] expectedReturnValueSuperTypes,
                                          final Object... arguments)
    throws InvalidMethodException, WrongTypedInstanceException {
        try {
            final ReturnValue returnValue = (ReturnValue) method.invoke(/* static == null */ null, arguments);

            ensureSubtype(returnValue.getClass(), expectedReturnValueSuperTypes);

            return returnValue;
        }
        catch (IllegalAccessException | InvocationTargetException exception) {
            throw new InvalidMethodException(message(), method.getClass().getName(), method.getName(), exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Method findMethod(final Class<?> methodClass, final String methodName,
                             final Class<?>[] expectedReturnValueSuperTypes, final Class<?>... argumentTypes)
    throws InvalidMethodException, WrongTypedInstanceException {
        try {
            final Method method = methodClass.getMethod(methodName, argumentTypes);

            ensureSubtype(method.getReturnType(), expectedReturnValueSuperTypes);

            return method;
        }
        catch (final NoSuchMethodException exception) {
            throw new InvalidMethodException(message(), methodClass.getName(), methodName, exception);
        }
    }

    @Override
    public void ensureSubtype(final Class<?> actualType, final Class<?>... expectedSuperTypes)
    throws WrongTypedInstanceException {
        for (final Class<?> expectedReturnValueSuperType : expectedSuperTypes)
            if (! expectedReturnValueSuperType.isAssignableFrom(actualType))
                throw new WrongTypedInstanceException(actualType, expectedReturnValueSuperType);
    }

    @Override
    public Class<?>[] typesOf(final Object... arguments) {
        return map(arguments, Object::getClass, Class<?>[]::new);
    }
}
