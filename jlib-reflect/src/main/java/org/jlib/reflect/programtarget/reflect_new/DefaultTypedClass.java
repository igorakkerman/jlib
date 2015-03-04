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
import org.jlib.reflect.programtarget.NoSubtypeException;
import static org.jlib.reflect.programtarget.factory.Factories.staticMethodFactory;
import static org.jlib.reflect.programtarget.factory.Factories.typedClassFactory;

public class DefaultTypedClass<Obj>
implements TypedClass<Obj> {

    private final Class<?> clazz;

    public DefaultTypedClass(final Class<?> clazz)
    throws NoSubtypeException {
        this.clazz = clazz;
    }

    public DefaultTypedClass(final Class<?> clazz, final Class<Obj> staticType)
    throws NoSubtypeException {
        this(clazz);

        assertSubtypeOf(staticType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Obj> get() {
        return (Class<Obj>) clazz;
    }

    @Override
    public <SubtypeObject extends Obj>
    TypedClass<SubtypeObject> withType(final Class<SubtypeObject> staticType)
    throws NoSubtypeException {
        return typedClassFactory().typedClass(get(), staticType);
    }

    private void assertValid(final Class<Obj> actualClass, final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);
    }

    @Override
    public TypedClass<Obj> assertSubtypeOf(final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (! expectedParentType.isAssignableFrom(clazz))
            throw new NoSubtypeException(clazz, expectedParentType);

        return this;
    }

    @Override
    public Overload<Object> useStaticMethod(final String staticMethodName)
    throws ClassException {
        return staticMethodFactory().staticMethod(clazz, staticMethodName);
    }

    @Override
    public Overload<Obj> useConstructor() {
        // FIXME: implement
        return null;
    }
}
