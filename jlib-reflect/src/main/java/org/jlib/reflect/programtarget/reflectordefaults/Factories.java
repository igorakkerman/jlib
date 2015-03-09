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

package org.jlib.reflect.programtarget.reflectordefaults;

import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.programtarget.reflectordefaults.DefaultMethod0;
import org.jlib.reflect.programtarget.reflectordefaults.DefaultTypedClass;
import org.jlib.reflect.programtarget.reflectordefaults.DefaultUntypedClass;
import org.jlib.reflect.programtarget.reflector.Method0;
import org.jlib.reflect.programtarget.reflector.Method1;
import org.jlib.reflect.programtarget.reflector.Method2;
import org.jlib.reflect.programtarget.reflector.Method3;
import org.jlib.reflect.programtarget.reflectordefaults.NonstaticMethod;
import org.jlib.reflect.programtarget.reflectordefaults.StaticMethod;
import org.jlib.reflect.programtarget.reflectordefaults.StaticMethodOverload;
import org.jlib.reflect.programtarget.reflectorfactory.MethodFactory;
import org.jlib.reflect.programtarget.reflectorfactory.MethodReturnValueFactory;
import org.jlib.reflect.programtarget.reflectorfactory.NonstaticMethodFactory;
import org.jlib.reflect.programtarget.reflectorfactory.StaticMethodFactory;
import org.jlib.reflect.programtarget.reflectorfactory.StaticMethodOverloadFactory;
import org.jlib.reflect.programtarget.reflectorfactory.TypedClassFactory;
import org.jlib.reflect.programtarget.reflectorfactory.UntypedClassFactory;
import org.jlib.reflect.reflector_old.ValidatingMethodReturnValue;

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
            public <ReturnValue> Method0<ReturnValue> method0() {
                return new DefaultMethod0<>();
            }

            @Override
            public <ReturnValue, Parameter1> Method1<ReturnValue, Parameter1> method1() {
                return null;
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2> Method2<ReturnValue, Parameter1, Parameter2> method2() {
                return null;
            }

            @Override
            public <ReturnValue, Parameter1, Parameter2, Parameter3> Method3<ReturnValue, Parameter1, Parameter2, Parameter3> method3() {
                return null;
            }
        }
    }


    private Factories() {}
}
