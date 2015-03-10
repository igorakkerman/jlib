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

package org.jlib.reflect.reflectordefaults.methodreturn;

import org.jlib.reflect.programtarget.InvalidMethodReturnValueException;
import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.ProgramTargetException;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.Overload;
import static org.jlib.reflect.reflectordefaults.DefaultReflectorFactories.instanceMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.InstanceMethodOverloadFactory;
import org.jlib.reflect.validator.MethodReturnValueValidator;

public class DefaultMethodReturn<ReturnValue>
implements MethodReturn<ReturnValue> {

    // TODO: use DI
    private final InstanceMethodOverloadFactory instanceMethodOverloadFactory = instanceMethodOverloadFactory();

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
    public MethodReturn<ReturnValue> assertReturned(final MethodReturnValueValidator<ReturnValue> validator)
    throws InvalidMethodReturnValueException {
        validator.assertValid(returnValue, methodInvoker.getMethod());

        return this;
    }

    @Override
    public Overload<Object> useMethod(final String methodName) {
        return instanceMethodOverloadFactory.instanceMethodOverload(returnValue, methodName, Object.class);
    }

    @Override
    public ReturnValue get()
    throws ProgramTargetException {
        return returnValue;
    }
}
