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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jlib.container.Container;

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
 * On instantiation, you can specify the minimum and the maximum index of the
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
 * It doesn't know whether the first parameter is meant to be the minimum index of
 * the ArraySequence or the first Element of the sequence. You could pass a Java array of
 * Integers instead which is the equivalent to the sequence form for the argument
 * {@code Integer... elements} but this class provides an easier way: the
 * factory methods {@link #createIntegerArray(Integer[])} or
 * {@link #createIntegerArrayFrom(int, Integer[])}. The latter form takes the
 * minimum index as first argument.
 * 
 * <pre>
 * // possible but not handy
 * ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(new Integer[] {1, 2, 3, 4, 5, 6});
 * ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(1, new Integer[] {1, 2, 3, 4, 5, 6});
 *
 * // easier to use (needs the static import of the factory method(s))
 * ArraySequence&lt;Integer&gt; integerArray = createIntegerArray(1, 2, 3, 4, 5);
 * ArraySequence&lt;Integer&gt; integerArray = createIntegerArrayFrom(1, 1, 2, 3, 4, 5);
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
public class ArraySequence<Element>
extends AbstractDelegatingReplaceIndexSequence<Element>
implements Cloneable {

    /**
     * Non-empty {@link ReplaceIndexSequence} backed by an {@link ArrayList}.
     * 
     * @param <Element>
     *        type of elements held in the {@link Sequence}
     * 
     * @author Igor Akkerman
     */
    private static class NonEmptyArraySequence<Element>
    extends AbstractNonEmptyReplaceIndexSequence<Element>
    implements Cloneable {

        /** delegate {@link List} of this {@link ArraySequence} */
        private final List<Element> delegateList;

        /**
         * Creates a new {@link NonEmptyArraySequence} with the specified
         * minimum and maximum indices initialized with {@code null} values.
         * 
         * @param firstIndex
         *        integer specifying the minimum index of this
         *        {@link NonEmptyArraySequence}
         * @param maximumIndex
         *        integer specifying the maximum index of this
         *        {@link NonEmptyArraySequence}
         */
        @SuppressWarnings("javadoc")
        public NonEmptyArraySequence(final int minimumIndex, final int maximumIndex) {
            super(minimumIndex, maximumIndex);

            delegateList = new ArrayList<Element>(getSize());
            for (int index = minimumIndex; index <= maximumIndex; index ++)
                delegateList.add(null);
        }

        /**
         * Creates a new NonEmptyArraySequence.
         * 
         * @param minimumIndex
         *        integer specifying the minimum index of this
         *        NonEmptyArraySequence
         * @param elements
         *        Elements added to this NonEmptyArraySequence
         */
        private NonEmptyArraySequence(final int minimumIndex, final List<Element> elements) {
            super(minimumIndex, minimumIndex + elements.size() - 1);

            this.delegateList = new ArrayList<Element>(elements);
        }

        // @see org.jlib.container.sequence.IndexSequence#get(int)
        @Override
        public Element get(final int index)
        throws SequenceIndexOutOfBoundsException {
            if (index < firstIndex || index > maximumIndex)
                throw new SequenceIndexOutOfBoundsException(this, index);

            return delegateList.get(index - firstIndex);
        }

        // @see org.jlib.container.sequence.ReplaceIndexSequence#set(int, java.lang.Object)
        @Override
        public void replace(final int index, final Element element)
        throws SequenceIndexOutOfBoundsException {
            try {
                delegateList.set(index - firstIndex, element);
            }
            catch (final IndexOutOfBoundsException exception) {
                throw new SequenceIndexOutOfBoundsException(this, index);
            }
        }

        // @see org.jlib.container.AbstractContainer#contains(java.lang.Object)
        @Override
        // overridden for efficiency
        public boolean contains(final Object object) {
            return delegateList.contains(object);
        }

        // @see org.jlib.container.AbstractContainer#containsAll(Container)
        // overridden for efficiency
        @Override
        public boolean containsAll(final Collection<? extends Element> collection) {
            return delegateList.containsAll(collection);
        }

        // @see java.lang.Object#clone()
        @Override
        public Object clone() {
            return new NonEmptyArraySequence<Element>(firstIndex, delegateList);
        }

        // @see org.jlib.container.sequence.IndexSequence#equals(java.lang.Object)
        @Override
        public boolean equals(final Object otherObject) {
            if (!(otherObject instanceof NonEmptyArraySequence<?>))
                return false;
            final NonEmptyArraySequence<?> otherArray = (NonEmptyArraySequence<?>) otherObject;
            return firstIndex == otherArray.firstIndex && maximumIndex == otherArray.maximumIndex &&
                   delegateList.equals(otherArray.delegateList);
        }

        // @see org.jlib.container.AbstractContainer#hashCode()
        @Override
        public int hashCode() {
            return 3 * firstIndex + 5 * maximumIndex + delegateList.hashCode();
        }
    }

    /** delegate {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequence<Element> delegateSequence;

    /**
     * Creates a new ArraySequence initially filled with {@code null} Elements.
     * 
     * @param minimumIndex
     *        integer specifying the minimum index of this ArraySequence
     * @param maximumIndex
     *        integer specifying the maximum index of this ArraySequence
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0 || maximumIndex < firstIndex}
     */
    public ArraySequence(final int minimumIndex, final int maximumIndex)
    throws IllegalArgumentException {
        super();

        delegateSequence = new NonEmptyArraySequence<Element>(minimumIndex, maximumIndex);
    }

    /**
     * Creates a new ArraySequence initially filled with {@code null} Elements.
     * 
     * @param size
     *        integer specifying the size of this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code size < 0}
     */
    public ArraySequence(final int size)
    throws IllegalArgumentException {
        this(0, size - 1);
    }

    /**
     * Creates a new ArraySequence containing the specified Elements. That is,
     * the index of the first Element of the specified sequence in this
     * ArraySequence is 0. The fixed size of this ArraySequence is the size of
     * the specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Elements to store or Java array
     *        containing those Elements
     */
    @SafeVarargs
    public ArraySequence(final Element... elements) {
        this(0, elements);
    }

    /**
     * Creates a new ArraySequence containing the specified Integer Elements.
     * That is, the index of the first Element of the specified sequence in this
     * ArraySequence is 0. The fixed size of this ArraySequence is the size of
     * the specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Integer Elements to store or Java
     *        array containing those Elements
     * @return the new ArraySequence of Integers
     */
    public static ArraySequence<Integer> createIntegerArray(final Integer... elements) {
        return new ArraySequence<Integer>(0, elements);
    }

    /**
     * Creates a new ArraySequence containing the specified Elements having a
     * specified minimum index. That is, the index of the first Element of the
     * specified sequence in this ArraySequence can be specified. The fixed size
     * of this ArraySequence is the size of the specified sequence.
     * 
     * @param minimumIndex
     *        integer specifying the minimum index of this ArraySequence
     * @param elements
     *        comma separated sequence of Elements to store or Java array
     *        containing those Elements
     */
    @SafeVarargs
    public ArraySequence(final int minimumIndex, final Element... elements) {
        this(minimumIndex, minimumIndex + elements.length - 1);

        for (int elementsIndex = 0, arrayIndex = minimumIndex; elementsIndex < elements.length; elementsIndex ++, arrayIndex ++)
            delegateSequence.replace(arrayIndex, elements[elementsIndex]);
    }

    /**
     * Creates a new ArraySequence containing the specified Integer Elements
     * having a specified minimum index. That is, the index of the first Element
     * of the specified sequence in this ArraySequence can be specified. The
     * fixed size of this ArraySequence is the size of the specified sequence.
     * 
     * @param minimumIndex
     *        integer specifying the minimum index of this ArraySequence
     * @param elements
     *        comma separated sequence of Integer elements to store or Java
     *        array containing those Elements
     * @return the new ArraySequence of Integers
     */
    public static ArraySequence<Integer> createIntegerArrayFrom(final int minimumIndex, final Integer... elements) {
        return new ArraySequence<Integer>(minimumIndex, elements);
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified
     * Container. The index of the first Element of the specified Container in
     * this ArraySequence is 0. The fixed size of this ArraySequence is the size
     * of the specified Container.
     * 
     * @param collection
     *        Container of which the Elements are copied to this ArraySequence
     * @throws IllegalArgumentException
     *         if {@code collection} is {@code null}
     */
    public ArraySequence(final Container<Element> collection) {
        this(0, collection);
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified Java
     * Container. The index of the first Element of the specified Container in
     * this ArraySequence is 0. The fixed size of this ArraySequence is the size
     * of the specified Container.
     * 
     * @param collection
     *        Collection of which the Elements are copied to this ArraySequence
     */
    public ArraySequence(final Collection<Element> collection) {
        this(0, collection);
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified
     * Container having a specified minimum index. That is, the index of the
     * first Element of the specified collection in this ArraySequence can be
     * specified. The fixed size of this ArraySequence is the size of the
     * specified Container.
     * 
     * @param minimumIndex
     *        integer specifying the minimum index of this ArraySequence. The
     *        first Element of {@code collection} is stored at this index of
     *        this ArraySequence.
     * @param elements
     *        Container of which the Elements are copied to this ArraySequence
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    public ArraySequence(final int minimumIndex, final Container<Element> elements)
    throws IllegalArgumentException {
        this(minimumIndex, minimumIndex + elements.getSize() - 1);

        int arrayIndex = minimumIndex;
        for (final Iterator<Element> collectionIterator = elements.iterator(); collectionIterator.hasNext(); arrayIndex ++)
            delegateSequence.replace(arrayIndex, collectionIterator.next());
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified
     * Container having a specified minimum index. That is, the index of the
     * first Element of the specified collection in this ArraySequence can be
     * specified. The fixed size of this ArraySequence is the size of the
     * specified Container.
     * 
     * @param minimumIndex
     *        integer specifying the minimum index of this ArraySequence. The
     *        first Element of {@code collection} is stored at this index of
     *        this ArraySequence.
     * @param collection
     *        Container of which the Elements are copied to this ArraySequence
     * @throws NullPointerException
     *         if {@code collection} is {@code null}
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    public ArraySequence(final int minimumIndex, final Collection<Element> collection)
    throws NullPointerException, IllegalArgumentException {
        this(minimumIndex, minimumIndex + collection.size() - 1);

        int arrayIndex = minimumIndex;
        for (final Iterator<Element> collectionIterator = collection.iterator(); collectionIterator.hasNext(); arrayIndex ++)
            delegateSequence.replace(arrayIndex, collectionIterator.next());
    }

    @Override
    protected ReplaceIndexSequence<Element> getDelegateSequence() {
        return delegateSequence;
    }
}
