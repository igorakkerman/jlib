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

package org.jlib.core.reflection;

import org.jlib.core.classinstance.ClassInstanceService;
import org.jlib.core.classinstance.ClassInstantiationException;
import org.jlib.core.classinstance.WrongTypedClassInstantiationException;

public class ReflectionService
implements ClassInstanceService {

    private static final ReflectionService INSTANCE = new ReflectionService();

    public static ReflectionService getInstance() {
        return INSTANCE;
    }

    private ReflectionService() {}

    @Override
    public <Obj> Obj instanceOf(final Class<? extends Obj> clazz)
    throws ClassInstantiationException {
        try {
            return clazz.newInstance();
        }
        catch (final InstantiationException | IllegalAccessException exception) {
            throw new ClassInstantiationException(clazz, exception);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Obj> Obj instanceOfClassOf(final Obj object)
    throws ClassInstantiationException {
        return instanceOf((Class<? extends Obj>) object.getClass());
    }

    @Override
    @SuppressWarnings({ "unchecked", "DuplicateThrows" })
    public <Obj> Obj instanceOf(final String className, final Class<Obj> expectedSuperType)
    throws WrongTypedClassInstantiationException, ClassInstantiationException {
        try {
            final Class<?> clazz = Class.forName(className);

            if (! expectedSuperType.isAssignableFrom(clazz))
                throw new WrongTypedClassInstantiationException(clazz, expectedSuperType);

            return instanceOf((Class<? extends Obj>) clazz);
        }
        catch (final ClassNotFoundException exception) {
            throw new ClassInstantiationException(className, exception);
        }
    }
}
