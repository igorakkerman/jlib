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

package org.jlib.core.reflection.reflector;

import org.jlib.core.classinstance.ClassInstanceException;
import org.jlib.core.classinstance.WrongTypedInstanceException;

public interface TypedClassReflector<Value> {

    Class<Value> get()
    throws ClassInstanceException;

    TypedClassReflector<Value> ensureType(Class<?> expectedSuperType)
    throws WrongTypedInstanceException;

    ConstructorReflector<Value> useConstructor();

    <Argument1> /*
 */ Constructor1Reflector<Value, Argument1> /*
     */ useConstructor(Class<Argument1> argument1Type);

    <Argument1, Argument2> /*
 */ Constructor2Reflector<Value, Argument1, Argument2> /*
     */ useConstructor(Class<Argument1> argument1Type, Class<Argument2> argument2Type);

    <Argument1, Argument2, Argument3> /*
 */ Constructor3Reflector<Value, Argument1, Argument2, Argument3> /*
     */ useConstructor(Class<Argument1> argument1Type, Class<Argument2> argument2Type, Class<Argument3> argument3Type);

    StaticMethod0Reflector<Value> /*
     */ useStaticMethod(String methodName);

    <Argument1> /*
 */ StaticMethod1Reflector<Value, Argument1> /*
     */ useStaticMethod(String methodName,
                        Class<Argument1> argument1Type);

    <Argument1, Argument2> /*
 */ StaticMethod2Reflector<Value, Argument1, Argument2> /*
     */ useStaticMethod(String methodName,
                        Class<Argument1> argument1Type, Class<Argument2> argument2Type);

    <Argument1, Argument2, Argument3> /*
 */ StaticMethod3Reflector<Value, Argument1, Argument2, Argument3> /*
     */ useStaticMethod(String methodName,
                        Class<Argument1> argument1Type, Class<Argument2> argument2Type, Class<Argument3> argument3Type);
}
