/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.binaryrelation;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.core.traverser.RemoveTraverser;
sing hashing for left and right hand side
 * associations.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the bijection
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the bijection
 * 
 * @author Igor Akkerman
 */
public class HashAddRemoveBijection<LeftValue, RightValue>
extends HashAddBijection<LeftValue, RightValue>
implements RemoveBinaryRelation<LeftValue, RightValue> {

    /**
     * AddBinaryRelation used as delegate for some methods allowing the
     * {@code HashAddBijection} class to implement the {@link AddBinaryRelation}
     * interface.
     * 
     * @param <DelegateLeftValue>
     *        type of the objects on the left hand side of the BinaryRelation
     * 
     * @param <DelegateRightValue>
     *        type of the objects on the right hand side of the BinaryRelation
     * 
     * @author Igor Akkerman
     */
    private class DelegateBijection<DelegateLeftValue, DelegateRightValue>
    extends AbstractReplaceAddRemoveBinaryRelation<DelegateLeftValue, DelegateRightValue> {

        /** Bijection for which this Bijection is used as delegate */
        private final AddBijection<DelegateLeftValue, DelegateRightValue> baseBijection;

        /**
         * Creates a new DelegateBijection.
         * 
         * @param baseBijection
         *        AddBijection for which this Bijection is used as delegate
         */
        DelegateBijection(final AddBijection<DelegateLeftValue, DelegateRightValue> baseBijection) {
            super();

            this.baseBijection = baseBijection;
        }

        @Override
        public void remove(final DelegateLeftValue leftValue, final DelegateRightValue rightValue) {
            baseBijection.remove(leftValue, rightValue);
        }
    }

    /** DelegateBijection for this Bijection */
    private final DelegateBijection<LeftValue, RightValue> delegateBijection =
        new DelegateBijection<LeftValue, RightValue>(this);

    /** Creates a new initially empty HashAddBijection. */
    public HashAddRemoveBijection() {
        super();
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified jlib Container.
     * 
     * @param associations
     *        Container of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddRemoveBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations contained by
     * the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddRemoveBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    /**
     * Creates a new HashAddBijection containing the Associations specified in a
     * comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects is already associated to another Object; if
     *         an Association is equal to another Associations in the Container,
     *         it is ignored
     */
    public HashAddRemoveBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws ObjectAlreadyAssociatedException {
        super(associations);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue) {
        leftToRightMap.remove(leftValue);
        rightToLeftMap.remove(rightValue);
    }

    @Override
    public RemoveTraverser<Association<LeftValue, RightValue>> iterator() {
        return delegateBijection.iterator();
    }

    @Override
    public void addAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void removeAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.removeAll(associations);
    }

    @Override
    public void removeAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateBijection.removeAll(associations);
    }

    @Override
    public void retainAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.retainAll(associations);
    }

    @Override
    public void retainAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateBijection.retainAll(associations);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association) {
        delegateBijection.add(association);
    }

    @Override
    public void addAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateBijection.addAll(associations);
    }

    @Override
    public void clear() {
        delegateBijection.removeAll();
    }

    @Override
    public void remove(final Association<LeftValue, RightValue> object) {
        delegateBijection.remove(object);
    }

    @Override
    public void removeAll(final Collection<? extends Association<LeftValue, RightValue>> collection) {
        delegateBijection.removeAll(collection);
    }

    @Override
    public void retainAll(final Collection<? extends Association<LeftValue, RightValue>> collection) {
        delegateBijection.retainAll(collection);
    }

}
