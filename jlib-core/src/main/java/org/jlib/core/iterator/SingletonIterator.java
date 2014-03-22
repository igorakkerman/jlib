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

public class SingletonIterator<Item, Itble extends SingletonIterable<Item>>
extends IterableAware<Item, Itble>
implements BidiIterator<Item> {

    private final Item item;

    private final BidiIterator<Item> delegateIterator;

    private final BidiIteratorState<Item, SingletonIteratorState> stuck = /*
     */ new StuckIteratorState<>(getIterable());

    private class SingletonIteratorState
    extends ForwardingIteratorState<Item, Itble, SingletonIteratorState> {

        private SingletonIteratorState(final Itble iterable) {
            super(iterable, stuck);

            new StuckIteratorState<Item, Itble, SingletonIteratorState>(iterable);
        }
    }

    @SuppressWarnings("InstanceVariableOfConcreteClass")
    private final SingletonIteratorState beforeItem = /*
     */ new SingletonIteratorState(getIterable()) {

        @Override
        public SingletonIteratorState nextState() {
            return afterItem;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Item next()
        throws NoNextItemException {
            return item;
        }
    };

    @SuppressWarnings("InstanceVariableOfConcreteClass")
    private final SingletonIteratorState afterItem = /*
     */ new SingletonIteratorState(getIterable()) {

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

    public SingletonIterator(final Itble iterable) {
        super(iterable);

        item = iterable.getItem();

        delegateIterator = new StatefulBidiIterator<>(iterable, beforeItem);
    }

    @Override
    public boolean hasPrevious() {
        return delegateIterator.hasPrevious();
    }

    @Override
    public Item previous()
    throws NoPreviousItemException {
        return delegateIterator.previous();
    }

    @Override
    public boolean hasNext() {
        return delegateIterator.hasNext();
    }

    @Override
    public Item next()
    throws NoNextItemException {
        return delegateIterator.next();
    }
}
