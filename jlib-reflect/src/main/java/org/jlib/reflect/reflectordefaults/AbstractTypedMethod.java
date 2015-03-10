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

package org.jlib.reflect.reflectordefaults;

import java.lang.reflect.Executable;

import org.jlib.reflect.reflector.TypedMethod;
import org.jlib.reflect.validator.MethodReturnTypeValidator;

public abstract class AbstractTypedMethod<ReturnType, Met extends Executable>
implements TypedMethod<ReturnType> {

    private final Met method;
    private final MethodReturnTypeValidator methodReturnTypeValidator;

    protected AbstractTypedMethod(final Met method, final MethodReturnTypeValidator methodReturnTypeValidator) {
        this.method = method;
        this.methodReturnTypeValidator = methodReturnTypeValidator;
    }

    protected Met getMethod() {
        return method;
    }

    protected MethodReturnTypeValidator getMethodReturnTypeValidator() {
        return methodReturnTypeValidator;
    }
}
