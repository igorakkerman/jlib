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

import org.jlib.core.language.ExceptionMessage;
import org.jlib.core.traverser.InvalidTraversableArgumentException;

/**
 * {@link InvalidTraversableArgumentException} thrown when a {@link IndexSequence}
 * is accessed with an invalid index.
 *
 * @author Igor Akkerman
 */
public class InvalidSequenceIndexException
extends InvalidTraversableArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1501618255867836784L;

    /**
     * Creates a new InvalidSequenceIndexException for the specified invalid
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
    public InvalidSequenceIndexException(@SuppressWarnings("TypeMayBeWeakened") final IndexSequence<?> sequence,
                                         final ExceptionMessage message) {
        super(sequence, message);
    }
}
