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

package org.jlib.container;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import org.jlib.core.language.HashCode;
import org.jlib.core.traverser.Traversable;

import static org.jlib.core.traverser.TraversableUtility.iterable;

public class ApacheCommonsTraversableHashCode<Item>
implements HashCode<Traversable<Item>> {

    /** sole {@link ApacheCommonsTraversableHashCode} instance */
    private static final ApacheCommonsTraversableHashCode<?> INSTANCE = new ApacheCommonsTraversableHashCode<>();

    /**
     * Returns the sole {@link ApacheCommonsTraversableHashCode} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link ApacheCommonsTraversableHashCode} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> ApacheCommonsTraversableHashCode<Item> getInstance() {
        return (ApacheCommonsTraversableHashCode<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link ApacheCommonsTraversableHashCode}.
     */
    private ApacheCommonsTraversableHashCode() {
        super();
    }

    @Override
    public int getHashCode(final Traversable<Item> items) {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        for (final Item item : iterable(items))
            hashCodeBuilder.append(item);

        return hashCodeBuilder.toHashCode();
    }
}
