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
import static org.jlib.core.language.ExceptionMessageUtility.printf;

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

    /** corresponding {@link ArrayTraversible} */
    private final ArrayTraversible<Item> traversible;

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

        traversible = new ArrayTraversible<>(array);

        arrayLength = array.length;
        currentIndex = initialIndex;
    }

    @Override
    public boolean isNextItemAccessible() {
        return currentIndex < arrayLength;
    }

    @Override
    public Item getNextItem() {
        if (! isNextItemAccessible())
            throw new NoNextItemException(traversible, message(Arrays.toString(array)));

        return array[currentIndex++];
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return currentIndex >= 0;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        if (! isPreviousItemAccessible())
            throw new NoPreviousItemException(traversible, message(Arrays.toString(array)));

        return array[-- currentIndex];
    }

    public static void main(String... commandLineArguments) {
        System.out.println(new ArrayTraverser<>(new Integer[]{ 1, 2, 3 }));

        throw new NoPreviousItemException(new ArrayTraversible<>(new Integer[]{ 1, 2, 3 }), printf());
    }
}
