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
 * Collection that supports addition and removal of Elements.
 * 
 * @param <Element>
 *        type of elements held in the Collection
 * @author Igor Akkerman
 */
public interface ModifiableCollection<Element>
extends Collection<Element>, java.util.Collection<Element> {

    /**
     * Adds all Elements contained in the specified Collection to this
     * Collection.
     * 
     * @param otherCollection
     *        Collection containing the Elements to add to this Collection
     * @return {@code true} if this Collection has been modified by this
     *         operation; {@code false} otherwise
     */
    public boolean addAll(Collection<? extends Element> otherCollection);

    /**
     * Adds all specified Elements to this Collection.
     * 
     * @param elements
     *        comma separated list of Elements to add to this Collection
     * @return {@code true} if this Collection has been modified by this
     *         operation; {@code false} otherwise
     */
    public boolean addAll(Element... elements);

    /**
     * Removes all Objects contained in the specified Collection from this
     * Collection.
     * 
     * @param otherCollection
     *        Collection containing the Objects to remove from this Collection
     * @return {@code true} if this Collection has been modified by this
     *         operation; {@code false} otherwise
     */
    public boolean removeAll(Collection<?> otherCollection);

    /**
     * Removes all specified Objects from this Collection.
     * 
     * @param elements
     *        comma separated list of Objects to remove from this Collection
     * @return {@code true} if this Collection has been modified by this
     *         operation; {@code false} otherwise
     */
    public boolean removeAll(Object... elements);

    /**
     * Removes all Objects from this Collection <i>except</i> the Objects
     * contained in the specified Collection.
     * 
     * @param otherCollection
     *        Collection containing the Objects to retain in this Collection
     * @return {@code true} if this Collection has been modified by this
     *         operation; {@code false} otherwise
     */
    public boolean retainAll(Collection<?> otherCollection);

    /**
     * Removes all Objects from this Collection <i>except</i> the specified
     * Objects.
     * 
     * @param elements
     *        comma separated list of Objects to retain in this Collection
     * @return {@code true} if this Collection has been modified by this
     *         operation; {@code false} otherwise
     */
    public boolean retainAll(Object... elements);
}
