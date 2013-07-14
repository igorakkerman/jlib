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

package org.jlib.core.traverser;

/**
 * {@link Object} traversible by a {@link TwoWayTraverser}.
 *
 * @param <Item>
 *        type of items returned by the {@link Traverser}
 *
 * @author Igor Akkerman
 */
public interface TwoWayTraversible<Item>
extends Traversible<Item> {

    /**
     * Returns a new {@link TwoWayTraverser} over the Items of this
     * {@link TwoWayTraversible}.
     *
     * @return newly createTraverser}
     */
    @Override
    public TwoWayTraverser<Item> createTraverser();
}
