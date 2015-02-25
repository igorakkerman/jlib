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

public class DefaultMethod0Reflector<ReturnType>
implements Method0Reflector<ReturnType> {

    private final MethodInvoker methodInvoker;
    private final Object methodEnclosingObject;

    public DefaultMethod0Reflector(final MethodInvoker methodInvoker, final Object methodEnclosingObject) {
        this.methodInvoker = methodInvoker;
        this.methodEnclosingObject = methodEnclosingObject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturnValueReflector<ReturnType> invoke()
    throws MethodException {
        return (MethodReturnValueReflector<ReturnType>) methodInvoker.invoke(methodEnclosingObject);
    }

    @Override
    public Method0Reflector<ReturnType> assertReturns(final Class<ReturnType> staticReturnSuperType)
    throws NoSubtypeException {
        return null;
    }

    @Override
    public Method get()
    throws MethodException {
        return null;
    }
}
