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

package org.jlib.container.operation.containsadapter;

import java.util.Collection;

import org.jlib.array.ArrayUtility;

import org.jlib.container.operation.ContainsSingle;
import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;

import static org.jlib.container.iterator.IterableUtility.singletonIterable;

public final class ContainsAdapterUtility {

    public static <Item> ContainsAdapter<Item> item(final Item suppliedItem) {

        return new ContainsAdapter<Item>(singletonIterable(suppliedItem)) {

            @Override
            public boolean contains(final Item item)
            throws InvalidContainerArgumentException, InvalidContainerStateException {
                return suppliedItem.equals(item);
            }
        };
    }

    public static <Item, ContainsSingleIterable extends ContainsSingle<Item> & Iterable<Item>> /*
               */ ContainsAdapter<Item> allOf(final ContainsSingleIterable items) {

        return new ContainsAdapter<Item>(items) {

            @Override
            public boolean contains(final Item item)
            throws InvalidContainerArgumentException, InvalidContainerStateException {
                return items.contains(item);
            }
        };
    }

    public static <Item> ContainsAdapter<Item> allOf(final Iterable<Item> items) {

        return new IterativeContainsAdapter<>(items);
    }

    public static <Item> ContainsAdapter<Item> allOf(final Collection<Item> items) {

        return new ContainsAdapter<Item>(items) {

            @Override
            public boolean contains(final Item item)
            throws InvalidContainerArgumentException, InvalidContainerStateException {
                return items.contains(item);
            }
        };
    }

    @SafeVarargs
    public static <Item> ContainsAdapter<Item> allOf(final Item... items) {
        return new IterativeContainsAdapter<>(ArrayUtility.iterable(items));
    }

    private ContainsAdapterUtility() {}
}
