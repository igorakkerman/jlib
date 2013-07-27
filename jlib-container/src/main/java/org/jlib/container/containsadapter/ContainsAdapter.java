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

package org.jlib.container.containsadapter;

import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

import org.jlib.container.ContainsSingle;

public abstract class ContainsAdapter<Item>
implements Traversable<Item>,
           ContainsSingle<Item> {

    private final Traversable<Item> items;

    protected ContainsAdapter(final Traversable<Item> items) {
        super();

        this.items = items;
    }

    protected final Traversable<Item> getItems() {
        return items;
    }

    @Override
    public final Traverser<Item> createTraverser() {
        return items.createTraverser();
    }
}
