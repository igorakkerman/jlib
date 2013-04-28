/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

package org.jlib.core.array;

import java.util.Iterator;

/**
 * Wrapper for an array allowing it to be used as {@link Iterable}.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayIterable<Item>
implements Iterable<Item> {

    /** array to traverse */
    private final Item[] array;

    /**
     * Creates a new {@link ArrayIterable} for the specified array.
     * 
     * @param array
     *        array of Items to traverse
     */
    public ArrayIterable(final Item[] array) {
        this.array = array;
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator<Item>(array);
    }
}
