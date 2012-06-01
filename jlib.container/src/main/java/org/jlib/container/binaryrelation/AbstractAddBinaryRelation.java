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

import org.jlib.container.AbstractReplaceAddContainer;
import org.jlib.container.AddContainer;
import org.jlib.container.Container;
import org.jlib.core.traverser.Traverser;

/**
 * Skeletal implementation of a AddBinaryRelation.
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
public abstract class AbstractAddBinaryRelation<LeftValue, RightValue>
extends AbstractBinaryRelation<LeftValue, RightValue>
implements AddBinaryRelation<LeftValue, RightValue> {

    /**
     * AddContainer used as delegate for some methods allowing the
     * {@code AbstractReplaceAddBinaryRelation} class to implement the
     * {@link AddContainer} interface.
     * 
     * @param <DelegateLeftValue>
     *        type of the objects on the left hand side of the Associations held
     *        in this Container
     * 
     * @param <DelegateRightValue>
     *        type of the objects on the right hand side of the Associations
     *        held in this Container
     * 
     * @author Igor Akkerman
     */
    private class DelegateContainer<DelegateLeftValue, DelegateRightValue>
    extends AbstractReplaceAddContainer<Association<DelegateLeftValue, DelegateRightValue>> {

        /** BinaryRelation for which this Container is used as delegate */
        private final AddBinaryRelation<DelegateLeftValue, DelegateRightValue> baseBinaryRelation;

        /**
         * Creates a new DelegateContainer.
         * 
         * @param baseBinaryRelation
         *        BinaryRelation for which this Container is used as delegate
         */
        DelegateContainer(final AddBinaryRelation<DelegateLeftValue, DelegateRightValue> baseBinaryRelation) {
            super();

            this.baseBinaryRelation = baseBinaryRelation;
        }

        // @see Container#size()
        @Override
        public int getSize() {
            return baseBinaryRelation.getSize();
        }

        @Override
        public Traverser<Association<DelegateLeftValue, DelegateRightValue>> createTraverser() {
            return baseBinaryRelation.createTraverser();
        }

        // @see Collection#add(java.lang.Object)
        @Override
        public void add(final Association<DelegateLeftValue, DelegateRightValue> association) {
            baseBinaryRelation.add(association);
        }
    }

    /** DelegateContainer for this BinaryRelation */
    private final DelegateContainer<LeftValue, RightValue> delegateContainer =
        new DelegateContainer<LeftValue, RightValue>(this);

    /**
     * Creates a new AbstractReplaceAddBinaryRelation.
     */
    protected AbstractAddBinaryRelation() {
        super();
    }

    @Override
    public Traverser<Association<LeftValue, RightValue>> createTraverser() {
        return new DefaultRemoveBinaryRelationTraverser<LeftValue, RightValue>(this);
    }

    @Override
    public void add(final Association<LeftValue, RightValue> association) {
        add(association.left(), association.right());
    }

    @Override
    public void addAll(final Container<? extends Association<LeftValue, RightValue>> associations) {
        delegateContainer.addAll(associations);
    }

    @Override
    public void addAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Association<LeftValue, RightValue>... associations) {
        delegateContainer.addAll(associations);
    }

    @Override
    public void addAll(final Collection<? extends Association<LeftValue, RightValue>> associations) {
        delegateContainer.addAll(associations);
    }

    @Override
    public Association<LeftValue, RightValue>[] toArray() {
        return delegateContainer.toArray();
    }
}
