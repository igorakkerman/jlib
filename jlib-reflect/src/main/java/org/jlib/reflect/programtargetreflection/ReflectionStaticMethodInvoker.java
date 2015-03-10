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

package org.jlib.reflect.programtargetreflection;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;

import static org.jlib.core.message.MessageUtility.message;
import org.jlib.reflect.programtarget.MethodLookupException;
import org.jlib.reflect.programtarget.MethodInvocationException;
import org.jlib.reflect.programtarget.MethodInvoker;

public class ReflectionStaticMethodInvoker
implements MethodInvoker {

    private final Method method;

    public ReflectionStaticMethodInvoker(final Method method) {
        this.method = method;
    }

    @Override
    public Object invoke(final Object... arguments)
    throws MethodLookupException {
        try {
            return method.invoke(/* static */ null, arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new MethodInvocationException(message(), method.getClass().getName(), method.toString());
        }
    }

    @Override
    public Executable getMethod() {
        return method;
    }
}
