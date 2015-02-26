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

package org.jlib.reflect.programtarget.reflection;

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.ClassLookup;
import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.MethodLookup;
import org.jlib.reflect.programtarget.MethodReturnValueSupplier;
import org.jlib.reflect.reflector.DefaultTypedClassReflector;
import org.jlib.reflect.reflector.DefaultUntypedClassReflector;
import org.jlib.reflect.reflector.MethodReturnValueReflector;
import org.jlib.reflect.reflector.ReflectorFactory;
import org.jlib.reflect.reflector.StaticMethodOverloadReflector;
import org.jlib.reflect.reflector.TypedClassReflector;
import org.jlib.reflect.reflector.UntypedClassReflector;
import org.jlib.reflect.reflector.UntypedClassSupplier;
import org.jlib.reflect.reflector.UntypedMethodReflector;
import org.jlib.reflect.reflector.UntypedStaticMethodReflector;
import org.jlib.reflect.reflector.ValidatingMethodReturnValueReflector;

public class ReflectionReflectorFactory
implements ReflectorFactory {

    @Override
    public ClassLookup classLookup(final String className) {
        return new ReflectionClassLookup(className);
    }

    @Override
    public MethodLookup methodLookup(final Class<?> clazz, final String methodName, final Class<?>... parameterTypes) {
        return new ReflectionMethodLookup(clazz, methodName, parameterTypes);
    }

    @Override
    public MethodInvoker methodInvoker(final Method method) {
        return new ReflectionMethodInvoker(method);
    }

    @Override
    public <ReturnValue> StaticMethodOverloadReflector<ReturnValue>
    staticMethodOverloadReflector(final Class<ReturnValue> returnValueClass) {
        return new StaticMethodOverloadReflector<>(returnValueClass);
    }

    @Override
    public <Value>
    TypedClassReflector<Value> typedClassReflector(final Class<Value> staticType,
                                                   final UntypedClassSupplier untypedClassSupplier) {
        return new DefaultTypedClassReflector<>(staticType, untypedClassSupplier);
    }

    @Override
    public <Value>
    UntypedMethodReflector untypedStaticMethodReflector(final String staticMethodName,
                                                        final TypedClassReflector<Value> typedClassReflector) {
        return new UntypedStaticMethodReflector<>(staticMethodName, typedClassReflector);
    }

    @Override
    public UntypedClassReflector untypedClassReflector(final ClassLookup classLookup) {
        return new DefaultUntypedClassReflector(classLookup);
    }

    @Override
    public <ReturnValue>
    MethodReturnValueReflector<ReturnValue> methodReturnValueReflector
    /*                                      */(final MethodReturnValueSupplier<ReturnValue> methodReturnValueSupplier) {
        return new ValidatingMethodReturnValueReflector<>(methodReturnValueSupplier);
    }
}
