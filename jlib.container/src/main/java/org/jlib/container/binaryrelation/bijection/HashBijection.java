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
import org.jlib.container.binaryrelation.ItemAlreadyAssociatedException;
import org.jlib.container.binaryrelation.LeftItemAlreadyAssociatedException;
import org.jlib.container.binaryrelation.NoSuchLeftValueException;
import org.jlib.container.binaryrelation.NoSuchRightValueException;
import org.jlib.container.binaryrelation.RightItemAlreadyAssociatedException;

/**
 * Bijection implemented using hashing for left and right hand side items.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the bijection
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the bijection
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
     * @throws ItemAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to a
     *         previously added Association, it is ignored
     */
    public HashBijection(final Container<Association<LeftValue, RightValue>> associations)
    throws ItemAlreadyAssociatedException {
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
     * @throws ItemAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to a
     *         previously added Association, it is ignored
     */
    public HashBijection(final Collection<Association<LeftValue, RightValue>> associations)
    throws ItemAlreadyAssociatedException {
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
     * @throws ItemAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to a
     *         previously added Association, it is ignored
     */
    public HashBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws ItemAlreadyAssociatedException {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection}.
     * 
     * @param leftValue
     *        LeftValue of the Association
     * 
     * @param rightValue
     *        RightValue of the Association
     * 
     * @throws ItemAlreadyAssociatedException
     *         if {@code leftValue} or {@code rightValue} is already associated
     *         to another Object; an existing Association is ignored
     */
    @Override
    protected void associate(final LeftValue leftValue, final RightValue rightValue)
    throws ItemAlreadyAssociatedException {
        if (hasLeft(leftValue)) {
            if (!rightValue.equals(getRightValue(leftValue)))
                throw new LeftItemAlreadyAssociatedException(this, leftValue, rightValue);

            return;
        }

        if (hasRight(rightValue)) // and automatically !leftValue.equals(left(rightValue))
            throw new RightItemAlreadyAssociatedException(this, leftValue, rightValue);

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
    public int getSize() {
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
