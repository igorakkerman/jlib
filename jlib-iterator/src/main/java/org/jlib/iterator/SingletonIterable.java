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

package org.jlib.iterator;

public class SingletonIterable<Item>
implements BidiIterable<Item> {

    private final Item item;

    public SingletonIterable(final Item item) {

        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public BidiIterator<Item> iterator() {
        return new SingletonIterator<>(this);
    }
}
