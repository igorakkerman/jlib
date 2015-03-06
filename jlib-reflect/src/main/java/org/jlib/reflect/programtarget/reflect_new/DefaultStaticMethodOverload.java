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

package org.jlib.reflect.programtarget.reflect_new;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.jlib.reflect.programtarget.InvalidMethodParameterTypesException;
import org.jlib.reflect.programtarget.InvalidMethodReturnTypeException;
import org.jlib.reflect.programtarget.MethodNotStaticException;
import static org.jlib.reflect.programtarget.factory.Factories.typedMethodFactory;
import static org.jlib.reflect.programtarget.reflection.ReflectionFactories.methodLookupFactory;

public class DefaultStaticMethodOverload<ReturnValue>
extends DefaultMethodOverload<ReturnValue> {

    public DefaultStaticMethodOverload(final Class<?> enclosingClass, final String methodName,
                                       final Class<ReturnValue> returnValueClass) {
        super(enclosingClass, methodName, returnValueClass);
    }

    @Override
    public TypedMethod0<ReturnValue> withoutParameters()
    throws InvalidMethodParameterTypesException, MethodNotStaticException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName());

        assertMethodIsStatic(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().method0(method);
    }

    @Override
    public <Argument1>
    TypedMethod1<ReturnValue, Argument1> withParameterTypes(final Class<Argument1> parameter1Type)
    throws InvalidMethodParameterTypesException, MethodNotStaticException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameter1Type);

        assertMethodIsStatic(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().method1(method);
    }

    @Override
    public <Argument1, Argument2>
    TypedMethod2<ReturnValue, Argument1, Argument2> withParameterTypes(final Class<Argument1> parameter1Type,
                                                                       final Class<Argument2> parameter2Type)
    throws InvalidMethodParameterTypesException, MethodNotStaticException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameter1Type, parameter2Type);

        assertMethodIsStatic(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().method2(method);
    }

    @Override
    public <Argument1, Argument2, Argument3>
    TypedMethod3<ReturnValue, Argument1, Argument2, Argument3>
                                                     /**/ withParameterTypes(final Class<Argument1> parameter1Type,
                                                                             final Class<Argument2> parameter2Type,
                                                                             final Class<Argument3> parameter3Type)
    throws InvalidMethodParameterTypesException, MethodNotStaticException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameter1Type, parameter2Type, parameter3Type);

        assertMethodIsStatic(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().method3(method);
    }

    @Override
    public UncheckedTypedMethod<ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes)
    throws InvalidMethodParameterTypesException, MethodNotStaticException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameterTypes);

        assertMethodIsStatic(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().uncheckedTypedMethod(method);
    }

    @Override
    public <RefinedReturnValue extends ReturnValue>
    MethodOverload<RefinedReturnValue> withReturnType(final Class<RefinedReturnValue> refinedReturnValueClass) {
        return new DefaultStaticMethodOverload<>(getEnclosingClass(), getMethodName(), refinedReturnValueClass);
    }

    private static void assertMethodIsStatic(final Method method)
    throws MethodNotStaticException {
        if (! Modifier.isStatic(method.getModifiers()))
            throw new MethodNotStaticException(method);
    }
}
