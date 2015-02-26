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
import org.jlib.reflect.reflector.MethodOverloadReflector;
import org.jlib.reflect.reflector.TypedClassReflector;
import org.jlib.reflect.reflector.UntypedMethodReflector;

public class DefaultTypedClassReflector<Value>
implements TypedClassReflector<Value> {

    private final Class<?> actualClass;

    public DefaultTypedClassReflector(final Class<Value> staticType, final Class<?> actualClass)
    throws NoSubtypeException {
        this.actualClass = actualClass;

        assertSubtypeOf(staticType);
    }

    public DefaultTypedClassReflector(final Class<Value> actualClass) {
        this.actualClass = actualClass;
    }

    private void assertValid(final Class<Value> actualClass, final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Value> get()
    throws ClassException {
        return (Class<Value>) actualClass;
    }

    @Override
    public TypedClassReflector<Value> assertSubtypeOf(final Class<?> expectedParentType)
    throws NoSubtypeException {
        if (!expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);

        return this;
    }

    @Override
    public UntypedMethodReflector useStaticMethod(final String staticMethodName) {
//        return factory().untypedStaticMethodReflector(staticMethodName, this);
        // FIXME: implement
        return null;
    }

    @Override
    public MethodOverloadReflector<Value> useConstructor() {
        // FIXME: implement
        return null;
    }
}
