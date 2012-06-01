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
import java.util.NoSuchItemException;
import java.util.Set;

import org.jlib.container.Container;
import org.jlib.container.binaryrelation.AbstractBinaryRelation;
import org.jlib.container.binaryrelation.Association;
import org.jlib.container.binaryrelation.DefaultBinaryRelationTraverser;

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
extends AbstractBinaryRelation<LeftValue, RightValue>
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
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * 
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to a
     *         previously added Association, it is ignored
     */
    public HashBijection(Container<Association<LeftValue, RightValue>> associations)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        super();
        for (Association<LeftValue, RightValue> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBijection containing the Associations contained by the
     * specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     *        
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to a
     *         previously added Association, it is ignored
     */
    public HashBijection(Collection<Association<LeftValue, RightValue>> associations)
    throws ObjectAlreadyAssociatedException {
        super();
        for (Association<LeftValue, RightValue> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBijection containing the Associations specified in a
     * comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     *        
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to a
     *         previously added Association, it is ignored
     */
    public HashBijection(@SuppressWarnings({ "unchecked", /* "varargs" */}) Association<LeftValue, RightValue>... associations)
    throws ObjectAlreadyAssociatedException {
        super();
        for (Association<LeftValue, RightValue> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in
     * this Bijection.
     * 
     * @param leftValue
     *        LeftValue of the Association
     *        
     * @param rightValue
     *        RightValue of the Association
     *        
     * @throws ObjectAlreadyAssociatedException
     *         if {@code leftValue} or {@code rightValue} is already
     *         associated to another Object; an existing Association is ignored
     */
    protected void add(LeftValue leftValue, RightValue rightValue)
    throws ObjectAlreadyAssociatedException {
        if (leftValue == null || rightValue == null)
            throw new NullPointerException();

        if (hasLeft(leftValue)) {
            if (! rightValue.equals(right(leftValue)))
                throw new ObjectAlreadyAssociatedException(this, leftValue);

            return;
        }

        if (hasRight(rightValue)) // and automatically !leftValue.equals(left(rightValue))
            throw new ObjectAlreadyAssociatedException(this, rightValue);

        leftToRightMap.put(leftValue, rightValue);
        rightToLeftMap.put(rightValue, leftValue);
    }

    @Override
    public boolean hasLeft(LeftValue leftValue) {
        return leftToRightMap.containsKey(leftValue);
    }

    @Override
    public boolean hasRight(RightValue rightValue) {
        return rightToLeftMap.containsKey(rightValue);
    }

    @Override
    public RightValue right(LeftValue leftValue) {
        RightValue rightValue = leftToRightMap.get(leftValue);
        if (rightValue != null)
            return rightValue;
        else
            throw new NoSuchItemException(leftValue.toString());
    }

    @Override
    public LeftValue left(RightValue rightValue) {
        LeftValue leftValue = rightToLeftMap.get(rightValue);
        if (leftValue != null)
            return leftValue;
        else
            throw new NoSuchItemException(rightValue.toString());
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
    public Set<LeftValue> leftValues() {
        return Collections.unmodifiableSet(leftToRightMap.keySet());
    }

    @Override
    public Set<RightValue> rightValues() {
        return Collections.unmodifiableSet(rightToLeftMap.keySet());
    }

    @Override
    public Traverser<Association<LeftValue, RightValue>> iterator() {
        return new DefaultBinaryRelationTraverser<LeftValue, RightValue>(this);
    }

    @Override
    public Set<RightValue> rightSet(LeftValue leftValue) {
        return hasLeft(leftValue) ? Collections.singleton(right(leftValue)) : new HashSet<RightValue>();
    }

    @Override
    public Set<LeftValue> leftSet(RightValue rightValue) {
        return hasRight(rightValue) ? Collections.singleton(left(rightValue)) : new HashSet<LeftValue>();
    }

    @Override
    public boolean contains(LeftValue leftValue, RightValue rightValue) {
        return leftToRightMap.get(leftValue).equals(rightValue);
    }
}
