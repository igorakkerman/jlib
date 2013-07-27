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

import static org.jlib.core.traverser.SingletonTraverser.*;

public class SingletonTraverser<Item, Travble extends SingletonTraversable<Item>>
extends AbstractTraverser<Item, SingletonTraversable<Item>>
implements TwoWayTraverser<Item> {

    public static abstract class SingletonTraverserState<Item>
    implements TwoWayTraverserState<Item, SingletonTraverserState<Item>> {

    }

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

    private final TwoWayTraverserState<Item,> beforeItem = new FirstItemTraverserState<Item>(getTraversable()) {

        @Override
        public TwoWayTraverserState<Item> getNextState() {
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

    private final TwoWayTraverserState<Item> afterItem = new LastItemTraverserState<Item>(getTraversable()) {

        @Override
        public TwoWayTraverserState<Item> getPreviousState() {
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
