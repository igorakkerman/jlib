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

import java.util.function.Supplier;

import org.jlib.reflect.programtarget.reflection.ReflectionReflectorFactory;

public final class Reflectors {

    private Reflectors() {}

    public static UntypedClassReflector useClass(final String className) {
        return factory().untypedClassReflector(factory().classLookup(className));
    }

    public static UntypedClassReflector useClass(final Supplier<String> classNameSupplier) {
        return useClass(classNameSupplier.get());
    }

    public static <Value> TypedClassReflector<Value> useClass(final Class<Value> clazz) {
        return null; // FIXME: implement
//        return new ConcreteTypedClassReflector<>(clazz);
    }

    static ReflectorFactory factory() {
        // TODO: change this to use DI or some property lookup mechanism
        return new ReflectionReflectorFactory();
    }
}

