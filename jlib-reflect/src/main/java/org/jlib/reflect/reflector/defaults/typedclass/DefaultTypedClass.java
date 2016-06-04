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

import static java.util.Arrays.asList;
import org.jlib.reflect.languageelement.ClassException;
import org.jlib.reflect.languageelement.LanguageElementHandler;
import static org.jlib.reflect.languageelement.LanguageElementUtility.assertSubtype;
import org.jlib.reflect.languageelement.NoSubtypeException;
import org.jlib.reflect.reflector.ConstructorOverload;
import org.jlib.reflect.reflector.MethodOverload;
import org.jlib.reflect.reflector.TypedClass;
import org.jlib.reflect.reflector.defaults.overload.DefaultConstructorOverload;
import org.jlib.reflect.reflector.defaults.overload.DefaultStaticMethodOverload;

public class DefaultTypedClass<Obj>
    implements TypedClass<Obj> {

    private final LanguageElementHandler languageElementHandler;
    private final Class<?> actualClass;

    public DefaultTypedClass(final LanguageElementHandler languageElementHandler, final Class<Obj> actualClass) {
        this.languageElementHandler = languageElementHandler;
        this.actualClass = actualClass;
    }

    public DefaultTypedClass(final LanguageElementHandler languageElementHandler, final Class<Obj> staticType,
                             final Class<?> actualClass)
        throws NoSubtypeException {
        this.languageElementHandler = languageElementHandler;
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
        return new DefaultTypedClass<>(languageElementHandler, staticType, actualClass);
    }

    @Override
    public TypedClass<Obj> withSupertypes(final Class<?>... expectedParentTypes)
        throws NoSubtypeException {
        assertSubtype(actualClass, asList(expectedParentTypes));

        return this;
    }

    @Override
    public MethodOverload<?> staticMethod(final String staticMethodName) {
        return new DefaultStaticMethodOverload<>(languageElementHandler, getActualClass(), staticMethodName,
                                                 Object.class);
    }

    @Override
    public ConstructorOverload<Obj> constructor() {
        return new DefaultConstructorOverload<>(languageElementHandler, getActualClass());
    }

    @SuppressWarnings("unchecked")
    protected Class<Obj> getActualClass() {
        return (Class<Obj>) actualClass;
    }
}
