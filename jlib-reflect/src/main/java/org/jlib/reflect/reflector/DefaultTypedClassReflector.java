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

import java.util.List;

import org.jlib.reflect.programtarget.ClassException;
import org.jlib.reflect.programtarget.NoSubtypeException;
import static org.jlib.reflect.validator.Validators.hasSupertypes;

public class DefaultTypedClassReflector<Value>
implements TypedClassReflector<Value> {

    public DefaultTypedClassReflector(final Class<Value> staticType, final Class<?> clazz) {

    }

    public DefaultTypedClassReflector(final Class<Value> actualClass) {
        this(actualClass, () -> actualClass);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Value> get()
    throws ClassException {
        final Class<?> actualClass = untypedClassSupplier.get();
        hasSupertypes(expectedSuperTypes).assertHasExpectedSupertypes(actualClass);
        return (Class<Value>) actualClass;
    }

    @Override
    public TypedClassReflector<Value> assertSubtypeOf(final Class<?> expectedSuperType)
    throws NoSubtypeException {
        expectedSuperTypes.add(expectedSuperType);
        return this;
    }

    @Override
    public MethodOverloadReflector<Value> useConstructor() {
        // FIXME: implement
        return null;
    }

    @Override
    public UntypedMethodReflector useStaticMethod(final String staticMethodName) {
        return factory().untypedStaticMethodReflector(staticMethodName, this);
    }

    protected Class<Value> getStaticType() {
        return staticType;
    }

    protected UntypedClassSupplier getUntypedClassSupplier() {
        return untypedClassSupplier;
    }

    protected List<Class<?>> getExpectedSuperTypes() {
        return expectedSuperTypes;
    }
}
