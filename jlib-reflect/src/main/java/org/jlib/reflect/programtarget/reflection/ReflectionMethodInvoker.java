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

package org.jlib.reflect.programtarget.reflection;

import java.lang.reflect.Method;

import static org.jlib.core.message.MessageUtility.message;
import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.MethodException;
import org.jlib.reflect.programtarget.MethodInvocationException;

public class ReflectionMethodInvoker
implements MethodInvoker {

    private final Method method;

    public ReflectionMethodInvoker(final Method method) {
        this.method = method;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(final Object object, final Object... arguments)
    throws MethodException {
        try {
            return method.invoke(object, arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new MethodInvocationException(message(), method.getClass().getName(), method.toString());
        }
    }

    @Override
    public Object invokeStatic(final Object... arguments)
    throws MethodException {
        return invoke(/* static */ null, arguments);
    }
}
