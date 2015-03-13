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

import org.jlib.reflect.programelement.MethodLookupException;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.TypedMethod3;

public class DefaultTypedMethod3<ReturnValue, Argument1, Argument2, Argument3>
extends AbstractTypedMethod<ReturnValue>
implements TypedMethod3<ReturnValue, Argument1, Argument2, Argument3> {

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturn<ReturnValue> invoke(final Argument1 argument1, final Argument2 argument2,
                                            final Argument3 argument3)
    throws MethodLookupException {
        final ReturnValue returnValue = (ReturnValue) getMethodInvoker().invoke(argument1, argument2);

        return methodReturnValue(returnValue);
    }

    @Override
    public <StaticReturnValue>
    TypedMethod3<StaticReturnValue, Argument1, Argument2, Argument3>
    withReturnType(final Class<StaticReturnValue> staticReturnSuperType) {
        return getTypedMethodSupplier().method3(getMethodInvoker());
    }
}
