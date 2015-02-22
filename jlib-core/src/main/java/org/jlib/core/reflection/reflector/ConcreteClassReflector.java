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

import org.jlib.core.classinstance.ClassInstanceException;
import org.jlib.core.classinstance.ClassInstantiationException;
import org.jlib.core.classinstance.WrongTypedInstanceException;

public class ConcreteClassReflector<Type>
implements ClassReflector<Type> {

    private final String className;
    private final List<Class<?>> expectedSuperTypes = new ArrayList<>();

    public ConcreteClassReflector(final String className) {
        this.className = className;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Type> get()
    throws ClassInstanceException {
        try {
            return (Class<Type>) Class.forName(className);
        }
        catch (final ClassNotFoundException exception) {
            throw new ClassInstantiationException(className, exception);
        }
    }

    @Override
    public ClassReflector<Type> ensureType(final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        expectedSuperTypes.add(expectedSuperType);
        return this;
    }

    @Override
    public ConstructorReflector<Type> constructor() {
        return new ClassReflectorAwareConstructorReflector<Type>(this);
    }

    @Override
    public StaticMethodReflector<Type> staticMethod(final String methodName) {
        return new DefaultStaticMethodReflector<Type>(methodName);
    }

    @Override
    public List<Class<?>> getExpectedSuperTypes() {
        return expectedSuperTypes;
    }
}
