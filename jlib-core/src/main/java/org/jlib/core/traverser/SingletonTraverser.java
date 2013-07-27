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

public class SingletonTraverser<Item, Travble extends SingletonTraversable<Item>>
extends TraversableAware<Item, SingletonTraversable<Item>>
implements TwoWayTraverser<Item> {

    private final Item item;

    private final TwoWayTraverser<Item> delegateTraverser;

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

    public abstract class SingletonTraverserState
    implements TwoWayTraverserState<Item, SingletonTraverserState> {

        private final TwoWayTraverserState<Item, SingletonTraverserState> stuck;

        protected SingletonTraverserState(final SingletonTraversable<Item> traversable) {
            super();

            stuck = new StuckTraverserState<>(traversable);
        }
    }

    private final TwoWayTraverserState=new Item>(

    getTraversable()

    )

    {

        @Override public TwoWayTraverserState<Item, SingletonTraverserState<Item>> getNextState () {
        return afterItem;
    }

        @Override public boolean hasNextItem () {
        return true;
    }

        @Override public Item getNextItem ()
        throws NoNextItemException {
        return item;
    }
    }

    ;

    private final TwoWayTraverserState<Item, SingletonTraverserState<Item>> afterItem = new LastItemTraverserState<Item>(
                                                                                                                        getTraversable()) {

        @Override
        public STwoWayTraverserState<Item, SingletonTraverserState<Item>> getPreviousState() {
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

    public SingletonTraverser(final Travble traversable) {
        delegateTraverser = new StatefulTwoWayTraverser<Item, Travble, TwoWayTraverserState<Item,>>(traversable,
                                                                                                    beforeItem);

        item = traversable.getItem();
    }
}
