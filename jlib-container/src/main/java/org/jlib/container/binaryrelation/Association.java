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

/**
 * Association in a BinaryRelation.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the BinaryRelation
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the BinaryRelation
 *
 * @author Igor Akkerman
 */
public class Association<LeftValue, RightValue> {

    /** LeftValue of this Association */
    private final LeftValue leftValue;

    /** RightValue of this Association */
    private final RightValue rightValue;

    /**
     * Creates a new Association.
     *
     * @param leftValue
     *        LeftValue of this Association
     *
     * @param rightValue
     *        RightValue of this Association
     */
    public Association(final LeftValue leftValue, final RightValue rightValue) {
        super();

        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /**
     * Returns the object on the left hand side of this Association.
     *
     * @return LeftValue of this Association
     */
    public LeftValue getLeftValue() {
        return leftValue;
    }

    /**
     * Returns the object on the right hand side of this Association.
     *
     * @return RightValue of this Association
     */
    public RightValue getRightValue() {
        return rightValue;
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (! (otherObject instanceof Association<?, ?>))
            return false;

        final Association<?, ?> otherAssociation = (Association<?, ?>) otherObject;

        return leftValue.equals(otherAssociation.getLeftValue()) && rightValue.equals(otherAssociation.getRightValue());
    }

    @Override
    public int hashCode() {
        return leftValue.hashCode() * 2 + rightValue.hashCode();
    }
}
