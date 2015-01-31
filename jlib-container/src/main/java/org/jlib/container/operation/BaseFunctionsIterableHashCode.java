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

package org.jlib.container.operation;

import org.jlib.basefunctions.HashCode;
import org.jlib.basefunctions.HashCodeEngine;
import org.jlib.basefunctions.BaseFunctionsService;

public class BaseFunctionsIterableHashCode<Item>
implements HashCode<Iterable<Item>> {

    private static final BaseFunctionsIterableHashCode<?> INSTANCE = new BaseFunctionsIterableHashCode<>();

    @SuppressWarnings("unchecked")
    public static <Item> BaseFunctionsIterableHashCode<Item> getInstance() {
        return (BaseFunctionsIterableHashCode<Item>) INSTANCE;
    }

    private BaseFunctionsIterableHashCode() {}

    @Override
    public int hashCode(final Iterable<Item> items) {
        final HashCodeEngine<Iterable<Item>> engine = BaseFunctionsService.getInstance().getBaseFunctionsDispatcher().hashCodeEngine(items);

        for (final Item item : items)
            engine.append(item);

        return engine.toHashCode();
    }
}
