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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.jlib.core.language.Valid;

public interface ClassInstanceService {

    <Obj> Obj instanceOf(Class<? extends Obj> clazz)
    throws ClassInstanceException;

    <Obj> Obj instanceOf(String className, Class<Obj> expectedSuperType)
    throws ClassInstanceException;

    @SuppressWarnings("unchecked")
    <Obj> Obj instanceOf(String className, Class<Obj>... expectedSuperTypes)
    throws ClassInstanceException;

    <Obj> Class<Obj> findClass(String className, Class<? super Obj> expectedSuperType)
    throws ClassInstanceException;

    @SuppressWarnings("unchecked")
    <Obj> Class<Obj> findClass(String className, Class<? super Obj>... expectedSuperTypes)
    throws ClassInstanceException;

    @SuppressWarnings("unchecked")
    <ReturnValue, Argument>/*
         */ ReturnValue invokeStaticMethod(Class<?> methodClass, String methodName, Argument argument,
                                           Class<ReturnValue> expectedReturnValueSuperType)
    throws InvalidMethodException, WrongTypedInstanceException;

    // precondition method types match
    @SuppressWarnings("unchecked")
    <ReturnValue, Argument> /*
         */ ReturnValue invokeStaticMethod(@Valid Method method, Argument argument,
                                           Class<ReturnValue> expectedReturnValueSuperType)
    throws IllegalAccessException,
           InvocationTargetException,
           WrongTypedInstanceException;

    void ensureSubtype(Class<?> actualType, Class<?> expectedSuperType)
    throws WrongTypedInstanceException;

    void ensureSubtype(Class<?> actualType, Class<?>... expectedSuperTypes)
    throws WrongTypedInstanceException;
}
