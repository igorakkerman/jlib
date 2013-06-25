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

package org.jlib.container.sequence;

import org.jlib.container.traverser.NoItemToRemoveException;

/**
 * {@link NoItemToRemoveException} thrown when
 * {@link RemoveSequenceTraverser#remove()} has been called without a previously
 * returned Item.
 *
 * @author Igor Akkerman
 */
public class NoSequenceItemToRemoveException
extends NoItemToRemoveException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 2785280233767786496L;

    /** traversed {@link RemoveSequence} */
    private final RemoveSequence<?> sequence;

    /**
     * Creates a new {@link NoSequenceItemToRemoveException}.
     *
     * @param sequence
     *        traversed {@link RemoveSequence}
     */
    public NoSequenceItemToRemoveException(final RemoveSequence<?> sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    /**
     * Creates a new {@link NoSequenceItemToRemoveException}.
     *
     * @param sequence
     *        traversed {@link RemoveSequence}
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSequenceItemToRemoveException}
     */
    public NoSequenceItemToRemoveException(final RemoveSequence<?> sequence, final Throwable cause) {
        super(sequence, cause);

        this.sequence = sequence;
    }

    @Override
    public RemoveSequence<?> getTraversible() {
        return sequence;
    }
}
