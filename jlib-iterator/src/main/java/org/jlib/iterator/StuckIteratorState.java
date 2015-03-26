/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.iterator;

public final class StuckIteratorState<Item, Itble extends Iterable<Item>, State extends BidiIteratorState<Item, State>>
extends IterableAware<Item, Itble>
implements BidiIteratorState<Item, State> {

    public StuckIteratorState(final Itble iterable) {
        super(iterable);
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Item previous()
    throws NoPreviousItemException {
        throw new NoPreviousItemException("iterable", getIterable());
    }

    @Override
    public State previousState() {
        throw new NoPreviousItemException("iterable", getIterable());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next()
    throws NoNextItemException {
        throw new NoNextItemException("iterable", getIterable());
    }

    @Override
    public State nextState() {
        throw new NoNextItemException("iterable", getIterable());
    }
}
