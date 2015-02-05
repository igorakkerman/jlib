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

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.jlib.container.iterator.iterator.NoNextItemException;
import org.jlib.container.iterator.iterator.Iterator;
import org.jlib.core.value.InitializedModifiable;
import org.jlib.core.value.Modifiable;
import org.jlib.core.value.Uninitialized;
import org.jlib.core.value.ValueNotAccessibleException;

/**
 * Default implementation of a {@link Iterator} over the {@link Pair}
 * items of a {@link BinaryRelation}.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the binaryRelation
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the binaryRelation
 *
 * @param <Relation>
 *        type of the traversed {@link BinaryRelation}
 *
 * @author Igor Akkerman
 */
public class DefaultBinaryRelationIterator<LeftValue, RightValue, Relation extends BinaryRelation<LeftValue, RightValue>>
implements Iterator<Pair<LeftValue, RightValue>> {

    /** traversed {@link BinaryRelation} */
    private final Relation binaryRelation;

    /** {@link Iterator} over the LeftValues of the {@link BinaryRelation} */
    private final Iterator<LeftValue> leftValuesIterator;

    /** {@link Iterator} over the RightValues of the {@link BinaryRelation} */
    private Iterator<RightValue> rightValuesIterator;

    /** current LeftValue */
    private LeftValue leftValue;

    /** {@link Modifiable} for the index of the last accessed Item */
    private Modifiable<Pair<LeftValue, RightValue>> lastAccessedItemHolder;

    /**
     * Creates a new {@link DefaultBinaryRelationIterator} for the specified
     * {@link BinaryRelation}.
     *
     * @param binaryRelation
     *        traversed {@link BinaryRelation}
     */
    public DefaultBinaryRelationIterator(final Relation binaryRelation) {
        super();

        this.binaryRelation = binaryRelation;

        leftValuesIterator = binaryRelation.getLeftValues().iterator();

        if (leftValuesIterator.hasNext())
            readNextLeftValue();
        else
            rightValuesIterator = Collections.<RightValue>emptySet().iterator();

        unsetLastAccessedItem();
    }

    /**
     * Unregisters the last accessed Item.
     */
    protected void unsetLastAccessedItem() {
        lastAccessedItemHolder = new Uninitialized<Pair<LeftValue, RightValue>>() {

            @Override
            public void setValue(final Pair<LeftValue, RightValue> pair) {
                lastAccessedItemHolder = new InitializedModifiable<>(pair);
            }
        };
    }

    /**
     * Retrieves the next LeftValue.
     */
    private void readNextLeftValue() {
        leftValue = leftValuesIterator.next();
        rightValuesIterator = binaryRelation.getRightSet(leftValue).iterator();
    }

    @Override
    public boolean hasNext() {
        return rightValuesIterator.hasNext() || leftValuesIterator.hasNext();
    }

    @Override
    public Pair<LeftValue, RightValue> next()
    throws NoNextItemException {
        try {
            if (! rightValuesIterator.hasNext())
                readNextLeftValue();

            final Pair<LeftValue, RightValue> pair = new Pair<>(leftValue,
                                                                                     rightValuesIterator.next());

            lastAccessedItemHolder.setValue(pair);

            return pair;
        }
        catch (final NoSuchElementException exception) {
            throw new NoNextItemException(binaryRelation, exception);
        }
    }

    /**
     * Returns the traversed {@link BinaryRelation}. .
     *
     * @return traversed {@link BinaryRelation}
     */
    public Relation getBinaryRelation() {
        return binaryRelation;
    }

    /**
     * Returns the last {@link Pair} returned by this
     * {@link DefaultBinaryRelationIterator}.
     *
     * @return last returned {@link Pair}
     *
     * @throws ValueNotAccessibleException
     *         if no {@link Pair} has been accessed
     */
    protected Pair<LeftValue, RightValue> getLastAccessedItem()
    throws ValueNotAccessibleException {
        return lastAccessedItemHolder.getValue();
    }
}
