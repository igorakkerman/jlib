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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.jlib.core.collections.Collection;

/**
 * Bijection implemented using hashing for left and right hand side elements.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the bijection
 * @param <RightObject>
 *        type of the objects on the right hand side of the bijection
 * @author Igor Akkerman
 */
public class HashBijection<LeftObject, RightObject>
extends AbstractBinaryRelation<LeftObject, RightObject>
implements Bijection<LeftObject, RightObject> {

    /** Map assigning each LeftObject the RightObject associated with it */
    protected Map<LeftObject, RightObject> leftToRightMap = new HashMap<LeftObject, RightObject>();

    /** Map assigning each RightObject the LeftObject associated with it */
    protected Map<RightObject, LeftObject> rightToLeftMap = new HashMap<RightObject, LeftObject>();

    /**
     * Creates a new empty HashBijection.
     */
    public HashBijection() {
        super();
    }

    /**
     * Creates a new HashBijection containing the Associations contained by the
     * specified jlib Collection.
     * 
     * @param associations
     *        Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to
     *         a previously added Association, it is ignored
     */
    public HashBijection(Collection<Association<LeftObject, RightObject>> associations)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        super();
        for (Association<LeftObject, RightObject> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBijection containing the Associations contained by the
     * specified Java Collection.
     * 
     * @param associations
     *        Java Collection of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to
     *         a previously added Association, it is ignored
     */
    public HashBijection(java.util.Collection<Association<LeftObject, RightObject>> associations)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        super();
        for (Association<LeftObject, RightObject> association : associations)
            add(association.left(), association.right());
    }

    /**
     * Creates a new HashBijection containing the Associations specified in a
     * comma separated list.
     * 
     * @param associations
     *        Comma separated list of the Associations to add
     * @throws NullPointerException
     *         if for one of the specified Associations
     *         {@code left() == null || right() == null}
     * @throws ObjectAlreadyAssociatedException
     *         if one of the Objects in {@code associations} is already
     *         associated to another Object; if an Association is equal to
     *         a previously added Association, it is ignored
     */
    public HashBijection(Association<LeftObject, RightObject>... associations)
    throws NullPointerException, ObjectAlreadyAssociatedException {
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
     * @throws ObjectAlreadyAssociatedException
     *         if {@code leftObject} or {@code rightObject} is already
     *         associated to another Object; an existing Association is ignored
     */
    protected boolean add(LeftObject leftObject, RightObject rightObject)
    throws NullPointerException, ObjectAlreadyAssociatedException {
        if (leftObject == null || rightObject == null)
            throw new NullPointerException();

        if (hasLeft(leftObject)) {
            if (rightObject.equals(right(leftObject)))
                return false;
            else
                throw new ObjectAlreadyAssociatedException(this, leftObject);
        }

        if (hasRight(rightObject)) // and automatically !leftObject.equals(left(rightObject))
            throw new ObjectAlreadyAssociatedException(this, rightObject);

        leftToRightMap.put(leftObject, rightObject);
        rightToLeftMap.put(rightObject, leftObject);

        return true;
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#hasRight(java.lang.Object)
    @Override
    public boolean hasLeft(LeftObject leftObject) {
        return leftToRightMap.containsKey(leftObject);
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#hasLeft(java.lang.Object)
    @Override
    public boolean hasRight(RightObject rightObject) {
        return rightToLeftMap.containsKey(rightObject);
    }

    // @see org.jlib.core.collections.relation.Bijection#right(java.lang.Object)
    @Override
    public RightObject right(LeftObject leftObject) {
        RightObject rightObject = leftToRightMap.get(leftObject);
        if (rightObject != null)
            return rightObject;
        else
            throw new NoSuchElementException(leftObject.toString());
    }

    // @see org.jlib.core.collections.relation.Bijection#left(java.lang.Object)
    @Override
    public LeftObject left(RightObject rightObject) {
        LeftObject leftObject = rightToLeftMap.get(rightObject);
        if (leftObject != null)
            return leftObject;
        else
            throw new NoSuchElementException(rightObject.toString());
    }

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        return leftToRightMap.toString();
    }

    // @see org.jlib.core.collections.Collection#size()
    @Override
    public int size() {
        return rightToLeftMap.size();
    }

    // @see org.jlib.core.collections.relation.Bijection#leftObjects()
    @Override
    public Set<LeftObject> leftObjects() {
        return Collections.unmodifiableSet(leftToRightMap.keySet());
    }

    // @see org.jlib.core.collections.relation.Bijection#rightObjects()
    @Override
    public Set<RightObject> rightObjects() {
        return Collections.unmodifiableSet(rightToLeftMap.keySet());
    }

    // @see java.util.AbstractCollection#iterator()
    @Override
    public Iterator<Association<LeftObject, RightObject>> iterator() {
        return new BinaryRelationIterator<LeftObject, RightObject>(this);
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#rightSet(java.lang.Object)
    @Override
    public Set<RightObject> rightSet(LeftObject leftObject) {
        return hasLeft(leftObject) ? Collections.singleton(right(leftObject)) : new HashSet<RightObject>();
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#leftSet(java.lang.Object)
    @Override
    public Set<LeftObject> leftSet(RightObject rightObject) {
        return hasRight(rightObject) ? Collections.singleton(left(rightObject)) : new HashSet<LeftObject>();
    }

    // @see org.jlib.core.collections.relation.BinaryRelation#contains(java.lang.Object, java.lang.Object)
    @Override
    public boolean contains(LeftObject leftObject, RightObject rightObject) {
        return leftToRightMap.get(leftObject).equals(rightObject);
    }
}
