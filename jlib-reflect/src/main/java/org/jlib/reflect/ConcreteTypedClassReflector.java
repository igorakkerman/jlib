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

package org.jlib.reflect;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConcreteTypedClassReflector<Type>
/*implements TypedClassReflector<Type>*/ {

    private final Class<Type> staticType;
    private final UntypedClassSupplier untypedClassSupplier;
    private final List<Class<?>> expectedSuperTypes = new ArrayList<>();

    public ConcreteTypedClassReflector(final Class<Type> staticType,
                                       final UntypedClassSupplier untypedClassSupplier) {
        this.staticType = staticType;
        this.untypedClassSupplier = untypedClassSupplier;
        expectedSuperTypes.add(staticType);
    }

    public ConcreteTypedClassReflector(final Class<Type> staticType) {
        this(staticType, () -> staticType);
    }

    //    @Override
    @SuppressWarnings("unchecked")
    public Class<Type> get()
    throws ClassInstanceException {
        final Class<?> actualClass = untypedClassSupplier.get();

        final List<Class<?>> invalidSuperTypes = /*
         */ expectedSuperTypes.stream()
                              .filter(superType -> ! superType.isAssignableFrom(actualClass))
                              .collect(toList());

        if (! invalidSuperTypes.isEmpty())
            throw new WrongTypedInstanceException(actualClass, invalidSuperTypes);

        return (Class<Type>) actualClass;
    }

/*
    @Override
    public TypedClassReflector<Type> assertSubtypeOf(final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        expectedSuperTypes.add(expectedSuperType);
        return this;
    }
*/

    protected Class<Type> getStaticType() {
        return staticType;
    }

    protected UntypedClassSupplier getUntypedClassSupplier() {
        return untypedClassSupplier;
    }

    protected List<Class<?>> getExpectedSuperTypes() {
        return expectedSuperTypes;
    }
}
