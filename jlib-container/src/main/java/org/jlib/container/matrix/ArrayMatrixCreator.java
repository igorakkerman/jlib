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

/**
 * {@link IndexMatrixCreator} of {@link ArrayMatrix} instances.
 *
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 *
 * @author Igor Akkerman
 */
public final class ArrayMatrixCreator<Entry>
/*extends IndexMatrixCreator<ArrayMatrix<Entry>, Entry> */{

//    /** sole {@link ArrayMatrixCreator} instance */
//    private static final ArrayMatrixCreator<?> INSTANCE = new ArrayMatrixCreator<>();
//
//    /**
//     * Returns the sole {@link ArrayMatrixCreator} instance.
//     *
//     * @param <Entry>
//     *        type of entries held in the {@link Matrix}
//     *
//     * @return sole {@link ArrayMatrixCreator} instance
//     */
//    @SuppressWarnings("unchecked")
//    public static <Entry> ArrayMatrixCreator<Entry> getInstance() {
//        return (ArrayMatrixCreator<Entry>) INSTANCE;
//    }
//
//    /**
//     * Creates a new {@link ArrayMatrixCreator} instance.
//     */
//    private ArrayMatrixCreator() {
//        super();
//    }
//
//    @Override
//    public ArrayMatrix<Entry> createMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex, final int lastRowIndex) {
//        return new ArrayMatrix<>(firstColumnIndex, firstRowIndex, lastColumnIndex, lastRowIndex);
//    }
}
