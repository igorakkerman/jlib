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

package org.jlib.core.iterator;

import java.util.Iterator;

public class StatefulIterator<Item, Itble extends Iterable<Item>, State extends IteratorState<Item, State>>
extends IterableAware<Item, Itble>
implements Iterator<Item> {

    private State currentState;

    public StatefulIterator(final Itble iterable, final State initialState) {
        super(iterable);

        currentState = initialState;
    }

    @Override
    public final boolean hasNext() {
        return currentState.hasNext();
    }

    @Override
    public final Item next()
    throws NoNextItemException {
        final Item nextItem = currentState.next();

        currentState = currentState.nextState();

        return nextItem;
    }

    protected final State getCurrentState() {
        return currentState;
    }

    protected final void setCurrentState(final State currentState) {
        this.currentState = currentState;
    }
}
