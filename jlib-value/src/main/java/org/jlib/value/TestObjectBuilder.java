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

package org.jlib.value;

public abstract class TestObjectBuilder<TestObject, Self extends Builder<TestObject, Self>>
    extends Builder<TestObject, Self> {

    /**
     * Initializes the built {@link TestObject} with common values to reduce boilerplate code in unit tests.
     * Should be overridden by concrete implementations.
     *
     * @return this {@link TestObjectBuilder}
     */
    public TestObjectBuilder<TestObject, Self> withCommonValues() {
        return this;
    }
}
