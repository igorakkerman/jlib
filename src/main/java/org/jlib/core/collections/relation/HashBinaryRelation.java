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

package org.jlib.core.collections.relation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jlib.core.collections.Collection;

/**
 * BinaryRelation implemented using hashing for left and right hand side
 * elements.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public class HashBinaryRelation<LeftObject, RightObject>
extends AbstractBinaryRelation<LeftObject, RightObject> {

    /** Map assigning each LeftObject the Set of RightObjects associated with it */
    protected Map<LeftObject, Set<RightObject>> leftToRightMap = new HashMap<LeftObject, Set<RightObject>>();

    /** Map assigning each RightObject the Set of LeftObjects associated with it */
    protected Map<RightObject, Set<LeftObject>> rightToLeftMap = new HashMap<RightObject, Set<LeftObject>>();

    /**
     * Creates a new initially empty HashBinaryRelation.
     */
    public HashBinaryRelation() {
        super();
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations contained by
     * the specified jlib Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public HashBinaryRelation(Collection<Association<LeftObject, RightObject>> associations)
    throws NullPointerException {
        super();
        for (Association<LeftObject, RightObject> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations contained by
     * the specified Java Collection.
     * 
     * @param associations
     *        Java Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public HashBinaryRelation(java.util.Collection<Association<LeftObject, RightObject>> associations)
    throws NullPointerException {
        super();
        for (Association<LeftObject, RightObject> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBinaryRelation containing the Associations specified in
     * a comma separated list.
     * 
     * @param associations
     *        Comma separated list of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     */
    public HashBinaryRelation(Association<LeftObject, RightObject>... associations)
    throws NullPointerException {
        super();
        for (Association<LeftObject, RightObject> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Associates the specified LeftObject with the specified RightObject in
     * this Bijection.
     * 
     * @param leftObject
     *        LeftObject of the Association
     * @param rightObject
     *        RightObject of the Association
     * @return {@code true} if this Bijection has been modified by this
     *         operation, that is, if {@code leftObject} has been associated
     *         with {@code rightObject} by this Bijection; {@code false}
     *         otherwise
     * @throws NullPointerException
     *         if {@code leftObject == null || rightObject == null}
     */
    protected boolean add(LeftObject leftObject, RightObject rightObject)
    throws NullPointerException {
        if (leftObject == null || rightObject == null)
            throw new NullPointerException();

        Set<RightObject> rightObjectSet;
        if (hasLeft(leftObject))
            rightObjectSet = leftToRightMap.get(leftObject);
        else {
            rightObjectSet = new HashSet<RightObject>();
            leftToRightMap.put(leftObject, rightObjectSet);
        }
        rightObjectSet.add(rightObject);
        
        Set<LeftObject> leftObjectSet;
        if (hasRight(rightObject))
            leftObjectSet = rightToLeftMap.get(rightObject);
        else {
            leftObjectSet = new HashSet<LeftObject>();
            rightToLeftMap.put(rightObject, leftObjectSet);
        }
        return leftObjectSet.add(leftObject);
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#hasLeft(java.lang.Object)
    @Override
    public boolean hasLeft(LeftObject leftObject) {
        return leftToRightMap.containsKey(leftObject);
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#hasRight(java.lang.Object)
    @Override
    public boolean hasRight(RightObject rightObject) {
        return rightToLeftMap.containsKey(rightObject);
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#leftObjects()
    @Override
    public Set<LeftObject> leftObjects() {
        return leftToRightMap.keySet();
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#leftSet(java.lang.Object)
    @Override
    public Set<LeftObject> leftSet(RightObject rightObject) {
        return rightToLeftMap.get(rightObject);
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#rightObjects()
    @Override
    public Set<RightObject> rightObjects() {
        return rightToLeftMap.keySet();
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#rightSet(java.lang.Object)
    @Override
    public Set<RightObject> rightSet(LeftObject leftObject) {
        return leftToRightMap.get(leftObject);
    }

    // @see org.jlib.core.collections.Collection#size()
    @Override
    public int size() {
        return leftToRightMap.size();
    }
}
