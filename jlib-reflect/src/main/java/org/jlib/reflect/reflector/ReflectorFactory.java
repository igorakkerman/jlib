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

package org.jlib.reflect.reflector;

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.ClassLookup;
import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.MethodLookup;

public interface ReflectorFactory {

    ClassLookup classLookup(String className);

    MethodLookup methodLookup(Class<?> clazz, String methodName, Class<?>... parameterTypes);

    MethodInvoker methodInvoker(Method method);

    <ReturnValue> StaticMethodOverloadReflector<ReturnValue>
    staticMethodOverloadReflector(Class<ReturnValue> returnValueClass);

    <Value> TypedClassReflector<Value>
    typedClassReflector(Class<Value> staticType, final UntypedClassReflector untypedClassReflector);

    <Value> UntypedMethodReflector untypedStaticMethodReflector(String staticMethodName,
                                                                TypedClassReflector<Value> typedClassReflector);

    UntypedClassReflector untypedClassReflector(ClassLookup classLookup);
}
