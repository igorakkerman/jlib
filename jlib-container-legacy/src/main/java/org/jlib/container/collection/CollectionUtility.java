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

package org.jlib.container.operation.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.addAll;

/**
 * Utility class providing methods operating on {@link Collection Collections}.
 *
 * @author Igor Akkerman
 */
public final class CollectionUtility {

    /** no visible constructor */
    private CollectionUtility() {
    }

    /**
     * Creates a {@link Set} containing the items of the specified array.
     *
     * @param <SetItem>
     *        type of the items held in the {@link Set}
     *
     * @param <ArrayItem>
     *        type of the items held in the array; subtype of
     *        {@code <SetItem>}
     *
     * @param array
     *        the source array
     *
     * @return Set containing the Items of {@code array}
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public static <SetItem, ArrayItem extends SetItem> Set<SetItem> toSet(final ArrayItem[] array) {
        final Set<SetItem> set = new HashSet<SetItem>(array.length);

        addAll(set, array);

        return set;
    }

    /**
     * Creates a Set containing the items provided by the specified
     * {@link Traversable}.
     *
     * @param <SetItem>
     *        type of the items held in the {@link Set}
     *
     * @param <TraversableItem>
     *        type of the items provided by the {@link Traversable}; subtype of
     *        {@code <SetItem>}
     *
     * @param traversable
     *        the source traversable
     *
     * @return Set containing the Items of {@code traversable}
     */
    public static <SetItem, TraversableItem extends SetItem> Set<SetItem> toSet(
                                                                               final Traversable<TraversableItem> traversable) {
        final Set<SetItem> set = new HashSet<SetItem>();
        for (TraversableItem item : traversable)
            set.add(item);
        return set;
    }

    /**
     * Removes all items from the specified {@link Collection} provided by
     * the specified {@link Traversable}.
     *
     * @param <CollectionItem>
     *        type of the items held in the {@link Collection}
     *
     * @param <RemovedItem>
     *        type of the items removed from the {@link Collection}; subtype
     *        of {@code <CollectionItem>}
     *
     * @param collection
     *        Collection from which {@code items} are removed
     *
     * @param items
     *        {@link Traversable} providing the items to retain
     */
    public static <CollectionItem, RemovedItem extends CollectionItem> void removeAll(
                                                                                     final Collection<CollectionItem> collection,
                                                                                     final Traversable<RemovedItem> items) {
        for (RemovedItem item : items)
            collection.remove(item);
    }
}
