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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jlib.container.Container;

/**
 * BinaryRelation implemented using hashing for left and right hand side
 * items.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the BinaryRelation
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the BinaryRelation
 * 
 * @author Igor Akkerman
 */
public class HashBinaryRelation<LeftValue, RightValue>
extends AbstractBinaryRelation<LeftValue, RightValue> {

    /** Map assigning each LeftValue the Set of RightValues associated with it */
    protected Map<LeftValue, Set<RightValue>> leftToRightMap = new HashMap<LeftValue, Set<RightValue>>();

    /** Map assigning each RightValue the Set of LeftValues associated with it */
    protected Map<RightValue, Set<LeftValue>> rightToLeftMap = new HashMap<RightValue, Set<LeftValue>>();

    /**
     * Creates a new initially empty HashBinaryRelation.
     */
    public HashBinaryRelation() {
        super();
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations contained by
     * the specified jlib Container.
     * 
     * @param associations
     *        Container of the Associations to add
     */
    public HashBinaryRelation(Container<Association<LeftValue, RightValue>> associations) {
        super();
        for (Association<LeftValue, RightValue> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations contained by
     * the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     */
    public HashBinaryRelation(Collection<Association<LeftValue, RightValue>> associations) {
        super();
        for (Association<LeftValue, RightValue> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations specified in
     * a comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     */
    public HashBinaryRelation(@SuppressWarnings({ "unchecked", /* "varargs" */}) Association<LeftValue, RightValue>... associations) {
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
     */
    protected void add(LeftValue leftValue, RightValue rightValue) {
        if (leftValue == null || rightValue == null)
            throw new NullPointerException();

        Set<RightValue> rightValueSet;
        if (hasLeft(leftValue))
            rightValueSet = leftToRightMap.get(leftValue);
        else {
            rightValueSet = new HashSet<RightValue>();
            leftToRightMap.put(leftValue, rightValueSet);
        }
        rightValueSet.add(rightValue);

        Set<LeftValue> leftValueSet;
        if (hasRight(rightValue))
            leftValueSet = rightToLeftMap.get(rightValue);
        else {
            leftValueSet = new HashSet<LeftValue>();
            rightToLeftMap.put(rightValue, leftValueSet);
        }

        leftValueSet.add(leftValue);
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
    public Set<LeftValue> leftValues() {
        return leftToRightMap.keySet();
    }

    @Override
    public Set<LeftValue> leftSet(RightValue rightValue) {
        return rightToLeftMap.get(rightValue);
    }

    @Override
    public Set<RightValue> rightValues() {
        return rightToLeftMap.keySet();
    }

    @Override
    public Set<RightValue> rightSet(LeftValue leftValue) {
        return leftToRightMap.get(leftValue);
    }

    @Override
    public int getSize() {
        return leftToRightMap.size();
    }
}
