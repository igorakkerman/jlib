/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

// TODO: transform into interface, create ArrayListsMatrix
// TODO: MatrixIndexOutOfBoundsException

package org.jlib.core.collections.matrix;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import org.jlib.core.collections.list.Array;
import org.jlib.core.collections.list.EditableIndexListIterator;
import org.jlib.core.collections.list.IndexList;
import org.jlib.core.collections.list.ListIndexOutOfBoundsException;

/**
 * <p>
 * Fixed sized matrix. Replacement for two-dimensional arrays with special
 * features.
 * </p>
 * <p>
 * The only syntactical difference to two-dimensinal arrays lies in the syntax
 * of setting and getting objects:
 * </p>
 * 
 * <pre>
 * {@literal
 * // good(?) old two-dimensional array           // cool(!) new jlib Matrix class
 * String[][] stringMatrix = new String[10][5];   Matrix<String> stringMatrix = new Matrix<String>(10, 5);
 * stringMatrix[2][3] = "Too old!";               stringMatrix.set(2, 3, "Brand-new!");
 * String s = stringMatrix[2][3];                 String s = stringMatrix.get(2, 3); }
 * </pre>
 * 
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <li>Minimum and maximum width and height:<br/>
 * On instantiation, you can specify the minimum and the maximum width and
 * height of the Matrix. Thus, no offset is necessary for matrices starting at
 * other indices than 0. The following example illustrates how a (4x2)-Matrix
 * with indices starting at 1, in which every entry is the product of the column
 * and row number:
 * 
 * <pre>
 * {@literal
 * // good(?) old two-dimensional array             // cool(!) new jlib Matrix class
 * Integer[][] integerMatrix = new Integer[4][2];   Matrix<Integer> integerMatrix = new Matrix<Integer>(4, 2);
 * for (int row = 1; row <= 2; row ++)              for (int row = 1; row <= 2; row ++)
 *   for (int col = 1; col <= 4; col ++)              for (int col = 1; col <= 4; col ++)
 *     integerMatrix[col - 1][row - 1] = col * row;     integerMatrix.set(col, row, col * row); }
 * </pre>
 * 
 * </li>
 * <li>Conformance to the Java Collections Framework <br/>
 * The class implements the {@code java.util.Collection} interface and thus
 * behaves like all Java Collections.</li>
 * <br />
 * <li>Full support for generics:<br/>
 * The Java arrays do not support generic classes. For example, you cannot
 * create an array of String Lists:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * Set<String>[][] stringSetMatrix = new Set<String>[4][2];
 *
 * // PERMITTED!
 * Matrix<Set<String>> stringSetMatrix = new Matrix<Set<String>>(4, 2);}
 * </pre>
 * 
 * </li>
 * </ul>
 * <p>
 * A default algorithm of how this Matrix is traversed by
 * {@link Iterator Iterators} returned by {@link #iterator()} can be defined
 * specifying a default {@link Iterable} as iterable provider.
 * </p>
 * <p>
 * A Matrix has a fixed size, thus no Elements can be added to or removed from
 * it. The corresponding methods for adding and removing Elements all throw an
 * {@link UnsupportedOperationException}.
 * </p>
 * 
 * @param <Element>
 *        type of the elements held in the Matrix
 * @author Igor Akkerman
 */
public class Matrix<Element>
extends AbstractCollection<Element> {

    /** number of columns */
    private int width;

    /** number of rows */
    private int height;

    /** minimum column index */
    private int minColumnIndex;

    /** maximum column index */
    private int maxColumnIndex;

    /** minimum row index */
    private int minRowIndex;

    /** maximum row index */
    private int maxRowIndex;

    /**
     * {@link MatrixIteratorFactory} used to create {@link Iterator Iterators} over the
     * Elements of this Matrix by {@link #iterator()}
     */
    private MatrixIteratorFactory<Element> iteratorFactory;

    /** Matrix data */
    private Array<Array<Element>> matrixData;

    /**
     * {@link MatrixIteratorFactory} creating {@link HorizontalMatrixIterator
     * HorizontalMatrixIterators} over this Matrix
     */
    private final MatrixIteratorFactory<Element> horizontalIteratorFactory = new HorizontalMatrixIteratorFactory<Element>(this);

    /**
     * {@link MatrixIteratorFactory} creating {@link VerticalMatrixIterator
     * VerticalMatrixIterators} over this Matrix
     */
    private final MatrixIteratorFactory<Element> verticalIteratorFactory = new VerticalMatrixIteratorFactory<Element>(this);

    /**
     * Creates a new empty Matrix.
     */
    public Matrix() {
        this(0, 0);
    }

    /**
     * Creates a new Matrix of the specified width and height.
     * 
     * @param width
     *        integer specifying the number of columns of this matrix
     * @param height
     *        integer specifying the number of rows of this matrix
     * @throws IllegalArgumentException
     *         if {@code width < 0 || height < 0}
     */
    public Matrix(int width, int height)
    throws IllegalArgumentException {
        super();
        if (width != 0 && height != 0) {
            construct(0, width - 1, 0, height - 1);
        }
        else {
            minRowIndex = -1;
            maxRowIndex = -1;
            minColumnIndex = -1;
            maxColumnIndex = -1;
            this.width = width;
            this.height = height;
            matrixData = new Array<Array<Element>>();

            iteratorFactory = horizontalIteratorFactory;
        }
    }

    /**
     * Creates a new Matrix with the specified minimum and maximum column and
     * row indices.
     * 
     * @param minColumnIndex
     *        minimum column index
     * @param maxColumnIndex
     *        maximum column index
     * @param minRowIndex
     *        minimum row index
     * @param maxRowIndex
     *        maximum row index
     * @throws IllegalArgumentException
     *         if {@code minColumnIndex < 0 || maxColumnIndex < minColumnIndex
     *         || minRowIndex < 0 || maxRowIndex < minRowIndex}
     */
    public Matrix(int minColumnIndex, int maxColumnIndex, int minRowIndex, int maxRowIndex) {
        super();
        construct(minColumnIndex, maxColumnIndex, minRowIndex, maxRowIndex);
    }

    /**
     * Constructs this Matrix.
     * 
     * @param minColumnIndex
     *        minimum column index
     * @param maxColumnIndex
     *        maximum column index
     * @param minRowIndex
     *        minimum row index
     * @param maxRowIndex
     *        maximum row index
     * @throws IllegalArgumentException
     *         if {@code minColumnIndex < 0 || maxColumnIndex < minColumnIndex
     *         || minRowIndex < 0 || maxRowIndex < minRowIndex}
     */

    private void construct(@SuppressWarnings("hiding") int minColumnIndex,
                           @SuppressWarnings("hiding") int maxColumnIndex, @SuppressWarnings("hiding") int minRowIndex,
                           @SuppressWarnings("hiding") int maxRowIndex) {
        if (minColumnIndex < 0 || minColumnIndex > maxColumnIndex || minRowIndex < 0 || minRowIndex > maxRowIndex)
            throw new IllegalArgumentException();

        this.minColumnIndex = minColumnIndex;
        this.maxColumnIndex = maxColumnIndex;
        this.minRowIndex = minRowIndex;
        this.maxRowIndex = maxRowIndex;
        this.width = maxColumnIndex - minColumnIndex + 1;
        this.height = maxRowIndex - minRowIndex + 1;

        matrixData = new Array<Array<Element>>(minRowIndex, maxRowIndex);
        for (int rowIndex = minRowIndex; rowIndex <= maxRowIndex; rowIndex ++)
            matrixData.set(rowIndex, new Array<Element>(minColumnIndex, maxColumnIndex));

        iteratorFactory = horizontalIteratorFactory;
    }

    /**
     * Returns the Element stored at the specified column and row in this
     * Matrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * @return Element stored at the specified position in this Matrix
     * @throws ListIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public Element get(int columnIndex, int rowIndex)
    throws ListIndexOutOfBoundsException {
        return matrixData.get(rowIndex).get(columnIndex);
    }

    /**
     * Registers the Element to store at the specified column and row in this
     * Matrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the Element to store
     * @param rowIndex
     *        integer specifying the row of the Element to store
     * @param element
     *        Element to store. {@code null} is a valid Element.
     * @throws ListIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public void set(int columnIndex, int rowIndex, Element element) {
        matrixData.get(rowIndex).set(columnIndex, element);
    }

    /**
     * Returns a MatrixColumn representing the specified column of this Matrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @return MatrixColumn representing the column with {@code nextColumnIndex}
     */
    public MatrixColumn<Element> column(int columnIndex) {
        return new DefaultMatrixColumn<Element>(this, columnIndex);
    }

    /**
     * Returns a MatrixColumn representing the specified portion of the
     * specified column of this Matrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @param minRowIndex
     *        integer specifying the minimum row index of the portion of the
     *        column
     * @param maxRowIndex
     *        integer specifying the maximum row index of the portion of the
     *        column
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    public MatrixColumn<Element> column(int columnIndex, @SuppressWarnings("hiding") int minRowIndex,
                                        @SuppressWarnings("hiding") int maxRowIndex) {
        return new DefaultMatrixColumn<Element>(this, columnIndex, minRowIndex, maxRowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified row of this Matrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @return MatrixRow representing the row with {@code nextRowIndex}
     */
    public MatrixRow<Element> row(int rowIndex) {
        return new DefaultMatrixRow<Element>(this, rowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified portion of the specified
     * row of this Matrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @param minColumnIndex
     *        integer specifying the minimum column index of the portion of the
     *        row
     * @param maxColumnIndex
     *        integer specifying the maximum column index of the portion of the
     *        row
     * @return MatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    // TODO: maybe it would be more appropriate to name these kinds of parameters using start/end or first/last
    public MatrixRow<Element> row(int rowIndex, @SuppressWarnings("hiding") int minColumnIndex,
                                  @SuppressWarnings("hiding") int maxColumnIndex) {
        return new DefaultMatrixRow<Element>(this, rowIndex, minColumnIndex, maxColumnIndex);
    }

    /**
     * Returns the List of the MatrixRows of this Matrix.
     * 
     * @return IndexList of the MatrixRows of this Matrix
     */
    public IndexList<MatrixRow<Element>> rowsList() {
        return new MatrixRowsList<Element>(this);
    }

    /**
     * Returns the List of the MatrixColumns of this Matrix.
     * 
     * @return IndexList of the MatrixColumns of this Matrix
     */
    public IndexList<MatrixColumn<Element>> columnsList() {
        return new MatrixColumnsList<Element>(this);
    }

    /**
     * Returns the minimum column index of this Matrix.
     * 
     * @return integer specifying the minimum column of this Matrix
     */
    public int minColumnIndex() {
        return minColumnIndex;
    }

    /**
     * Returns the maximum column index of this Matrix.
     * 
     * @return integer specifying the maximum column of this Matrix
     */
    public int maxColumnIndex() {
        return maxColumnIndex;
    }

    /**
     * Returns the minimum row index of this Matrix.
     * 
     * @return integer specifying the minimum row of this Matrix
     */
    public int minRowIndex() {
        return minRowIndex;
    }

    /**
     * Returns the maximum row index of this Matrix.
     * 
     * @return integer specifying the maximum row of this Matrix
     */
    public int maxRowIndex() {
        return maxRowIndex;
    }

    /**
     * Returns the width of this Matrix.
     * 
     * @return integer specifying the width
     */
    public int width() {
        return width;
    }

    /**
     * Returns the height of this Matrix.
     * 
     * @return integer specifying the height
     */
    public int height() {
        return height;
    }

    /**
     * Returns the number of cells in this Matrix. The size is equal to {@code
     * getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of cells
     */
    @Override
    public int size() {
        return width * height;
    }

    /**
     * Creates an {@link Iterator} traversing the Elements of this Matrix. The
     * provider of Iterators
     * 
     * @return a new Iterator for this Matrix
     * 
     * @see #setIteratorFactory(MatrixIteratorFactory)
     */
    @Override
    public Iterator<Element> iterator() {
        return iteratorFactory.iterator();
    }

    /**
     * Returns an {@link Iterable} creating {@link HorizontalMatrixIterator
     * HorizontalMatrixIterators}.
     * 
     * @return {@link Iterable} creating {@link HorizontalMatrixIterator
     *         HorizontalMatrixIterators}.
     */
    public Iterable<Element> getHorizontalIteratorFactory() {
        return horizontalIteratorFactory;
    }
    
    /**
     * Returns an {@link Iterable} creating {@link VerticalMatrixIterator
     * VerticalMatrixIterators}.
     * 
     * @return {@link Iterable} creating {@link VerticalMatrixIterator
     *         VerticalMatrixIterators}.
     */
    public Iterable<Element> getVerticalIteratorFactory() {
        return verticalIteratorFactory;
    }
    
    /**
     * Returns a {@link MatrixIteratorFactory} creating
     * {@link HorizontalMatrixIterator HorizontalMatrixIterators}.
     * Syntactic sugar for
     * {@link #getHorizontalIteratorFactory()} in enhanced for loops:
     * <pre>
     *     for (Element element : matrix.horizontallyIterated()) ...
     * </pre>
     * 
     * @return {@link MatrixIteratorFactory} creating
     *         {@link HorizontalMatrixIterator HorizontalMatrixIterators}.
     */
    public MatrixIteratorFactory<Element> horizontallyIterated() {
        return horizontalIteratorFactory;
    }
    
    /**
     * Returns a {@link MatrixIteratorFactory} creating
     * {@link VerticalMatrixIterator VerticalMatrixIterators}.
     * Syntactic sugar for
     * {@link #getVerticalIteratorFactory()} in enhanced for loops:
     * <pre>
     *     for (Element element : matrix.verticallyIterated()) ...
     * </pre>
     * 
     * @return {@link MatrixIteratorFactory} creating 
     *         {@link VerticalMatrixIterator VerticalMatrixIterators}.
     */
    public MatrixIteratorFactory<Element> verticallyIterated() {
        return verticalIteratorFactory;
    }

    /**
     * Registers the {@link MatrixIteratorFactory} to use to create
     * {@link Iterator Iterators} returned by {@link #iterator()}.
     * 
     * @param iteratorFactory
     *        {@link Iterable} to use to create {@link Iterator Iterators}
     *        returned by {@link #iterator()}
     */
    public void setIteratorFactory(MatrixIteratorFactory<Element> iteratorFactory) {
        this.iteratorFactory = iteratorFactory;
        this.iteratorFactory.setMatrix(this);
    }

    /**
     * Specify that a {@link HorizontalMatrixIteratorFactory} should be used to create
     * {@link Iterator Iterators} returned by {@link #iterator()}.
     */
    public void setHorizontallyIterated() {
        setIteratorFactory(horizontalIteratorFactory);
    }
    
    /**
     * Specify that a {@link VerticalMatrixIteratorFactory} should be used to create
     * {@link Iterator Iterators} returned by {@link #iterator()}.
     */
    public void setVerticallyIterated() {
        setIteratorFactory(verticalIteratorFactory);
    }
    
    /**
     * Returns an {@link EditableIndexListIterator} over the Elements of a
     * single column of this Matrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column to traverse
     * @return a new column Iterator for this Matrix
     */
    public EditableIndexListIterator<Element> columnIterator(int columnIndex) {
        return column(columnIndex).editableIndexListIterator();
    }

    /**
     * Returns an {@link EditableIndexListIterator} over the Elements of a
     * single row of this Matrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row to traverse
     * @return a new row Iterator for this Matrix
     */
    public EditableIndexListIterator<Element> rowIterator(int rowIndex) {
        return row(rowIndex).editableIndexListIterator();
    }

    // @see java.util.Collection#contains(java.lang.Object)
    @Override
    public boolean contains(Object element) {
        for (Array<Element> columnArray : matrixData)
            if (columnArray.contains(element))
                return true;
        return false;
    }

    // @see java.util.Collection#containsAll(java.util.Collection)
    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object object : collection)
            if (!contains(object))
                return false;
        return true;
    }

    // @see java.util.AbstractCollection#toString()
    @Override
    public String toString() {
        return matrixData.toString();
    }
}