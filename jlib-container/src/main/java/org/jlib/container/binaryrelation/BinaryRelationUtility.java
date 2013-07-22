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
     * Adds the specified Association to the specified
     * {@link AssociateBinaryRelation} that does not yet contain the
     * Association.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Association is
     *        associated
     *
     * @param association
     *        associated Association
     *
     * @throws AssociationAlreadyContainedException
     *         if {@code binaryRelation} already contains {@code association}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of {@code association} prevents it from being
     *         associated to {@code binaryRelation}
     */
    public static <LeftValue, RightValue> void associate(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Association<LeftValue, RightValue> association)
    throws AssociationAlreadyContainedException, InvalidBinaryRelationArgumentException {
        if (binaryRelation.contains(association))
            throw new AssociationAlreadyContainedException(binaryRelation, association.getLeftValue(),
                                                           association.getRightValue());
        binaryRelation.assertContained(association);
    }

    /**
     * Adds all Associations provided by the specified {@link Iterable} to the
     * specified {@link AssociateBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param <Associations>
     *        type of the {@link Iterable} containing the {@link Association}
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
     *         if {@code binaryRelation} already contains one Association in
     *         {@code associations}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of one Association in {@code associations}
     *         prevents it from being associated to {@code binaryRelation}
     */
    // @formatter:off
    public static <LeftValue, RightValue, Associations extends Iterable<? extends Association<LeftValue, RightValue>>> void associate(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Associations associations) {
        // @formatter:on
        for (final Association<LeftValue, RightValue> association : associations)
            binaryRelation.associate(association);
    }

    /**
     * Adds all Associations in the specified comma separated sequence to the
     * specified {@link AssociateBinaryRelation}.
     *
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param associations
     *        {@link Iterable} providing the Associations to associate
     *
     * @throws AssociationAlreadyContainedException
     *         if {@code binaryRelation} already contains one Association in
     *         {@code associations}
     *
     * @throws InvalidBinaryRelationArgumentException
     *         if some property of one Association in {@code associations}
     *         prevents it from being associated to {@code binaryRelation}
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void associate(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Association<LeftValue, RightValue>... associations) {
        associate(binaryRelation, ArrayUtility.iterable(associations));
    }

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains the
     * specified Associations. If the {@link AssociateBinaryRelation} does not
     * contain the Association, it is associated.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param associations
     *        {@link Iterable} providing the Associations to associate
     */
    public static <LeftValue, RightValue> void assertContained(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Iterable<? extends Association<LeftValue, RightValue>> associations) {
        for (final Association<LeftValue, RightValue> newAssociation : associations)
            binaryRelation.assertContained(newAssociation);
    }

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains the
     * specified Associations. If the {@link AssociateBinaryRelation} does not
     * contain the Association, it is associated.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link AssociateBinaryRelation} to which the Associations are
     *        associated
     *
     * @param associations
     *        {@link Iterable} providing the Associations to associate
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void assertContained(final AssociateBinaryRelation<LeftValue, RightValue> binaryRelation, final Association<LeftValue, RightValue>... associations) {
        assertContained(binaryRelation, ArrayUtility.iterable(associations));
    }

    /**
     * Removes all Associations provided by the specified {@link Iterable} from
     * the specified {@link RemoveBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations
     *
     * @param associations
     *        {@link Iterable} providing the Associations to remove
     */
    public static <LeftValue, RightValue> void remove(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Iterable<? extends Association<LeftValue, RightValue>> associations) {
        for (final Association<LeftValue, RightValue> association : associations)
            binaryRelation.remove(association);
    }

    /**
     * Removes all Associations in the specified comma separated sequence from
     * the specified {@link RemoveBinaryRelation}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations
     *
     * @param associations
     *        {@link Iterable} providing the Associations to remove
     */
    @SafeVarargs
    public static <LeftValue, RightValue> void remove(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Association<LeftValue, RightValue>... associations) {
        remove(binaryRelation, ArrayUtility.iterable(associations));
    }

    /**
     * Removes all Associations from the specified
     * {@link AssociateBinaryRelation} <em>except</em> the Associations provided
     * by the specified {@link Iterable}.
     *
     * @param <LeftValue>
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations to remove
     *
     * @param associations
     *        {@link Iterable} providing the Associations to retain
     */
    public static <LeftValue, RightValue> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Iterable<? extends Association<LeftValue, RightValue>> associations) {
        final Set<Association<LeftValue, RightValue>> retainedAssociationsSet = CollectionUtility.toSet(associations);

        final RemoveTraverser<Association<LeftValue, RightValue>> binaryRelationTraverser = binaryRelation.createTraverser();

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
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations to remove
     *
     * @param associations
     *        {@link Collection} containing the Associations to retain
     */
    public static <LeftValue, RightValue> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final Collection<? extends Association<LeftValue, RightValue>> associations) {
        final RemoveTraverser<Association<LeftValue, RightValue>> associationsTraverser = binaryRelation.createTraverser();

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
     *        type of the left value of the {@link Association}
     *
     * @param <RightValue>
     *        type of the right value of the {@link Association}
     *
     * @param <RetainedAssociation>
     *        type of the retained {@link Association}
     *
     * @param binaryRelation
     *        {@link RemoveBinaryRelation} containing the Associations to remove
     *
     * @param associations
     *        {@link Collection} containing the Associations to retain
     */
    @SafeVarargs
    public static <LeftValue, RightValue, RetainedAssociation extends Association<LeftValue, RightValue>> void retain(final RemoveBinaryRelation<LeftValue, RightValue> binaryRelation, final RetainedAssociation... associations) {
        // necessary as we need the contains() method fot the associations sequence
        retain(binaryRelation, CollectionUtility.toSet(associations));
    }
}
