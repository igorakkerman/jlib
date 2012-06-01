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

import java.util.Set;

import org.jlib.container.Container;

/**
 * Binary association between various Objects. Each Object on either of the two
 * sides may be associated with a Set of Objects on the other side.
 * 
 * @param <LeftValue>
 *        type of the objects on the left hand side of the BinaryRelation
 * 
 * @param <RightValue>
 *        type of the objects on the right hand side of the BinaryRelation
 * 
 * @author Igor Akkerman
 */
public interface BinaryRelation<LeftValue, RightValue>
extends Container<Association<LeftValue, RightValue>> {

    /**
     * Returns the Set of RightValues associated with the specified LeftValue.
     * 
     * @param leftValue
     *        LeftValue associated with the Set of RightValues to return
     * 
     * @return {@link Set} of RightValues associated with {@code leftValue};
     *         empty {@link Set} if no RightValue is associated with
     *         {@code leftValue}
     */
    public Set<RightValue> rightSet(final LeftValue leftValue);

    /**
     * Returns the Set of LeftValues associated with the specified RightValue.
     * 
     * @param rightValue
     *        RightValue associated with the Set of LeftValues to return
     * 
     * @return {@link Set} of RightValues associated with {@code leftValue}
     *         empty {@link Set} if no RightValue is associated with
     *         {@code leftValue}
     */
    public Set<LeftValue> leftSet(final RightValue rightValue);

    /**
     * Verifies whether the specified LeftValue is associated with the specified
     * RightValue.
     * 
     * @param leftValue
     *        LeftValue of the potential association
     * 
     * @param rightValue
     *        RightValue of the potential association
     * 
     * @return {@code true} if {@code leftValue} is associated with
     *         {@code rightValue}
     */
    public boolean contains(final LeftValue leftValue, final RightValue rightValue);

    /**
     * Verifies whether the specified LeftValue is associated with some
     * RightValue by this BinaryRelation.
     * 
     * @param leftValue
     *        the LeftValue
     * 
     * @return {@code true} if {@code leftValue} is associated with some
     *         RightValue; {@code false} otherwise
     */
    public boolean hasLeft(final LeftValue leftValue);

    /**
     * Verifies whether the specified RightValue is associated with some
     * LeftValue by this BinaryRelation.
     * 
     * @param rightValue
     *        the RightValue
     * 
     * @return {@code true} if {@code rightValue} is associated with some
     *         LeftValue; {@code false} otherwise
     */
    public boolean hasRight(final RightValue rightValue);

    /**
     * Returns a {@link Set} containing the LeftValues of this
     * {@link BinaryRelation}. The {@link Set} is updated when this
     * {@link BinaryRelation} is modified. Note that, in that case, the values
     * returned by the {@link Set}'s {@link BinaryRelationTraverser} may be
     * inconsistent. The {@link Set} is immutable, that is, calling one of its
     * modifying operations results in an {@link UnsupportedOperationException}.
     * 
     * @return {@link Set} containing the LeftValues
     */
    public Set<LeftValue> leftValues();

    /**
     * Returns a {@link Set} containing the RightValues of this
     * {@link BinaryRelation}. The {@link Set} is updated when this
     * {@link BinaryRelation} is modified. Note that, in that case, the values
     * returned by the {@link Set}'s {@link BinaryRelationTraverser} may be
     * inconsistent. The {@link Set} is immutable, that is, calling one of its
     * modifying operations results in an {@link UnsupportedOperationException}.
     * 
     * @return {@link Set} containing the RightValues
     */
    public Set<RightValue> rightValues();
}
