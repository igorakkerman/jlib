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

package org.jlib.reflect.programelement;

public class MethodReturnValueHolder<ReturnValue> {

    private final ReturnValue returnValue;
    private final String className;
    private final String methodName;
    private final Class<?>[] parameterTypes;

    public MethodReturnValueHolder(final ReturnValue returnValue, final String className, final String methodName,
                                   final Class<?>... parameterTypes) {
        this.returnValue = returnValue;
        this.className = className;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
    }

    public ReturnValue getReturnValue() {
        return returnValue;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }
}