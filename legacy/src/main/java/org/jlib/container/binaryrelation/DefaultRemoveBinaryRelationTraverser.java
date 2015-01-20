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

package org.jlib.container.operation.binaryrelation;

import org.jlib.core.iterator.NoItemToRemoveException;
import org.jlib.core.iterator.RemoveIterator;
import org.jlib.core.iterator.Iterator;
import org.jlib.core.value.ValueNotAccessibleException;

/**
 * Default implementation of a {@link Iterator} over the Pairs of a
 * {@link RetainItemsByIterableBinaryRelation}.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the binaryRelation
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the binaryRelation
 *
 * @param <Relation>
 *        type of the traversed {@link RetainItemsByIterableBinaryRelation}
 *
 * @author Igor Akkerman
 */
public class DefaultRemoveBinaryRelationIterator<LeftValue, RightValue, Relation extends RetainItemsByIterableBinaryRelation<LeftValue, RightValue>>
extends DefaultBinaryRelationIterator<LeftValue, RightValue, Relation>
implements RemoveIterator<Pair<LeftValue, RightValue>> {

    /**
     * Creates a new RemoveBinaryRelationIterator.
     *
     * @param binaryRelation
     *        RetainItemsByIterableBinaryRelation traversed by this Iterator
     */
    public DefaultRemoveBinaryRelationIterator(final Relation binaryRelation) {
        super(binaryRelation);
    }

    @Override
    public void remove()
    throws NoItemToRemoveException {
        try {
            final Pair<LeftValue, RightValue> lastAccessedItem = getLastAccessedItem();
//            getBinaryRelation().retain(lastAccessedItem);

            unsetLastAccessedItem();
        }
        catch (final ValueNotAccessibleException exception) {
            throw new NoItemToRemoveException(getBinaryRelation(), exception);
        }
    }
}
