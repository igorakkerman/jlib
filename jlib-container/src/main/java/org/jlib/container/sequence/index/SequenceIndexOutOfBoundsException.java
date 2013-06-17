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

import org.jlib.container.sequence.InvalidSequenceArgumentException;

/**
 * {@link InvalidSequenceArgumentException} thrown when a {@link IndexSequence}
 * is accessed with an invalid index.
 *
 * @author Igor Akkerman
 */
public class SequenceIndexOutOfBoundsException
extends InvalidSequenceArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1501618255867836784L;

    /** invalid index */
    private final int invalidIndex;

    /**
     * Creates a new SequenceIndexOutOfBoundsException for the specified invalid
     * invalidIndex and the specified message.
     *
     * @param sequence
     *        {@link IndexSequence} accessed with the invalid index
     *
     * @param invalidIndex
     *        integer specifying the invalid invalidIndex
     *
     * @param message
     *        {@link String} specifying the message explaining the invalid
     *        access
     */
    public SequenceIndexOutOfBoundsException(final IndexSequence<?> sequence, final int invalidIndex, final String message) {
        super(sequence, "{0}, {1}: {2}", invalidIndex, message);

        this.invalidIndex = invalidIndex;
    }

    /**
     * Returns the invalid index of this SequenceIndexOutOfBoundsException.
     *
     * @return integer specifying the invalid index
     */
    public int getInvalidIndex() {
        return invalidIndex;
    }
}
