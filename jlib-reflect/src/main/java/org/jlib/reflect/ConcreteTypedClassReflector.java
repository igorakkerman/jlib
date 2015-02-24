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

import org.jlib.core.classinstance.ClassInstanceException;
import org.jlib.core.classinstance.WrongTypedInstanceException;

import static java.util.stream.Collectors.toList;

public class ConcreteTypedClassReflector<Type>
implements TypedClassReflector<Type> {

    private final UntypedClassReflector untypedClassReflector;
    private final Class<Type> staticType;
    private final List<Class<?>> expectedSuperTypes = new ArrayList<>();

    public ConcreteTypedClassReflector(final UntypedClassReflector untypedClassReflector, final Class<Type> staticType) {
        this.untypedClassReflector = untypedClassReflector;
        this.staticType = staticType;
        expectedSuperTypes.add(staticType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Type> get()
    throws ClassInstanceException {
        final Class<?> actualClass = untypedClassReflector.get();

        final List<Class<?>> invalidSuperTypes = /*
         */ expectedSuperTypes.stream()
                              .filter(superType -> ! superType.isAssignableFrom(actualClass))
                              .collect(toList());

        if (! invalidSuperTypes.isEmpty())
            throw new WrongTypedInstanceException(actualClass, invalidSuperTypes);

        return (Class<Type>) actualClass;
    }

    @Override
    public TypedClassReflector<Type> assertSubtypeOf(final Class<?> expectedSuperType)
    throws WrongTypedInstanceException {
        expectedSuperTypes.add(expectedSuperType);
        return this;
    }

    @Override
    public MethodOverloadReflector<Type> useConstructor() {
        return new ClassReflectorAwareConstructorReflector<Type>(this);
    }

    // FIXME: implement rest

    @Override
    public <Argument1> Constructor1Reflector<Type, Argument1> useConstructor(final Class<Argument1> argument1Type) {
        return null;
    }

    @Override
    public <Argument1, Argument2> Constructor2Reflector<Type, Argument1, Argument2> useConstructor(
                                                                                                  final
                                                                                                  Class<Argument1>
                                                                                                  argument1Type,
                                                                                                  final
                                                                                                  Class<Argument2>
                                                                                                  argument2Type) {
        return null;
    }

    @Override
    public <Argument1, Argument2, Argument3> Constructor3Reflector<Type, Argument1, Argument2, Argument3>
    useConstructor(
                                                                                                                        final Class<Argument1> argument1Type,
                                                                                                                        final Class<Argument2> argument2Type,
                                                                                                                        final Class<Argument3> argument3Type) {
        return null;
    }

    @Override
    public Method0Reflector<Type> useStaticMethod(final String methodName) {
        return null;
    }

    @Override
    public <Argument1> Method1Reflector<Type, Argument1> useStaticMethod(final String methodName,
                                                                               final Class<Argument1> argument1Type) {
        return null;
    }

    @Override
    public <Argument1, Argument2> Method2Reflector<Type, Argument1, Argument2> useStaticMethod(
                                                                                                    final String
                                                                                                    methodName,
                                                                                                    final
                                                                                                    Class<Argument1>
                                                                                                    argument1Type,
                                                                                                    final
                                                                                                    Class<Argument2> argument2Type) {
        return null;
    }

    @Override
    public <Argument1, Argument2, Argument3> Method3Reflector<Type, Argument1, Argument2, Argument3> useStaticMethod(
                                                                                                                          final String methodName,
                                                                                                                          final Class<Argument1> argument1Type,
                                                                                                                          final Class<Argument2> argument2Type,
                                                                                                                          final Class<Argument3> argument3Type) {
        return null;
    }

    protected UntypedClassReflector getUntypedClassReflector() {
        return untypedClassReflector;
    }

    protected Class<Type> getStaticType() {
        return staticType;
    }

    protected List<Class<?>> getExpectedSuperTypes() {
        return expectedSuperTypes;
    }
}
