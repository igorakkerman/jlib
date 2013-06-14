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

import org.jlib.core.IllegalJlibArgumentException;

/**
 * {@link IllegalJlibArgumentException} thrown when trying to create a
 * {@link Sequence} with an invalid number of Items.
 *
 * @author Igor Akkerman
 */
public class InvalidSequenceItemsCountException
extends IllegalJlibArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 23142560184875814L;

    /** invalid number of Items */
    private final int itemsCount;

    /**
     * Creates a new {@link InvalidSequenceItemsCountException}.
     *
     * @param itemsCount
     *        integer specifying the invalid number of Items
     *
     * @param messagePattern
     *        String specifying the error message pattern
     *
     * @param messageArguments
     *        array of {@link Object} error message arguments
     */
    public InvalidSequenceItemsCountException(final int itemsCount, final String messagePattern, final Object... messageArguments) {
        super(messagePattern, messageArguments);

        this.itemsCount = itemsCount;
    }

    /**
     * Returns the invalid number of Items.
     *
     * @return integer specifying the invalid number of Items
     */
    public int getItemsCount() {
        return itemsCount;
    }
}
