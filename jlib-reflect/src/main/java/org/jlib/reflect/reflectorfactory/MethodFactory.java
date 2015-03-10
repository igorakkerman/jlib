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

package org.jlib.reflect.reflectorfactory;

import java.lang.reflect.Executable;

import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.UncheckedTypedMethod;

public interface MethodFactory {

    <ReturnValue>
    TypedMethod0<ReturnValue> method0(Executable method);

    <ReturnValue, Parameter1>
    TypedMethod1<ReturnValue, Parameter1> method1(Executable method, Class<Parameter1> parameter1Type);

    <ReturnValue, Parameter1, Parameter2>
    TypedMethod2<ReturnValue, Parameter1, Parameter2> method2(Executable method,
                                                              Class<Parameter1> parameter1Type,
                                                              Class<Parameter2> parameter2Type);

    <ReturnValue, Parameter1, Parameter2, Parameter3>
    TypedMethod3<ReturnValue, Parameter1, Parameter2, Parameter3> method3(Executable method,
                                                                          Class<Parameter1> parameter1Type,
                                                                          Class<Parameter2> parameter2Type,
                                                                          Class<Parameter3> parameter3Type);

    <ReturnValue>
    UncheckedTypedMethod<ReturnValue> uncheckedParameterTypesMethod(Executable method);
}
