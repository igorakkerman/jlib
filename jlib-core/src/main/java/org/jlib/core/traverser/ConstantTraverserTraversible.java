/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core.traverser;

/**
 * {@link Traversible} always providing a constant {@link Traverser}.
 *
 * @param <Item>
 *        type of the Items traversed by the {@link Traverser}
 *
 * @author Igor Akkerman
 */
public class ConstantTraverserTraversible<Item>
implements Traversible<Item> {

    /** returned {@link Traverser}r */
    private final Traverser<Item> traverser;

    /**
     * Creates a new {@link ConstantTraverserTraversible}.
     *
     * @param traverser
     *        constantly returned {@link Traverser}
     */
    public ConstantTraverserTraversible(final Traverser<Item> traverser) {
        super();

        this.traverser = traverser;
    }

    @Override
    public Traverser<Item> createTraverser() {
        return traverser;
    }
}
