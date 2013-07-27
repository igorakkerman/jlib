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

public final class StuckTraverserState<Item, Travble extends Traversable<Item>, State extends TwoWayTraverserState<Item, State>>
extends TraversableAware<Item, Travble>
implements TwoWayTraverserState<Item, State> {

    public StuckTraverserState(final Travble traversable) {
        super(traversable);
    }

    @Override
    public boolean hasPreviousItem() {
        return false;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        throw new NoPreviousItemException(getTraversable());
    }

    @Override
    public State getPreviousState() {
        throw new NoPreviousItemException(getTraversable());
    }

    @Override
    public boolean hasNextItem() {
        return false;
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        throw new NoNextItemException(getTraversable());
    }

    @Override
    public State getNextState() {
        throw new NoNextItemException(getTraversable());
    }
}
