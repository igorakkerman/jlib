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

package org.jlib.container.matrix;

import org.jlib.core.language.InvalidStateException;
import org.jlib.container.traverser.Traverser;

/**
 * {@link Traverser} over a {@link Matrix}.
 *
 * @param <Item>
 *        type of Items held in the matrix
 *
 * @author Igor Akkerman
 */
public interface MatrixTraverser<Item>
extends Traverser<Item> {

    /**
     * Verifies whether the iteration has a next entity (like a row or column).
     *
     * @return {@code true} if the iteration has a next entity; {@code false}
     *         otherwise
     */
    public boolean hasNextEntity();

    /**
     * Moves the cursor in front of the first Item of the next entity (like a
     * row or column), skipping the remaining items of the current entity.
     *
     * @throws InvalidStateException
     *         if the cursor is located behind the last iterated Item of the
     *         {@link Matrix}
     */
    public void gotoNextEntity()
    throws InvalidStateException;
}
