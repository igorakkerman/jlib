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

package org.jlib.reflect.reflector.defaults;

import org.jlib.reflect.programelement.ClassLookupException;
import org.jlib.reflect.programelement.MethodInvoker;
import org.jlib.reflect.programelement.NoSubtypeException;
import org.jlib.reflect.programelement.reflection.ReflectionSuppliers;
import static org.jlib.reflect.programelement.reflection.ReflectionSuppliers.classLookupSupplier;
import static org.jlib.reflect.programelement.reflection.ReflectionSuppliers.methodLookupSupplier;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.ReflectorService;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.TypedMethodUnchecked;
import org.jlib.reflect.reflector.defaults.method.AbstractTypedMethod;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod0;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod1;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod2;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod3;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethodUnchecked;
import org.jlib.reflect.reflector.defaults.methodreturn.DefaultMethodReturn;
import org.jlib.reflect.reflector.defaults.overload.AbstractOverload;
import org.jlib.reflect.reflector.defaults.overload.DefaultConstructorOverload;
import org.jlib.reflect.reflector.defaults.overload.DefaultInstanceMethodOverload;
import org.jlib.reflect.reflector.defaults.overload.DefaultStaticMethodOverload;
import org.jlib.reflect.reflector.defaults.typedclass.DefaultTypedClass;
import org.jlib.reflect.reflector.supplier.ConstructorOverloadSupplier;
import org.jlib.reflect.reflector.supplier.InstanceMethodOverloadSupplier;
import org.jlib.reflect.reflector.supplier.MethodReturnSupplier;
import org.jlib.reflect.reflector.supplier.TypedClassSupplier;
import org.jlib.reflect.reflector.supplier.TypedMethodSupplier;
import org.jlib.reflect.reflector.supplier.TypedStaticMethodOverloadSupplier;

public class DefaultReflectorService
implements ReflectorService {

    private static final DefaultReflectorService INSTANCE = new DefaultReflectorService();

    public static DefaultReflectorService getInstance() {
        return INSTANCE;
    }

    private DefaultReflectorService() {}

    @Override
    public TypedClass<?> useClass(final String className)
    throws ClassLookupException {
        return typedClassSupplier().typedClass(classLookupSupplier().classLookup().lookupClass(className));
    }

    @Override
    public <Value> TypedClass<Value> useClass(final Class<Value> concreteClass) {
        return typedClassSupplier().typedClass(concreteClass);
    }

    public TypedClassSupplier typedClassSupplier() {
        return new TypedClassSupplier() {
            @Override
            public <Value> TypedClass<Value> typedClass(final Class<Value> clazz) {
                return configure(new DefaultTypedClass<>(clazz));
            }

            @Override
            public <Value> TypedClass<Value> typedClass(final Class<Value> staticType, final Class<?> actualClass)
            throws NoSubtypeException {
                return configure(new DefaultTypedClass<>(staticType, actualClass));
            }
        };
    }

    private <Value>
    DefaultTypedClass<Value> configure(final DefaultTypedClass<Value> typedClass) {
        return typedClass
               .withTypedClassSupplier(typedClassSupplier())
               .withConstructorOverloadSupplier(constructorOverloadSupplier())
               .withTypedStaticMethodOverloadSupplier(typedStaticMethodOverloadSupplier());
    }

    public TypedStaticMethodOverloadSupplier typedStaticMethodOverloadSupplier() {
        return new TypedStaticMethodOverloadSupplier() {
            @Override
            public <EnclosingClassObject, ReturnValue>
            Overload<ReturnValue> typedStaticMethodOverload(final Class<EnclosingClassObject> enclosingClass,
                                                            final String methodName,
                                                            final Class<ReturnValue> returnValueType) {
                return configure(new DefaultStaticMethodOverload<>(enclosingClass, methodName, returnValueType))
                       .withMethodInvokerSupplier(ReflectionSuppliers.staticMethodInvokerSupplier());
            }
        };
    }

    public InstanceMethodOverloadSupplier instanceMethodOverloadSupplier() {
        return new InstanceMethodOverloadSupplier() {
            @Override
            public <EnclosingObject, ReturnValue>
            Overload<ReturnValue> instanceMethodOverload(final EnclosingObject enclosingObject,
                                                         final String methodName,
                                                         final Class<ReturnValue> returnValueType) {
                return configure(new DefaultInstanceMethodOverload<>(enclosingObject, methodName, returnValueType))
                       .withMethodInvokerSupplier(ReflectionSuppliers.instanceMethodInvokerSupplier())
                       .withInstanceMethodOverloadSupplier(instanceMethodOverloadSupplier());
            }
        };
    }

    public ConstructorOverloadSupplier constructorOverloadSupplier() {
        return new ConstructorOverloadSupplier() {
            @Override
            public <EnclosingClassObject>
            Overload<EnclosingClassObject> constructorOverload(final Class<EnclosingClassObject> enclosingClass) {
                return configure(new DefaultConstructorOverload<>(enclosingClass))
                       .withConstructorInvokerSupplier(ReflectionSuppliers.constructorInvokerSupplier())
                       .withConstructorLookup(ReflectionSuppliers.constructorLookupSupplier().constructorLookup());
            }
        };
    }

    private <Oload extends AbstractOverload<EnclosingClassObject>, EnclosingClassObject>
    Oload configure(final Oload constructorOverload) {
        constructorOverload.setMethodLookup(methodLookupSupplier().methodLookup());
        constructorOverload.setTypedMethodSupplier(typedMethodSupplier());

        return constructorOverload;
    }

    public MethodReturnSupplier methodReturnSupplier() {
        return new MethodReturnSupplier() {
            @Override
            public <ReturnValue>
            MethodReturn<ReturnValue> methodReturnValue(final ReturnValue returnValue,
                                                        final MethodInvoker methodInvoker) {
                return new DefaultMethodReturn<>(returnValue, methodInvoker)
                       .withInstanceMethodOverloadSupplier(instanceMethodOverloadSupplier());
            }
        };
    }

    public TypedMethodSupplier typedMethodSupplier() {
        return new TypedMethodSupplier() {
            @Override
            public <ReturnValue> TypedMethod0<ReturnValue>
            method0(final MethodInvoker methodInvoker) {
                return configure(new DefaultTypedMethod0<>(), methodInvoker);
            }

            @Override
            public <ReturnValue, Parameter1>
            TypedMethod1<ReturnValue, Parameter1>
            method1(final MethodInvoker methodInvoker) {
                return configure(new DefaultTypedMethod1<>(), methodInvoker);
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2>
            TypedMethod2<ReturnValue, Parameter1, Parameter2>
            method2(final MethodInvoker methodInvoker) {
                return configure(new DefaultTypedMethod2<>(), methodInvoker);
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2, Parameter3>
            TypedMethod3<ReturnValue, Parameter1, Parameter2, Parameter3>
            method3(final MethodInvoker methodInvoker) {
                return configure(new DefaultTypedMethod3<>(), methodInvoker);
            }

            @Override
            public <ReturnValue>
            TypedMethodUnchecked<ReturnValue> uncheckedParameterTypesMethod(final MethodInvoker methodInvoker) {
                return configure(new DefaultTypedMethodUnchecked<>(), methodInvoker);
            }
        };
    }

    private <TypedMet extends AbstractTypedMethod<ReturnValue>, ReturnValue>
    TypedMet configure(final TypedMet typedMethod, final MethodInvoker methodInvoker) {
        typedMethod.setMethodReturnSupplier(methodReturnSupplier());
        typedMethod.setMethodInvoker(methodInvoker);
        typedMethod.setTypedMethodSupplier(typedMethodSupplier());

        return typedMethod;
    }
}
