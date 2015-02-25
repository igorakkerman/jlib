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

import java.util.ArrayList;
import java.util.List;

import org.jlib.reflect.programtarget.InvalidMethodReturnValueException;
import org.jlib.reflect.programtarget.MethodReturnValueSupplier;
import org.jlib.reflect.programtarget.ProgramTargetException;
import org.jlib.reflect.validator.MethodReturnValueValidator;

public class ValidatingMethodReturnValueReflector<ReturnValue>
implements MethodReturnValueReflector<ReturnValue> {

    private final MethodReturnValueSupplier<ReturnValue> returnValueSupplier;
    private final List<MethodReturnValueValidator<ReturnValue>> validators = new ArrayList<>();

    public ValidatingMethodReturnValueReflector(final MethodReturnValueSupplier<ReturnValue> returnValueSupplier) {
        this.returnValueSupplier = returnValueSupplier;
    }

    @Override
    public final ReturnValue get()
    throws ProgramTargetException {
        final ReturnValue returnValue = returnValueSupplier.get();

        assertValid(returnValue);

        return returnValue;
    }

    @Override
    public MethodReturnValueReflector<ReturnValue> assertReturned(final MethodReturnValueValidator<ReturnValue> validator)
    throws InvalidMethodReturnValueException {
        validators.add(validator);

        return this;
    }

    private void assertValid(final ReturnValue returnValue)
    throws ProgramTargetException {
        for (final MethodReturnValueValidator<ReturnValue> validator : validators)
            validator.assertValid(returnValue);
    }
}
