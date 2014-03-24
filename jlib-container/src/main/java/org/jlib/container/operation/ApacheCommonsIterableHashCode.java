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

package org.jlib.container.operation;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.jlib.core.language.operation.HashCode;

public class ApacheCommonsIterableHashCode<Item>
implements HashCode<Iterable<Item>> {

    /** sole {@link ApacheCommonsIterableHashCode} instance */
    private static final ApacheCommonsIterableHashCode<?> INSTANCE = new ApacheCommonsIterableHashCode<>();

    /**
     * Returns the sole {@link ApacheCommonsIterableHashCode} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link ApacheCommonsIterableHashCode} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> ApacheCommonsIterableHashCode<Item> getInstance() {
        return (ApacheCommonsIterableHashCode<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link ApacheCommonsIterableHashCode}.
     */
    private ApacheCommonsIterableHashCode() {
    }

    @Override
    public int hashCode(final Iterable<Item> items) {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        for (final Item item : items)
            hashCodeBuilder.append(item);

        return hashCodeBuilder.toHashCode();
    }
}
