/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

package org.jlib.core.traverser;

/**
 * {@link Traverser} allowing to traverse Items forward and backwards.
 * 
 * @param <Item>
 *        type of items traversed by the {@link TwoWayTraverser}
 * 
 * @author Igor Akkerman
 */
public interface TwoWayTraverser<Item>
extends Traverser<Item> {

    /**
     * Verifies whether this {@link TwoWayTraverser} has a previous Item.
     * 
     * @return {@code true} if this {@link TwoWayTraverser} has a previous Item;
     *         {@code false} otherwise
     */
    public boolean isPreviousItemAccessible();

    /**
     * Returns the previous Item of this {@link TwoWayTraverser}.
     * 
     * @return the previous Item
     * 
     * @throws NoPreviousItemException
     *         if there is no previous Item
     */
    public Item getPreviousItem()
    throws NoPreviousItemException;
}
