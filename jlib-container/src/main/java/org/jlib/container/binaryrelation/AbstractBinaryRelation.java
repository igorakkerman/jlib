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

package org.jlib.container.binaryrelation;

import org.jlib.container.AbstractContainer;
import org.jlib.core.traverser.Traverser;

/**
 * Skeletal implementation of a {@link BinaryRelation}.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link BinaryRelation}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the
 *        {@link BinaryRelation}
 *
 * @author Igor Akkerman
 */
public abstract class AbstractBinaryRelation<LeftValue, RightValue>
extends AbstractContainer<Pair<LeftValue, RightValue>>
implements BinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new {@link AbstractBinaryRelation}.
     */
    protected AbstractBinaryRelation() {
        super();
    }

    @Override
    public Traverser<Pair<LeftValue, RightValue>> createTraverser() {
        return new DefaultBinaryRelationTraverser<>(this);
    }

    @Override
    public boolean contains(final LeftValue leftValue, final RightValue rightValue) {
        return hasLeft(leftValue) && getRightSet(leftValue).contains(rightValue);
    }

    @Override
    public boolean contains(final Pair<LeftValue, RightValue> pair) {
        return contains(pair.getLeftValue(), pair.getRightValue());
    }
}
