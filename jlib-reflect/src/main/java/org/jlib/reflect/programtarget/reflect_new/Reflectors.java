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

import java.util.function.Supplier;

import org.jlib.reflect.programtarget.ClassLookupException;
import static org.jlib.reflect.programtarget.factory.Factories.untypedClassFactory;
import static org.jlib.reflect.programtarget.factory.ReflectionFactories.classLookupFactory;

public final class Reflectors {

    public static TypedClass<Object> useClass(final String className)
    throws ClassLookupException {
        return untypedClassFactory(classLookupFactory()).untypedClass(className);
    }

    public static TypedClass<Object> useClass(final Supplier<String> classNameSupplier)
    throws ClassLookupException {
        return useClass(classNameSupplier.get());
    }

    public static <Value>
    TypedClass<Value> useClass(final Class<Value> concreteClass) {
        return new DefaultTypedClass<>(concreteClass);
    }

    private Reflectors() {}
}

