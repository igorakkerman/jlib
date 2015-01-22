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

import org.jlib.core.language.InvalidArgumentException;

import static org.jlib.core.language.MessageUtility.message;

/**
 * {@link InvalidArgumentException} thrown when trying to create a
 * {@link Sequence} with an invalid number of Items.
 *
 * @author Igor Akkerman
 */
public class InvalidSequenceItemsCountException
extends InvalidArgumentException {

    private static final long serialVersionUID = - 23142560184875814L;

    /**
     * Creates a new {@link InvalidSequenceItemsCountException}.
     *
     * @param itemsCount
     *        integer specifying the invalid number of Items
     */
    public InvalidSequenceItemsCountException(final int itemsCount) {
        super(message("itemsCount == {0} < 1", itemsCount));
    }
}
