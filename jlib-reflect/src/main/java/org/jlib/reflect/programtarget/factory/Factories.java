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

package org.jlib.reflect.programtarget.factory;

import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.programtarget.reflect_new.DefaultTypedMethod0;
import org.jlib.reflect.programtarget.reflect_new.DefaultTypedClass;
import org.jlib.reflect.programtarget.reflect_new.DefaultUntypedClass;
import org.jlib.reflect.programtarget.reflect_new.TypedMethod0;
import org.jlib.reflect.programtarget.reflect_new.TypedMethod1;
import org.jlib.reflect.programtarget.reflect_new.TypedMethod2;
import org.jlib.reflect.programtarget.reflect_new.TypedMethod3;
import org.jlib.reflect.programtarget.reflect_new.NonstaticMethod;
import org.jlib.reflect.programtarget.reflect_new.StaticMethod;
import org.jlib.reflect.programtarget.reflect_new.StaticMethodOverload;
import org.jlib.reflect.reflector.ValidatingMethodReturnValue;

public final class Factories {

    public static UntypedClassFactory untypedClassFactory() {
        return DefaultUntypedClass::new;
    }

    public static TypedClassFactory typedClassFactory()
    throws NoSubtypeException {
        return DefaultTypedClass::new;
    }

    public static StaticMethodFactory staticMethodFactory() {
        return StaticMethod::new;
    }

    public static NonstaticMethodFactory nonstaticMethodFactory() {
        return NonstaticMethod::new;
    }

    public static StaticMethodOverloadFactory staticMethodOverloadFactory() {
        return StaticMethodOverload::new;
    }

    public static MethodReturnValueFactory methodReturnValueFactory() {
        return ValidatingMethodReturnValue::new;
    }

    public static MethodFactory methodFactory() {
        return new MethodFactory() {
            @Override
            public <ReturnValue> TypedMethod0<ReturnValue> method0() {
                return new DefaultTypedMethod0<>();
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
        }
    }


    private Factories() {}
}
