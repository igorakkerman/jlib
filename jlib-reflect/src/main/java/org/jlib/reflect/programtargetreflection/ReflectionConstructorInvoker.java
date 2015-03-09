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

import java.lang.reflect.Constructor;

import static org.jlib.core.message.MessageUtility.message;
import org.jlib.reflect.programtarget.ConstructorInvocationException;
import org.jlib.reflect.programtarget.MethodInvocationException;
import org.jlib.reflect.programtarget.MethodInvoker;

public class ReflectionConstructorInvoker<Obj>
implements MethodInvoker {

    private final Constructor<Obj> constructor;

    public ReflectionConstructorInvoker(final Constructor<Obj> constructor) {
        this.constructor = constructor;
    }

    @Override
    public Object invoke(final Object... arguments)
    throws MethodInvocationException {
        try {
            return constructor.newInstance(arguments);
        }
        catch (final ReflectiveOperationException exception) {
            throw new ConstructorInvocationException(message(), constructor);
        }
    }

    public Constructor<Obj> getConstructor() {
        return constructor;
    }
}
