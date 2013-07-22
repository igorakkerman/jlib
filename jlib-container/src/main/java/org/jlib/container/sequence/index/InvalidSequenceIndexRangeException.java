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

package org.jlib.container.sequence.index;

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.core.traverser.InvalidTraversibleArgumentException;

/**
 * {@link InvalidTraversibleArgumentException} thrown if an invalid index range has
 * been used with an {@link IndexSequence}.
 *
 * @author Igor Akkerman
 */
public class InvalidSequenceIndexRangeException
extends InvalidTraversibleArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5716666495830602559L;

    /**
     * Creates a new {@link InvalidSequenceIndexRangeException}.
     *
     * @param sequence
     *        {@link IndexSequence} for which this
     *        {@link InvalidSequenceIndexRangeException} is thrown
     *
     * @param fromIndex
     *        integer specifying the from index
     *
     * @param toIndex
     *        integer specifying the to index
     *
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public InvalidSequenceIndexRangeException(final IndexSequence<?> sequence, final int fromIndex, final int toIndex) {
        super(sequence, message("fromIndex = {0} > {1} = toIndex: ", fromIndex, toIndex));
    }
}
