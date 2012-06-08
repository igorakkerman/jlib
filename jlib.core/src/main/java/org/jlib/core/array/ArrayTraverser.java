package org.jlib.core.array;

import java.util.Arrays;

import org.jlib.core.traverser.BidirectionalTraverser;
import org.jlib.core.traverser.NoNextItemException;
import org.jlib.core.traverser.NoPreviousItemException;
import org.jlib.core.traverser.Traverser;

/**
 * {@link Traverser} over the items of an array.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayTraverser<Item>
implements BidirectionalTraverser<Item> {

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
        if (!isNextItemAccessible())
            throw new NoNextItemException(traversible, "{1}: {2}", Arrays.toString(array));

        return array[currentIndex ++];
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return currentIndex >= 0;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        if (!isPreviousItemAccessible())
            throw new NoPreviousItemException(traversible, "{1}: {2}", Arrays.toString(array));

        return array[-- currentIndex];
    }
}
