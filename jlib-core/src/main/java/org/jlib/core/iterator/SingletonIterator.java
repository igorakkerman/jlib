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

public class SingletonIterator<Item, Travble extends SingletonIterable<Item>>
extends IterableAware<Item, Travble>
implements BidiIterator<Item> {

    private final Item item;

    private final BidiIterator<Item> delegateTraverser;

    private final BidiIteratorState<Item, SingletonIteratorState> stuck = /*
     */ new StuckIteratorState<>(getTraversable());

    private class SingletonIteratorState
    extends ForwardingIteratorState<Item, Travble, SingletonIteratorState> {

        private SingletonIteratorState(final Travble traversable) {
            super(traversable, stuck);

            new StuckIteratorState<Item, Travble, SingletonIteratorState>(traversable);
        }
    }

    @SuppressWarnings("InstanceVariableOfConcreteClass")
    private final SingletonIteratorState beforeItem = /*
     */ new SingletonIteratorState(getTraversable()) {

        @Override
        public SingletonIteratorState nextState() {
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
    private final SingletonIteratorState afterItem = /*
     */ new SingletonIteratorState(getTraversable()) {

        @Override
        public SingletonIteratorState previousState() {
            return beforeItem;
        }

        @Override
        public boolean hasPrevious() {
            return true;
        }

        @Override
        public Item previous()
        throws NoPreviousItemException {
            return item;
        }
    };

    public SingletonIterator(final Travble traversable) {
        super(traversable);

        item = traversable.getItem();

        delegateTraverser = new StatefulBidiIterator<>(traversable, beforeItem);
    }

    @Override
    public boolean hasPrevious() {
        return delegateTraverser.hasPrevious();
    }

    @Override
    public Item previous()
    throws NoPreviousItemException {
        return delegateTraverser.previous();
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
