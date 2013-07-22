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

import org.jlib.container.binaryrelation.bijection.AssociationAlreadyContainedException;
import org.jlib.container.collection.CollectionUtility;
import org.jlib.core.array.ArrayUtility;
import org.jlib.core.traverser.RemoveTraverser;

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
     * {@link AssociateBinaryRelation} that does not yet contain the
     * Pair.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Pair is
     *        associated
     *
     * @param pair
     *        associated Pair
     *
     * @throws AssociationAlreadyContainedException
     *         if {@code binaryRelation} already contains {@code pair}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of {@code pair} prevents it from being
     *         associated to {@code binaryRelation}
     */
    public static <LeftValue, RightValue> void associate(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Pair<LeftValue, RightValue> pair)
    throws AssociationAlreadyContainedException, InvalidBinaryRelationArgumentException {
        if (binaryRelation.contains(pair))
            throw new AssociationAlreadyContainedException(binaryRelation, pair.getLeftValue(),
                                                           pair.getRightValue());
        binaryRelation.assertContained(pair);
    }

    /**
     * Adds all Associations provided by the specified {@link Iterable} to the
     * specified {@link AssociateBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param <Associations>
     *        type of the {@link Iterable} containing the {@link Pair}
     *        items
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param associations
     *        {@link Iterable} providing the Associations to associate
     *
     * @throws AssociationAlreadyContainedException
     *         if {@code binaryRelation} already contains one Pair in
     *         {@code associations}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of one Pair in {@code associations}
     *         prevents it from being associated to {@code binaryRelation}
     */
    // @formatter:off
    public static <LeftValue, RightValue, Associations extends Iterable<? extends Pair<LeftValue, RightValue>>> void associate(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Associations associations) {
        // @formatter:on
        for (final Pair<LeftValue, RightValue> pair : associations)
            binaryRelation.associate(pair);
    }

    /**
     * Adds all Associations in the specified comma separated sequence to the
     * specified {@link AssociateBinaryRelation}.
     *
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param pairs
     *        {@link Iterable} providing the Associations to associate
     *
     * @throws AssociationAlreadyContainedException
     *         if {@code binaryRelation} already contains one Pair in
     *         {@code pairs}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of one Pair in {@code pairs}
     *         prevents it from being associated to {@code binaryRelation}
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void associate(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Pair<LeftValue, RightValue>... pairs) {
        associate(binaryRelation, ArrayUtility.iterable(pairs));
    }

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains the
     * specified Associations. If the {@link AssociateBinaryRelation} does not
     * contain the Pair, it is associated.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param associations
     *        {@link Iterable} providing the Associations to associate
     */
    public static <LeftValue, RightValue> void assertContained(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Iterable<? extends Pair<LeftValue, RightValue>> associations) {
        for (final Pair<LeftValue, RightValue> newPair : associations)
            binaryRelation.assertContained(newPair);
    }

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains the
     * specified Associations. If the {@link AssociateBinaryRelation} does not
     * contain the Pair, it is associated.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param pairs
     *        {@link Iterable} providing the Associations to associate
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void assertContained(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Pair<LeftValue, RightValue>... pairs) {
        assertContained(binaryRelation, ArrayUtility.iterable(pairs));
    }

    /**
     * Removes all Associations provided by the specified {@link Iterable} from
     * the specified {@link RemoveBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations
     *
     * @param associations
     *        {@link Iterable} providing the Associations to remove
     */
    public static <LeftValue, RightValue> void remove(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Iterable<? extends Pair<LeftValue, RightValue>> associations) {
        for (final Pair<LeftValue, RightValue> pair : associations)
            binaryRelation.remove(pair);
    }

    /**
     * Removes all Associations in the specified comma separated sequence from
     * the specified {@link RemoveBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations
     *
     * @param pairs
     *        {@link Iterable} providing the Associations to remove
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void remove(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Pair<LeftValue, RightValue>... pairs) {
        remove(binaryRelation, ArrayUtility.iterable(pairs));
    }

    /**
     * Removes all Associations from the specified
     * {@link AssociateBinaryRelation} <em>except</em> the Associations provided
     * by the specified {@link Iterable}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations to remove
     *
     * @param associations
     *        {@link Iterable} providing the Associations to retain
     */
    public static <LeftValue, RightValue> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Iterable<? extends Pair<LeftValue, RightValue>> associations) {
        final Set<Pair<LeftValue, RightValue>> retainedAssociationsSet = CollectionUtility.toSet(associations);

        final RemoveTraverser<Pair<LeftValue, RightValue>> binaryRelationTraverser = binaryRelation.createTraverser();

        while (binaryRelationTraverser.isNextItemAccessible())
            if (! retainedAssociationsSet.contains(binaryRelationTraverser.getNextItem()))
                binaryRelationTraverser.remove();
    }

    /**
     * Removes all Associations from the specified
     * {@link AssociateBinaryRelation} <em>except</em> for the Associations
     * contained by the specified {@link Collection}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations to remove
     *
     * @param associations
     *        {@link Collection} containing the Associations to retain
     */
    public static <LeftValue, RightValue> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Collection<? extends Pair<LeftValue, RightValue>> associations) {
        final RemoveTraverser<Pair<LeftValue, RightValue>> associationsTraverser = binaryRelation.createTraverser();

        while (associationsTraverser.isNextItemAccessible())
            if (! associations.contains(associationsTraverser.getNextItem()))
                associationsTraverser.remove();
    }

    /**
     * Removes all Associations from the specified
     * {@link AssociateBinaryRelation} <em>except</em> for the Associations
     * contained by the specified {@link Collection}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Pair}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Pair}
     *
     * @param <RetainedAssociation>
     *        type of the retained {@link Pair}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations to remove
     *
     * @param associations
     *        {@link Collection} containing the Associations to retain
     */
    @SafeVarargs
    public static <LeftValue, RightValue, RetainedAssociation extends Pair<LeftValue, RightValue>> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final RetainedAssociation... associations) {
        // necessary as we need the contains() method fot the associations sequence
        retain(binaryRelation, CollectionUtility.toSet(associations));
    }
}
