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

import org.jlib.reflect.languageelement.NoSubtypeException;
import org.jlib.reflect.languageelement.ProgramElementException;

public interface TypedClass<Obj> {

    @SuppressWarnings("RedundantThrows")
    Class<Obj> get()
        throws ProgramElementException;

    // downcast necessary for parametrized types although not fully typesafe
    @SuppressWarnings({ "unchecked", "RedundantThrows" })
    default <Val extends Obj>
    Class<Val> downcast()
        throws ProgramElementException {

        return (Class<Val>) get();
    }

    <StaticTypedObject>
    TypedClass<StaticTypedObject> withType(Class<StaticTypedObject> staticType)
        throws NoSubtypeException;

    TypedClass<Obj> withSupertypes(Class<?>... expectedSuperType)
        throws NoSubtypeException;

    @SuppressWarnings("RedundantThrows")
    default Obj instance()
        throws ProgramElementException {

        return constructor()
            .withoutParameters()
            .invoke()
            .getReturned();
    }

    @SuppressWarnings({ "RedundantThrows", "unchecked" })
    default <Argument1>
    Obj instance(final Argument1 argument1)
        throws ProgramElementException {

        return constructor()
            .withParameterTypes((Class<Argument1>) argument1.getClass())
            .invoke(argument1)
            .getReturned();
    }

    @SuppressWarnings({ "RedundantThrows", "unchecked" })
    default <Argument1, Argument2>
    Obj instance(final Argument1 argument1, final Argument2 argument2)
        throws ProgramElementException {

        return constructor()
            .withParameterTypes((Class<Argument1>) argument1.getClass(), (Class<Argument2>) argument2.getClass())
            .invoke(argument1, argument2)
            .getReturned();
    }

    @SuppressWarnings({ "RedundantThrows", "unchecked" })
    default <Argument1, Argument2, Argument3>
    Obj instance(final Argument1 argument1, final Argument2 argument2, final Argument3 argument3)
        throws ProgramElementException {

        return constructor()
            .withParameterTypes((Class<Argument1>) argument1.getClass(), (Class<Argument2>) argument2.getClass(),
                                (Class<Argument3>) argument3.getClass())
            .invoke(argument1, argument2, argument3)
            .getReturned();
    }

    default Obj instanceUnchecked(final Object... arguments)
        throws ProgramElementException {

        return constructor()
            .withUncheckedParameterTypes()
            .invoke(arguments)
            .getReturned();
    }

    ConstructorOverload<Obj> constructor();

    MethodOverload<?> staticMethod(String staticMethodName);
}
