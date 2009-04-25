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

package org.jlib.core.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jlib.core.collections.list.Array;
import org.jlib.core.collections.list.IndexList;
import org.jlib.core.operator.BinaryOperator;
import org.jlib.core.operator.IdentityElementBinaryOperator;

/**
 * Utility class providing methods operating on Collections.
 * 
 * @author Igor Akkerman
 */
public final class CollectionUtility {

    /** no visible constructor */
    private CollectionUtility() {}

    /**
     * Creates a Set containing the elements of the specified array.
     * 
     * @param <SetElement>
     *        type of the elements in the Set; super type of {@code
     *        <ArrayElement>}
     * @param <ArrayElement>
     *        type of the elements in the array
     * @param array
     *        the source array
     * @return Set containing the Elements of {@code array}
     */
    public static <SetElement, ArrayElement extends SetElement> Set<SetElement> asSet(ArrayElement[] array) {
        Set<SetElement> set = new HashSet<SetElement>(array.length);
        for (ArrayElement element : array)
            set.add(element);
        return set;
    }

    /**
     * Applies the specified BinaryOperator on the elements of the specified non
     * empty Collection with left associativity. Let <i>a</i>, <i>b</i>,
     * <i>c</i>, ... be the first elements returned by the Collection's Iterator
     * in the correct order, and let the BinaryOperator be represented by
     * <i>*</i>. Then this method returns the result of <i>((a*b)*c)*...</i>.
     * 
     * @param <Value>
     *        type of the values to which the BinaryOperator is applied
     * @param collection
     *        non empty Collection of Values on which the BinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}
     * @throws IllegalArgumentException
     *         if {@code collection} is empty
     */
    public static <Value> Value applyToAll(Collection<Value> collection, BinaryOperator<Value, Value, Value> operator)
    throws IllegalArgumentException {
        if (collection.isEmpty())
            throw new IllegalArgumentException();

        Iterator<Value> collectionIterator = collection.iterator();

        Value result = collectionIterator.next();

        while (collectionIterator.hasNext())
            result = operator.operate(result, collectionIterator.next());

        return result;
    }

    /**
     * Applies the specified IdentityElementBinaryOperator on the elements of
     * the specified Collection with left associativity, returning the
     * operator's identity element if the Collection is empty. Let <i>a</i>,
     * <i>b</i>, <i>c</i>, ... be the first elements returned by the
     * Collection's Iterator in the correct order, and let the operator be
     * represented by <i>*</i>. Then this method returns the result of
     * <i>((a*b)*c)*...</i>. If the Collection is empty, the value returned by
     * the operator's {@link IdentityElementBinaryOperator#identityElement()}
     * method is returned.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Collection of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        IdentityElementBinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; the {@code operator}'s identity
     *         element if {@code collection} is empty
     */
    public static <Value> Value applyToAll(Collection<Value> collection, IdentityElementBinaryOperator<Value> operator) {
        return applyToAll(collection, operator, operator.identityElement());
    }

    /**
     * Applies the specified BinaryOperator on the elements of the specified
     * Collection with left associativity, returning the specified identity
     * element if the Collection is empty. Let <i>a</i>, <i>b</i>, <i>c</i>, ...
     * be the first elements returned by the non empty Collection's Iterator in
     * the correct order, and let the BinaryOperator be represented by <i>*</i>.
     * Then this method returns the result of <i>((a*b)*c)*...</i>.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Collection of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @param identityElement
     *        Value to return if {@code collection} is empty
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; {@code identityElement} if
     *         {@code collection} is empty
     */
    public static <Value> Value applyToAll(Collection<Value> collection, BinaryOperator<Value, Value, Value> operator,
                                           Value identityElement) {
        if (collection.isEmpty())
            return identityElement;

        return applyToAll(collection, operator);
    }

    /**
     * Applies the specified BinaryOperator on the elements of the specified non
     * empty Collection with right associativity. Let ..., <i>x</i>, <i>y</i>,
     * <i>z</i> be the last elements returned by the Collection's Iterator in
     * the correct order, and let the BinaryOperator be represented by <i>*</i>.
     * Then this method returns the result of <i>...*(x*(y*z))</i>.
     * 
     * @param <Value>
     *        type of the values to which the BinaryOperator is applied
     * @param collection
     *        non empty Collection of Values on which the BinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}
     * @throws IllegalArgumentException
     *         if {@code collection} is empty
     */
    public static <Value> Value applyToAllRightAssociative(Collection<Value> collection,
                                                           BinaryOperator<Value, Value, Value> operator)
    throws IllegalArgumentException {

        if (collection.isEmpty())
            throw new IllegalArgumentException();

        IndexList<Value> list =
            collection instanceof IndexList<?> ? (IndexList<Value>) collection : new Array<Value>(1, collection);

        int listIndex = list.maxIndex();
        int minListIndex = list.minIndex();

        Value result = list.get(listIndex);
        while (-- listIndex >= minListIndex)
            result = operator.operate(list.get(listIndex), result);

        return result;
    }

    /**
     * Applies the specified IdentityElementBinaryOperator on the elements of
     * the specified Collection with right associativity, returning the
     * operator's identity element if the Collection is empty. Let ...,
     * <i>x</i>, <i>y</i>, <i>z</i> be the last elements returned by the
     * Collection's Iterator in the correct order, and let the operator be
     * represented by <i>*</i>. Then this method returns the result of
     * <i>...*(x*(y*z))</i>. If the Collection is empty, the value returned by
     * the operator's {@link IdentityElementBinaryOperator#identityElement()}
     * method is returned.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Collection of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        IdentityElementBinaryOperator applied to {@code collection}
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; the {@code operator}'s identity
     *         element if {@code collection} is empty
     */
    public static <Value> Value applyToAllRightAssociative(Collection<Value> collection, IdentityElementBinaryOperator<Value> operator) {
        return applyToAllRightAssociative(collection, operator, operator.identityElement());
    }

    /**
     * Applies the specified IdentityElementBinaryOperator on the elements of
     * the specified Collection with right associativity, returning the
     * specified identity element if the Collection is empty. Let ...,
     * <i>x</i>, <i>y</i>, <i>z</i> be the last elements returned by the
     * Collection's Iterator in the correct order, and let the operator be
     * represented by <i>*</i>. Then this method returns the result of
     * <i>...*(x*(y*z))</i>.
     * 
     * @param <Value>
     *        type of the values to which the IdentityElementBinaryOperator is
     *        applied
     * @param collection
     *        Collection of Values on which the IdentityElementBinaryOperator is
     *        applied
     * @param operator
     *        BinaryOperator applied to {@code collection}
     * @param identityElement
     *        Value to return if {@code collection} is empty
     * @return Value returned after {@code operator} has been applied to all
     *         elements of {@code collection}; {@code identityElement} if
     *         {@code collection} is empty
     */
    public static <Value> Value applyToAllRightAssociative(Collection<Value> collection, BinaryOperator<Value, Value, Value> operator, Value identityElement) {
        if (collection.isEmpty())
            return identityElement;
        
        return applyToAll(collection, operator);
    }
}
