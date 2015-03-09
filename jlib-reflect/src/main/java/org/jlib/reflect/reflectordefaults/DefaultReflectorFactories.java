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

package org.jlib.reflect.reflectordefaults;

import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector_old.ValidatingMethodReturnValue;
import org.jlib.reflect.reflectorfactory.InstanceMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.MethodReturnValueFactory;
import org.jlib.reflect.reflectorfactory.TypedClassFactory;
import org.jlib.reflect.reflectorfactory.TypedStaticMethodOverloadFactory;

public final class DefaultReflectorFactories {

    public static TypedClassFactory typedClassFactory() {
        return new TypedClassFactory() {
            @Override
            public <Value> TypedClass<Value> typedClass(final Class<Value> clazz) {
                return new DefaultTypedClass<>(clazz);
            }

            @Override
            public <Value> TypedClass<Value> typedClass(final Class<Value> staticType, final Class<?> actualClass)
            throws NoSubtypeException {
                return new DefaultTypedClass<>(staticType, actualClass);
            }
        };
    }

    public static TypedStaticMethodOverloadFactory typedStaticMethodOverloadFactory() {
        return DefaultStaticMethodOverload::new;
    }

    public static InstanceMethodOverloadFactory instanceMethodFactory() {
        return DefaultInstanceMethodOverload::new;
    }

    public static MethodReturnValueFactory methodReturnValueFactory() {
        return ValidatingMethodReturnValue::new;
    }

    private DefaultReflectorFactories() {}
}
