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
import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.programtarget.ProgramTargetException;

public interface TypedClass<Obj> {

    Class<Obj> get()
    throws ClassException;

    // downcast necessary for parametrized types although not fully typesafe
    @SuppressWarnings("unchecked")
    default <Val extends Obj>
    Class<Val> downcast()
    throws ClassException {
        return (Class<Val>) get();
    }

    TypedClass<Obj> assertSubtypeOf(Class<?> expectedSuperType)
    throws NoSubtypeException;

    default Obj instance()
    throws ProgramTargetException {
        return useConstructor().withoutParameters().invoke().get();
    }

    TypedOverload<Obj> useConstructor();

    TypedOverload<Object> useStaticMethod(String staticMethodName)
    throws ClassException;
}
