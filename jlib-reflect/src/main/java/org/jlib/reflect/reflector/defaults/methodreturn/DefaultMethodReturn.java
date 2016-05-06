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

package org.jlib.reflect.reflector.defaults.methodreturn;

import static java.util.Arrays.asList;
import org.jlib.reflect.programelement.InvalidMethodReturnTypeException;
import org.jlib.reflect.programelement.ProgramElementException;
import static org.jlib.reflect.programelement.LanguageElementUtility.assertMethodReturnTypeInstanceOf;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.Overload;
import org.jlib.reflect.reflector.defaults.overload.DefaultInstanceMethodOverload;

public class DefaultMethodReturn<ReturnValue>
implements MethodReturn<ReturnValue> {

    private final ReturnValue returnValue;
    private final MethodInvoker methodInvoker;

    public DefaultMethodReturn(final ReturnValue returnValue, final MethodInvoker methodInvoker) {
        this.returnValue = returnValue;
        this.methodInvoker = methodInvoker;
    }

    protected ReturnValue getReturnValue() {
        return returnValue;
    }

    protected MethodInvoker getMethodInvoker() {
        return methodInvoker;
    }

    @Override
    public MethodReturn<ReturnValue> returning(final Class<?>... expectedSuperTypes)
    throws InvalidMethodReturnTypeException {
        assertMethodReturnTypeInstanceOf(returnValue, asList(expectedSuperTypes), methodInvoker);

        return this;
    }

    @Override
    public Overload<Object> useMethod(final String methodName) {
        return new DefaultInstanceMethodOverload<>(returnValue, methodName, Object.class);
    }

    @Override
    public ReturnValue get()
    throws ProgramElementException {
        return returnValue;
    }
}