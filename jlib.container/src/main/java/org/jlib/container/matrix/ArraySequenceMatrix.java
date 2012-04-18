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

// TODO: transform into interface, create ArraySequencesMatrix
// TODO: MatrixIndexOutOfBoundsException
// TODO: separate empty matrices from ArraySequenceMatrix class or use delegates

package org.jlib.container.matrix;

import java.util.Iterator;

import org.jlib.container.AbstractContainer;
import org.jlib.container.sequence.ArraySequence;
import org.jlib.container.sequence.IndexSequence;
import org.jlib.container.sequence.ReplaceIndexSequenceIterator;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;
import org.jlib.container.sequence.SequenceIterator;

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
 * 
 * {
 *     &#064;literal
 *     // good(?) old two-dimensional array           // cool(!) new jlib ArraySequenceMatrix class
 *     String[][] stringMatrix = new String[10][5];
 *     ArraySequenceMatrix&lt;String&gt; stringMatrix = new ArraySequenceMatrix&lt;String&gt;(10, 5);
 *     stringMatrix[2][3] = &quot;Too old!&quot;;
 *     stringMatrix.set(2, 3, &quot;Brand-new!&quot;);
 *     String s = stringMatrix[2][3];
 *     String s = stringMatrix.get(2, 3);
 * }
 * </pre>
 * 
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <li>Minimum and maximum width and height:<br/>
 * On instantiation, you can specify the minimum and the maximum width and
 * height of the ArraySequenceMatrix. Thus, no offset is necessary for matrices
 * starting at other indices than 0. The following example illustrates how a
 * (4x2)-ArraySequenceMatrix with indices starting at 1, in which every entry is
 * the product of the column and row number:
 * 
 * <pre>
 * 
 * {
 *     &#064;literal
 *     // good(?) old two-dimensional array             // cool(!) new jlib ArraySequenceMatrix class
 *     Integer[][] integerMatrix = new Integer[4][2];
 *     ArraySequenceMatrix&lt;Integer&gt; integerMatrix = new ArraySequenceMatrix&lt;Integer&gt;(4, 2);
 *     for (int row = 1; row &lt;= 2; row ++)
 *         for (int row = 1; row &lt;= 2; row ++)
 *             for (int col = 1; col &lt;= 4; col ++)
 *                 for (int col = 1; col &lt;= 4; col ++)
 *                     integerMatrix[col - 1][row - 1] = col * row;
 *     integerMatrix.set(col, row, col * row);
 * }
 * </pre>
 * 
 * </li>
 * <li>Conformance to the Collections Framework <br/>
 * The class implements the {@code Collection} interface and thus behaves like
 * all Collections.</li>
 * <br />
 * <li>Full support for generics:<br/>
 * The Java arrays do not support generic classes. For example, you cannot
 * create an array of String Sequences:
 * 
 * <pre>
 * 
 * {
 *     &#064;literal
 *     // FORBIDDEN!
 *     Set&lt;String&gt;[][] stringSetMatrix = new Set&lt;String&gt;[4][2];
 * 
 *     // PERMITTED!
 *     ArraySequenceMatrix&lt;Set&lt;String&gt;&gt; stringSetMatrix = new ArraySequenceMatrix&lt;Set&lt;String&gt;&gt;(4, 2);
 * }
 * </pre>
 * 
 * </li>
 * </ul>
 * <p>
 * <!-- TODO: update documentation --> A default algorithm of how this
 * ArraySequenceMatrix is traversed by {@link Iterator Iterators} returned by
 * {@link #iterator()} can be defined specifying a default {@link Iterable} as
 * iterable provider.
 * </p>
 * <p>
 * A ArraySequenceMatrix has a fixed size, thus no Elements can be added to or
 * removed from it. The corresponding methods for adding and removing Elements
 * all throw an {@link UnsupportedOperationException}.
 * </p>
 * 
 * @param <Element>
 *        type of the elements held in the ArraySequenceMatrix
 * @author Igor Akkerman
 */
public class ArraySequenceMatrix<Element>
extends AbstractContainer<Element> {

    /** number of columns */
    private int width;

    /** number of rows */
    private int height;

    /** minimum column index */
    private int firstColumnIndex;

    /** maximum column index */
    private int lastColumnIndex;

    /** minimum row index */
    private int minimumRowIndex;

    /** maximum row index */
    private int maximumRowIndex;

    /** ArraySequenceMatrix data */
    private ArraySequence<ArraySequence<Element>> matrixData;

    /**
     * {@link MatrixIterationOrder} used by each {@link Iterator} returned by
     * {@link #iterator()}.
     */
    private MatrixIterationOrder defaultIterationOrder;

    /**
     * Creates a new empty ArraySequenceMatrix.
     */
    public ArraySequenceMatrix() {
        this(0, 0);
    }

    /**
     * Creates a new ArraySequenceMatrix of the specified width and height.
     * 
     * @param width
     *        integer specifying the number of columns of this matrix
     * @param height
     *        integer specifying the number of rows of this matrix
     * @throws IllegalArgumentException
     *         if {@code width < 0 || height < 0}
     */
    public ArraySequenceMatrix(int width, int height)
    throws IllegalArgumentException {
        super();
        if (width != 0 && height != 0) {
            construct(0, width - 1, 0, height - 1);
        }
        else {
            minimumRowIndex = -1;
            maximumRowIndex = -1;
            firstColumnIndex = -1;
            lastColumnIndex = -1;
            this.width = width;
            this.height = height;
            matrixData = new ArraySequence<ArraySequence<Element>>();

            defaultIterationOrder = MatrixUtility.HORIZONTAL;
        }
    }

    /**
     * Creates a new ArraySequenceMatrix with the specified minimum and maximum
     * column and row indices.
     * 
     * @param firstColumnIndex
     *        minimum column index
     * @param lastColumnIndex
     *        maximum column index
     * @param minimumRowIndex
     *        minimum row index
     * @param maximumRowIndex
     *        maximum row index
     * @throws IllegalArgumentException
     *         if
     *         {@code firstColumnIndex < 0 || lastColumnIndex < firstColumnIndex
     *         || minimumRowIndex < 0 || maximumRowIndex < minimumRowIndex}
     */
    public ArraySequenceMatrix(int firstColumnIndex, int lastColumnIndex, int minimumRowIndex, int maximumRowIndex) {
        super();
        construct(firstColumnIndex, lastColumnIndex, minimumRowIndex, maximumRowIndex);
    }

    /**
     * Constructs this ArraySequenceMatrix.
     * 
     * @param firstColumnIndex
     *        minimum column index
     * @param lastColumnIndex
     *        maximum column index
     * @param minimumRowIndex
     *        minimum row index
     * @param maximumRowIndex
     *        maximum row index
     * @throws IllegalArgumentException
     *         if
     *         {@code firstColumnIndex < 0 || lastColumnIndex < firstColumnIndex
     *         || minimumRowIndex < 0 || maximumRowIndex < minimumRowIndex}
     */

    private void construct(@SuppressWarnings("hiding") int firstColumnIndex,
                           @SuppressWarnings("hiding") int lastColumnIndex,
                           @SuppressWarnings("hiding") int minimumRowIndex,
                           @SuppressWarnings("hiding") int maximumRowIndex) {
        if (firstColumnIndex < 0 || firstColumnIndex > lastColumnIndex || minimumRowIndex < 0 ||
            minimumRowIndex > maximumRowIndex)
            throw new IllegalArgumentException();

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.minimumRowIndex = minimumRowIndex;
        this.maximumRowIndex = maximumRowIndex;
        this.width = lastColumnIndex - firstColumnIndex + 1;
        this.height = maximumRowIndex - minimumRowIndex + 1;

        matrixData = new ArraySequence<ArraySequence<Element>>(minimumRowIndex, maximumRowIndex);
        for (int rowIndex = minimumRowIndex; rowIndex <= maximumRowIndex; rowIndex ++)
            matrixData.replace(rowIndex, new ArraySequence<Element>(firstColumnIndex, lastColumnIndex));

        defaultIterationOrder = MatrixUtility.HORIZONTAL;
    }

    /**
     * Returns the Element stored at the specified column and row in this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * @return Element stored at the specified position in this
     *         ArraySequenceMatrix
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public Element get(int columnIndex, int rowIndex)
    throws SequenceIndexOutOfBoundsException {
        return matrixData.get(rowIndex).get(columnIndex);
    }

    /**
     * Registers the Element to store at the specified column and row in this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the Element to store
     * @param rowIndex
     *        integer specifying the row of the Element to store
     * @param element
     *        Element to store. {@code null} is a valid Element.
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public void set(int columnIndex, int rowIndex, Element element) {
        matrixData.get(rowIndex).replace(columnIndex, element);
    }

    /**
     * Returns a MatrixColumn representing the specified column of this
     * ArraySequenceMatrix.
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
     * specified column of this ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @param minimumRowIndex
     *        integer specifying the minimum row index of the portion of the
     *        column
     * @param maximumRowIndex
     *        integer specifying the maximum row index of the portion of the
     *        column
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    public MatrixColumn<Element> column(int columnIndex, @SuppressWarnings("hiding") int minimumRowIndex,
                                        @SuppressWarnings("hiding") int maximumRowIndex) {
        return new DefaultMatrixColumn<Element>(this, columnIndex, minimumRowIndex, maximumRowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified row of this
     * ArraySequenceMatrix.
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
     * row of this ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @param firstColumnIndex
     *        integer specifying the minimum column index of the portion of the
     *        row
     * @param lastColumnIndex
     *        integer specifying the maximum column index of the portion of the
     *        row
     * @return MatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    // TODO: maybe it would be more appropriate to name these kinds of parameters using start/end or first/last
    public MatrixRow<Element> row(int rowIndex, @SuppressWarnings("hiding") int firstColumnIndex,
                                  @SuppressWarnings("hiding") int lastColumnIndex) {
        return new DefaultMatrixRow<Element>(this, rowIndex, firstColumnIndex, lastColumnIndex);
    }

    /**
     * Returns the Sequence of the MatrixRows of this ArraySequenceMatrix.
     * 
     * @return IndexSequence of the MatrixRows of this ArraySequenceMatrix
     */
    public IndexSequence<MatrixRow<Element>> rowsSequence() {
        return new MatrixRowsSequence<Element>(this);
    }

    /**
     * Returns the Sequence of the MatrixColumns of this ArraySequenceMatrix.
     * 
     * @return IndexSequence of the MatrixColumns of this ArraySequenceMatrix
     */
    public IndexSequence<MatrixColumn<Element>> columnsSequence() {
        return new MatrixColumnsSequence<Element>(this);
    }

    /**
     * Returns the minimum column index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the minimum column of this ArraySequenceMatrix
     */
    public int firstColumnIndex() {
        return firstColumnIndex;
    }

    /**
     * Returns the maximum column index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the maximum column of this ArraySequenceMatrix
     */
    public int lastColumnIndex() {
        return lastColumnIndex;
    }

    /**
     * Returns the minimum row index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the minimum row of this ArraySequenceMatrix
     */
    public int minimumRowIndex() {
        return minimumRowIndex;
    }

    /**
     * Returns the maximum row index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the maximum row of this ArraySequenceMatrix
     */
    public int maximumRowIndex() {
        return maximumRowIndex;
    }

    /**
     * Returns the width of this ArraySequenceMatrix.
     * 
     * @return integer specifying the width
     */
    public int width() {
        return width;
    }

    /**
     * Returns the height of this ArraySequenceMatrix.
     * 
     * @return integer specifying the height
     */
    public int height() {
        return height;
    }

    /**
     * Returns the number of cells in this ArraySequenceMatrix. The size is
     * equal to {@code getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of cells
     */
    @Override
    public int getSize() {
        return width * height;
    }

    /**
     * Creates a {@link AbstractMatrixIterator} traversing the Elements of this
     * {@link ArraySequenceMatrix}. The order in which the Elements are
     * traversed is specified using
     * {@link #setDefaultIterationOrder(MatrixIterationOrder)}.
     * 
     * @return a new {@link AbstractMatrixIterator} for this ArraySequenceMatrix
     * 
     * @see #setDefaultIterationOrder(MatrixIterationOrder)
     * @see MatrixIterationOrder
     */
    @Override
    public MatrixIterator<Element>createIterator() {
        return defaultIterationOrder.createIterator(this);
    }

    /**
     * Registers the {@link MatrixIterationOrder} used by each {@link Iterator}
     * returned by {@link #iterator()}.
     * 
     * @param defaultIterationOrder
     *        {@link MatrixIterationOrder} used by default {@link Iterator
     *        Iterators}
     */
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder) {
        this.defaultIterationOrder = defaultIterationOrder;
    }

    /**
     * Returns an {@link ReplaceIndexSequenceIterator} over a
     * single column of this ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column to traverse
     * @return a new column {@link SequenceIterator} for this ArraySequenceMatrix
     */
    public ReplaceIndexSequenceIterator<Element> createColumnIterator(int columnIndex) {
        return column(columnIndex).createIterator();
    }

    /**
     * Returns an {@link ReplaceIndexSequenceIterator} over a
     * single row of this ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row to traverse
     * @return a new row {@link SequenceIterator} for this ArraySequenceMatrix
     */
    public ReplaceIndexSequenceIterator<Element> createRowIterator(int rowIndex) {
        return row(rowIndex).createIterator();
    }

    @Override
    public String toString() {
        return matrixData.toString();
    }
}