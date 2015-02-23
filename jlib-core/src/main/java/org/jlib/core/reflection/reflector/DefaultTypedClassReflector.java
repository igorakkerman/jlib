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

// FIXME: implement
public class DefaultTypedClassReflector<Value>
implements TypedClassReflector<Value> {

    private final Class<Value> clazz;

    public DefaultTypedClassReflector(final Class<Value> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Class<Value> get()
    throws ClassInstanceException {
        return null;
    }

    @Override
    public TypedClassReflector<Value> ensureType(final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        return null;
    }

    @Override
    public ConstructorReflector<Value> withConstructor(final Class<?> argumentTypes) {
        return null;
    }

    @Override
    public StaticMethod0Reflector<Value> useStaticMethod(final String methodName) {
        return null;
    }

    @Override
    public <Argument1> StaticMethod1Reflector<Value, Argument1> useStaticMethod(final String methodName,
                                                                                final Class<Argument1> argument1Type) {
        return null;
    }

    @Override
    public <Argument1, Argument2> StaticMethod2Reflector<Value, Argument1, Argument2> useStaticMethod(
                                                                                                     final String
                                                                                                     methodName,
                                                                                                     final
                                                                                                     Class<Argument1>
                                                                                                     argument1Type,
                                                                                                     final
                                                                                                     Class<Argument2>
                                                                                                     argument2Type) {
        return null;
    }

    @Override
    public <Argument1, Argument2, Argument3> StaticMethod3Reflector<Value, Argument1, Argument2, Argument3>
    useStaticMethod(
                                                                                                                           final String methodName,
                                                                                                                           final Class<Argument1> argument1Type,
                                                                                                                           final Class<Argument2> argument2Type,
                                                                                                                           final Class<Argument3> argument3Type) {
        return null;
    }
}
