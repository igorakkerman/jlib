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

package org.jlib.reflect.reflector.defaults.typedclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static java.util.Arrays.asList;
import org.jlib.reflect.programelement.ClassException;
import org.jlib.reflect.programelement.LanguageElementHelper;
import static org.jlib.reflect.programelement.LanguageElementUtility.assertSubtype;
import org.jlib.reflect.programelement.NoSubtypeException;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.defaults.overload.DefaultConstructorOverload;
import org.jlib.reflect.reflector.defaults.overload.DefaultStaticMethodOverload;

public class DefaultTypedClass<Obj>
    implements TypedClass<Obj> {

    private final LanguageElementHelper languageElementHelper;
    private final Class<?> actualClass;

    public DefaultTypedClass(final LanguageElementHelper languageElementHelper, final Class<Obj> actualClass) {
        this.languageElementHelper = languageElementHelper;
        this.actualClass = actualClass;
    }

    public DefaultTypedClass(final LanguageElementHelper languageElementHelper, final Class<Obj> staticType,
                             final Class<?> actualClass)
        throws NoSubtypeException {
        this.languageElementHelper = languageElementHelper;
        this.actualClass = actualClass;

        withSupertypes(staticType);
    }

    private void assertValid(final Class<Obj> actualClass, final Class<?> expectedParentType)
        throws NoSubtypeException {
        if (expectedParentType.isAssignableFrom(actualClass))
            throw new NoSubtypeException(actualClass, expectedParentType);
    }

    @Override
    public Class<Obj> get()
        throws ClassException {
        return getActualClass();
    }

    @Override
    public <StaticReturnValue>
    TypedClass<StaticReturnValue> withType(final Class<StaticReturnValue> staticType)
        throws NoSubtypeException {
        return new DefaultTypedClass<>(languageElementHelper, staticType, actualClass);
    }

    @Override
    public TypedClass<Obj> withSupertypes(final Class<?>... expectedParentTypes)
        throws NoSubtypeException {
        assertSubtype(actualClass, asList(expectedParentTypes));

        return this;
    }

    @Override
    public Overload<Method, Object> useStaticMethod(final String staticMethodName) {
        return new DefaultStaticMethodOverload<>(languageElementHelper, getActualClass(), staticMethodName, Object.class);
    }

    @Override
    public Overload<Constructor<Obj>, Obj> useConstructor() {
        return new DefaultConstructorOverload<>(languageElementHelper, getActualClass());
    }

    @SuppressWarnings("unchecked")
    protected Class<Obj> getActualClass() {
        return (Class<Obj>) actualClass;
    }
}
