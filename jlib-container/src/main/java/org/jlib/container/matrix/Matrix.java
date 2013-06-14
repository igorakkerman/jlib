/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.matrix;

import org.jlib.container.Container;
import org.jlib.core.traverser.Traverser;

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
 * <lem>Minimum and maximum width and height:<br/>
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
 * </lem>
 * <lem>Conformance to the Collections Framework <br/>
 * The class implements the {@code Collection} interface and thus behaves like
 * all Collections.</lem>
 * <br />
 * <lem>Full support for generics:<br/>
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
 * </lem>
 * </ul>
 * <p>
 * <!-- TODO: update documentation --> A default algorithm of how this
 * ArrayMatrix is traversed by {@link Traverser Traversers} returned by
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
extends Container<Entry>, MatrixTraversible<Entry> {

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
    public int getItemsCount();
}
