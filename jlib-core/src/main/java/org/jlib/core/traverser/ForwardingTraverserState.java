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

package org.jlib.core.traverser;

public abstract class ForwardingTraverserState<Item, Travble extends TwoWayTraversable<Item>, State extends ForwardingTraverserState<Item, Travble, State>>
extends TraversableAware<Item, Travble>
implements TwoWayTraverserState<Item, State> {

    private final TwoWayTraverserState<Item, State> delegateTraverserState;

    ForwardingTraverserState(final Travble traversable,
                             final TwoWayTraverserState<Item, State> delegateTraverserState) {
        super(traversable);

        this.delegateTraverserState = delegateTraverserState;
    }

    protected TwoWayTraverserState<Item, State> getDelegateTraverserState() {
        return delegateTraverserState;
    }

    @Override
    public State getPreviousState() {
        return delegateTraverserState.getPreviousState();
    }

    @Override
    public State getNextState() {
        return delegateTraverserState.getNextState();
    }

    @Override
    public boolean hasNextItem() {
        return delegateTraverserState.hasNextItem();
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        return delegateTraverserState.getNextItem();
    }

    @Override
    public boolean hasPreviousItem() {
        return delegateTraverserState.hasPreviousItem();
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        return delegateTraverserState.getPreviousItem();
    }
}
