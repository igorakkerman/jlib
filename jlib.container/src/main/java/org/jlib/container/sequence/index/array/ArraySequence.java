/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence.index.array;

import java.util.Arrays;
import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.IllegalSequenceSizeException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.AbstractInitializeableIndexSequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.ValueObserver;

import static org.jlib.core.array.ArrayUtility.createArray;

// @formatter:off
/**
 * <p>
 * Fixed sized array. Replacement for the standard Java arrays with special
 * features.
 * </p>
 * <p>
 * The only syntactical difference to Java arrays lies in the notation for
 * retrieving and providing values and retrieving the array size:
 * </p>
 * 
 * <pre>
 * {
 *     &#064;literal
 *     // good(?) old Java array                      // cool(!) new jlib ArraySequence class
 *     String[] stringArray = new String[10];
 *     ArraySequence&lt;String&gt; stringArray = new ArraySequence&lt;String&gt;(10);
 *     stringArray[4] = &quot;good(?) old Java array&quot;;
 *     stringArray.set(4, &quot;cool(!) new jlib ArraySequence class&quot;);
 *     String s = stringArray[4];
 *     String s = stringArray.get(4);
 *     int size = stringArray.length;
 *     int size = stringArray.size();
 * }
 * </pre>
 * 
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <lem>Minimum and maximum index: <br/>
 * On instantiation, you can specify the first and the maximum index of the
 * ArraySequence. Thus, no offset is necessary for Arrays starting at other
 * indices than 0. The following example illustrates how an ArraySequence is
 * filled with numbers from 1 to 10:
 * 
 * <pre>
 * // good(?) old Java array                      // cool(!) new jlib ArraySequence class
 * Integer[] integerArray = new Integer[10];
 * ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(1, 10);
 * for (int i = 1; i &lt;= 10; i ++)
 *     for (int i = 1; i &lt;= 10; i ++)
 *         integerArray[i - 1] = i;
 * integerArray.set(i, i);
 * </pre>
 * 
 * </lem>
 * 
 * <lem>Conformance to the Collections framework <br/>
 * The class implements the {@code Collection} interface and thus behaves like
 * all Collections.</lem> <br />
 * <lem>Full support for generics:<br/>
 * The Java arrays do not support generic classes. For example, you cannot
 * create an array of String sequences:
 * 
 * <pre>
 * {
 *     &#064;literal
 *     // FORBIDDEN!
 *     Sequence&lt;String&gt;[] stringSequenceArray = new Sequence&lt;String&gt;[10];
 * 
 *     // PERMITTED!
 *     ArraySequence&lt;Sequence&lt;String&gt;&gt; stringSequenceArray = new ArraySequence&lt;Sequence&lt;String&gt;&gt;(10);
 * }
 * </pre>
 * 
 * </lem> <lem> Easy to create:<br />
 * 
 * <pre>
 * {
 *     &#064;literal
 *     // creating an ArraySequence with three Strings
 *     ArraySequence&lt;String&gt; stringArray = new ArraySequence&lt;String&gt;(&quot;cool&quot;, &quot;ArraySequence&quot;, &quot;class!&quot;);
 * 
 *     // creating an ArraySequence with three Strings starting at index 1
 *     ArraySequence&lt;String&gt; stringArray = new ArraySequence&lt;String&gt;(1, &quot;jlib&quot;, &quot;is&quot;, &quot;cool!&quot;);
 * }
 * </pre>
 * 
 * To create Arrays of Integers. The Java autoboxing feature forbids the
 * following ArraySequence creation:
 * 
 * <pre>
 * {
 *     &#064;literal
 *     // FORBIDDEN!
 *     ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(1, 2, 3, 4, 5, 6);
 * }
 * </pre>
 * 
 * The compiler claims:
 * 
 * <pre>
 * {@literal The constructor ArraySequence<Integer>(Integer[]) is ambiguous}
 * </pre>
 * 
 * </lem>
 * </ul>
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
// @formatter:on
public class ArraySequence<Item>
extends AbstractInitializeableIndexSequence<Item>
implements Cloneable {

    /** array holding the Items of this {@link ArraySequence} */
    private Item[] delegateArray;

    /**
     * Creates a new {@link ArraySequence} with the specified minimum and
     * maximum indices initialized with {@code null} values.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this {@link ArraySequence}
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this {@link ArraySequence}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code  lastIndex < firstIndex}
     */
    protected ArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);

        delegateArray = createArray(getItemsCount());
    }

    /**
     * <p>
     * Creates a new {@link IndexSequence} containing the specified Integer
     * Items having a specified first index. That is, the index of the first
     * Item of the specified sequence in the newly created {@link IndexSequence}
     * can be specified. The fixed size of the newly created
     * {@link IndexSequence} is the size of the specified sequence.
     * </p>
     * <p>
     * It doesn't know whether the first parameter is meant to be the minimum
     * index of the {@link IndexSequence} or the first Item of the sequence. You
     * could pass an array of {@link Integer} values instead which is the
     * equivalent to the sequence form for the argument {@code Integer... items}
     * but the newly created class provides an easier way: the factory methods
     * {@link #createIntegerArraySequence(Integer...)} or
     * {@link #createIntegerArraySequenceFrom(int, Integer[])} . The latter form
     * takes the minimum index as first argument.
     * </p>
     * 
     * {@literal
     *     // possible but not handy
     *     IndexSequence&lt;Integer&gt; integerSequence = createIntegerIndexSequence&lt;Integer&gt;new Integer[] 1, 2, 3, 4, 5, 6 }
     * );
     * 
     * IndexSequence&lt;Integer&gt; integerSequence =
     * createIntegerIndexSequence&lt;Integer&gt;(1, new Integer[] { 1, 2, 3, 4,
     * 5, 6 });
     * 
     * // easier to use (needs the static import of the factory method(s))
     * IndexSequence&lt;Integer&gt; integerSequence = createIntegerSequence(1,
     * 2, 3, 4, 5);
     * 
     * IndexSequence&lt;Integer&gt; integerSequence =
     * createIntegerSequenceFrom(1, 1, 2, 3, 4, 5); }
     * 
     * @param firstIndex
     *        integer specifying the minimum index
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the insertion
     *        of Items
     * 
     * @param items
     *        comma separated sequence of {@link Integer} Items to store
     * 
     * @return new {@link IndexSequence} of {@link Integer} Items
     */
    public static ArraySequence<Integer> createIntegerIndexSequenceFrom(final int firstIndex,
                                                                        final ValueObserver<Integer>[] observers,
                                                                        final Integer... items) {
        return new ArraySequence<Integer>(firstIndex, observers, items);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Integer Items
     * having a first index of {@code 0}. The fixed size of the {@link Sequence}
     * is the size of the specified sequence.
     * 
     * @param observers
     *        array of {@link ValueObserver} instances attending the insertion
     *        of Items
     * 
     * @param items
     *        comma separated sequence of {@link Integer} items to store
     * 
     * @return the newly created {@link Sequence}
     */

    public static ArraySequence<Integer> createIntegerIndexSequence(final ValueObserver<Integer>[] observers,
                                                                    final Integer... items) {
        return new ArraySequence<Integer>(0, observers, items);
    }

    /**
     * Creates a new {@link AbstractInitializeableIndexSequence} containing the
     * Items of the specified Java Container. The index of the first Item of the
     * specified Container in the {@link AbstractInitializeableIndexSequence} is
     * 0. The fixed size of the {@link AbstractInitializeableIndexSequence} is
     * the size of the specified Container.
     * 
     * @param items
     *        Collection of which the Items are copied to the
     *        {@link AbstractInitializeableIndexSequence}
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the insertion of Items
     */
    public ArraySequence(final Collection<? extends Item> items, final ValueObserver<Item>... observers) {
        super(items, observers);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     */
    public ArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     * @param observers
     */
    public ArraySequence(final Container<? extends Item> items, final ValueObserver<Item>... observers) {
        super(items, observers);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     */
    public ArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     * @param observers
     */
    public ArraySequence(final int firstIndex, final Collection<? extends Item> items,
                         final ValueObserver<Item>... observers) {
        super(firstIndex, items, observers);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     */
    public ArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     * @param observers
     */
    public ArraySequence(final int firstIndex, final Container<? extends Item> items,
                         final ValueObserver<Item>... observers) {
        super(firstIndex, items, observers);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     */
    public ArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param firstIndex
     * @param items
     */
    public ArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     */
    public ArraySequence(final int firstIndex, final ValueObserver<Item>[] observers, final Item... items) {
        super(firstIndex, observers, items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param size
     * @throws IllegalSequenceSizeException
     */
    public ArraySequence(final int size)
    throws IllegalSequenceSizeException {
        super(size);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param items
     */
    public ArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ArraySequence}.
     * 
     * @param observers
     * @param items
     */
    public ArraySequence(final ValueObserver<Item>[] observers, final Item... items) {
        super(observers, items);
    }

    /**
     * Returns the Item stored at the specified index expecting the index to be
     * valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @return Item stored at {@code index}
     */
    @Override
    protected Item getStoredItem(final int index) {
        return getDelegateArrayItem(getDelegateArrayIndex(index));
    }

    @Override
    protected void replaceStoredItem(final int index, final Item item) {
        replaceDelegateArrayItem(getDelegateArrayIndex(index), item);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void replaceStoredItem(final int index, final Item newItem, final ValueObserver<Item>... observers) {
        ObserverUtility.operate(new Operator() {

            @Override
            public void operate() {
                replaceStoredItem(getDelegateArrayIndex(index), newItem);
            }
        },

        newItem, observers); // throws SequenceIndexOutOfBoundsException
    }

    /**
     * Returns the delegate array index in the specified index in this
     * {@link ArraySequence}.
     * 
     * @param index
     *        integer specifying the index of the Item in the
     *        {@link ArraySequence}
     * 
     * @return integer specifying the corresponding index in the delegate array
     */
    protected int getDelegateArrayIndex(final int index) {
        return index - getFirstIndex();
    }

    /**
     * Returns the Item stored in the delegate array at the specified index.
     * Provides a typesafe access to the (non generic) array.
     * 
     * @param arrayIndex
     *        index of the Item in the array
     * 
     * @return Item stored at {@code arrayIndex} in the array
     */
    protected Item getDelegateArrayItem(final int arrayIndex) {
        return delegateArray[arrayIndex];
    }

    /**
     * Replaces the Item stored in the delegate array at the specified index.
     * Provides a typesafe access to the (non generic) array.
     * 
     * @param arrayIndex
     *        integer specifying the index of the Item in the array
     * 
     * @param item
     *        replacing Item
     */
    protected void replaceDelegateArrayItem(final int arrayIndex, final Item item) {
        delegateArray[arrayIndex] = item;
    }

    @Override
    public ArraySequence<Item> clone() {
        final ArraySequence<Item> cloneSequence = new ArraySequence<Item>(getFirstIndex(), getLastIndex());

        final int delegateArrayLength = delegateArray.length;

        final Object[] cloneSequenceDelegateArray = cloneSequence.delegateArray;

        for (int delegateArrayIndex = 0; delegateArrayIndex < delegateArrayLength; delegateArrayIndex ++)
            cloneSequenceDelegateArray[delegateArrayIndex] = delegateArray[delegateArrayIndex];

        return cloneSequence;
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (!(otherObject instanceof ArraySequence<?>))
            return false;

        final ArraySequence<?> otherSequence = (ArraySequence<?>) otherObject;

        return getFirstIndex() == otherSequence.getFirstIndex() && getLastIndex() == otherSequence.getLastIndex() &&
               Arrays.equals(delegateArray, otherSequence.delegateArray);
    }

    @Override
    public int hashCode() {
        return 3 * getFirstIndex() + 5 * getLastIndex() + Arrays.hashCode(delegateArray);
    }

    /**
     * Asserts that the delegate array has the specified expected capacity,
     * replacing it by a larger {@code null} padded copy, if necessary.
     * 
     * @param expectedCapacity
     *        integer specifying the expected capacity
     * 
     * @throws IllegalArgumentException
     *         if {@code expectedCapacity < 1}
     */
    protected void assertCapacity(final int expectedCapacity) {
        assertExpectedCapacityValid(expectedCapacity);

        if (delegateArray.length < expectedCapacity)
            delegateArray = Arrays.copyOf(delegateArray, expectedCapacity);
    }

    /**
     * Asserts that the delegate array has the specified expected capacity,
     * replacing it by a larger {@code null} padded copy, if necessary.
     * 
     * @param expectedCapacity
     *        integer specifying the expected capacity
     * 
     * @param holeArrayIndex
     *        integer specifying the insert index
     * 
     * @param holeSize
     *        integer specifying the size of the hole
     * 
     * @throws InvalidDelegateArrayCapacityException
     *         if
     *         {@code expectedCapacity < 1 || getSize() + holeSize > expectedCapacity}
     */
    protected void assertCapacityWithHole(final int expectedCapacity, final int holeArrayIndex, final int holeSize)
    throws InvalidDelegateArrayCapacityException {
        assertExpectedCapacityValid(expectedCapacity);

        if (getItemsCount() + holeSize > expectedCapacity)
            throw new InvalidDelegateArrayCapacityException(
                                                            this,
                                                            expectedCapacity,
                                                            "{0}: getSize() + items.length == {2} + {3} > {1} == expectedCapacity",
                                                            getItemsCount(), holeSize);

        final Item[] originalDelegateArray = delegateArray;

        if (delegateArray.length < expectedCapacity) {
            delegateArray = createArray(expectedCapacity);

            System.arraycopy(originalDelegateArray, 0, delegateArray, 0, holeArrayIndex);
        }

        System.arraycopy(originalDelegateArray, holeArrayIndex, delegateArray, holeArrayIndex + holeSize,
                         getItemsCount() - holeArrayIndex);

        Arrays.fill(delegateArray, getItemsCount() + expectedCapacity, delegateArray.length, null);
    }

    /**
     * Asserts that the specified expected capacity is valid.
     * 
     * @param expectedCapacity
     *        integer specifying the expected capacity
     * 
     * @throws InvalidDelegateArrayCapacityException
     *         if {@code expectedCapacity < 1}
     */
    protected void assertExpectedCapacityValid(final int expectedCapacity)
    throws InvalidDelegateArrayCapacityException {
        if (expectedCapacity < 1)
            throw new InvalidDelegateArrayCapacityException(this, expectedCapacity, "{0}: expectedCapacity == {1} < 1");
    }
}
