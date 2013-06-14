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

package org.jlib.core.array;

import org.jlib.core.iterator.AbstractIterator;

import java.util.Iterator;

/**
 * {@link Iterator} over the items of an array.
 *
 * @param <Item>
 *        type of the items held in the array
 *
 * @author Igor Akkerman
 */
public class ArrayIterator<Item>
extends AbstractIterator<Item> {

    /** array to traverse */
    private final Item[] array;

    /** length of the array */
    private final int arrayLength;

    /** current index */
    private int currentIndex = 0;

    /**
     * Creates a new {@link ArrayIterator}.
     *
     * @param array
     *        array to traverse
     */
    public ArrayIterator(final Item[] array) {
        this(array, 0);
    }

    /**
     * Creates a new {@link ArrayIterator} beginning the iteration at the
     * specified initial index.
     *
     * @param array
     *        array to traverse
     *
     * @param initialIndex
     *        integer specifying the initial index
     */
    public ArrayIterator(final Item[] array, final int initialIndex) {
        this.array = array;
        arrayLength = array.length;
        currentIndex = initialIndex;
    }

    // @see java.util.Iterator#hasNext()
    @Override
    public boolean hasNext() {
        return currentIndex < arrayLength;
    }

    // @see java.util.Iterator#next()
    @Override
    public Item next() {
        return array[currentIndex++];
    }
}
