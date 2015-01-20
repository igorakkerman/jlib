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

import org.jlib.core.language.Message;

import org.jlib.container.operation.InvalidContainerStateException;

/**
 * {@link InvalidContainerStateException} thrown when attempting to store an invalid number of Items in a
 * {@link Sequence}.
 *
 * @author Igor Akkerman
 */
public class InvalidStoredItemsCountException
extends InvalidContainerStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5400803962181030353L;

    /** invalid number of Items */
    private final int invalidItemsCount;

    /**
     * Creates a new {@link InvalidStoredItemsCountException}.
     *
     * @param sequence
     *        targeted {@link Sequence}
     *
     * @param invalidItemsCount
     *        integer specifying the invalid number of Items
     *
     * @param errorMessageTemplate
     *        {@link String} specifying the error message template
     *
     * @param errorMessageArguments
     *        comma separated sequence of Object error message arguments
     */
    public InvalidStoredItemsCountException(final Sequence<?> sequence, final int invalidItemsCount,
                                            Message exceptionMessage) {
        super(sequence, exceptionMessage.append(invalidItemsCount));

        this.invalidItemsCount = invalidItemsCount;
    }

    /**
     * Returns the invalid number of Items.
     *
     * @return integer specifying the invalid number of Items
     */
    public int getInvalidItemsCount() {
        return invalidItemsCount;
    }
}
