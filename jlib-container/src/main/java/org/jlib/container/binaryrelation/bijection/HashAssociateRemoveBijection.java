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

package org.jlib.container.binaryrelation.bijection;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.binaryrelation.Pair;
import org.jlib.container.binaryrelation.DefaultRemoveBinaryRelationTraverser;
import org.jlib.container.binaryrelation.InvalidAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.NoSuchAssociationValueException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * {@link HashAssociateBijection} allowing the removal of {@link Pair}
 * items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 *
 * @author Igor Akkerman
 */
public class HashAssociateRemoveBijection<LeftValue, RightValue>
extends HashAssociateBijection<LeftValue, RightValue>
implements RemoveBijection<LeftValue, RightValue> {

    /** Creates a new initially empty HashAddBijection. */
    public HashAssociateRemoveBijection() {
        super();
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified jlib Container.
     *
     * @param associations
     *        Container of the Associations to add
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAssociateRemoveBijection(final Container<Pair<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified Collection.
     *
     * @param pairs
     *        Collection of the Associations to add
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code pairs} is already
     *         associated to another RightValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code pairs} is already
     *         associated to another LeftValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of one Item in {@code pairs} prevents it
     *         from being added
     */
    public HashAssociateRemoveBijection(final Collection<Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        super(pairs);
    }

    /**
     * Creates a new HashAddBijection containing the Associations specified in a
     * comma separated sequence.
     *
     * @param pairs
     *        Comma separated sequence of the Associations to add
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code pairs} is already
     *         associated to another RightValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code pairs} is already
     *         associated to another LeftValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of one Item in {@code pairs} prevents it
     *         from being added
     */
    @SuppressWarnings("unchecked")
    public HashAssociateRemoveBijection(final Pair<LeftValue, RightValue>... pairs)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        super(pairs);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue)
    throws NoSuchAssociationValueException {
        leftToRightMap.remove(leftValue);
        rightToLeftMap.remove(rightValue);
    }

    @Override
    public void remove(final Pair<LeftValue, RightValue> pair) {
        remove(pair.getLeftValue(), pair.getRightValue());
    }

    @Override
    public void removeAll() {
        ContainerUtility.remove(this, this);
    }

    @Override
    public void remove(final Iterable<? extends Pair<LeftValue, RightValue>> associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    public void remove(final Container<? extends Pair<LeftValue, RightValue>> associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    public void remove(final Collection<? extends Pair<LeftValue, RightValue>> associations) {
        ContainerUtility.remove(this, associations);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Pair<LeftValue, RightValue>... pairs) {
        ContainerUtility.remove(this, pairs);
    }

    @Override
    public void retain(final Container<? extends Pair<LeftValue, RightValue>> associations) {
        ContainerUtility.retain(this, associations);
    }

    @Override
    public void retain(final Collection<? extends Pair<LeftValue, RightValue>> associations) {
        ContainerUtility.retain(this, associations);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Pair<LeftValue, RightValue>... pairs) {
        ContainerUtility.retain(this, pairs);
    }

    @Override
    public RemoveTraverser<Pair<LeftValue, RightValue>> createTraverser() {
        return new DefaultRemoveBinaryRelationTraverser<>(this);
    }
}
