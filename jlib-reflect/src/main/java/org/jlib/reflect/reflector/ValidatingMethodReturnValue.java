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

import org.jlib.reflect.programtarget.InvalidMethodReturnValueException;
import org.jlib.reflect.programtarget.ProgramTargetException;
import org.jlib.reflect.programtarget.reflect_new.MethodReturn;
import org.jlib.reflect.validator.MethodReturnValueValidator;
import static org.jlib.reflect.validator.Validators.assertValid;

public class ValidatingMethodReturnValue<ReturnValue>
implements MethodReturn<ReturnValue> {

    private final ReturnValue returnValue;
    private final Method method;

    public ValidatingMethodReturnValue(final ReturnValue returnValue, final Method method) {
        this.returnValue = returnValue;
        this.method = method;
    }

    @Override
    public final ReturnValue get()
    throws ProgramTargetException {
        return returnValue;
    }

    @Override
    public MethodReturn<ReturnValue>
    assertReturned(final MethodReturnValueValidator<ReturnValue> validator)
    throws InvalidMethodReturnValueException {
        assertValid(validator, returnValue, method);

        return this;
    }
}
