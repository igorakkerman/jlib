/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.container.storage.indexrangeoperation;

import java.io.Serializable;

import org.jlib.core.exception.UnexpectedStateException;

/**
 * Descriptor of an operation on indexed objects specifying a source index range and a target index.
 *
 * @author Igor Akkerman
 */
public class IndexRangeOperationDescriptor
implements Cloneable,
           Serializable {

    private static final long serialVersionUID = - 2349186633834250865L;

    /** begin index of the source range */
    private final Integer sourceBeginIndex;

    /** end index of the source range */
    private final Integer sourceEndIndex;

    /** target index */
    private final Integer targetIndex;

    /**
     * Creates a new {@link IndexRangeOperationDescriptor}.
     *
     * @param sourceBeginIndex
     *        Integereger specifying the begin index of the source range
     *
     * @param sourceEndIndex
     *        Integereger specifying the end index of the source range
     *
     * @param targetIndex
     *        Integereger specifying the target index
     */
    public IndexRangeOperationDescriptor(final Integer sourceBeginIndex, final Integer sourceEndIndex, final Integer targetIndex) {

        this.sourceBeginIndex = sourceBeginIndex;
        this.sourceEndIndex = sourceEndIndex;
        this.targetIndex = targetIndex;
    }

    /**
     * Returns the begin index of the source range.
     *
     * @return Integereger specifying the begin index of the source range
     */
    public Integer getSourceBeginIndex() {
        return sourceBeginIndex;
    }

    /**
     * Returns the end index of the source range.
     *
     * @return Integereger specifying the end index of the source range
     */
    public Integer getSourceEndIndex() {
        return sourceEndIndex;
    }

    /**
     * Returns the target index.
     *
     * @return Integereger specifying the target index
     */
    public Integer getTargetIndex() {
        return targetIndex;
    }

    @Override
    public IndexRangeOperationDescriptor clone() {

        // TODO: replace by more general strategy
        try {
            return (IndexRangeOperationDescriptor) super.clone();
        }
        catch (CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
