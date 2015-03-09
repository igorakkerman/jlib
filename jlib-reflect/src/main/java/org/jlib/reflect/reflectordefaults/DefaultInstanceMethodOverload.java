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

import org.jlib.reflect.programtarget.InvalidMethodParameterTypesException;
import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.TypedOverload;
import org.jlib.reflect.reflector.UntypedOverload;
import org.jlib.reflect.reflector_old.UncheckedTypedMethod;

public class DefaultInstanceMethodOverload<EnclosingObject>
implements UntypedOverload {

    private final EnclosingObject enclosingObject;
    private final String methodName;

    public DefaultInstanceMethodOverload(final EnclosingObject enclosingObject, final String methodName) {
        this.enclosingObject = enclosingObject;
        this.methodName = methodName;
    }

    @Override
    public <ReturnValue> TypedOverload<ReturnValue> withReturnType(final Class<ReturnValue> returnValueClass)
    throws NoSubtypeException {
        // FIXME: implement
        return null;
    }

    @Override
    public TypedMethod0<Object> withoutParameters()
    throws InvalidMethodParameterTypesException {
        // FIXME: implement
        return null;
    }

    @Override
    public <Parameter1> TypedMethod1<Object, Parameter1> withParameterTypes(final Class<Parameter1> parameter1Type)
    throws InvalidMethodParameterTypesException {
        // FIXME: implement
        return null;
    }

    @Override
    public <Parameter1, Parameter2> TypedMethod2<Object, Parameter1, Parameter2> withParameterTypes(
                                                                                                   final
                                                                                                   Class<Parameter1>
                                                                                                   parameter1Type,
                                                                                                   final Class
                                                                                                         <Parameter2>
                                                                                                   parameter2Type)
    throws InvalidMethodParameterTypesException {
        // FIXME: implement
        return null;
    }

    @Override
    public <Parameter1, Parameter2, Parameter3> TypedMethod3<Object, Parameter1, Parameter2, Parameter3>
    withParameterTypes(
                                                                                                                           final Class<Parameter1> parameter1Type,
                                                                                                                           final Class<Parameter2> parameter2Type,
                                                                                                                           final Class<Parameter3> parameter3Type)
    throws InvalidMethodParameterTypesException {
        // FIXME: implement
        return null;
    }

    @Override
    public UncheckedTypedMethod<Object> withUncheckedParameterTypes(final Class<?>... parameterTypes)
    throws InvalidMethodParameterTypesException {
        // FIXME: implement
        return null;
    }
}
