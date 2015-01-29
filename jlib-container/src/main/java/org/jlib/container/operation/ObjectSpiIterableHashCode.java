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

import org.jlib.object_spi.HashCode;
import org.jlib.object_spi.HashCodeEngine;
import org.jlib.object_spi.ObjectService;

public class ObjectSpiIterableHashCode<Item>
implements HashCode<Iterable<Item>> {

    private static final ObjectSpiIterableHashCode<?> INSTANCE = new ObjectSpiIterableHashCode<>();

    @SuppressWarnings("unchecked")
    public static <Item> ObjectSpiIterableHashCode<Item> getInstance() {
        return (ObjectSpiIterableHashCode<Item>) INSTANCE;
    }

    private ObjectSpiIterableHashCode() {}

    @Override
    public int hashCode(final Iterable<Item> items) {
        final HashCodeEngine engine = ObjectService.getInstance().getCoreFunctionsDispatcher().hashCodeEngine();

        for (final Item item : items)
            engine.append(item);

        return engine.toHashCode();
    }
}
