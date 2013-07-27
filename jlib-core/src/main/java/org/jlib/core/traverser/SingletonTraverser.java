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

import javax.swing.plaf.nimbus.State;

public class SingletonTraverser<Item, Travble extends SingletonTraversable<Item>>
extends TraversableAware<Item, SingletonTraversable<Item>>
implements TwoWayTraverser<Item> {

    private final Item item;

    private final TwoWayTraverser<Item> delegateTraverser;

    private final StuckTraverserState<Item, Travble, SingletonTraverserState> stuck =
    new StuckTraverserState<>(getTraversable());

    class SingletonTraverserState
    extends ForwardingTraverserState<Item, Travble, SingletonTraverserState> {

        SingletonTraverserState(final Travble traversable) {
            super(traversable, stuck);

            new StuckTraverserState<Item, Travble, SingletonTraverserState>(traversable);
        }
    }

    @SuppressWarnings("InstanceVariableOfConcreteClass")
    final SingletonTraverserState beforeItem = /*
     */ new SingletonTraverserState(getTraversable()) {

        @Override
        public SingletonTraverserState getNextState() {
            return afterItem;
        }

        @Override
        public boolean hasNextItem() {
            return true;
        }

        @Override
        public Item getNextItem()
        throws NoNextItemException {
            return item;
        }
    };

    @SuppressWarnings("InstanceVariableOfConcreteClass")
    final SingletonTraverserState afterItem = /*
     */ new SingletonTraverserState(getTraversable()) {

        @Override
        public SingletonTraverserState getPreviousState() {
            return beforeItem;
        }

        @Override
        public boolean hasPreviousItem() {
            return true;
        }

        @Override
        public Item getPreviousItem()
        throws NoPreviousItemException {
            return item;
        }
    };

    public SingletonTraverser(final SingletonTraversable<Item> traversable) {
        super(traversable);

        item = traversable.getItem();

        delegateTraverser = new StatefulTwoWayTraverser<>(traversable, beforeItem);
    }

    @Override
    public boolean hasPreviousItem() {
        return delegateTraverser.hasPreviousItem();
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousItemException {
        return delegateTraverser.getPreviousItem();
    }

    @Override
    public boolean hasNextItem() {
        return delegateTraverser.hasNextItem();
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        return delegateTraverser.getNextItem();
    }
}
