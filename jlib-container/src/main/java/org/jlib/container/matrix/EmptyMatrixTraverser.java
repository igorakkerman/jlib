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

import org.jlib.container.traverser.NoNextItemException;
import org.jlib.container.traverser.ReplaceTraverser;

/**
 * {@link MatrixTraverser} of an {@link EmptyMatrix}. Implemented as a
 * singleton.
 *
 * @param <Entry>
 *        type of entries of the {@link Matrix}
 *
 * @author Igor Akkerman
 */
public class EmptyMatrixTraverser<Entry>
implements MatrixTraverser<Entry>, ReplaceTraverser<Entry> {

    /** sole {@link EmptyMatrixTraverser} instance */
    private static final EmptyMatrixTraverser<?> INSTANCE = new EmptyMatrixTraverser<>();

    /**
     * Returns the sole {@link EmptyMatrixTraverser} instance.
     *
     * @param <Entry>
     *        type of the entries potentially held in the {@link EmptyMatrix}
     *
     * @return sole {@link EmptyMatrixTraverser} instance
     */
    @SuppressWarnings("unchecked")
    public static <Entry> EmptyMatrixTraverser<Entry> getInstance() {
        return (EmptyMatrixTraverser<Entry>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyMatrixTraverser}.
     */
    private EmptyMatrixTraverser() {
        super();
    }

    @Override
    public boolean isNextItemAccessible() {
        return false;
    }

    @Override
    public Entry getNextItem() {
        throw new NoNextItemException(EmptyMatrix.getInstance());
    }

    @Override
    public boolean hasNextEntity() {
        return false;
    }

    @Override
    public void gotoNextEntity()
    throws IllegalStateException {
        throw new IllegalStateException();
    }

    @Override
    public void replace(final Entry item)
    throws IllegalStateException {
        throw new IllegalStateException();
    }
}
