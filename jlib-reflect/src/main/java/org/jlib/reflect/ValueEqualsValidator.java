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

public class ValueEqualsValidator<Value>
implements Validator<Value> {

    public static <Value>
    Validator<Value> valueEqualTo(final Value expectedValue) {
        return new ValueEqualsValidator<>(expectedValue);
    }

    private final Value expectedValue;

    public ValueEqualsValidator(final Value expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public void assertValid(final Value value)
    throws InvalidValueException {
        if (! value.equals(expectedValue))
            throw new InvalidValueException();
    }
}
