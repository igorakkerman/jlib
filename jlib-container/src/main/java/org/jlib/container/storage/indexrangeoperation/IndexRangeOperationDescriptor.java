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

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

import org.jlib.core.exception.UnexpectedStateException;

import org.apache.commons.beanutils.BeanUtils;

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
    private final int sourceBeginIndex;

    /** end index of the source range */
    private final int sourceEndIndex;

    /** target index */
    private final int targetIndex;

    /**
     * Creates a new {@link IndexRangeOperationDescriptor}.
     *
     * @param sourceBeginIndex
     *        integer specifying the begin index of the source range
     *
     * @param sourceEndIndex
     *        integer specifying the end index of the source range
     *
     * @param targetIndex
     *        integer specifying the target index
     */
    public IndexRangeOperationDescriptor(final int sourceBeginIndex, final int sourceEndIndex, final int targetIndex) {

        this.sourceBeginIndex = sourceBeginIndex;
        this.sourceEndIndex = sourceEndIndex;
        this.targetIndex = targetIndex;
    }

    /**
     * Returns the begin index of the source range.
     *
     * @return integer specifying the begin index of the source range
     */
    public int getSourceBeginIndex() {
        return sourceBeginIndex;
    }

    /**
     * Returns the end index of the source range.
     *
     * @return integer specifying the end index of the source range
     */
    public int getSourceEndIndex() {
        return sourceEndIndex;
    }

    /**
     * Returns the target index.
     *
     * @return integer specifying the target index
     */
    public int getTargetIndex() {
        return targetIndex;
    }

    @Override
    public IndexRangeOperationDescriptor clone() {

        // TODO: replace by more general strategy
        try {
            final IndexRangeOperationDescriptor cloneTarget = (IndexRangeOperationDescriptor) super.clone();

            BeanUtils.copyProperties(cloneTarget, this);

            return cloneTarget;
        }
        catch (IllegalAccessException | InvocationTargetException | CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
