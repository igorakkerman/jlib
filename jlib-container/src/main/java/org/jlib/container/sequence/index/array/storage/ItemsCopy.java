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

package org.jlib.container.sequence.index.array.storage;

/**
 * Descriptor of an Item copy operation specifying a source Item index range
 * <em>from</em> which and destination Item index <em>to</em> which a
 * specified amount of Items is copied.
 *
 * @author Igor Akkerman
 */
public class ItemsCopy {

    /** begin index of the copied range */
    private final int sourceBeginIndex;

    /** end index of the copied range */
    private final int sourceEndIndex;

    /** index to which the range is copied */
    private final int targetIndex;

    /**
     * Creates a new {@link ItemsCopy}.
     *
     * @param sourceBeginIndex
     *        integer specifying the begin index of the copied range
     *
     * @param sourceEndIndex
     *        integer specifying the end index of the copied range
     *
     * @param targetIndex
     *        integer specifying the index to which the range is copied
     */
    public ItemsCopy(final int sourceBeginIndex, final int sourceEndIndex, final int targetIndex) {
        super();

        this.sourceBeginIndex = sourceBeginIndex;
        this.sourceEndIndex = sourceEndIndex;
        this.targetIndex = targetIndex;
    }

    /**
     * Returns the begin index of the copied range.
     *
     * @return integer specifying the begin index of the copied range
     */
    public int getSourceBeginIndex() {
        return sourceBeginIndex;
    }

    /**
     * Returns the end index of the copied range.
     *
     * @return integer specifying the end index of the copied range
     */
    public int getSourceEndIndex() {
        return sourceEndIndex;
    }

    /**
     * Returns the index to which the range is copied.
     *
     * @return integer specifying the index to which the range is copied
     */
    public int getTargetIndex() {
        return targetIndex;
    }
}
