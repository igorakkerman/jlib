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

import org.jlib.reflect.programtarget.ClassLookup;
import org.jlib.reflect.programtarget.ClassLookupException;
import org.jlib.reflect.programtarget.NoSubtypeException;
import static org.jlib.reflect.programtarget.factory.Factories.typedClassFactory;

public class DefaultUntypedClass
implements UntypedClass {

    private final ClassLookup classLookup;

    private Class<?> clazz;

    public DefaultUntypedClass(final ClassLookup classLookup) {
        this.classLookup = classLookup;
    }

    @Override
    public Class<?> get()
    throws ClassLookupException {
        if (clazz == null)
            clazz = classLookup.get();

        return clazz;
    }

    @Override
    public <Obj> TypedClass<Obj> withType(final Class<Obj> staticType)
    throws ClassLookupException, NoSubtypeException {
        return typedClassFactory().typedClassReflector(staticType, get());
    }
}
