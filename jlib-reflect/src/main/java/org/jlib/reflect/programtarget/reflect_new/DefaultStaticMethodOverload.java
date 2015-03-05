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

import org.jlib.reflect.programtarget.InvalidMethodSignatureException;
import org.jlib.reflect.programtarget.MethodLookup;
import static org.jlib.reflect.programtarget.factory.Factories.typedMethodFactory;
import static org.jlib.reflect.programtarget.reflection.ReflectionFactories.methodLookupFactory;

public class DefaultStaticMethodOverload<ReturnValue>
implements Overload<ReturnValue> {

    private final Class<?> enclosingClass;
    private final String methodName;
    private final Class<ReturnValue> returnValueClass;

    public DefaultStaticMethodOverload(final Class<?> enclosingClass, final String methodName,
                                       final Class<ReturnValue> returnValueClass) {
        this.enclosingClass = enclosingClass;
        this.methodName = methodName;
        this.returnValueClass = returnValueClass;
    }

    @Override
    public TypedMethod0<ReturnValue> withoutParameters()
    throws InvalidMethodSignatureException {
        final MethodLookup methodLookup = methodLookupFactory().methodLookup(enclosingClass, methodName);

        return typedMethodFactory().method0(methodLookup);
    }

    @Override
    public <Argument1>
    TypedMethod1<ReturnValue, Argument1> withParameterTypes(final Class<Argument1> parameter1Type) {
        return typedMethodFactory().method1(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                          parameter1Type));
    }

    @Override
    public <Argument1, Argument2>
    TypedMethod2<ReturnValue, Argument1, Argument2> withParameterTypes(final Class<Argument1> parameter1Type,
                                                                           final Class<Argument2> parameter2Type) {
        return typedMethodFactory().method2(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                          parameter1Type,
                                                                          parameter2Type));
    }

    @Override
    public <Argument1, Argument2, Argument3>
    TypedMethod3<ReturnValue, Argument1, Argument2, Argument3>
                                                     /**/ withParameterTypes(final Class<Argument1> parameter1Type,
                                                                             final Class<Argument2> parameter2Type,
                                                                             final Class<Argument3> parameter3Type) {
        return typedMethodFactory().method3(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                          parameter1Type,
                                                                          parameter2Type,
                                                                          parameter3Type));
    }

    @Override
    public UncheckedTypedMethod<ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes) {
        return typedMethodFactory().methodUncheckedParameterTypes(methodLookupFactory().methodLookup(enclosingClass,
                                                                                                methodName,
                                                                                                parameterTypes));
    }
}
