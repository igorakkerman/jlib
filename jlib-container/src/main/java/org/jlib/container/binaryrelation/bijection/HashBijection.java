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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jlib.container.Container;
import org.jlib.container.binaryrelation.AbstractInitializeableBinaryRelation;
import org.jlib.container.binaryrelation.Association;
import org.jlib.container.binaryrelation.InvalidAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.NoSuchLeftValueException;
import org.jlib.container.binaryrelation.NoSuchRightValueException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;

/**
 * {@link Bijection} implemented using hashing for left and right hand side
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
public class HashBijection<LeftValue, RightValue>
extends AbstractInitializeableBinaryRelation<LeftValue, RightValue>
implements Bijection<LeftValue, RightValue> {

    /** Map assigning each LeftValue the RightValue associated with it */
    protected Map<LeftValue, RightValue> leftToRightMap = new HashMap<LeftValue, RightValue>();

    /** Map assigning each RightValue the LeftValue associated with it */
    protected Map<RightValue, LeftValue> rightToLeftMap = new HashMap<RightValue, LeftValue>();

    /**
     * Creates a new empty HashBijection.
     */
    public HashBijection() {
        super();
    }

    /**
     * Creates a new HashBijection containing the Associations contained by the
     * specified jlib Container.
     *
     * @param associations
     *        Container of the Associations to add
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    /**
     * Creates a new HashBijection containing the Associations contained by the
     * specified Collection.
     *
     * @param associations
     *        Collection of the Associations to add
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    /**
     * Creates a new HashBijection containing the Associations specified in a
     * comma separated sequence.
     *
     * @param associations
     *        Comma separated sequence of the Associations to add
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if the LeftValue of one Item in {@code associations} is already
     *         associated to another RightValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if the RightValue of one Item in {@code associations} is already
     *         associated to another LeftValue; if an {@link Association} is
     *         equal to another {@link Association} in the
     *         {@link HashAssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    @SuppressWarnings("unchecked")
    public HashBijection(final Association<LeftValue, RightValue>... associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    @Override
    protected void associate(final LeftValue leftValue, final RightValue rightValue)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, InvalidAssociationException {
        if (contains(leftValue, rightValue))
            throw new AssociationAlreadyContainedException(this, leftValue, rightValue);

        doAssociate(leftValue, rightValue);
    }

    @Override
    protected void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        if (contains(leftValue, rightValue))
            return;

        associate(leftValue, rightValue);
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection} without verifying if the specified {@link Association}
     * already exists.
     *
     * @param leftValue
     *        LeftValue of the {@link Association}
     *
     * @param rightValue
     *        RightValue of the {@link Association}
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if {@code leftValue} is already associated to another RightValue
     *
     * @throws RightValueAlreadyAssociatedException
     *         if {@code rightValue} is already associated to another LeftValue
     *
     * @throws InvalidAssociationException
     *         if some property of the {@code associations} prevents it from
     *         being added
     */
    // InvalidAssociationException may be thrown by subclasses
    protected void doAssociate(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException {
        if (hasLeft(leftValue))
            throw new LeftValueAlreadyAssociatedException(this, leftValue, rightValue);

        if (hasRight(rightValue))
            throw new RightValueAlreadyAssociatedException(this, leftValue, rightValue);

        leftToRightMap.put(leftValue, rightValue);
        rightToLeftMap.put(rightValue, leftValue);
    }

    @Override
    public boolean hasLeft(final LeftValue leftValue) {
        return leftToRightMap.containsKey(leftValue);
    }

    @Override
    public boolean hasRight(final RightValue rightValue) {
        return rightToLeftMap.containsKey(rightValue);
    }

    @Override
    public RightValue getRightValue(final LeftValue leftValue) {
        final RightValue rightValue = leftToRightMap.get(leftValue);

        if (rightValue == null)
            throw new NoSuchLeftValueException(this, leftValue);

        return rightValue;
    }

    @Override
    public LeftValue getLeftValue(final RightValue rightValue) {
        final LeftValue leftValue = rightToLeftMap.get(rightValue);

        if (leftValue == null)
            throw new NoSuchRightValueException(this, rightValue);

        return leftValue;
    }

    @Override
    public String toString() {
        return leftToRightMap.toString();
    }

    @Override
    public int getItemsCount() {
        return rightToLeftMap.size();
    }

    @Override
    public Set<LeftValue> getLeftValues() {
        return Collections.unmodifiableSet(leftToRightMap.keySet());
    }

    @Override
    public Set<RightValue> getRightValues() {
        return Collections.unmodifiableSet(rightToLeftMap.keySet());
    }

    @Override
    public final Set<RightValue> getRightSet(final LeftValue leftValue) {
        return hasLeft(leftValue)
               ? Collections.singleton(getRightValue(leftValue))
               : new HashSet<RightValue>();
    }

    @Override
    public final Set<LeftValue> getLeftSet(final RightValue rightValue) {
        return hasRight(rightValue)
               ? Collections.singleton(getLeftValue(rightValue))
               : new HashSet<LeftValue>();
    }

    @Override
    public boolean contains(final LeftValue leftValue, final RightValue rightValue) {
        return leftToRightMap.get(leftValue).equals(rightValue);
    }
}
