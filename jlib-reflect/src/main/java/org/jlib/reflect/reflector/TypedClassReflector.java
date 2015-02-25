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

import org.jlib.reflect.programtarget.ClassException;
import org.jlib.reflect.programtarget.InvalidValueException;
import org.jlib.reflect.programtarget.MethodException;
import org.jlib.reflect.programtarget.NoSubtypeException;

public interface TypedClassReflector<Value> {

    Class<Value> type()
    throws ClassException;

    // downcast necessary for parametrized types although not fully typesafe
    @SuppressWarnings("unchecked")
    default <Val extends Value>
    Class<Val> parametrizedType()
    throws ClassException {
        return (Class<Val>) type();
    }

    TypedClassReflector<Value> assertSubtypeOf(Class<?> expectedSuperType)
    throws NoSubtypeException;

    default Value instance()
    throws MethodException, InvalidValueException {
        return useConstructor().withoutArguments().invoke().get();
    }

    MethodOverloadReflector<Value> useConstructor();

    UntypedMethodReflector useStaticMethod(String staticMethodName);
}
