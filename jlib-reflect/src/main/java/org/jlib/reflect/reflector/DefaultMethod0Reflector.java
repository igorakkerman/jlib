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

package org.jlib.reflect.reflector;

import java.lang.reflect.Method;

import org.jlib.reflect.programtarget.MethodException;
import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.NoSubtypeException;
import static org.jlib.reflect.reflector.Reflectors.factory;
import org.jlib.reflect.validator.MethodReturnTypeValidator;

public class DefaultMethod0Reflector<ReturnValue>
implements Method0Reflector<ReturnValue> {

    private final MethodInvoker methodInvoker;
    private final MethodReturnTypeValidator methodReturnTypeValidator;
    private final Object methodEnclosingObject;

    public DefaultMethod0Reflector(final MethodInvoker methodInvoker, final MethodReturnTypeValidator methodReturnTypeValidator,
                                   final Object methodEnclosingObject) {
        this.methodInvoker = methodInvoker;
        this.methodReturnTypeValidator = methodReturnTypeValidator;
        this.methodEnclosingObject = methodEnclosingObject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturnValueReflector<ReturnValue> invoke()
    throws MethodException {
        return factory().methodReturnValueReflector(this);
    }

    @Override
    public Method0Reflector<ReturnValue> assertReturns(final Class<ReturnValue> staticReturnSuperType)
    throws NoSubtypeException {
        methodReturnTypeValidator.assertReturns(staticReturnSuperType);

        return this;
    }

    @Override
    public Method get()
    throws MethodException {
        // FIXME: implement
        return null;
    }
}
