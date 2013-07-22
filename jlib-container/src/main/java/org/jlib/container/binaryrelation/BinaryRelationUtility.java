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

package org.jlib.container.binaryrelation;

import java.util.Collection;
import java.util.Set;

import org.jlib.core.array.ArrayUtility;
import org.jlib.core.traverser.InvalidTraversibleArgumentException;
import org.jlib.core.traverser.RemoveTraverser;

import org.jlib.container.binaryrelation.bijection.PairAlreadyContainedException;

import static org.jlib.container.collection.CollectionUtility.toSet;

/**
 * Facade utility for {@link BinaryRelation} creation and operations.
 *
 * @author Igor Akkerman
 */
public class BinaryRelationUtility {

    /** no visible constructor */
    private BinaryRelationUtility() {
    }

    /**
     * Adds the specified Pair to the specified
     * {@link AddBinaryRelation} that does not yet contain the
     * Pair.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AddBinaryRelation} to which the Pair is
     *        added
     *
     * @param pair
     *        added Pair
     *
     * @throws PairAlreadyContainedException
     *         if {@code binaryRelation} already contains {@code pair}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of {@code pair} prevents it from being
     *         added to {@code binaryRelation}
     */
    public static <LeftValue, RightValue> /*
               */ void associate(final AddBinaryRelation<LeftValue, RightValue> binaryRelation,
                                 final Pair<LeftValue, RightValue> pair)
    throws PairAlreadyContainedException, InvalidTraversibleArgumentException {

        if (binaryRelation.contains(pair))
            throw new PairAlreadyContainedException(binaryRelation, pair);

        binaryRelation.ensureContained(pair);
    }

    /**
     * Adds all {@link Pair}s provided by the specified {@link Iterable} to the specified {@link AddBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param <Pairs>
     *        type of the {@link Iterable} containing the {@link Pair}
     *        items
     *
     * @param binaryRelation
     *        {@link AddBinaryRelation} to which the Pairs are
     *        added
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to add
     *
     * @throws PairAlreadyContainedException
     *         if {@code binaryRelation} already contains one Pair in
     *         {@code pairs}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of one Pair in {@code pairs}
     *         prevents it from being added to {@code binaryRelation}
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public static <LeftValue, RightValue, Pairs extends Iterable<? extends Pair<LeftValue, RightValue>>> /*
               */ void add(final AddBinaryRelation<LeftValue, RightValue> binaryRelation, final Pairs pairs) {

        for (final Pair<LeftValue, RightValue> pair : pairs)
            binaryRelation.add(pair);
    }

    /**
     * Adds all Pairs in the specified comma separated sequence to the
     * specified {@link AddBinaryRelation}.
     *
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AddBinaryRelation} to which the Pairs are
     *        added
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to add
     *
     * @throws PairAlreadyContainedException
     *         if {@code binaryRelation} already contains one Pair in
     *         {@code pairs}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of one Pair in {@code pairs}
     *         prevents it from being added to {@code binaryRelation}
     */
    @SafeVarargs
    public static <LeftValue, RightValue> /*
               */ void add(final AddBinaryRelation<LeftValue, RightValue> binaryRelation,
                           final Pair<LeftValue, RightValue>... pairs) {
        add(binaryRelation, ArrayUtility.iterable(pairs));
    }

    /**
     * Ensures that the specified {@link AddBinaryRelation} contains the
     * specified Pairs. If the {@link AddBinaryRelation} does not
     * contain the Pair, it is added.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AddBinaryRelation} to which the Pairs are
     *        added
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to add
     */
    public static <LeftValue, RightValue> /*
               */ void ensureContained(final AddBinaryRelation<LeftValue, RightValue> binaryRelation,
                                       final Iterable<? extends Pair<LeftValue, RightValue>> pairs) {

        for (final Pair<LeftValue, RightValue> newPair : pairs)
            binaryRelation.ensureContained(newPair);
    }

    /**
     * Ensures that the specified {@link AddBinaryRelation} contains the
     * specified Pairs. If the {@link AddBinaryRelation} does not
     * contain the Pair, it is added.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AddBinaryRelation} to which the Pairs are
     *        added
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to add
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void ensureContained(
                                                              final AddBinaryRelation<LeftValue, RightValue> binaryRelation,
                                                              final Pair<LeftValue, RightValue>... pairs) {
        ensureContained(binaryRelation, ArrayUtility.iterable(pairs));
    }

    /**
     * Removes all Pairs provided by the specified {@link Iterable} from
     * the specified {@link RemoveBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Pairs
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to remove
     */
    public static <LeftValue, RightValue> /*
               */ void remove(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation,
                              final Iterable<? extends Pair<LeftValue, RightValue>> pairs) {

        for (final Pair<LeftValue, RightValue> pair : pairs)
            binaryRelation.remove((Pair<LeftValue, RightValue>) pair);
    }

    /**
     * Removes all Pairs in the specified comma separated sequence from
     * the specified {@link RemoveBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Pairs
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to remove
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void remove(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation,
                                                      final Pair<LeftValue, RightValue>... pairs) {
        remove(binaryRelation, ArrayUtility.iterable(pairs));
    }

    /**
     * Removes all Pairs from the specified {@link AddBinaryRelation} <em>except</em> the Pairs provided by the
     * specified {@link Iterable}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Pairs to remove
     *
     * @param pairs
     *        {@link Iterable} providing the Pairs to retain
     */
    public static <LeftValue, RightValue> /*
               */ void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation,
                              final Iterable<? extends Pair<LeftValue, RightValue>> pairs) {

        final Set<Pair<LeftValue, RightValue>> retainedPairsSet = toSet(pairs);

        final RemoveTraverser<Pair<LeftValue, RightValue>> binaryRelationTraverser = binaryRelation.createTraverser();

        while (binaryRelationTraverser.isNextItemAccessible())
            if (! retainedPairsSet.contains(binaryRelationTraverser.getNextItem()))
                binaryRelationTraverser.remove();
    }

    /**
     * Removes all Pairs from the specified
     * {@link AddBinaryRelation} <em>except</em> for the Pairs
     * contained by the specified {@link Collection}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Pairs to remove
     *
     * @param pairs
     *        {@link Collection} containing the Pairs to retain
     */
    public static <LeftValue, RightValue> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation,
                                                      final Collection<? extends Pair<LeftValue, RightValue>> pairs) {
        final RemoveTraverser<Pair<LeftValue, RightValue>> pairsTraverser = binaryRelation.createTraverser();

        while (pairsTraverser.isNextItemAccessible())
            if (! pairs.contains(pairsTraverser.getNextItem()))
                pairsTraverser.remove();
    }

    /**
     * Removes all Pairs from the specified
     * {@link AddBinaryRelation} <em>except</em> for the Pairs
     * contained by the specified {@link Collection}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param <RetainedPair>
     *        type of the retained {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Pairs to remove
     *
     * @param pairs
     *        {@link Collection} containing the Pairs to retain
     */
    @SafeVarargs
    public static <LeftValue, RightValue, RetainedPair extends Pair<LeftValue, RightValue>> /*
               */ void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation,
                              final RetainedPair... pairs) {
        // necessary as we need the contains() method for the pairs sequence
        retain(binaryRelation, toSet(pairs));
    }
}
