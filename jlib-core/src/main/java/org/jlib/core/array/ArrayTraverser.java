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

import java.util.Arrays;

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.core.language.AbstractObject;
import org.jlib.core.traverser.NoNextItemException;
import org.jlib.core.traverser.NoPreviousItemException;
import org.jlib.core.traverser.TwoWayTraverser;

/**
 * {@link TwoWayTraverser} over the items of an array.
 *
 * @param <Item>
 *        type of the items held in the array
 *
 * @author Igor Akkerman
 */
public class ArrayTraverser<Item>
extends AbstractObject
implements TwoWayTraverser<Item> {

    /** array to traverse */
    private final Item[] array;

    /** length of the array */
    private final int arrayLength;

    /** corresponding {@link ArrayTraversable} */
    private final ArrayTraversable<Item> traversable;

    /** current index */
    private int currentIndex = 0;

    /**
     * Creates a new {@link ArrayTraverser}.
     *
     * @param array
     *        array to traverse
     */
    public ArrayTraverser(final Item[] array) {
        this(array, 0);
    }

    /**
     * Creates a new {@link ArrayTraverser} beginning the iteration at the
     * specified initial index.
     *
     * @param array
     *        array to traverse
     *
     * @param initialIndex
     *        integer specifying the initial index
     */
    public ArrayTraverser(final Item[] array, final int initialIndex) {
        this.array = array;

        traversable = new ArrayTraversable<>(array);

        arrayLength = array.length;
        currentIndex = initialIndex;
    }

    @Override
    public boolean hasNextItem() {
        return currentIndex < arrayLength;
    }

    @Override
    public Item getNextItem() {
        if (! hasNextItem())
            throw new NoNextItemException(traversable, message(Arrays.toString(array)));

        return array[currentIndex++];
    }

    @Override
    public boolean hasPreviousItem() {
        return currentIndex >= 0;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        if (! hasPreviousItem())
            throw new NoPreviousItemException(traversable, message(Arrays.toString(array)));

        return array[-- currentIndex];
    }
}
