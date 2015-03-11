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

package org.jlib.reflect.reflector.defaults.overload;

import java.lang.reflect.Method;

import static java.util.Collections.singletonList;
import org.jlib.reflect.programtarget.MethodLookup;
import org.jlib.reflect.programtarget.NoSubtypeException;
import static org.jlib.reflect.programtarget.ProgramTargetUtility.assertSubtype;
import static org.jlib.reflect.programtarget.reflection.ReflectionFactories.methodLookupFactory;
import org.jlib.reflect.reflector.Overload;
import static org.jlib.reflect.reflector.defaults.DefaultReflectorFactories.methodFactory;
import org.jlib.reflect.reflector.factory.MethodFactory;

public abstract class AbstractOverload<ReturnValue>
implements Overload<ReturnValue> {

    // TODO: use DI
    protected final MethodLookup methodLookup = methodLookupFactory().methodLookup();

    // TODO: use DI
    protected final MethodFactory methodFactory = methodFactory();

    private final Class<?> enclosingClass;
    private final Class<ReturnValue> returnValueType;

    protected Class<?> getEnclosingClass() {
        return enclosingClass;
    }

    public AbstractOverload(final Class<?> enclosingClass,
                            final Class<ReturnValue> returnValueType) {
        this.enclosingClass = enclosingClass;
        this.returnValueType = returnValueType;
    }

    protected void assertReturnValueTypeValid(final Method method)
    throws NoSubtypeException {
        assertSubtype(method.getReturnType(), singletonList(returnValueType));
    }
}
