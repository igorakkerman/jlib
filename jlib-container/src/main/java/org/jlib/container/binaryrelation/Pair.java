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

import org.jlib.core.language.AbstractCloneable;

/**
 * Binary association.
 *
 * @param <LeftValue>
 *        type of the left hand side value of the {@link BinaryRelation}
 *
 * @param <RightValue>
 *        type of the right hand side value of the {@link BinaryRelation}
 *
 * @author Igor Akkerman
 */
public class Pair<LeftValue, RightValue>
extends AbstractCloneable {

    /** LeftValue of this Pair */
    private final LeftValue leftValue;

    /** RightValue of this Pair */
    private final RightValue rightValue;

    /**
     * Creates a new Pair.
     *
     * @param leftValue
     *        {@link LeftValue} of this {@link Pair}
     *
     * @param rightValue
     *        {@link RightValue} of this {@link Pair}
     */
    public Pair(final LeftValue leftValue, final RightValue rightValue) {
        super();

        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /**
     * Returns the object on the left hand side of this {@link Pair}.
     *
     * @return {@link LeftValue} of this {@link Pair}
     */
    public LeftValue getLeftValue() {
        return leftValue;
    }

    /**
     * Returns the object on the right hand side of this {@link Pair}.
     *
     * @return {@link RightValue} of this {@link Pair}
     */
    public RightValue getRightValue() {
        return rightValue;
    }

    @Override
    public String toString() {
        return "<" + leftValue + ", " + rightValue + '>';
    }
}
