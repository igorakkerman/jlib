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
import static org.jlib.reflect.programelement.ProgramElementUtility.assertSubtype;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.supplier.ConstructorOverloadSupplier;
import org.jlib.reflect.reflector.supplier.TypedClassSupplier;
import org.jlib.reflect.reflector.supplier.TypedStaticMethodOverloadSupplier;

public class DefaultTypedClass<Obj>
implements TypedClass<Obj> {

    private TypedClassSupplier typedClassSupplier;
    private TypedStaticMethodOverloadSupplier typedStaticMethodOverloadSupplier;
    private ConstructorOverloadSupplier constructorOverloadSupplier;

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
        return typedClassSupplier.typedClass(staticType, actualClass);
    }

    @Override
    public TypedClass<Obj> withSupertypes(final Class<?>... expectedParentTypes)
    throws NoSubtypeException {
        assertSubtype(actualClass, asList(expectedParentTypes));

        return this;
    }

    @Override
    public Overload<Object> useStaticMethod(final String staticMethodName) {
        return typedStaticMethodOverloadSupplier.typedStaticMethodOverload(getActualClass(), staticMethodName,
                                                                           Object.class);
    }

    @Override
    public Overload<Obj> useConstructor() {
        return constructorOverloadSupplier.constructorOverload(getActualClass());
    }

    @SuppressWarnings("unchecked")
    protected Class<Obj> getActualClass() {
        return (Class<Obj>) actualClass;
    }

    public DefaultTypedClass<Obj> withTypedClassSupplier(final TypedClassSupplier typedClassSupplier) {
        this.typedClassSupplier = typedClassSupplier;

        return this;
    }

    public DefaultTypedClass<Obj> withConstructorOverloadSupplier
    (final ConstructorOverloadSupplier constructorOverloadSupplier) {
        this.constructorOverloadSupplier = constructorOverloadSupplier;

        return this;
    }

    public DefaultTypedClass<Obj> withTypedStaticMethodOverloadSupplier
    (final TypedStaticMethodOverloadSupplier typedStaticMethodOverloadSupplier) {
        this.typedStaticMethodOverloadSupplier = typedStaticMethodOverloadSupplier;

        return this;
    }
}
