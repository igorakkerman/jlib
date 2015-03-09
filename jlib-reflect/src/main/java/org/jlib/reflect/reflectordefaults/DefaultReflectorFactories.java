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

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector_old.ValidatingMethodReturnValue;
import org.jlib.reflect.reflectorfactory.MethodFactory;
import org.jlib.reflect.reflectorfactory.MethodReturnValueFactory;
import org.jlib.reflect.reflectorfactory.InstanceMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.StaticMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.TypedClassFactory;
import org.jlib.reflect.reflectorfactory.UntypedClassFactory;

public final class DefaultReflectorFactories {

    public static UntypedClassFactory untypedClassFactory() {
        return DefaultUntypedClass::new;
    }

    public static TypedClassFactory typedClassFactory()
    throws NoSubtypeException {
        return DefaultTypedClass::new;
    }

    public static StaticMethodOverloadFactory staticMethodOverloadFactory() {
        return DefaultStaticMethodOverload::new;
    }

    public static InstanceMethodOverloadFactory instanceMethodFactory() {
        return DefaultInstanceMethodOverload::new;
    }

    public static MethodReturnValueFactory methodReturnValueFactory() {
        return ValidatingMethodReturnValue::new;
    }

    public static MethodFactory methodFactory() {
        return new MethodFactory() {
            @Override
            public <ReturnValue> TypedMethod0<ReturnValue> method0(final Method method) {
                return new DefaultTypedMethod0<>(method);
            }

            @Override
            public <ReturnValue, Parameter1> TypedMethod1<ReturnValue, Parameter1> method1() {
                return null;
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2> TypedMethod2<ReturnValue, Parameter1, Parameter2> method2() {
                return null;
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2, Parameter3> TypedMethod3<ReturnValue, Parameter1, Parameter2, Parameter3> method3() {
                return null;
            }
        };
    }


    private DefaultReflectorFactories() {}
}
