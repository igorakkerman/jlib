/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.container.operation.sequence;

public final class EmptySequence<Item>
extends InitiallyEmptySequence<Item> {

    /** sole {@link EmptySequence} instance */
    private static final EmptySequence<?> INSTANCE = new EmptySequence<Object>();

    /**
     * Returns the sole {@link EmptySequence} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link EmptySequence} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequence<Item> getInstance() {
        return (EmptySequence<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequence}.
     */
    private EmptySequence() {
        super();
    }
}
