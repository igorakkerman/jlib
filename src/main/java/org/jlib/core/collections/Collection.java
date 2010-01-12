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

package org.jlib.core.collections;

/**
 * Collection of elements.
 * 
 * @param <Element>
 *        type of elements held in the Collection
 * @author Igor Akkerman
 */
public interface Collection<Element>
extends Iterable<Element> {

    /**
     * Returns the number of Elements in this Collection.
     * 
     * @return integer specifying the number of Elements in this Collection
     */
    public int size();

    /**
     * Returns whether this Collection contains no Elements.
     * 
     * @return {@code true} if this Collection contains no Elements;
     *         {@code false} otherwise
     */
    public boolean isEmpty();

    /**
     * Returns whether this Collection contains the specified Object.
     * 
     * @param object
     *        Object to verify
     * @return {@code true} if this Collection contains {@code object};
     *         {@code false} otherwise
     */
    public boolean contains(Object object);

    /**
     * Returns whether this Collection contains all of the Elements in the
     * specified Collection.
     * 
     * @param otherCollection
     *        Collection containing the Elements to verify
     * @return {@code true} if this Collection contains all of the Elements
     *         contained by {@code otherCollection}; {@code false} otherwise
     */
    public boolean containsAll(Collection<?> otherCollection);

    /**
     * Returns whether this Collection contains all of the Elements in the
     * specified Java Collection.
     * 
     * @param javaCollection
     *        Java Collection containing the Elements to verify
     * @return {@code true} if this Collection contains all of the Elements
     *         contained by {@code javaCollection}; {@code false} otherwise
     */
    public boolean containsAll(java.util.Collection<?> javaCollection);

    /**
     * Returns whether this Collection contains all of the specified Elements.
     * 
     * @param objects
     *        comma separated list of Objects to verify
     * @return {@code true} if this Collection contains all of the
     *         {@code objects}; {@code false} otherwise
     */
    public boolean containsAll(Object... objects);

    /**
     * Returns a Java Collection containing all of the Elements of this
     * Collection in the proper order as returned by this Collection's Iterator.
     * 
     * @return Java Collection containing all of the Elements of this Collection
     */
    public java.util.Collection<Element> toJavaCollection();

    /**
     * Returns an array containing all of the Elements of this Collection in the
     * proper order as returned by this Collection's Iterator.
     * 
     * @return array containing all of the Elements of this Collection
     */
    public Element[] toArray();

    /**
     * <p>
     * Verifies whether the specified Object is a Collection and contains the
     * same Elements as this Collection.
     *  
     * @param otherObject
     *        Object to compare to this Collection
     * @return {@code true} if {@code object} is equal to this Collection;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object otherObject);
}
