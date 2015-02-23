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

package org.jlib.core.reflection.reflector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jlib.core.classinstance.ClassInstanceException;
import org.jlib.core.classinstance.WrongTypedInstanceException;

public class ConcreteClassReflector<Type>
implements ClassReflector<Type> {

    private final NamedClassReflector namedClassReflector;
    private final Class<Type> staticType;
    private final List<Class<?>> expectedSuperTypes = new ArrayList<>();

    public ConcreteClassReflector(final NamedClassReflector namedClassReflector,
                                  final Class<Type> staticType) {
        this.namedClassReflector = namedClassReflector;
        this.staticType = staticType;
        expectedSuperTypes.add(staticType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Type> get()
    throws ClassInstanceException {
        final Class<?> actualClass = namedClassReflector.get();

        if (expectedSuperTypes.stream()
                              .filter(superType -> ! superType.isAssignableFrom(actualClass))
                              .findFirst()
                          .isPresent())
            throw new WrongTypedInstanceException(actualClass, superType);

        return (Class<Type>) actualClass;
    }

    @Override
    public ClassReflector<Type> alsoTyped(final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        expectedSuperTypes.add(expectedSuperType);
        return this;
    }

    @Override
    public ConstructorReflector<Type> constructor() {
        return new ClassReflectorAwareConstructorReflector<Type>(this);
    }

    @Override
    public StaticMethodReflector<Type> withStaticMethod(final String methodName) {
        return new DefaultStaticMethodReflector<>(methodName);
    }

    protected NamedClassReflector getNamedClassReflector() {
        return namedClassReflector;
    }

    protected Class<Type> getStaticType() {
        return staticType;
    }

    protected List<Class<?>> getExpectedSuperTypes() {
        return expectedSuperTypes;
    }
}
