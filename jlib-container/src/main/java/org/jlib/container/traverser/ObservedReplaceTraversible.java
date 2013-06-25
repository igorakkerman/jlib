/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.traverser;

/**
 * Object providing a {@link ObservedReplaceTraversible} over its Items.
 *
 * @param <Item>
 *        type of the traversed Items
 *
 * @author Igor Akkerman
 */
public interface ObservedReplaceTraversible<Item>
extends ReplaceTraversible<Item> {

    /**
     * Returns a new {@link ObservedReplaceTraverser} over the Items of this {@link ObservedReplaceTraversible}.
     *
     * @return newly created {@link ObservedReplaceTraverser}
     */
    @Override
    public ObservedReplaceTraverser<Item> createTraverser();
}
