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

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.core.traverser.InvalidTraversableArgumentException;

/**
 * {@link InvalidTraversableArgumentException} thrown when trying to invalidly add
 * an Item to a {@link Container} that already exists.
 *
 * @author Igor Akkerman
 */
public class ItemAlreadyContainedException
extends InvalidTraversableArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1090527595338576596L;

    /**
     * Creates a new {@link ItemAlreadyContainedException}.
     *
     * @param container
     *        referenced {@link Container}
     *
     * @param item
     *        already contained Item
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public ItemAlreadyContainedException(final Container<?> container, final Object item) {

        super(container, message(item.toString()));
    }
}
