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

package org.jlib.container;

import org.jlib.core.traverser.InvalidTraversableArgumentException;

import static org.jlib.core.language.ExceptionMessageUtility.message;

/**
 * {@link InvalidTraversableArgumentException} thrown when a {@link RemoveItemByItem} does not contain the
 * specified {@link Item} to retain.
 *
 * @author Igor Akkerman
 */
public class ItemToRemoveNotContainedException
extends InvalidContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 2921569537644842654L;

    /**
     * Creates a new {@link ItemToRemoveNotContainedException}.
     *
     * @param container
     *        referenced {@link TraversableContainer}
     *
     * @param item
     *        Item to retain
     */
    public ItemToRemoveNotContainedException(@SuppressWarnings("TypeMayBeWeakened")
                                             final RemoveItemByItem<?> container, final Object item) {
        super(container, message(item));
    }

    public ItemToRemoveNotContainedException(@SuppressWarnings("TypeMayBeWeakened")
                                             final RemoveItemByItem<?> container, final Object item,
                                             final Exception cause) {
        super(container, message(item), cause);
    }
}
