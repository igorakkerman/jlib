/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.container.operation;

import java.util.List;
import java.util.RandomAccess;

public interface ToRandomAccessList<Item> {

    /**
     * Returns a {@link RandomAccess} {@link List} containing all of the Items
     * of this {@link Object} in the proper order as returned by this
     * {@link Object}'s Iterator.
     *
     * @return {@link RandomAccess} {@link List} containing all of the Items of
     *         this {@link Object}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    List<Item> toRandomAccessList()
    throws InvalidContainerStateException;
}
