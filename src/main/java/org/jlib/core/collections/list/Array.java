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

package org.jlib.core.collections.list;

import java.util.ArrayList;

import org.jlib.core.collections.Collection;

/**
 * <p>
 * Fixed sized array. Replacement for the standard Java arrays with special features.
 * </p>
 * <p>
 * The only syntactical difference to Java arrays lies in the syntax of setting and
 * getting objects and getting the array size:
 * </p>
 * 
 * <pre>
 * {@literal
 * // good(?) old Java array                      // cool(!) new jlib Array class
 * String[] stringArray = new String[10];         Array<String> stringArray = new Array<String>(10);
 * stringArray[4] = "good(?) old Java array";     stringArray.set(4, "cool(!) new jlib Array class");
 * String s = stringArray[4];                     String s = stringArray.get(4);
 * int size = stringArray.length;                 int size = stringArray.size(); }
 * </pre>
 * 
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <li> Minimum and maximum index: <br/> On instantiation, you can specify the minimum and
 * the maximum index of the Array. Thus, no offset is necessary for Arrays starting at
 * other indices than 0. The following example illustrates how an Array is filled with
 * numbers from 1 to 10:
 * 
 * <pre>
 * {@literal
 * // good(?) old Java array                      // cool(!) new jlib Array class
 * Integer[] integerArray = new Integer[10];      Array<Integer> integerArray = new Array<Integer>(1, 10);
 * for (int i = 1; i <= 10; i ++)                 for (int i = 1; i <= 10; i ++)
 *     integerArray[i - 1] = i;                       integerArray.set(i, i); }
 * </pre>
 * 
 * </li>
 * <li> Conformance to the Java Collections framework <br/> The class implements the
 * {@code java.util.Collection} interface and thus behaves like all Java Collections.
 * </li>
 * <br />
 * <li> Full support for generics:<br/> The Java arrays do not support generic classes.
 * For example, you cannot create an array of String lists:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * List<String>[] stringListArray = new List<String>[10];
 *
 * // PERMITTED!
 * Array<List<String>> stringListArray = new Array<List<String>>(10);}
 * </pre>
 * 
 * </li>
 * <li> Easy to create:<br />
 * 
 * <pre>
 * {@literal
 * // creating an Array with three Strings
 * Array<String> stringArray = new Array<String>("cool", "Array", "class!");
 *
 * // creating an Array with three Strings starting at index 1
 * Array<String> stringArray = new Array<String>(1, "jlib", "is", "cool!");}
 * </pre>
 * 
 * A small problem arises if you want to create Arrays of Integers. The Java autoboxing
 * feature forbids the following Array creation:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * Array<Integer> integerArray = new Array<Integer>(1, 2, 3, 4, 5, 6);}
 * </pre>
 * 
 * The compiler claims:
 * 
 * <pre>
 * {@literal The constructor Array<Integer>(Integer[]) is ambiguous}
 * </pre>
 * 
 * It doesn't know whether the first parameter is meant as the minimum index of the Array
 * or the first Element of the list. You could pass a Java array of Integers instead which
 * is the equivalent to the list form for the argument {@code Integer... elements} but
 * this class provides an easier way: the factory methods
 * {@link #newIntegerArray(Integer[])} or {@link #newIntegerArrayFrom(int, Integer[])}.
 * The latter form takes the minimum index as first argument.
 * 
 * <pre>
 * // possible but not handy
 * Array&lt;Integer&gt; integerArray = new Array&lt;Integer&gt;(new Integer[] {1, 2, 3, 4, 5, 6});
 * Array&lt;Integer&gt; integerArray = new Array&lt;Integer&gt;(1, new Integer[] {1, 2, 3, 4, 5, 6});
 *
 * // easier to use (needs the static import of the factory method(s))
 * Array&lt;Integer&gt; integerArray = newIntegerArray(1, 2, 3, 4, 5);
 * Array&lt;Integer&gt; integerArray = newIntegerArrayFrom(1, 1, 2, 3, 4, 5);
 * </pre>
 * 
 * </li>
 * </ul>
 * 
 * @param <Element>
 *        type of elements held in the List
 * @author Igor Akkerman
 */
public class Array<Element>
extends AbstractEditableIndexList<Element>
implements Cloneable {

    /** ArrayList containing the Elements of this Array */
    private ArrayList<Element> backedList;

    /**
     * Creates a new empty Array.
     */
    public Array() {
        super();
        construct();
    }

    /**
     * Creates a new Array initially filled with {@code null} Elements.
     * 
     * @param size
     *        integer specifying the size of this Array
     * @throws IllegalArgumentException
     *         if {@code size < 0}
     */
    public Array(int size) 
    throws IllegalArgumentException {
        super();
        if (size != 0)
            construct(0, size - 1);
        else
            construct();
    }

    /**
     * Creates a new Array initially filled with {@code null} Elements.
     * 
     * @param minIndex
     *        integer specifying the minimum index of this Array
     * @param maxIndex
     *        integer specifying the maximum index of this Array
     * @throws IllegalArgumentException
     *         if {@code minIndex < 0 || maxIndex < minIndex}
     */
    public Array(int minIndex, int maxIndex)
    throws IllegalArgumentException {
        super();
        construct(minIndex, maxIndex);
    }

    /**
     * Creates a new Array containing the specified Elements. That is, the index
     * of the first Element of the specified list in this Array is 0. The fixed
     * size of this Array is the size of the specified list.
     * 
     * @param elements
     *        comma separated list of Elements to store or Java array containing
     *        those Elements
     */
    public Array(Element... elements) {
        this(0, elements);
    }

    /**
     * Creates a new Array containing the specified Integer Elements. That is,
     * the index of the first Element of the specified list in this Array is 0.
     * The fixed size of this Array is the size of the specified list.
     * 
     * @param elements
     *        comma separated list of Integer Elements to store or Java array
     *        containing those Elements
     * @return the new Array of Integers
     */
    public static Array<Integer> newIntegerArray(Integer... elements) {
        return new Array<Integer>(0, elements);
    }

    /**
     * Creates a new Array containing the specified Elements having a specified
     * minimum index. That is, the index of the first Element of the specified
     * list in this Array can be specified. The fixed size of this Array is the
     * size of the specified list.
     * 
     * @param minIndex
     *        integer specifying the minimum index of this Array
     * @param elements
     *        comma separated list of Elements to store or Java array containing
     *        those Elements
     */
    public Array(int minIndex, Element... elements) {
        super();
        if (elements.length != 0)
            construct(minIndex, minIndex + elements.length - 1);
        else
            construct();

        for (int index = 0; index < elements.length; index ++)
            backedList.set(index, elements[index]);
    }

    /**
     * Creates a new Array containing the specified Integer Elements having a
     * specified minimum index. That is, the index of the first Element of the
     * specified list in this Array can be specified. The fixed size of this
     * Array is the size of the specified list.
     * 
     * @param minIndex
     *        integer specifying the minimum index of this Array
     * @param elements
     *        comma separated list of Integer elements to store or Java array
     *        containing those Elements
     * @return the new Array of Integers
     */
    public static Array<Integer> newIntegerArrayFrom(int minIndex, Integer... elements) {
        return new Array<Integer>(minIndex, elements);
    }

    /**
     * Creates a new Array containing the Elements of the specified Collection.
     * The index of the first Element of the specified Collection in this Array
     * is 0. The fixed size of this Array is the size of the specified
     * Collection.
     * 
     * @param collection
     *        Collection of which the Elements are copied to this Array
     * @throws NullPointerException
     *         if {@code collection} is {@code null}
     */
    public Array(Collection<Element> collection)
    throws NullPointerException {
        this(0, collection);
    }

    /**
     * Creates a new Array containing the Elements of the specified Java
     * Collection. The index of the first Element of the specified Collection in
     * this Array is 0. The fixed size of this Array is the size of the
     * specified Collection.
     * 
     * @param collection
     *        Java Collection of which the Elements are copied to this Array
     * @throws NullPointerException
     *         if {@code collection} is {@code null}
     */
    public Array(java.util.Collection<Element> collection)
    throws NullPointerException {
        this(0, collection);
    }

    /**
     * Creates a new Array containing the Elements of the specified Collection
     * having a specified minimum index. That is, the index of the first Element
     * of the specified collection in this Array can be specified. The fixed
     * size of this Array is the size of the specified Collection.
     * 
     * @param minIndex
     *        integer specifying the minimum index of this Array. The first
     *        Element of {@code collection} is stored at this index of this
     *        Array.
     * @param collection
     *        Collection of which the Elements are copied to this Array
     * @throws NullPointerException
     *         if {@code collection} is {@code null}
     * @throws IllegalArgumentException
     *         if {@code minIndex < 0}
     */
    public Array(int minIndex, Collection<Element> collection)
    throws NullPointerException, IllegalArgumentException {
        super();
        if (minIndex < 0)
            throw new IllegalArgumentException();

        int collectionSize = collection.size();
        backedList = new ArrayList<Element>(collectionSize);
        for (Element collectionElement : collection)
            backedList.add(collectionElement);

        this.minIndex = minIndex;
        this.maxIndex = minIndex + collectionSize - 1;
    }

    /**
     * Creates a new Array containing the Elements of the specified Collection
     * having a specified minimum index. That is, the index of the first Element
     * of the specified collection in this Array can be specified. The fixed
     * size of this Array is the size of the specified Collection.
     * 
     * @param minIndex
     *        integer specifying the minimum index of this Array. The first
     *        Element of {@code collection} is stored at this index of this
     *        Array.
     * @param collection
     *        Collection of which the Elements are copied to this Array
     * @throws NullPointerException
     *         if {@code collection} is {@code null}
     * @throws IllegalArgumentException
     *         if {@code minIndex < 0}
     */
    public Array(int minIndex, java.util.Collection<Element> collection)
    throws NullPointerException, IllegalArgumentException {
        super();
        if (minIndex < 0)
            throw new IllegalArgumentException();

        backedList = new ArrayList<Element>(collection);

        this.minIndex = minIndex;
        this.maxIndex = minIndex + backedList.size() - 1;
    }

    /**
     * Constructs this Array as empty.
     */
    private void construct() {
        backedList = new ArrayList<Element>(0);
        minIndex = -1;
        maxIndex = -2;
    }

    /**
     * Constructs this Array.
     * 
     * @param minIndex
     *        integer specifying the minimum index of this Array
     * @param maxIndex
     *        integer specifying the maximum index of this Array
     * @throws IllegalArgumentException
     *         if {@code minIndex < 0 || minIndex > maxIndex}
     */
    @SuppressWarnings("hiding")
    private void construct(int minIndex, int maxIndex)
    throws IllegalArgumentException {
        if (minIndex < 0 || minIndex > maxIndex)
            throw new IllegalArgumentException();

        int size = maxIndex - minIndex + 1;
        backedList = new ArrayList<Element>(size);
        for (int index = 0; index < size; index ++)
            backedList.add(null);

        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    // -------------------------------------------------------------------------------------

    // @see org.jlib.core.collections.list.IndexList#get(int)
    @Override
    public Element get(int index)
    throws ListIndexOutOfBoundsException {
        try {
            return backedList.get(index - minIndex);
        }
        catch (IndexOutOfBoundsException exception) {
            throw new ListIndexOutOfBoundsException(index);
        }
    }

    // @see org.jlib.core.collections.list.EditableIndexList#set(int, java.lang.Object)
    @Override
    public Element set(int index, Element element)
    throws ListIndexOutOfBoundsException {
        try {
            Element oldElement = get(index);
            backedList.set(index - minIndex, element);
            return oldElement;
        }
        catch (IndexOutOfBoundsException exception) {
            throw new ListIndexOutOfBoundsException(index);
        }
    }

    // @see org.jlib.core.collections.AbstractCollection#contains(java.lang.Object)
    @Override
    // overridden for efficiency
    public boolean contains(Object object) {
        return backedList.contains(object);
    }

    // @see org.jlib.core.collections.AbstractCollection#containsAll(org.jlib.core.collections.Collection)
    // overridden for efficiency
    @Override
    public boolean containsAll(java.util.Collection<?> javaCollection) {
        return backedList.containsAll(javaCollection);
    }

    // @see java.lang.Object#clone()
    @Override
    @SuppressWarnings("unchecked")
    public Object clone()
    throws CloneNotSupportedException {
        Array<Element> clonedArray = (Array<Element>) super.clone();
        clonedArray.backedList = (ArrayList<Element>) backedList.clone();
        return clonedArray;
    }

    // @see org.jlib.core.collections.list.IndexList#equals(java.lang.Object)
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Array<?>))
            return false;
        Array<?> otherArray = (Array<?>) otherObject;
        return minIndex == otherArray.minIndex && maxIndex == otherArray.maxIndex &&
               backedList.equals(otherArray.backedList);
    }
    
    // @see org.jlib.core.collections.AbstractCollection#hashCode()
    @Override
    public int hashCode() {
        return minIndex + maxIndex + backedList.hashCode();
    }
}
