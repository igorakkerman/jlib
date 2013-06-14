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

package org.jlib.container;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.traverser.ReplaceTraverser;

/**
 * <p>
 * Container that allows its Items to be modified using an
 * {@link ReplaceTraverser}.
 * </p>
 * <p>
 * It does not necessarily allow modification of the {@link Container}, that is,
 * this interface does not provide methods for adding and removing Items. See
 * {@link AppendSequence} for this functionality.
 * </p>
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * @author Igor Akkerman
 */
public interface ReplaceContainer<Item>
extends Container<Item> {

    /**
     * Creates a new {@link ReplaceTraverser} over the Items of this {@link ReplaceContainer}
     * .
     *
     * @return newly createTraverser}
     */
    public ReplaceTraverser<Item> createTraverser();
}
