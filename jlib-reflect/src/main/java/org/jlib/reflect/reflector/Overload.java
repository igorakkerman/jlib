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

package org.jlib.reflect.reflector;

import org.jlib.reflect.programtarget.InvalidMethodSignatureException;
import org.jlib.reflect.reflector_old.UncheckedTypedMethod;

public interface Overload<ReturnValue> {

    TypedMethod0<ReturnValue> withoutParameters()
    throws InvalidMethodSignatureException;

    <Parameter1>
    TypedMethod1<ReturnValue, Parameter1> withParameterTypes(Class<Parameter1> parameter1Type);

    <Parameter1, Parameter2>
    TypedMethod2<ReturnValue, Parameter1, Parameter2> withParameterTypes(Class<Parameter1> parameter1Type,
                                                                    Class<Parameter2> parameter2Type);

    <Parameter1, Parameter2, Parameter3>
    TypedMethod3<ReturnValue, Parameter1, Parameter2, Parameter3>
                                                            /**/ withParameterTypes(Class<Parameter1> parameter1Type,
                                                                                    Class<Parameter2> parameter2Type,
                                                                                    Class<Parameter3> parameter3Type);

    UncheckedTypedMethod<ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes);
}
