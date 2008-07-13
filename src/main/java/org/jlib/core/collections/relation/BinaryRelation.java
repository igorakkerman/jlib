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

import java.util.Set;

import org.jlib.core.collections.Collection;

/**
 * Binary association between various Objects. Each Object on either of the two
 * sides may be associated with a Set of Objects on the other side.
 * 
 * @param <LeftObject>
 *        type of the objects on the left hand side of the BinaryRelation
 * @param <RightObject>
 *        type of the objects on the right hand side of the BinaryRelation
 * @author Igor Akkerman
 */
public interface BinaryRelation<LeftObject, RightObject>
extends Collection<Association<LeftObject, RightObject>> {

    /**
     * Returns the Set of RightObjects associated with the specified LeftObject.
     * 
     * @param leftObject
     *        LeftObject associated with the Set of RightObjects to return
     * @return Set of RightObjects associated with {@code leftObject}
     */
    public Set<RightObject> rightSet(LeftObject leftObject);

    /**
     * Returns the Set of LeftObjects associated with the specified RightObject.
     * 
     * @param rightObject
     *        RightObject associated with the Set of LeftObjects to return
     * @return Set of RightObjects associated with {@code leftObject}
     */
    public Set<LeftObject> leftSet(RightObject rightObject);

    /**
     * Returns whether the specified LeftObject is associated with the specified
     * RightObject.
     * 
     * @param leftObject
     *        LeftObject of the potential association
     * @param rightObject
     *        RightObject of the potential association
     * @return {@code true} if {@code leftObject} is associated with
     *         {@code rightObject}
     */
    public boolean contains(LeftObject leftObject, RightObject rightObject);

    /**
     * Returns whether the specified LeftObject is associated with some
     * RightObject by this BinaryRelation.
     * 
     * @param leftObject
     *        the LeftObject
     * @return {@code true} if {@code leftObject} is associated with some
     *         RightObject; {@code false} otherwise
     */
    public boolean hasLeft(LeftObject leftObject);

    /**
     * Returns whether the specified RightObject is associated with some
     * LeftObject by this BinaryRelation.
     * 
     * @param rightObject
     *        the RightObject
     * @return {@code true} if {@code rightObject} is associated with some
     *         LeftObject; {@code false} otherwise
     */
    public boolean hasRight(RightObject rightObject);

    /**
     * Returns a Set containing the LeftObjects of this BinaryRelation. The Set
     * is updated when this BinaryRelation is modified. Note that, in that case,
     * the values returned by the Set's Iterator may be inconsistent. The Set is
     * immutable, that is, calling one of its modifying operations results in an
     * {@link UnsupportedOperationException}.
     * 
     * @return Set containing the LeftObjects of this BinaryRelation
     */
    public Set<LeftObject> leftObjects();

    /**
     * Returns a Set containing the RightObjects of this BinaryRelation. The Set
     * is updated when this BinaryRelation is modified. Note that, in that case,
     * the values returned by the Set's Iterator may be inconsistent. The Set is
     * immutable, that is, calling one of its modifying operations results in an
     * {@link UnsupportedOperationException}.
     * 
     * @return Set containing the RightObjects of this BinaryRelation
     */
    public Set<RightObject> rightObjects();
}
