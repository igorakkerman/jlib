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

package org.jlib.reflect;

import java.util.ArrayList;
import java.util.List;

public class ValidatingMethodResultReflector<ReturnValue>
implements MethodResultReflector<ReturnValue> {

    private final List<Validator<ReturnValue>> validators = new ArrayList<>();
    private final Invoker<ReturnValue> invoker;

    public ValidatingMethodResultReflector(final Invoker<ReturnValue> invoker) {
        this.invoker = invoker;
    }

    @Override
    public final ReturnValue get()
    throws InvalidValueException, InvalidMethodException {
        final ReturnValue returnValue = invoker.invoke();

        assertValid(returnValue);

        return returnValue;
    }

    @Override
    public MethodResultReflector<ReturnValue> assertReturned(final Validator<ReturnValue> validator)
    throws InvalidValueException {
        validators.add(validator);

        return this;
    }

    private void assertValid(final ReturnValue returnValue)
    throws InvalidValueException {
        for (final Validator<ReturnValue> validator : validators)
            validator.assertValid(returnValue);
    }
}
