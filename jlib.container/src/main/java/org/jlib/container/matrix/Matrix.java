package org.jlib.container.matrix;

import java.util.Iterator;

import org.jlib.container.Container;

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
 *     // good(?) old two-dimensional array           // cool(!) new jlib ArrayMatrix class
 *     String[][] stringMatrix = new String[10][5];
 *     ArrayMatrix&lt;String&gt; stringMatrix = new ArrayMatrix&lt;String&gt;(10, 5);
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
 * height of the ArrayMatrix. Thus, no offset is necessary for matrices
 * starting at other indices than 0. The following example illustrates how a
 * (4x2)-ArrayMatrix with indices starting at 1, in which every entry is
 * the product of the column and row number:
 * 
 * <pre>
 * 
 * 
 * {
 *     &#064;literal
 *     // good(?) old two-dimensional array             // cool(!) new jlib ArrayMatrix class
 *     Integer[][] integerMatrix = new Integer[4][2];
 *     ArrayMatrix&lt;Integer&gt; integerMatrix = new ArrayMatrix&lt;Integer&gt;(4, 2);
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
 * create an array of String SequenceUtility:
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
 *     ArrayMatrix&lt;Set&lt;String&gt;&gt; stringSetMatrix = new ArrayMatrix&lt;Set&lt;String&gt;&gt;(4, 2);
 * }
 * </pre>
 * 
 * </li>
 * </ul>
 * <p>
 * <!-- TODO: update documentation --> A default algorithm of how this
 * ArrayMatrix is traversed by {@link Iterator Iterators} returned by
 * {@link #iterator()} can be defined specifying a default {@link Iterable} as
 * iterable provider.
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
     * Returns the number of columns of this {@link Matrix}.
     * 
     * @return integer specifying the width
     */
    public int getWidth();

    /**
     * Returns the number or rows of this {@link Matrix}.
     * 
     * @return integer specifying the height
     */
    public int getHeight();

    /**
     * Returns the number of Entries in this ArrayMatrix. The size is equal to
     * {@code getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of Entries
     */
    @Override
    public int getSize();

    /**
     * Creates a {@link MatrixIterator} traversing the Entries of this
     * {@link ArrayMatrix} in the default order. The default order may be
     * defined by the concrete implementation or even made customizable.
     * 
     * @return a new {@link MatrixIterator} over the Entries of this
     *         {@link Matrix}
     */
    @Override
    public MatrixIterator<Entry> createIterator();
}
