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
 * {@link BinaryRelation} implemented using hashing for left and right hand side
 * items.
 * 
 * @param <LeftValue>
 *        type of the items on the left hand side of the {@link BinaryRelation}
 * 
 * @param <RightValue>
 *        type of the items on the right hand side of the {@link BinaryRelation}
 * 
 * @author Igor Akkerman
 */
public class HashBinaryRelation<LeftValue, RightValue>
extends AbstractInitializeableBinaryRelation<LeftValue, RightValue> {

    /**
     * {@link Map} assigning each LeftValue the {@link Set} of RightValue items
     * associated with it
     */
    protected Map<LeftValue, Set<RightValue>> leftToRightMap = new HashMap<LeftValue, Set<RightValue>>();

    /**
     * {@link Map} assigning each RightValue the Set of LeftValue items
     * associated with it
     */
    protected Map<RightValue, Set<LeftValue>> rightToLeftMap = new HashMap<RightValue, Set<LeftValue>>();

    /**
     * Creates a new initially empty {@link HashBinaryRelation}.
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
    public HashBinaryRelation(final Container<Association<LeftValue, RightValue>> associations) {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations contained by
     * the specified Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     */
    public HashBinaryRelation(final Collection<Association<LeftValue, RightValue>> associations) {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations specified in
     * a comma separated sequence.
     * 
     * @param associations
     *        Comma separated sequence of the Associations to add
     */
    public HashBinaryRelation(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        super();

        for (final Association<LeftValue, RightValue> association : associations)
            associate(association.getLeftValue(), association.getRightValue());
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link HashBinaryRelation}.
     * 
     * @param leftValue
     *        LeftValue of the Association
     * 
     * @param rightValue
     *        RightValue of the Association
     */
    @Override
    protected void associate(final LeftValue leftValue, final RightValue rightValue) {

        associateUnidirectional(leftValue, rightValue, leftToRightMap, hasLeft(leftValue));
        associateUnidirectional(rightValue, leftValue, rightToLeftMap, hasRight(rightValue));
    }

    /**
     * Creates a unidirectional association between the specified values.
     * 
     * @param <Value1>
     *        type of first value
     * 
     * @param <Value2>
     *        type of second value
     * 
     * @param value1
     *        first value
     * 
     * @param value2
     *        second Value
     * 
     * @param value1ToValue2SetMap
     *        {@link Map} associating Value1 items with a {@link Set} of Value2
     *        items
     * 
     * @param value1Exists
     *        boolean specifying whether {@code value1} is associated to at
     *        least one Value2 item
     */
    private <Value1, Value2> void associateUnidirectional(final Value1 value1, final Value2 value2,
                                                          final Map<Value1, Set<Value2>> value1ToValue2SetMap,
                                                          final boolean value1Exists) {
        final Set<Value2> value2Set = value1Exists
            ? value1ToValue2SetMap.get(value1)
            : new HashSet<Value2>();

        value2Set.add(value2);

        if (!value1Exists)
            value1ToValue2SetMap.put(value1, value2Set);
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
    public Set<LeftValue> leftValues() {
        return leftToRightMap.keySet();
    }

    @Override
    public Set<LeftValue> leftSet(final RightValue rightValue) {
        return rightToLeftMap.get(rightValue);
    }

    @Override
    public Set<RightValue> rightValues() {
        return rightToLeftMap.keySet();
    }

    @Override
    public Set<RightValue> rightSet(final LeftValue leftValue) {
        return leftToRightMap.get(leftValue);
    }

    @Override
    public int getSize() {
        return leftToRightMap.size();
    }
}
