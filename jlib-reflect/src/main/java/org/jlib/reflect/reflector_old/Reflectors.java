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

package org.jlib.reflect.reflector_old;

import java.util.function.Supplier;

import static org.jlib.reflect.programtargetreflection.ReflectionFactories.classLookupFactory;
import static org.jlib.reflect.reflectordefaults.DefaultReflectorFactories.untypedClassFactory;
import org.jlib.reflect.reflectordefaults.DefaultTypedClass;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.UntypedClass;

public final class Reflectors {

    private Reflectors() {}

    public static UntypedClass useClass(final String className) {
        return untypedClassFactory().untypedClass(classLookupFactory().classLookup());
    }

    public static UntypedClass useClass(final Supplier<String> classNameSupplier) {
        return useClass(classNameSupplier.get());
    }

    public static <Value> TypedClass<Value> useClass(final Class<Value> concreteClass) {
        return new DefaultTypedClass<Value>(concreteClass);
    }
}

