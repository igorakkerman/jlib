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

import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.TypedOverload;
import org.jlib.reflect.reflector.UncheckedTypedMethod;

public class DefaultStaticMethodOverload<EnclosingClassObject, ReturnValue>
implements TypedOverload<ReturnValue> {

    private final Class<EnclosingClassObject> enclosingClass;
    private final String methodName;
    private final Class<ReturnValue> returnValueClass;

    public DefaultStaticMethodOverload(final Class<EnclosingClassObject> enclosingClass, final String methodName,
                                       final Class<ReturnValue> returnValueClass) {
        this.enclosingClass = enclosingClass;
        this.methodName = methodName;
        this.returnValueClass = returnValueClass;
    }

    @Override
    public TypedMethod0<ReturnValue> withoutParameters() {
        // FIXME: implement
        return null;
    }

    @Override
    public <Argument1>
    TypedMethod1<ReturnValue, Argument1> withParameterTypes(final Class<Argument1> parameter1Type) {
        // FIXME: implement
        return null;
    }

    @Override
    public <Argument1, Argument2>
    TypedMethod2<ReturnValue, Argument1, Argument2> withParameterTypes(final Class<Argument1> parameter1Type,
                                                                           final Class<Argument2> parameter2Type) {
        // FIXME: implement
        return null;
    }

    @Override
    public <Argument1, Argument2, Argument3>
    TypedMethod3<ReturnValue, Argument1, Argument2, Argument3>
                                                     /**/ withParameterTypes(final Class<Argument1> parameter1Type,
                                                                             final Class<Argument2> parameter2Type,
                                                                             final Class<Argument3> parameter3Type) {
        // FIXME: implement
        return null;
    }

    @Override
    public UncheckedTypedMethod<ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes) {
        // FIXME: implement
        return null;
    }
}
