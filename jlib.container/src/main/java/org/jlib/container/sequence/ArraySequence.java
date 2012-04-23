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

package org.jlib.container.sequence;

import java.util.Arrays;

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
 * {@literal
 * // good(?) old Java array                      // cool(!) new jlib ArraySequence class
 * String[] stringArray = new String[10];         ArraySequence<String> stringArray = new ArraySequence<String>(10);
 * stringArray[4] = "good(?) old Java array";     stringArray.set(4, "cool(!) new jlib ArraySequence class");
 * String s = stringArray[4];                     String s = stringArray.get(4);
 * int size = stringArray.length;                 int size = stringArray.size(); }
 * </pre>
 * 
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <li>Minimum and maximum index: <br/>
 * On instantiation, you can specify the first and the maximum index of the
 * ArraySequence. Thus, no offset is necessary for Arrays starting at other indices than
 * 0. The following example illustrates how an ArraySequence is filled with numbers from
 * 1 to 10:
 * 
 * <pre>
 * // good(?) old Java array                      // cool(!) new jlib ArraySequence class
 * Integer[] integerArray = new Integer[10];      ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(1, 10);
 * for (int i = 1; i <= 10; i ++)                 for (int i = 1; i <= 10; i ++)
 *     integerArray[i - 1] = i;                       integerArray.set(i, i);
 * </pre>
 * 
 * </li>
 * 
 * <li>Conformance to the Collections framework <br/>
 * The class implements the {@code Collection} interface and thus
 * behaves like all Collections.</li>
 * <br />
 * <li>Full support for generics:<br/>
 * The Java arrays do not support generic classes. For example, you cannot
 * create an array of String sequences:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * Sequence<String>[] stringSequenceArray = new Sequence<String>[10];
 *
 * // PERMITTED!
 * ArraySequence<Sequence<String>> stringSequenceArray = new ArraySequence<Sequence<String>>(10);}
 * </pre>
 * 
 * </li>
 * <li>
 * Easy to create:<br />
 * 
 * <pre>
 * {@literal
 * // creating an ArraySequence with three Strings
 * ArraySequence<String> stringArray = new ArraySequence<String>("cool", "ArraySequence", "class!");
 *
 * // creating an ArraySequence with three Strings starting at index 1
 * ArraySequence<String> stringArray = new ArraySequence<String>(1, "jlib", "is", "cool!");}
 * </pre>
 * 
 * To create Arrays of Integers. The Java
 * autoboxing feature forbids the following ArraySequence creation:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * ArraySequence<Integer> integerArray = new ArraySequence<Integer>(1, 2, 3, 4, 5, 6);}
 * </pre>
 * 
 * The compiler claims:
 * 
 * <pre>
 * {@literal The constructor ArraySequence<Integer>(Integer[]) is ambiguous}
 * </pre>
 * 
 * </li>
 * </ul>
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 *        
 * @author Igor Akkerman
 */
// @formatter:on

// TODO: allow negative indices

public class ArraySequence<Element>
extends AbstractNonEmptyIndexSequence<Element>
implements Cloneable {

    /** delegate array of this {@link ArraySequence} */
    private final Object[] delegateArray;

    /**
     * Creates a new {@link ArraySequence} with the specified minimum and
     * maximum indices initialized with {@code null} values.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this {@link ArraySequence}
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this {@link ArraySequence}
     */
    public ArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);

        final int size = getSize();

        delegateArray = new Object[size];
    }

    // @see org.jlib.container.sequence.IndexSequence#get(int)
    @Override
    public Element get(final int index)
    throws SequenceIndexOutOfBoundsException {
        assertIndexValid(index);

        return getDelegateArrayElement(index - firstIndex);
    }

    /**
     * Asserts that the specified index is inside the valid bounds of this
     * {@link ArraySequence}.
     * 
     * @param index
     *        integer specifying the index to verify
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index} is out of the {@link ArraySequence} bounds
     */
    protected void assertIndexValid(final int index)
    throws SequenceIndexOutOfBoundsException {
        if (index < firstIndex || index > lastIndex)
            throw new SequenceIndexOutOfBoundsException(this, index);
    }

    /**
     * Returns the Element stored in the delegate array at the specified index.
     * Provides a typesafe access to the (non generic) array.
     * 
     * @param arrayIndex
     *        index of the Element in the array
     * 
     * @return Element stored at {@code arrayIndex} in the array
     */
    @SuppressWarnings("unchecked")
    private Element getDelegateArrayElement(final int arrayIndex) {
        return (Element) delegateArray[arrayIndex];
    }

    // @see java.lang.Object#clone()
    @Override
    public ArraySequence<Element> clone() {
        final ArraySequence<Element> cloneSequence = new ArraySequence<Element>(firstIndex, lastIndex);

        final int delegateArrayLength = delegateArray.length;

        final Object[] cloneSequenceDelegateArray = cloneSequence.delegateArray;

        for (int delegateArrayIndex = 0; delegateArrayIndex < delegateArrayLength; delegateArrayIndex ++)
            cloneSequenceDelegateArray[delegateArrayIndex] = delegateArray[delegateArrayIndex];

        return cloneSequence;
    }

    // @see org.jlib.container.sequence.IndexSequence#equals(java.lang.Object)
    @Override
    public boolean equals(final Object otherObject) {
        if (!(otherObject instanceof ArraySequence<?>))
            return false;

        final ArraySequence<?> otherSequence = (ArraySequence<?>) otherObject;

        return firstIndex == otherSequence.firstIndex && lastIndex == otherSequence.lastIndex &&
               Arrays.equals(delegateArray, otherSequence.delegateArray);
    }

    // @see org.jlib.container.AbstractContainer#hashCode()
    @Override
    public int hashCode() {
        return 3 * firstIndex + 5 * lastIndex + Arrays.hashCode(delegateArray);
    }
}
