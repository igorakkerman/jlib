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

package org.jlib.reflect.reflector.defaults;

import org.jlib.reflect.programelement.ClassLookupException;
import static org.jlib.reflect.programelement.reflection.ReflectionSuppliers.classLookupSupplier;
import org.jlib.reflect.reflector.ReflectorService;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.defaults.typedclass.DefaultTypedClass;

public class DefaultReflectorService
implements ReflectorService {

    private static final DefaultReflectorService INSTANCE = new DefaultReflectorService();

    public static DefaultReflectorService getInstance() {
        return INSTANCE;
    }

    private DefaultReflectorService() {}

    @Override
    public TypedClass<?> useClass(final String className)
    throws ClassLookupException {
        return new DefaultTypedClass<>(classLookupSupplier().classLookup().lookupClass(className));
    }

    @Override
    public <Value> TypedClass<Value> useClass(final Class<Value> concreteClass) {
        return new DefaultTypedClass<>(concreteClass);
    }
}