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

package org.jlib.reflect.reflectordefaults.overload;

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.InstanceMethodInvokerFactory;
import org.jlib.reflect.programtarget.InvalidMethodParameterTypesException;
import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.NoSubtypeException;
import static org.jlib.reflect.programtargetreflection.ReflectionFactories.instanceMethodInvokerFactory;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.UncheckedTypedMethod;

public class DefaultInstanceMethodOverload<EnclosingObject, ReturnValue>
    extends AbstractOverload<ReturnValue> {

    // TODO: use DI
    private final InstanceMethodInvokerFactory methodInvokerFactory = instanceMethodInvokerFactory();

    private final EnclosingObject enclosingObject;
    private final String methodName;

    public DefaultInstanceMethodOverload(final EnclosingObject enclosingObject, final String methodName,
                                         final Class<ReturnValue> returnValueType) {
        super(enclosingObject.getClass(), returnValueType);

        this.enclosingObject = enclosingObject;
        this.methodName = methodName;
    }

    @Override
    public TypedMethod0<ReturnValue> withoutParameters()
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Method method = methodLookup.lookupMethod(getEnclosingClass(), methodName /* no parameter types */);
        final MethodInvoker methodInvoker = methodInvokerFactory.methodInvoker(method, enclosingObject);

        assertReturnValueTypeValid(method);

        //noinspection ConstantConditions
        return methodFactory.method0(methodInvoker);
    }

    @Override
    public <Parameter1>
    TypedMethod1<ReturnValue, Parameter1> withParameterTypes(final Class<Parameter1> parameter1Type)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Method method = methodLookup.lookupMethod(getEnclosingClass(), methodName, parameter1Type);
        final MethodInvoker methodInvoker = methodInvokerFactory.methodInvoker(method, enclosingObject);

        assertReturnValueTypeValid(method);

        //noinspection ConstantConditions
        return methodFactory.method1(methodInvoker, parameter1Type);
    }

    @Override
    public <Parameter1, Parameter2>
    TypedMethod2<ReturnValue, Parameter1, Parameter2> withParameterTypes(final Class<Parameter1> parameter1Type,
                                                                         final Class<Parameter2> parameter2Type)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Method method = methodLookup.lookupMethod(getEnclosingClass(), methodName, parameter1Type, parameter2Type);
        final MethodInvoker methodInvoker = methodInvokerFactory.methodInvoker(method, enclosingObject);

        assertReturnValueTypeValid(method);

        //noinspection ConstantConditions
        return methodFactory.method2(methodInvoker, parameter1Type, parameter2Type);
    }

    @Override
    public <Parameter1, Parameter2, Parameter3>
    TypedMethod3<ReturnValue, Parameter1, Parameter2, Parameter3>
                                                     /**/ withParameterTypes(final Class<Parameter1> parameter1Type,
                                                                             final Class<Parameter2> parameter2Type,
                                                                             final Class<Parameter3> parameter3Type)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Method method = methodLookup.lookupMethod(getEnclosingClass(), methodName, parameter1Type, parameter2Type,
                                                        parameter3Type);
        final MethodInvoker methodInvoker = methodInvokerFactory.methodInvoker(method, enclosingObject);

        assertReturnValueTypeValid(method);

        //noinspection ConstantConditions
        return methodFactory.method3(methodInvoker, parameter1Type, parameter2Type, parameter3Type);
    }

    @Override
    public UncheckedTypedMethod<ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Method method = methodLookup.lookupMethod(getEnclosingClass(), methodName, parameterTypes);
        final MethodInvoker methodInvoker = methodInvokerFactory.methodInvoker(method, enclosingObject);

        assertReturnValueTypeValid(method);

        //noinspection ConstantConditions
        return methodFactory.uncheckedParameterTypesMethod(methodInvoker);
    }

    @Override
    public <StaticTypeReturnValue>
    Overload<StaticTypeReturnValue> withReturnType(final Class<StaticTypeReturnValue> staticReturnType) {
        return new DefaultInstanceMethodOverload<>(enclosingObject, methodName, staticReturnType);
    }
}
