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
import org.jlib.reflect.programtarget.InstanceMethodExpectedException;
import static org.jlib.reflect.programtarget.factory.Factories.typedMethodFactory;
import static org.jlib.reflect.programtarget.reflection.ReflectionFactories.methodLookupFactory;

public class DefaultConstructorOverload<Value>
extends DefaultOverload<Value> {

    public DefaultConstructorOverload(final Class<?> enclosingClass) {
        super(enclosingClass);
    }

    @Override
    public TypedMethod0<Value> withoutParameters()
    throws InvalidMethodParameterTypesException, InstanceMethodExpectedException, InvalidMethodReturnTypeException {
        final Method method = constructorLookupFactory().constructor()
                                                   .lookupMethod(getEnclosingClass(), getMethodName());

        return typedMethodFactory().method0(method);
    }

    @Override
    public <Argument1>
    TypedMethod1<Value, Argument1> withParameterTypes(final Class<Argument1> parameter1Type)
    throws InvalidMethodParameterTypesException, InstanceMethodExpectedException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameter1Type);

        assertConcreteInstanceMethod(method);

        return typedMethodFactory().method1(method);
    }

    @Override
    public <Argument1, Argument2>
    TypedMethod2<Value, Argument1, Argument2> withParameterTypes(final Class<Argument1> parameter1Type,
                                                                       final Class<Argument2> parameter2Type)
    throws InvalidMethodParameterTypesException, InstanceMethodExpectedException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameter1Type, parameter2Type);

        assertConcreteInstanceMethod(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().method2(method);
    }

    @Override
    public <Argument1, Argument2, Argument3>
    TypedMethod3<Value, Argument1, Argument2, Argument3>
                                                     /**/ withParameterTypes(final Class<Argument1> parameter1Type,
                                                                             final Class<Argument2> parameter2Type,
                                                                             final Class<Argument3> parameter3Type)
    throws InvalidMethodParameterTypesException, InstanceMethodExpectedException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameter1Type, parameter2Type, parameter3Type);

        assertConcreteInstanceMethod(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().method3(method);
    }

    @Override
    public UncheckedTypedMethod<Value> withUncheckedParameterTypes(final Class<?>... parameterTypes)
    throws InvalidMethodParameterTypesException, InstanceMethodExpectedException, InvalidMethodReturnTypeException {
        final Method method = methodLookupFactory().methodLookup()
                                                   .lookupMethod(getEnclosingClass(), getMethodName(),
                                                                 parameterTypes);

        assertConcreteInstanceMethod(method);
        assertMethodReturnsValidType(method);

        return typedMethodFactory().uncheckedTypedMethod(method);
    }

    @Override
    public <RefinedReturnValue extends Value>
    Overload<RefinedReturnValue> withReturnType(final Class<RefinedReturnValue> refinedReturnValueClass) {
        return new DefaultConstructorOverload<>(getEnclosingClass(), getMethodName(), refinedReturnValueClass);
    }

    private static void assertConcreteInstanceMethod(final Method method)
    throws InstanceMethodExpectedException {
        final int modifiers = method.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isAbstract(modifiers))
            throw new InstanceMethodExpectedException(method);
    }
}
