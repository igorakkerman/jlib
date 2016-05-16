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

package org.jlib.container.storage;

import java.io.Serializable;

import org.jlib.exception.UnexpectedStateException;

/**
 * Descriptor of an operation on indexed objects specifying a source index range and a target index.
 *
 * @author Igor Akkerman
 */
public class IndexRangeOperationDescriptor
    implements Cloneable,
               Serializable {

    private static final long serialVersionUID = - 750513726974596434L;

    private final IndexRange sourceRange;
    private final Integer targetIndex;

    public IndexRangeOperationDescriptor(final Integer sourceMinimumIndex, final Integer sourceMaximumIndex,
                                         final Integer targetIndex) {
        this(new IndexRange(sourceMinimumIndex, sourceMaximumIndex), targetIndex);
    }

    public IndexRangeOperationDescriptor(final IndexRange sourceRange, final Integer targetIndex) {
        this.sourceRange = sourceRange;
        this.targetIndex = targetIndex;
    }

    public IndexRange getSourceRange() {
        return sourceRange;
    }

    public Integer getTargetIndex() {
        return targetIndex;
    }

    @Override
    public IndexRangeOperationDescriptor clone() {
        try {
            return (IndexRangeOperationDescriptor) super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
