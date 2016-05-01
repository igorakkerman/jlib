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

import java.lang.reflect.Constructor;

import org.jlib.reflect.programelement.ConstructorInvokerSupplier;
import org.jlib.reflect.programelement.ConstructorLookup;
import org.jlib.reflect.programelement.InvalidMethodParameterTypesException;
import org.jlib.reflect.programelement.MethodInvoker;
import org.jlib.reflect.programelement.NoSubtypeException;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.TypedMethodUnchecked;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod0;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod1;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod2;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod3;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethodUnchecked;

public class DefaultConstructorOverload<EnclosingClassObject>
extends AbstractOverload<EnclosingClassObject> {

    private ConstructorInvokerSupplier constructorInvokerSupplier;

    private ConstructorLookup constructorLookup;

    public DefaultConstructorOverload(final Class<EnclosingClassObject> enclosingClass) {
        super(enclosingClass, enclosingClass);
    }

    @Override
    public TypedMethod0<EnclosingClassObject> withoutParameters()
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Constructor<?> constructor =
        /**/ constructorLookup.lookupConstructor(getEnclosingClass() /* no parameter types */);
        final MethodInvoker methodInvoker = constructorInvokerSupplier.constructorInvoker(constructor);

        return new DefaultTypedMethod0<>(methodInvoker);
    }

    @Override
    public <Parameter1>
    TypedMethod1<EnclosingClassObject, Parameter1> withParameterTypes(final Class<Parameter1> parameter1Type)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Constructor<?> constructor = constructorLookup.lookupConstructor(getEnclosingClass(), parameter1Type);
        final MethodInvoker methodInvoker = constructorInvokerSupplier.constructorInvoker(constructor);

        return new DefaultTypedMethod1<>(methodInvoker);
    }

    @Override
    public <Parameter1, Parameter2>
    TypedMethod2<EnclosingClassObject, Parameter1, Parameter2> withParameterTypes(
                                                                                 final Class<Parameter1> parameter1Type,
                                                                                 final Class<Parameter2> parameter2Type)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Constructor<?> constructor = constructorLookup.lookupConstructor(getEnclosingClass(), parameter1Type,
                                                                               parameter2Type);
        final MethodInvoker methodInvoker = constructorInvokerSupplier.constructorInvoker(constructor);

        return new DefaultTypedMethod2<>(methodInvoker);
    }

    @Override
    public <Parameter1, Parameter2, Parameter3>
    TypedMethod3<EnclosingClassObject, Parameter1, Parameter2, Parameter3>
                                                     /**/ withParameterTypes(final Class<Parameter1> parameter1Type,
                                                                             final Class<Parameter2> parameter2Type,
                                                                             final Class<Parameter3> parameter3Type)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Constructor<?> constructor = constructorLookup.lookupConstructor(getEnclosingClass(), parameter1Type,
                                                                               parameter2Type, parameter3Type);
        final MethodInvoker methodInvoker = constructorInvokerSupplier.constructorInvoker(constructor);

        return new DefaultTypedMethod3<>(methodInvoker);
    }

    @Override
    public TypedMethodUnchecked<EnclosingClassObject> withUncheckedParameterTypes(final Class<?>... parameterTypes)
    throws InvalidMethodParameterTypesException, NoSubtypeException {
        final Constructor<?> constructor = constructorLookup.lookupConstructor(getEnclosingClass(), parameterTypes);
        final MethodInvoker methodInvoker = constructorInvokerSupplier.constructorInvoker(constructor);

        //noinspection ConstantConditions
        return new DefaultTypedMethodUnchecked<>(methodInvoker);
    }

    @Override
    public <StaticTypeEnclosingClassObject>
    Overload<StaticTypeEnclosingClassObject>
    withReturnType(final Class<StaticTypeEnclosingClassObject> staticReturnSuperType) {
        return new DefaultConstructorOverload<>(staticReturnSuperType);
    }

    public DefaultConstructorOverload<EnclosingClassObject> withConstructorInvokerSupplier
    (final ConstructorInvokerSupplier constructorInvokerSupplier) {
        this.constructorInvokerSupplier = constructorInvokerSupplier;

        return this;
    }

    public DefaultConstructorOverload<EnclosingClassObject> withConstructorLookup
    (final ConstructorLookup constructorLookup) {
        this.constructorLookup = constructorLookup;

        return this;
    }
}
