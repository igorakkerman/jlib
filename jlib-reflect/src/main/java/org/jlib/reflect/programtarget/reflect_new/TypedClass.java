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

package org.jlib.reflect.programtarget.reflect_new;

import org.jlib.reflect.programtarget.ClassException;
import org.jlib.reflect.programtarget.ClassLookupException;
import org.jlib.reflect.programtarget.NoSubtypeException;

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

    <SubtypeObject extends Obj> TypedClass<SubtypeObject> withType(Class<SubtypeObject> staticType)
    throws ClassLookupException, NoSubtypeException;

    TypedClass<Obj> assertSubtypeOf(Class<?> expectedSuperType)
    throws NoSubtypeException;

/*
    default Value instance()
    throws ProgramTargetException {
        return useConstructor().withoutParameters().invoke().get();
    }
*/

    MethodOverload<Obj> useConstructor();

    MethodOverload<Object> useStaticMethod(String staticMethodName)
    throws ClassException;
}
