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

package org.jlib.container.operation.sequence;

import org.jlib.core.language.ExceptionMessage;
import org.jlib.core.traverser.InvalidTraverserStateException;

/**
 * {@link InvalidTraverserStateException} referencing a {@link Sequence}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidSequenceTraverserStateException
extends InvalidTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7078599807599575854L;

    /**
     * Creates a new {@link InvalidSequenceTraverserStateException}.
     *
     * @param sequence
     *        referenced {@link Sequence}
     */
    @SuppressWarnings("TypeMayBeWeakened")
    protected InvalidSequenceTraverserStateException(final Sequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link InvalidSequenceTraverserStateException} with the
     * specified error message.
     *
     * @param sequence
     *        referenced {@link Sequence}
     *
     * @param message
     *        the {@link ExceptionMessage}
     */
    protected InvalidSequenceTraverserStateException(@SuppressWarnings("TypeMayBeWeakened") final Sequence<?> sequence,
                                                     final ExceptionMessage message) {
        super(sequence, message);
    }

    /**
     * Creates a new {@link InvalidSequenceTraverserStateException} with the specified cause.
     *
     * @param sequence
     *        referenced {@link Sequence}
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidSequenceTraverserStateException}
     */
    @SuppressWarnings("TypeMayBeWeakened")
    protected InvalidSequenceTraverserStateException(final Sequence<?> sequence, final Exception cause) {
        super(sequence, cause);
    }

    /**
     * Creates a new {@link InvalidSequenceTraverserStateException} with the specified error message and cause.
     *
     * @param sequence
     *        referenced {@link Sequence}
     *
     * @param message
     *        {@link String} specifying the error message
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidSequenceTraverserStateException}
     */
    @SuppressWarnings("TypeMayBeWeakened")
    protected InvalidSequenceTraverserStateException(final Sequence<?> sequence, final ExceptionMessage message,
                                                     final Exception cause) {
        super(sequence, message, cause);
    }
}
