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

public class StatefulTraverser<Item, Travble extends Traversable<Item>, State extends TraverserState<Item, State>>
extends AbstractTraverser<Item, Travble> {

    private State currentState;

    public StatefulTraverser(final Travble traversable, final State initialState) {
        super(traversable);

        currentState = initialState;
    }

    @Override
    public final boolean hasNextItem() {
        return currentState.hasNextItem();
    }

    @Override
    public final Item getNextItem()
    throws NoNextItemException {
        final Item nextItem = currentState.getNextItem();

        currentState = currentState.getNextState();

        return nextItem;
    }

    protected final State getCurrentState() {
        return currentState;
    }

    protected final void setCurrentState(final State currentState) {
        this.currentState = currentState;
    }
}
