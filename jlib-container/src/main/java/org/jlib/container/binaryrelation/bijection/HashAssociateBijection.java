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

import org.jlib.container.Container;
import org.jlib.container.binaryrelation.Association;
import org.jlib.container.binaryrelation.BinaryRelationUtility;
import org.jlib.container.binaryrelation.IllegalAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;

import java.util.Collection;

/**
 * {@link HashBijection} allowing the addition of new {@link Association} items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 *
 * @author Igor Akkerman
 */
public class HashAssociateBijection<LeftValue, RightValue>
extends HashBijection<LeftValue, RightValue>
implements AssociateBijection<LeftValue, RightValue> {

    /** Creates a new initially empty HashAddBijection. */
    public HashAssociateBijection() {
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
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAssociateBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified Collection.
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
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    public HashAssociateBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations specified in a
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
     * @throws IllegalAssociationException
     *         if some property of one Item in {@code associations} prevents it
     *         from being added
     */
    @SuppressWarnings("unchecked")
    public HashAssociateBijection(final Association<LeftValue, RightValue>... associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super(associations);
    }

    @Override
    // raising visibility from protected to public
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, IllegalAssociationException {
        super.associate(leftValue, rightValue);
    }

    @Override
    // raising visibility from protected to public
    public void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        super.assertAssociated(leftValue, rightValue);
    }

    @Override
    public void associate(final Association<LeftValue, RightValue> association)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, IllegalAssociationException {
        associate(association.getLeftValue(), association.getRightValue());
    }

    @Override
    public void associate(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.associate(this, associations);
    }

    @Override
    public void associate(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.associate(this, associations);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void associate(final Association<LeftValue, RightValue>... associations)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.associate(this, associations);
    }

    @Override
    public void assertContained(final Association<LeftValue, RightValue> association)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.assertContained(this, association);
    }

    @Override
    public void assertContained(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.assertContained(this, associations);
    }

    @Override
    public void assertContained(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.assertContained(this, associations);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void assertContained(final Association<LeftValue, RightValue>... associations)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, IllegalAssociationException {
        BinaryRelationUtility.assertContained(this, associations);
    }
}
