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

import javax.annotation.Nullable;

import org.jlib.core.language.EqualsStrategy;
import org.jlib.core.traverser.Traversable;

import static org.jlib.core.traverser.TraversableUtility.provideEqualItems;

public final class IterativeEqualsOverTraversable<Item>
implements EqualsStrategy<Traversable<Item>> {

    /** sole {@link IterativeEqualsOverTraversable} instance */
    private static final IterativeEqualsOverTraversable<?> INSTANCE = new IterativeEqualsOverTraversable<>();

    /**
     * Returns the sole {@link IterativeEqualsOverTraversable} instance.
     *
     * @param <Item>
     *        type of the Item
     *
     * @return sole {@link IterativeEqualsOverTraversable} instance
     */
    @SuppressWarnings("unchecked")
    public static <Item> IterativeEqualsOverTraversable<Item> getInstance() {
        return (IterativeEqualsOverTraversable<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link IterativeEqualsOverTraversable}.
     */
    private IterativeEqualsOverTraversable() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean areEqual(final Traversable<Item> thisTraversable, @Nullable final Object otherObject) {
        return otherObject instanceof Traversable<?> && //
               provideEqualItems(thisTraversable, (Traversable<Item>) otherObject);
    }
}
