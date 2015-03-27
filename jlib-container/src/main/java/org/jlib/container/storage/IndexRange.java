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

import org.jlib.core.Valid;

import static org.jlib.core.NumericUtility.count;
import org.jlib.exception.UnexpectedStateException;

/**
 * Modifiable {@link Integer} index range.
 *
 * @author Igor Akkerman
 */
public class IndexRange
implements Cloneable,
           Serializable {

    private static final long serialVersionUID = - 7959127796333433937L;

    private Integer minimum;
    private Integer maximum;

    public IndexRange(@Valid final Integer minimum, @Valid final Integer maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(@Valid final Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(@Valid final Integer maximum) {
        this.maximum = maximum;
    }

    public void incrementMinimum(final int increment) {
        minimum += increment;
    }

    public void incrementMaximum(final int increment) {
        maximum += increment;
    }

    public int itemsCount() {
        return count(minimum, maximum);
    }

    @Override
    public IndexRange clone() {
        try {
            return (IndexRange) super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}
