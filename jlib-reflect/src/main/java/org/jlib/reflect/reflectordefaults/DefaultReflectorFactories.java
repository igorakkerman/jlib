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

package org.jlib.reflect.reflectordefaults;

import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.UncheckedTypedMethod;
import org.jlib.reflect.reflectordefaults.method.DefaultTypedMethod0;
import org.jlib.reflect.reflectordefaults.method.DefaultTypedMethod1;
import org.jlib.reflect.reflectordefaults.method.DefaultTypedMethod2;
import org.jlib.reflect.reflectordefaults.method.DefaultTypedMethod3;
import org.jlib.reflect.reflectordefaults.method.DefaultUncheckedTypedMethod;
import org.jlib.reflect.reflectordefaults.methodreturn.DefaultMethodReturn;
import org.jlib.reflect.reflectordefaults.overload.DefaultConstructorOverload;
import org.jlib.reflect.reflectordefaults.overload.DefaultInstanceMethodOverload;
import org.jlib.reflect.reflectordefaults.overload.DefaultStaticMethodOverload;
import org.jlib.reflect.reflectordefaults.typedclass.DefaultTypedClass;
import org.jlib.reflect.reflectorfactory.ConstructorOverloadFactory;
import org.jlib.reflect.reflectorfactory.InstanceMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.MethodFactory;
import org.jlib.reflect.reflectorfactory.MethodReturnFactory;
import org.jlib.reflect.reflectorfactory.TypedClassFactory;
import org.jlib.reflect.reflectorfactory.TypedStaticMethodOverloadFactory;

public final class DefaultReflectorFactories {

    public static TypedClassFactory typedClassFactory() {
        return new TypedClassFactory() {
            @Override
            public <Value> TypedClass<Value> typedClass(final Class<Value> clazz) {
                return new DefaultTypedClass<>(clazz);
            }

            @Override
            public <Value> TypedClass<Value> typedClass(final Class<Value> staticType, final Class<?> actualClass)
            throws NoSubtypeException {
                return new DefaultTypedClass<>(staticType, actualClass);
            }
        };
    }

    public static TypedStaticMethodOverloadFactory typedStaticMethodOverloadFactory() {
        return DefaultStaticMethodOverload::new;
    }

    public static InstanceMethodOverloadFactory instanceMethodOverloadFactory() {
        return DefaultInstanceMethodOverload::new;
    }

    public static ConstructorOverloadFactory constructorOverloadFactory() {
        return DefaultConstructorOverload::new;
    }

    public static MethodReturnFactory methodReturnFactory() {
        return DefaultMethodReturn::new;
    }

    public static MethodFactory methodFactory() {
        return new MethodFactory() {
            @Override
            public <ReturnValue> TypedMethod0<ReturnValue> method0(final MethodInvoker methodInvoker) {
                return new DefaultTypedMethod0<>(methodInvoker);
            }

            @Override
            public <ReturnValue, Parameter1>
            TypedMethod1<ReturnValue, Parameter1> method1(final MethodInvoker methodInvoker,
                                                          final Class<Parameter1> parameter1Type) {
                return new DefaultTypedMethod1<>(methodInvoker);
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2>
            TypedMethod2<ReturnValue, Parameter1, Parameter2> method2(final MethodInvoker methodInvoker,
                                                                      final Class<Parameter1> parameter1Type,
                                                                      final Class<Parameter2> parameter2Type) {
                return new DefaultTypedMethod2<>(methodInvoker);
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2, Parameter3>
            TypedMethod3<ReturnValue, Parameter1, Parameter2, Parameter3>
            method3(final MethodInvoker methodInvoker,
                    final Class<Parameter1> parameter1Type,
                    final Class<Parameter2> parameter2Type,
                    final Class<Parameter3> parameter3Type) {
                return new DefaultTypedMethod3<>(methodInvoker);
            }

            @Override
            public <ReturnValue>
            UncheckedTypedMethod<ReturnValue> uncheckedParameterTypesMethod(final MethodInvoker methodInvoker) {
                return new DefaultUncheckedTypedMethod<>(methodInvoker);
            }
        };
    }

    private DefaultReflectorFactories() {}
}
