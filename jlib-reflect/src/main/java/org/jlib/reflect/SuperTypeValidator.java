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

public class SuperTypeValidator<Value, ExpectedSuperType>
implements Validator<Value> {

    public static <Value, ExpectedSuperType> /*
               */ Validator<Value> instanceOf(final Class<ExpectedSuperType> expectedSuperType) {
        return new SuperTypeValidator<>(expectedSuperType);
    }

    private final Class<ExpectedSuperType> superType;

    protected SuperTypeValidator(final Class<ExpectedSuperType> expectedSuperType) {
        this.superType = expectedSuperType;
    }

    @Override
    public void assertValid(final Value value)
    throws InvalidValueException {
        if (! superType.isAssignableFrom(value.getClass()))
            throw new InvalidValueException();
    }
}
