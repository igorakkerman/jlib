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

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import org.jlib.reflect.programtarget.ClassException;
import org.jlib.reflect.programtarget.WrongTypedException;

public class DefaultTypedClassReflector<Value>
implements TypedClassReflector<Value> {

    private final Class<Value> staticType;
    private final UntypedClassSupplier untypedClassSupplier;
    private final List<Class<?>> expectedSuperTypes = new ArrayList<>();

    public DefaultTypedClassReflector(final Class<Value> staticType, final UntypedClassSupplier untypedClassSupplier) {
        this.staticType = staticType;
        this.untypedClassSupplier = untypedClassSupplier;
        expectedSuperTypes.add(staticType);
    }

    public DefaultTypedClassReflector(final Class<Value> staticType) {
        this(staticType, () -> staticType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Value> type()
    throws ClassException {
        final Class<?> actualType = untypedClassSupplier.get();

        final List<Class<?>> invalidSuperTypes = /*
         */ expectedSuperTypes.stream()
                              .filter(superType -> ! superType.isAssignableFrom(actualType))
                              .collect(toList());

        if (! invalidSuperTypes.isEmpty())
            throw new WrongTypedException(actualType, invalidSuperTypes);

        return (Class<Value>) actualType;
    }

    @Override
    public TypedClassReflector<Value> assertSubtypeOf(final Class<?> expectedSuperType)
    throws WrongTypedException {
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
        return new UntypedStaticMethodReflector(staticMethodName, this);
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
