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
 * {@link RuntimeException} referencing a {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public abstract class BinaryRelationException {

    /** referenced {@link BinaryRelation} */
    private final BinaryRelation<?, ?> binaryRelation;

    /**
     * Creates a new {@link BinaryRelationException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */
    public BinaryRelationException(final BinaryRelation<?, ?> binaryRelation) {
        super();

        this.binaryRelation = binaryRelation;
    }

    /**
     * Returns the {@link BinaryRelation} referenced by this
     * {@link BinaryRelationException}.
     *
     * @return referenced {@link BinaryRelation}
     */
    public BinaryRelation<?, ?> getBinaryRelation() {
        return binaryRelation;
    }
}
