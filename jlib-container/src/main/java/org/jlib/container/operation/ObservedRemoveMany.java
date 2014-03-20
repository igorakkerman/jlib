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

package org.jlib.container.operation;

import org.jlib.core.language.ItemOperation;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

/**
 * {@link RetainItemsByIterable} allowing its retain operations to be attended by
 * {@link ValueObserver} instances.
 *
 * @param <Item>
 *        type of items held in the {@link IterableContainer}
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveMany<Item>
extends ItemOperation<Item> {

    @SuppressWarnings("unchecked")
    public <ContainsIterable extends Iterable<Item> & ContainsSingle<Item>> /*
        */ void remove(ContainsIterable items, ValueObserver<Item>... observers)

    throws ItemToRemoveNotContainedException, InvalidContainerArgumentException, InvalidContainerStateException,
           ValueObserverException;
}
