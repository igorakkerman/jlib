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

public abstract class ForwardingIteratorState<Item, Travble extends BidiIterable<Item>, State extends ForwardingIteratorState<Item, Travble, State>>
extends IterableAware<Item, Travble>
implements BidiIteratorState<Item, State> {

    private final BidiIteratorState<Item, State> delegateTraverserState;

    ForwardingIteratorState(final Travble traversable, final BidiIteratorState<Item, State> delegateTraverserState) {
        super(traversable);

        this.delegateTraverserState = delegateTraverserState;
    }

    protected BidiIteratorState<Item, State> getDelegateTraverserState() {
        return delegateTraverserState;
    }

    @Override
    public State previousState() {
        return delegateTraverserState.previousState();
    }

    @Override
    public State nextState() {
        return delegateTraverserState.nextState();
    }

    @Override
    public boolean hasNextItem() {
        return delegateTraverserState.hasNext();
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        return delegateTraverserState.getNext();
    }

    @Override
    public boolean hasPrevious() {
        return delegateTraverserState.hasPrevious();
    }

    @Override
    public Item previous()
    throws NoPreviousItemException {
        return delegateTraverserState.previous();
    }
}
