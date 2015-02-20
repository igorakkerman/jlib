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

package org.jlib.core.classinstance;

import java.lang.reflect.Method;

import org.jlib.core.language.Valid;

import static org.jlib.core.array.ArrayUtility.asArray;

public interface ClassInstanceService {

    <Obj> Obj getInstanceOf(Class<? extends Obj> clazz)
    throws ClassInstanceException;

    @SuppressWarnings("unchecked")
    default <Obj> Obj getInstanceOf(final String className, final Class<? super Obj>... expectedSuperTypes)
    throws ClassInstanceException {
        return getInstanceOf((Class<? extends Obj>) findClass(className, expectedSuperTypes));
    }

    @SuppressWarnings("unchecked")
    <Obj> Class<Obj> findClass(String className, Class<? super Obj>... expectedSuperTypes)
    throws ClassInstanceException;

    @SuppressWarnings("unchecked")
    default Method findMethod(final Class<?> methodClass, final String methodName,
                              final Class<?> expectedReturnValueSuperType, final Class<?>... argumentTypes)
    throws InvalidMethodException, WrongTypedInstanceException {
        return findMethod(methodClass, methodName, asArray(expectedReturnValueSuperType), argumentTypes);
    }

    @SuppressWarnings("unchecked")
    Method findMethod(final Class<?> methodClass, final String methodName,
                      final Class<?>[] expectedReturnValueSuperTypes, final Class<?>... argumentTypes)
    throws InvalidMethodException, WrongTypedInstanceException;

    default <ReturnValue>
    /*   */ ReturnValue invokeStaticMethod(final Class<?> methodClass, final String methodName,
                                           final Class<? super ReturnValue> expectedReturnValueSuperType,
                                           final Object... arguments)
    throws InvalidMethodException, WrongTypedInstanceException {
        return invokeStaticMethod(methodClass, methodName, asArray(expectedReturnValueSuperType), arguments);
    }

    @SuppressWarnings("unchecked")
    <ReturnValue> /*
 */ ReturnValue invokeStaticMethod(Class<?> methodClass, String methodName,
                                   Class<? super ReturnValue>[] expectedReturnValueSuperTypes, Object... arguments)
    throws InvalidMethodException, WrongTypedInstanceException;

    // precondition method types match
    @SuppressWarnings("unchecked")
    <ReturnValue> /*
 */ ReturnValue invokeStaticMethod(@Valid Method method, Class<? super ReturnValue>[] expectedReturnValueSuperTypes,
                                   Object... arguments)
    throws InvalidMethodException, WrongTypedInstanceException;

    default void ensureSubtype(final Class<?> actualType, final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        ensureSubtype(actualType, asArray(expectedSuperType));
    }

    void ensureSubtype(Class<?> actualType, Class<?>... expectedSuperTypes)
    throws WrongTypedInstanceException;

    Class<?>[] typesOf(Object... arguments);
}
