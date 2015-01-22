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

package org.jlib.container.operation.containsadapter;

import org.jlib.container.iterator.IterableUtility;

import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;

public class IterativeContainsAdapter<Item>
extends ContainsAdapter<Item> {

    public IterativeContainsAdapter(final Iterable<Item> items) {
        super(items);
    }

    @Override
    public final boolean contains(final Item item)
    throws InvalidContainerArgumentException, InvalidContainerStateException {

        return IterableUtility.contains(getItems(), item);
    }
}
