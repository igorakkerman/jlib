/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.operator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jlib.container.Container;
import org.jlib.container.sequence.ArraySequenceCreator;
import org.jlib.container.sequence.IndexSequence;
import org.jlib.core.operator.BinaryOperator;
import org.jlib.core.operator.IdentityElementBinaryOperator;

/**
 * Utility class providing methods applying {@link BinaryOperator
 * BinaryOperators} on {@link Container Containers}.
 * 
 * @author Igor Akkerman
 */
public final class ContainerOperatorUtility {

    /** no visible constructor */
    private ContainerOperatorUtility() {}

    /**
     * Creates a Set containing the elements of the specified array.
     * 
     * @param <SetElement>
     *        type of the elements in the Set; super type of
     *        {@code <ArrayElement>}
     * @param <ArrayElement>
     *        type of the elements in the array
     * @param array
     *        the source array
     * @return Set containing the Elements of {@code array}
     */
    public static <SetElement, ArrayElement extends SetElement> Set<SetElement> asSet(final ArrayElement[] array) {
        final Set<SetElement> set = new HashSet<SetElement>(array.length);
        for (final ArrayElement element : array)
            set.add(element);
        return set;
    }

    /**
     * Applies the specified BinaryOperator on the elements of the specified non
     * empty Container with left associativity. Let <i>a</i>, <i>b</i>,
     * <i>c</i>, ... be the first elements returned by the Container's Iterator
     * in the correct order, and let the BinaryOperator be represented by
     * <i>*</i>. Then this method returns the result of <i>((a*b)*c)*...</i>.
     * 
     * @param <Value>
     *        type of the values to which the BinaryOperator is applied
     * @param collection
     *        non empty Container of Values on which the BinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}
     * @throws IllegalArgumentException
     *         if {@code collection} is empty
     */
    public static <Value> Value applyToAll(final Container<Value> collection,
                                           final BinaryOperator<Value, Value, Value> operator)
    throws IllegalArgumentException {
        if (collection.isEmpty())
            throw new IllegalArgumentException();

        final Iterator<Value> collectionIterator = collection.iterator();

        Value result = collectionIterator.next();

        while (collectionIterator.hasNext())
            result = operator.operate(result, collectionIterator.next());

        return result;
    }

    /**
     * Applies the specified IdentityElementBinaryOperator on the elements of
     * the specified Container with left associativity, returning the operator's
     * identity element if the Container is empty. Let <i>a</i>, <i>b</i>,
     * <i>c</i>, ... be the first elements returned by the Container's Iterator
     * in the correct order, and let the operator be represented by <i>*</i>.
     * Then this method returns the result of <i>((a*b)*c)*...</i>. If the
     * Container is empty, the value returned by the operator's
     * {@link IdentityElementBinaryOperator#identityElement()} method is
     * returned.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Container of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        IdentityElementBinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; the {@code operator}'s identity
     *         element if {@code collection} is empty
     */
    public static <Value> Value applyToAll(final Container<Value> collection,
                                           final IdentityElementBinaryOperator<Value> operator) {
        return applyToAll(collection, operator, operator.identityElement());
    }

    /**
     * Applies the specified BinaryOperator on the elements of the specified
     * Container with left associativity, returning the specified identity
     * element if the Container is empty. Let <i>a</i>, <i>b</i>, <i>c</i>, ...
     * be the first elements returned by the non empty Container's Iterator in
     * the correct order, and let the BinaryOperator be represented by <i>*</i>.
     * Then this method returns the result of <i>((a*b)*c)*...</i>.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Container of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @param identityElement
     *        Value to return if {@code collection} is empty
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; {@code identityElement} if
     *         {@code collection} is empty
     */
    public static <Value> Value applyToAll(final Container<Value> collection,
                                           final BinaryOperator<Value, Value, Value> operator,
                                           final Value identityElement) {
        if (collection.isEmpty())
            return identityElement;

        return applyToAll(collection, operator);
    }

    /**
     * Applies the specified BinaryOperator on the elements of the specified non
     * empty Container with right associativity. Let ..., <i>x</i>, <i>y</i>,
     * <i>z</i> be the last elements returned by the Container's Iterator in the
     * correct order, and let the BinaryOperator be represented by <i>*</i>.
     * Then this method returns the result of <i>...*(x*(y*z))</i>.
     * 
     * @param <Value>
     *        type of the values to which the BinaryOperator is applied
     * @param container
     *        non empty Container of Values on which the BinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}
     * @throws IllegalArgumentException
     *         if {@code collection} is empty
     */
    public static <Value> Value applyToAllRightAssociative(final Container<Value> container,
                                                           final BinaryOperator<Value, Value, Value> operator)
    throws IllegalArgumentException {

        if (container.isEmpty())
            throw new IllegalArgumentException();

        final IndexSequence<Value> sequence =
            container instanceof IndexSequence<?> ? (IndexSequence<Value>) container
                                                 : ArraySequenceCreator.<Value> getInstance().createSequence(1,
                                                                                                             container);

        int sequenceIndex = sequence.getLastIndex();
        final int firstSequenceIndex = sequence.getMinimumindex();

        Value result = sequence.get(sequenceIndex);
        while (-- sequenceIndex >= firstSequenceindex)
            result = operator.operate(sequence.get(sequenceIndex), result);

        return result;
    }

    /**
     * Applies the specified IdentityElementBinaryOperator on the elements of
     * the specified Container with right associativity, returning the
     * operator's identity element if the Container is empty. Let ..., <i>x</i>,
     * <i>y</i>, <i>z</i> be the last elements returned by the Container's
     * Iterator in the correct order, and let the operator be represented by
     * <i>*</i>. Then this method returns the result of <i>...*(x*(y*z))</i>. If
     * the Container is empty, the value returned by the operator's
     * {@link IdentityElementBinaryOperator#identityElement()} method is
     * returned.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Container of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        IdentityElementBinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; the {@code operator}'s identity
     *         element if {@code collection} is empty
     */
    public static <Value> Value applyToAllRightAssociative(final Container<Value> collection,
                                                           final IdentityElementBinaryOperator<Value> operator) {
        return applyToAllRightAssociative(collection, operator, operator.identityElement());
    }

    /**
     * Applies the specified IdentityElementBinaryOperator on the elements of
     * the specified Container with right associativity, returning the specified
     * identity element if the Container is empty. Let ..., <i>x</i>, <i>y</i>,
     * <i>z</i> be the last elements returned by the Container's Iterator in the
     * correct order, and let the operator be represented by <i>*</i>. Then this
     * method returns the result of <i>...*(x*(y*z))</i>.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Container of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @param identityElement
     *        Value to return if {@code collection} is empty
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; {@code identityElement} if
     *         {@code collection} is empty
     */
    public static <Value> Value applyToAllRightAssociative(final Container<Value> collection,
                                                           final BinaryOperator<Value, Value, Value> operator,
                                                           final Value identityElement) {
        if (collection.isEmpty())
            return identityElement;

        return applyToAll(collection, operator);
    }
}
