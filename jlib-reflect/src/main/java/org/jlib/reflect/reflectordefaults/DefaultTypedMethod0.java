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

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.MethodLookupException;
import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedMethod;
import org.jlib.reflect.reflector.TypedMethod0;
import static org.jlib.reflect.reflectordefaults.DefaultReflectorFactories.methodReturnValueFactory;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.validator.MethodReturnTypeValidator;

public class DefaultTypedMethod0<ReturnValue>
extends AbstractTypedMethod<ReturnValue, DefaultTypedMethod0<ReturnValue>> {

    // FIXME: implement
    private final MethodReturnTypeValidator methodReturnTypeValidator = null;

    public DefaultTypedMethod0(final Method method) {
        super(method);
    }

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturn<ReturnValue> invoke()
    throws MethodLookupException {
        final Object returnValue = getMethodInvoker().invoke();

        return methodReturnValueFactory().methodReturnValue(returnValue, method);
    }

    @Override
    public TypedMethod0<ReturnValue> assertReturns(final Class<ReturnValue> staticReturnSuperType)
    throws NoSubtypeException {
        methodReturnTypeValidator.assertReturns(staticReturnSuperType);

        return this;
    }

    @Override
    public Method get()
    throws MethodLookupException {
        // FIXME: implement
        return null;
    }

    @Override
    public DefaultTypedMethod0<StaticReturnValue> withReturnType(
        return new DefaultTypedMethod0<>());
    }
}
