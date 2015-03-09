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

package org.jlib.reflect.reflectordefaults;

import org.jlib.reflect.programtarget.ClassException;
import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.TypedOverload;
import static org.jlib.reflect.reflectordefaults.DefaultReflectorFactories.typedStaticMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.ConstructorOverloadFactory;
import org.jlib.reflect.reflectorfactory.TypedStaticMethodOverloadFactory;

public class DefaultTypedClass<Obj>
implements TypedClass<Obj> {

    @SuppressWarnings("FieldMayBeFinal") // TODO: use DI
    private TypedStaticMethodOverloadFactory typedStaticMethodOverloadFactory = typedStaticMethodOverloadFactory();

    @SuppressWarnings("FieldMayBeFinal") // TODO: use DI
    private ConstructorOverloadFactory constructorOverloadFactory = constructorOverloadFactory();

    private final Class<?> actualClass;

    public DefaultTypedClass(final Class<Obj> actualClass) {
        this.actualClass = actualClass;
    }

    public DefaultTypedClass(final Class<Obj> staticType, final Class<?> actualClass)
    throws NoSubtypeException {
        this.actualClass = actualClass;

        assertSubtypeOf(staticType);
    }

    private void assertValid(final Class<Obj> actualClass, final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Obj> get()
    throws ClassException {
        return (Class<Obj>) actualClass;
    }

    @Override
    public <StaticReturnValue>
    TypedClass<StaticReturnValue> withType(final Class<StaticReturnValue> staticType)
    throws NoSubtypeException {
        return new DefaultTypedClass<>(staticType, actualClass);
    }

    @Override
    public TypedClass<Obj> assertSubtypeOf(final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (!expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);

        return this;
    }

    @Override
    public TypedOverload<Object> useStaticMethod(final String staticMethodName)
    throws ClassException {
        return typedStaticMethodOverloadFactory.typedStaticMethodOverload(get(), staticMethodName, Object.class);
    }

    @Override
    public TypedOverload<Obj> useConstructor() {
        // FIXME: implement
        return constructorOverloadFactory.constructor(actualClass);
    }
}
