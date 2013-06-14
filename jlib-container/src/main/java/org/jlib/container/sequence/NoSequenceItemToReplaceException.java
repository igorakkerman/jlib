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

import org.jlib.core.traverser.NoItemToReplaceException;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when
 * {@link ReplaceSequenceTraverser#replace(Object)} has been called without a
 * previously returned Item.
 *
 * @author Igor Akkerman
 */
public class NoSequenceItemToReplaceException
extends NoItemToReplaceException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 4930329712329638796L;

    /**
     * Creates a new {@link NoSequenceItemToReplaceException}.
     *
     * @param sequence
     *        traversed {@link ReplaceSequence}
     *        {@link NoSequenceItemToReplaceException}
     */
    public NoSequenceItemToReplaceException(final ReplaceSequence<?> sequence) {
        super(sequence);
    }

    /**
     * Creates a new {@link NoSequenceItemToReplaceException}.
     *
     * @param sequence
     *        traversed {@link ReplaceSequence}
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoSequenceItemToReplaceException}
     */
    public NoSequenceItemToReplaceException(final ReplaceSequence<?> sequence, final Throwable cause) {
        super(sequence, cause);
    }
}
