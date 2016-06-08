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

package org.jlib.reflect.reflector.defaults.overload;

import java.lang.reflect.Method;

import org.jlib.reflect.languageelement.InvalidMethodParameterTypesException;
import org.jlib.reflect.languageelement.LanguageElementHandler;
import org.jlib.reflect.languageelement.NoSubtypeException;
import org.jlib.reflect.reflector.MethodOverload;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.TypedMethodUnchecked;
import org.jlib.reflect.reflector.defaults.invoke.StaticMethodInvokeStrategy;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod0;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod1;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod2;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod3;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethodUnchecked;

public class DefaultStaticMethodOverload<ReturnValue>
    extends AbstractOverload<Method, ReturnValue>
    implements MethodOverload<ReturnValue> {

    public static final Class<?>[] ZERO_PARAMETERS_TYPES = {};
    private static final Object[] NO_ARGUMENTS = {};

    private final Class<?> enclosingClass;
    private final String methodName;

    public DefaultStaticMethodOverload(final LanguageElementHandler languageElementHandler,
                                       final Class<?> enclosingClass,
                                       final String methodName,
                                       final Class<ReturnValue> returnValueType) {
        super(languageElementHandler, returnValueType);

        this.enclosingClass = enclosingClass;
        this.methodName = methodName;
    }

    @Override
    public TypedMethod0<Method, ReturnValue> withoutParameters()
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Method method = getLanguageElementHandler()
            .lookupStaticMethod(enclosingClass, methodName, ZERO_PARAMETERS_TYPES);

        return new DefaultTypedMethod0<>(getLanguageElementHandler(), strategy(method));
    }

    @Override
    public <Parameter1>
    TypedMethod1<Method, ReturnValue, Parameter1> withParameterTypes(final Class<Parameter1> parameter1Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Method method = getLanguageElementHandler()
            .lookupStaticMethod(enclosingClass, methodName, parameter1Type);

        return new DefaultTypedMethod1<>(getLanguageElementHandler(), strategy(method));
    }

    @Override
    public <Parameter1, Parameter2>
    TypedMethod2<Method, ReturnValue, Parameter1, Parameter2>
    withParameterTypes(final Class<Parameter1> parameter1Type,
                       final Class<Parameter2> parameter2Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Method method = getLanguageElementHandler()
            .lookupStaticMethod(enclosingClass, methodName, parameter1Type, parameter2Type);

        return new DefaultTypedMethod2<>(getLanguageElementHandler(), strategy(method));
    }

    @Override
    public <Parameter1, Parameter2, Parameter3>
    TypedMethod3<Method, ReturnValue, Parameter1, Parameter2, Parameter3>
    withParameterTypes(final Class<Parameter1> parameter1Type,
                       final Class<Parameter2> parameter2Type,
                       final Class<Parameter3> parameter3Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Method method = getLanguageElementHandler()
            .lookupStaticMethod(enclosingClass, methodName, parameter1Type, parameter2Type, parameter3Type);

        return new DefaultTypedMethod3<>(getLanguageElementHandler(), strategy(method));
    }

    @Override
    public TypedMethodUnchecked<Method, ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Method method = getLanguageElementHandler()
            .lookupStaticMethod(enclosingClass, methodName, parameterTypes);

        return new DefaultTypedMethodUnchecked<>(getLanguageElementHandler(), strategy(method));
    }

    @Override
    public <StaticTypeReturnValue>
    Overload<Method, StaticTypeReturnValue> withReturnType(final Class<StaticTypeReturnValue> staticReturnSuperType) {
        return new DefaultStaticMethodOverload<>(getLanguageElementHandler(), enclosingClass, methodName,
                                                 staticReturnSuperType);
    }

    private StaticMethodInvokeStrategy strategy(final Method method)
        throws NoSubtypeException {

        final StaticMethodInvokeStrategy invokeStrategy =
            new StaticMethodInvokeStrategy(getLanguageElementHandler(), method);

        assertReturnValueTypeValid(method);

        return invokeStrategy;
    }
}
