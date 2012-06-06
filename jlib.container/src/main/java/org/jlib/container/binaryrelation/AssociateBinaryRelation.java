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

/**
 * {@link BinaryRelation} allowing to associate and remove {@link Association}
 * Items.
 * 
 * @param <LeftValue>
 *        type of the values on the left hand side of the
 *        {@link AssociateBinaryRelation}
 * 
 * @param <RightValue>
 *        type of the values on the right hand side of the
 *        {@link AssociateBinaryRelation}
 * 
 * @author Igor Akkerman
 */
public interface AssociateBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue> {

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AssociateBinaryRelation}.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws IllegalAssociationException
     *         if some property of the specified {@link Association} prevents it
     *         from being associated
     */
    public void associate(LeftValue leftValue, RightValue rightValue)
    throws IllegalAssociationException;

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AssociateBinaryRelation}.
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     * 
     * @throws IllegalAssociationException
     *         if some property of the {@link Association} prevents it from
     *         being associated
     */
    public void assertAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws IllegalAssociationException;

    /**
     * Associates the specified Item to the specified
     * {@link AssociateBinaryRelation}.
     * 
     * @param association
     *        {@link Association} to create
     * 
     * @throws IllegalAssociationException
     *         if some property of {@code item} prevents it from being
     *         associated, for instance, if it is already contained
     */
    public void associate(final Association<LeftValue, RightValue> association)
    throws IllegalAssociationException;

    /**
     * Associates all Items contained by the specified {@link Container} to this
     * {@link AssociateBinaryRelation}.
     * 
     * @param associations
     *        {@link Container} containing the Items to associate
     * 
     * @throws IllegalAssociationException
     *         if {@code associations}
     * 
     * @throws IllegalAssociationException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated, for instance, if it is already contained
     */
    public void associate(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException;

    /**
     * Associates all Items contained by the specified {@link Collection} to the
     * specified {@link AssociateBinaryRelation}.
     * 
     * @param associations
     *        {@link Collection} containing the Items to associate
     * 
     * @throws IllegalAssociationException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated, for instance, if it is already contained
     */
    public void associate(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException;

    /**
     * Associates all specified Items to the specified
     * {@link AssociateBinaryRelation}.
     * 
     * @param associations
     *        comma separated sequence of Items to associate
     * 
     * @throws IllegalAssociationException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated, for instance, if it is already contained
     */
    public void associate(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws IllegalAssociationException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains the
     * specified Item. If the {@link AssociateBinaryRelation} does not contain
     * the Item, it is associated.
     * 
     * @param association
     *        {@link Association} to create
     * 
     * @throws IllegalAssociationException
     *         if some property of {@code item} prevents it from being
     *         associated
     */
    public void assertContained(final Association<LeftValue, RightValue> association)
    throws IllegalAssociationException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains all
     * Items contained by the specified {@link Container} to this
     * {@link AssociateBinaryRelation}. If the {@link AssociateBinaryRelation}
     * does not contain the Item, it is associated.
     * 
     * @param associations
     *        {@link Container} containing the Items to associate
     * 
     * @throws IllegalAssociationException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated
     */
    public void assertContained(final Container<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains all
     * Items contained by the specified {@link Collection} to this
     * {@link AssociateBinaryRelation}.
     * 
     * @param associations
     *        {@link Collection} containing the Items to associate
     * 
     * @throws IllegalAssociationException
     *         if some property of {@code item} prevents it from being
     *         associated
     */
    public void assertContained(final Collection<? extends Association<LeftValue, RightValue>> associations)
    throws IllegalAssociationException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains all
     * specified Items to the specified {@link AssociateBinaryRelation}.
     * 
     * @param associations
     *        comma separated sequence of Items to associate
     * 
     * @throws IllegalAssociationException
     *         if some property of {@code item} prevents it from being
     *         associated
     */
    public void assertContained(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations)
    throws IllegalAssociationException;
}
