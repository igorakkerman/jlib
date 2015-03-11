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

package org.jlib.reflect.reflector.defaults.method;

import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.MethodLookupException;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.TypedMethod0;

public class DefaultTypedMethod0<ReturnValue>
extends AbstractTypedMethod<ReturnValue>
implements TypedMethod0<ReturnValue> {

    public DefaultTypedMethod0(final MethodInvoker methodInvoker) {
        super(methodInvoker);
    }

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturn<ReturnValue> invoke()
    throws MethodLookupException {
        final ReturnValue returnValue = (ReturnValue) getMethodInvoker().invoke();

        return methodReturnValue(returnValue);
    }

    @Override
    public <StaticReturnValue>
    TypedMethod0<StaticReturnValue>
    withReturnType(final Class<StaticReturnValue> staticReturnSuperType) {
        return new DefaultTypedMethod0<>(getMethodInvoker());
    }
}
