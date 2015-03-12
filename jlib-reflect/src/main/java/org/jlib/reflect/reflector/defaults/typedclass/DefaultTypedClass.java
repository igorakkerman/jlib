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

package org.jlib.reflect.reflector.defaults.typedclass;

import static java.util.Arrays.asList;
import org.jlib.reflect.programelement.ClassException;
import org.jlib.reflect.programelement.NoSubtypeException;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.TypedClass;
import static org.jlib.reflect.reflector.defaults.DefaultReflectorFactories.typedStaticMethodOverloadFactory;
import static org.jlib.reflect.reflector.defaults.DefaultReflectorFactories.constructorOverloadFactory;
import org.jlib.reflect.reflector.factory.ConstructorOverloadFactory;
import org.jlib.reflect.reflector.factory.TypedStaticMethodOverloadFactory;
import static org.jlib.reflect.programelement.ProgramTargetUtility.assertSubtype;

public class DefaultTypedClass<Obj>
implements TypedClass<Obj> {

    // TODO: use DI
    private final TypedStaticMethodOverloadFactory typedStaticMethodOverloadFactory = typedStaticMethodOverloadFactory();

    // TODO: use DI
    private final ConstructorOverloadFactory constructorOverloadFactory = constructorOverloadFactory();

    private final Class<?> actualClass;

    public DefaultTypedClass(final Class<Obj> actualClass) {
        this.actualClass = actualClass;
    }

    public DefaultTypedClass(final Class<Obj> staticType, final Class<?> actualClass)
    throws NoSubtypeException {
        this.actualClass = actualClass;

        withSupertypes(staticType);
    }

    private void assertValid(final Class<Obj> actualClass, final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);
    }

    @Override
    public Class<Obj> get()
    throws ClassException {
        return getActualClass();
    }

    @Override
    public <StaticReturnValue>
    TypedClass<StaticReturnValue> withType(final Class<StaticReturnValue> staticType)
    throws NoSubtypeException {
        return new DefaultTypedClass<>(staticType, actualClass);
    }

    @Override
    public TypedClass<Obj> withSupertypes(final Class<?>... expectedParentTypes)
    throws NoSubtypeException {
        assertSubtype(actualClass, asList(expectedParentTypes));

        return this;
    }

    @Override
    public Overload<Object> useStaticMethod(final String staticMethodName) {
        return typedStaticMethodOverloadFactory.typedStaticMethodOverload(getActualClass(), staticMethodName, Object.class);
    }

    @Override
    public Overload<Obj> useConstructor() {
        return constructorOverloadFactory.constructorOverload(getActualClass());
    }

    @SuppressWarnings("unchecked")
    protected Class<Obj> getActualClass() {
        return (Class<Obj>) actualClass;
    }
}
