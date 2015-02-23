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

package org.jlib.core.reflection.reflector;

import java.lang.reflect.Method;

import org.jlib.core.classinstance.InvalidMethodException;

public class DefaultMethodResultReflector<ReturnValue, MethRef extends MethodReflector<ReturnValue, MethRef>>
implements MethodResultReflector<ReturnValue> {

    private final MethRef methodReflector;

    public DefaultMethodResultReflector(final MethRef methodReflector) {
        this.methodReflector = methodReflector;
    }

    @Override
    public <ExpectedReturnSuperType> /*
        */ MethodResultReflector<ReturnValue> ensure(final ResultValidator<ReturnValue> resultValidator)
    throws InvalidResultException, InvalidMethodException {
        final Method method = getMethodReflector().get();
        resultValidator.ensureValid(method);
        return this;
    }

    @Override
    public void ensure(final ResultValidator<ReturnType> resultValidator)
    throws InvalidResultException {
        resultValidator.ensureValid(get());
    }

    public MethodReflector<ReturnValue> getMethodReflector() {
        return methodReflector;
    }
}
