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

import org.jlib.reflect.programtarget.MethodLookupException;

public interface TypedMethod3<ReturnType, Argument1, Argument2, Argument3>
extends TypedMethod<ReturnType> {

    MethodReturn<ReturnType> invoke(Argument1 argument1, Argument2 argument2, Argument3 argument3)
    throws MethodLookupException;

    <StaticReturnValue>
    TypedMethod3<StaticReturnValue, Argument1, Argument2, Argument3> withReturnType(Class<StaticReturnValue> clazz);
}
