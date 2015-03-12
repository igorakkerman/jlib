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

package org.jlib.reflect.programelement.reflection;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;

import static org.jlib.core.message.MessageUtility.message;
import org.jlib.reflect.programelement.InstanceMethodInvocationException;
import org.jlib.reflect.programelement.MethodLookupException;
import org.jlib.reflect.programelement.MethodInvoker;

public class ReflectionInstanceMethodInvoker
implements MethodInvoker {

    private final Method method;
    private final Object enclosingObject;

    public ReflectionInstanceMethodInvoker(final Method method, final Object enclosingObject) {
        this.method = method;
        this.enclosingObject = enclosingObject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(final Object... arguments)
    throws MethodLookupException {
        try {
            return method.invoke(enclosingObject, arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new InstanceMethodInvocationException(message(), enclosingObject, method.toString());
        }
    }

    @Override
    public Executable getMethod() {
        return method;
    }

    protected Object getEnclosingObject() {
        return enclosingObject;
    }
}
