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

import org.jlib.reflect.programtarget.InvalidMethodSignatureException;
import org.jlib.reflect.programtarget.MethodException;

public class ReflectionMethodLookup {

    private final Class<?> clazz;
    private final String methodName;
    private final Class<?>[] parameterTypes;

    public ReflectionMethodLookup(final Class<?> clazz, final String methodName,
                                  final Class<?>... parameterTypes) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
    }

    public Method get()
    throws MethodException {
        try {
            return clazz.getMethod(methodName, parameterTypes);
        }
        catch (final NoSuchMethodException exception) {
            throw new InvalidMethodSignatureException(clazz.getName(), methodName, parameterTypes, exception);
        }
    }
}
