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
 * Fixed sized matrix. Replacement for two-dimensional arrays with special features.
 * </p>
 * <p>
 * The only syntactical difference to two-dimensinal arrays lies in the syntax of setting
 * and getting objects:
 * </p>
 *
 * <pre>
 * {@literal
 * // good(?) old two-dimensional array           // cool(!) new jlib Matrix class
 * String[][] stringMatrix = new String[10][5];   Matrix<String> stringMatrix = new Matrix<String>(10, 5);
 * stringMatrix[2][3] = "Too old!";               stringMatrix.set(2, 3, "Brandnew!");
 * String s = stringMatrix[2][3];                 String s = stringMatrix.get(2, 3); }
 * </pre>
 *
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <li> Minimum and maximum width and height:<br/> On instantiation, you can specify the
 * minimum and the maximum width and height of the Matrix. Thus, no offset is necessary
 * for matrices starting at other indices than 0. The following example illustrates how a
 * (4x2)-Matrix with indices starting at 1, in which every entry is the product of the
 * column and row number:
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
 * <li>Conformance to the Java Collections Framework <br/> The class implements the
 * {@code java.util.Collection} interface and thus behaves like all Java Collections.</li>
 * <br />
 * <li>Full support for generics:<br/> The Java arrays do not support generic classes.
 * For example, you cannot create an array of String Lists:
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
 * A default iteration order can be defined specifying how this Matrix is traversed by the
 * Iterator returned by {@link #iterator()}.
 * <ul>
 * <li> Horizontal iteration. That is, the traversal algorithm is as follows:
 *
 * <pre>{@literal
 * foreach row
 *     foreach column
 *         process element at (column, row)}
 * </pre>
 *
 * </li>
 * <li> Vertical iteration. That is, the traversal algorithm is as follows:
 *
 * <pre>{@literal
 * foreach column
 *     foreach row
 *         process element at (column, row)}
 * </pre>
 *
 * </li>
 * </ul>
 * </p>
 * <p>
 * A Matrix has a fixed size, thus no Elements can be added to or removed from it. The
 * corresponding methods for adding and removing Elements all throw an
 * {@link UnsupportedOperationException}.
 * </p>
 *
 * @param <Element>
 *        type of the elements held in the Matrix
 * @author Igor Akkerman
 */
public class Matrix<Element>
extends AbstractCollection<Element> {

    /** default iteration order */
    public static final MatrixIterationOrder DEFAULTITERATIONORDER = MatrixIterationOrder.HORIZONTAL;

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

    /** order in which this Matrix is iterated */
    private MatrixIterationOrder iterationOrder;

    /** Matrix data */
    private Array<Array<Element>> matrixData;

    /**
     * Creates a new empty Matrix.
     */
    public Matrix() {
        this(0, 0);
    }

    /**
     * Creates a new Matrix of the specified width and height and the default iteration
     * order. The default iteration order is specified by {@link #DEFAULTITERATIONORDER}.
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
            construct(0, width - 1, 0, height - 1, DEFAULTITERATIONORDER);
        }
        else {
            minRowIndex = -1;
            maxRowIndex = -1;
            minColumnIndex = -1;
            maxColumnIndex = -1;
            this.width = width;
            this.height = height;
            matrixData = new Array<Array<Element>>();
        }
    }

    /**
     * Creates a new Matrix with the specified minimum and maximum column and row indices
     * and the default iteration order. The default iteration order is specified by
     * {@link #DEFAULTITERATIONORDER}.
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
     *         if
     *         {@code minColumnIndex < 0 || maxColumnIndex < minColumnIndex || minRowIndex < 0 || maxRowIndex < minRowIndex}
     */
    public Matrix(int minColumnIndex, int maxColumnIndex, int minRowIndex, int maxRowIndex) {
        super();
        construct(minColumnIndex, maxColumnIndex, minRowIndex, maxRowIndex, DEFAULTITERATIONORDER);
    }

    /**
     * Creates a new Matrix of the specified width and height and the specified iteration
     * order.
     *
     * @param width
     *        integer specifying the number of columns of this matrix
     * @param height
     *        integer specifying the number of rows of this matrix
     * @param iterationOrder
     *        default iteration order to use by the Iterator returned by
     *        {@link #iterator()}
     * @throws IllegalArgumentException
     *         if {@code width < 0 || height < 0}
     */
    public Matrix(int width, int height, MatrixIterationOrder iterationOrder) {
        super();
        if (width != 0 && height != 0) {
            construct(0, width - 1, 0, height - 1, iterationOrder);
        }
        else {
            minRowIndex = -1;
            maxRowIndex = -1;
            minColumnIndex = -1;
            maxColumnIndex = -1;
            this.width = width;
            this.height = height;
            matrixData = new Array<Array<Element>>();
        }
    }

    /**
     * Creates a new Matrix with the specified minimum and maximum column and row indices
     * and the specified iteration order.
     *
     * @param minColumnIndex
     *        minimum column index
     * @param maxColumnIndex
     *        maximum column index
     * @param minRowIndex
     *        minimum row index
     * @param maxRowIndex
     *        maximum row index
     * @param iterationOrder
     *        default iteration order to use by the Iterator returned by
     *        {@link #iterator()}
     * @throws IllegalArgumentException
     *         if
     *         {@code minColumnIndex < 0 || maxColumnIndex < minColumnIndex || minRowIndex < 0 || maxRowIndex < minRowIndex}
     */
    public Matrix(int minColumnIndex, int maxColumnIndex, int minRowIndex, int maxRowIndex,
                  MatrixIterationOrder iterationOrder) {
        super();
        construct(minColumnIndex, maxColumnIndex, minRowIndex, maxRowIndex, iterationOrder);
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
     * @param iterationOrder
     *        default iteration order to use by the Iterator returned by
     *        {@link #iterator()}
     * @throws IllegalArgumentException
     *         if
     *         {@code minColumnIndex < 0 || maxColumnIndex < minColumnIndex || minRowIndex < 0 || maxRowIndex < minRowIndex}
     */
    @SuppressWarnings("hiding")
    private void construct(int minColumnIndex, int maxColumnIndex, int minRowIndex, int maxRowIndex,
                           MatrixIterationOrder iterationOrder) {
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

        this.iterationOrder = iterationOrder;
    }

    /**
     * Returns the Element stored at the specified column and row in this Matrix.
     *
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * @return Element stored at the specified position in this Matrix
     * @throws ListIndexOutOfBoundsException
     *         if
     *         {@code nextColumnIndex < getMinColumnIndex() || nextColumnIndex > getMaxColumnIndex() || nextRowIndex < getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public Element get(int columnIndex, int rowIndex)
    throws ListIndexOutOfBoundsException {
        return matrixData.get(rowIndex).get(columnIndex);
    }

    /**
     * Registers the Element to store at the specified column and row in this Matrix.
     *
     * @param columnIndex
     *        integer specifying the column of the Element to store
     * @param rowIndex
     *        integer specifying the row of the Element to store
     * @param element
     *        Element to store. {@code null} is a valid Element.
     * @throws ListIndexOutOfBoundsException
     *         if
     *         {@code nextColumnIndex < getMinColumnIndex() || nextColumnIndex > getMaxColumnIndex() || nextRowIndex < getMinRowIndex || nextRowIndex > getMaxRowIndex()}
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
     * Returns a MatrixColumn representing the specified portion of the specified column
     * of this Matrix.
     *
     * @param columnIndex
     *        integer specifying the index of the column
     * @param minRowIndex
     *        integer specifying the minimum row index of the portion of the column
     * @param maxRowIndex
     *        integer specifying the maximum row index of the portion of the column
     * @return MatrixColumn representing the specified portion of the column with {@code nextColumnIndex}
     */
    @SuppressWarnings("hiding")
    public MatrixColumn<Element> column(int columnIndex, int minRowIndex, int maxRowIndex) {
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
     * Returns a MatrixRow representing the specified portion of the specified row of this
     * Matrix.
     *
     * @param rowIndex
     *        integer specifying the index of the row
     * @param minColumnIndex
     *        integer specifying the minimum column index of the portion of the row
     * @param maxColumnIndex
     *        integer specifying the maximum column index of the portion of the row
     * @return MatrixRow representing the specified portion of the row with {@code nextRowIndex}
     */
    @SuppressWarnings("hiding")
    public MatrixRow<Element> row(int rowIndex, int minColumnIndex, int maxColumnIndex) {
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
     * Returns the number of cells in this Matrix. The size is equal to
     * {@code getWidth() * getHeight()}.
     *
     * @return integer specifying the number of cells
     */
    @Override
    public int size() {
        return width * height;
    }

    /**
     * Returns an Iterator of the Elements of this Matrix traversing it horizontally. That
     * is, the traversal algorithm is as follows:
     *
     * <pre>{@literal
     * for each row
     *     for each column
     *         process element at (column, row)}
     * </pre>
     *
     * The {@link #horizontalIterator()} method has the same functionality as this method.
     *
     * @return a new Iterator for this Matrix
     */
    @Override
    public Iterator<Element> iterator() {
        switch (iterationOrder) {
            case HORIZONTAL:
                return horizontalIterator();
            case VERTICAL:
                return verticalIterator();
            default:
                // impossible to occur
                throw new RuntimeException();
        }
    }

    /**
     * Returns an Iterator of the Elements of this Matrix traversing it horizontally. That
     * is, the traversal algorithm is as follows:
     *
     * <pre>{@literal
     * for each row
     *     for each column
     *         process element at (column, row)}
     * </pre>
     *
     * The {@link #iterator()} method has the same functionality as this method.
     *
     * @return a new horizontal Iterator for this Matrix
     */
    public Iterator<Element> horizontalIterator() {
        return new VerticalMatrixIterator<Element>(this);
    }

    /**
     * Returns an Iterator of the Elements of this Matrix traversing it vertically. That
     * is, the traversal algorithm is as follows:
     *
     * <pre>{@literal
     * for each column
     *     for each row
     *         process element at (column, row)}
     * </pre>
     *
     * @return a new vertical Iterator for this Matrix
     */
    public Iterator<Element> verticalIterator() {
        return new HorizontalMatrixIterator<Element>(this);
    }

    /**
     * Returns an Iterator of the Elements in a single column of this Matrix.
     *
     * @param columnIndex
     *        integer specifying the index of the column to traverse
     * @return a new column Iterator for this Matrix
     */
    public EditableIndexListIterator<Element> columnIterator(int columnIndex) {
        return column(columnIndex).editableIndexListIterator();
    }

    /**
     * Returns an EditableIndexListIterator over the Elements of a single row of this
     * Matrix.
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
