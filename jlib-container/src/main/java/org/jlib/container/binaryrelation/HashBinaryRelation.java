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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jlib.container.binaryrelation.bijection.PairAlreadyContainedException;

/**
 * {@link BinaryRelation} implemented using hashing for left and right hand side
 * values.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link BinaryRelation}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the
 *        {@link BinaryRelation}
 *
 * @author Igor Akkerman
 */
public class HashBinaryRelation<LeftValue, RightValue>
/*extends AbstractInitializeableBinaryRelation<LeftValue, RightValue> */{

    /**
     * {@link Map} assigning each LeftValue the {@link Set} of RightValues
     * added with it
     */
    protected Map<LeftValue, Set<RightValue>> leftToRightMap = new HashMap<LeftValue, Set<RightValue>>();

    /**
     * {@link Map} assigning each RightValue the Set of LeftValue items
     * added with it
     */
    protected Map<RightValue, Set<LeftValue>> rightToLeftMap = new HashMap<RightValue, Set<LeftValue>>();

    /**
     * Creates a new initially empty {@link HashBinaryRelation}.
     */
    public HashBinaryRelation() {
        super();
    }

    /**
     * Creates a new HashBinaryRelation containing the Pairs contained by
     * the specified jlib TraversableContainer.
     *
     * @param pairs
     *        TraversableContainer of the Pairs to add
     */
    public HashBinaryRelation(final TraversableContainer<Pair<LeftValue, RightValue>> pairs) {
        super();

        for (final Pair<LeftValue, RightValue> pair : pairs)
            associate(pair.getLeftValue(), pair.getRightValue());
    }

    /**
     * Creates a new HashBinaryRelation containing the Pairs contained by
     * the specified Collection.
     *
     * @param pairs
     *        Collection of the Pairs to add
     */
    public HashBinaryRelation(final Collection<Pair<LeftValue, RightValue>> pairs) {
        super();

        for (final Pair<LeftValue, RightValue> pair : pairs)
            associate(pair.getLeftValue(), pair.getRightValue());
    }

    /**
     * Creates a new HashBinaryRelation containing the Pairs specified in
     * a comma separated sequence.
     *
     * @param pairs
     *        Comma separated sequence of the Pairs to add
     */
    @SuppressWarnings("unchecked")
    public HashBinaryRelation(final Pair<LeftValue, RightValue>... pairs) {
        super();

        for (final Pair<LeftValue, RightValue> pair : pairs)
            associate(pair.getLeftValue(), pair.getRightValue());
    }

//    @Override
    protected void associate(final LeftValue leftValue, final RightValue rightValue)
    throws PairAlreadyContainedException, InvalidPairException {
//        if (contains(leftValue, rightValue))
//            throw new PairAlreadyContainedException(this, leftValue, rightValue);

        ensureAssociated(leftValue, rightValue);
    }

//    @Override
    protected void ensureAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws InvalidPairException {
        ensureAssociatedOneWay(leftValue, rightValue, leftToRightMap, hasLeft(leftValue));
        ensureAssociatedOneWay(rightValue, leftValue, rightToLeftMap, hasRight(rightValue));
    }

    /**
     * Creates a unidirectional pair between the specified values.
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
     *        second value
     *
     * @param value1ToValue2SetMap
     *        {@link Map} associating Value1 items with a {@link Set} of Value2
     *        items
     *
     * @param value1Exists
     *        boolean specifying whether {@code value1} is added to at
     *        least one Value2 item
     */
    private <Value1, Value2> void ensureAssociatedOneWay(final Value1 value1, final Value2 value2, final Map<Value1, Set<Value2>> value1ToValue2SetMap, final boolean value1Exists) {
        final Set<Value2> value2Set = value1Exists
                                      ? value1ToValue2SetMap.get(value1)
                                      : new HashSet<Value2>();

        value2Set.add(value2);

        if (! value1Exists)
            value1ToValue2SetMap.put(value1, value2Set);
    }

//    @Override
    public boolean hasLeft(final LeftValue leftValue) {
        return leftToRightMap.containsKey(leftValue);
    }

//    @Override
    public boolean hasRight(final RightValue rightValue) {
        return rightToLeftMap.containsKey(rightValue);
    }

//    @Override
    public Set<LeftValue> getLeftValues() {
        return leftToRightMap.keySet();
    }

//    @Override
    public Set<LeftValue> getLeftSet(final RightValue rightValue) {
        return rightToLeftMap.get(rightValue);
    }

//    @Override
    public Set<RightValue> getRightValues() {
        return rightToLeftMap.keySet();
    }

//    @Override
    public Set<RightValue> getRightSet(final LeftValue leftValue) {
        return leftToRightMap.get(leftValue);
    }

//    @Override
    public int getItemsCount() {
        return leftToRightMap.size();
    }
}
