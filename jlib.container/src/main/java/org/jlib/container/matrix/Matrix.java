package org.jlib.container.matrix;

import java.util.Iterator;

import org.jlib.container.Container;
import org.jlib.container.sequence.IndexSequence;

// @formatter:off
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
 * TODO: fix this example (Matrix is an interface now)
 * <pre>
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
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 *        
 * @author Igor Akkerman
 */
//@formatter:on
public interface Matrix<Entry>
extends Container<Entry>, MatrixIterable<Entry> {

    /**
     * Returns the Sequence of the MatrixRows of this ArraySequenceMatrix.
     * 
     * @return IndexSequence of the MatrixRows of this ArraySequenceMatrix
     */
    public IndexSequence<MatrixRow<Entry>> getRows();

    /**
     * Returns the Sequence of the MatrixColumns of this ArraySequenceMatrix.
     * 
     * @return IndexSequence of the MatrixColumns of this ArraySequenceMatrix
     */
    public IndexSequence<MatrixColumn<Entry>> getColumns();

    /**
     * Returns the width of this ArraySequenceMatrix.
     * 
     * @return integer specifying the width
     */
    public int getWidth();

    /**
     * Returns the height of this ArraySequenceMatrix.
     * 
     * @return integer specifying the height
     */
    public int getHeight();

    /**
     * Returns the number of cells in this ArraySequenceMatrix. The size is
     * equal to {@code getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of cells
     */
    @Override
    public int getSize();

    /**
     * Creates a {@link MatrixIterator} traversing the Elements of this
     * {@link ArraySequenceMatrix}. The order in which the Elements are
     * traversed is specified using
     * {@link #setDefaultIterationOrder(MatrixIterationOrder)}.
     * 
     * @return a new {@link AbstractIndexMatrixIterator} over this {@link Matrix}
     * 
     * @see #setDefaultIterationOrder(MatrixIterationOrder)
     * @see MatrixIterationOrder
     */
    @Override
    public MatrixIterator<Entry> createIterator();

    /**
     * <p>
     * Returns a {@link MatrixIterable} providing a {@link MatrixIterator}
     * traversing the Elements of this {@link Matrix} using the specified
     * {@link MatrixIterationOrder}.
     * </p>
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * for (Integer matrixEntry : matrix.iteratedInOrder(VERTICAL)
     *     System.out.print(matrixEntry + " ");
     * </pre>
     * 
     * @param iterationOrder
     *        {@link MatrixIterationOrder} used by the returned {@link Iterable}
     * 
     * @return {@link MatrixIterable} providing a {@link MatrixIterator}
     *         traversing the Elements of this {@link Matrix} using the
     *         specified {@link MatrixIterationOrder}.
     */
    public MatrixIterable<Entry> iteratedInOrder(final MatrixIterationOrder iterationOrder);

    /**
     * Registers the {@link MatrixIterationOrder} used by each {@link Iterator}
     * returned by {@link #iterator()}.
     * 
     * @param defaultIterationOrder
     *        {@link MatrixIterationOrder} used by default {@link Iterator
     *        Iterators}
     */
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder);
}
