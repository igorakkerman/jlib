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

import org.jlib.core.exception.ValueNotAccessibleException;
import org.jlib.core.exception.traverser.NoNextItemException;
import org.jlib.core.traverser.Traverser;
import org.jlib.core.valueholder.InitializedModifiableValueHolder;
import org.jlib.core.valueholder.ModifiableValueHolder;
import org.jlib.core.valueholder.UninitializedValueHolder;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Default implementation of a {@link Traverser} over the {@link Association}
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
public class DefaultBinaryRelationTraverser<LeftValue, RightValue, Relation extends BinaryRelation<LeftValue, RightValue>>
implements Traverser<Association<LeftValue, RightValue>> {

    /** traversed {@link BinaryRelation} */
    private final Relation binaryRelation;

    /** {@link Iterator} over the LeftValues of the {@link BinaryRelation} */
    private final Iterator<LeftValue> leftValuesIterator;

    /** {@link Iterator} over the RightValues of the {@link BinaryRelation} */
    private Iterator<RightValue> rightValuesIterator;

    /** current LeftValue */
    private LeftValue leftValue;

    /** {@link ModifiableValueHolder} for the index of the last accessed Item */
    private ModifiableValueHolder<Association<LeftValue, RightValue>> lastAccessedItemHolder;

    /**
     * Creates a new {@link DefaultBinaryRelationTraverser} for the specified
     * {@link BinaryRelation}.
     *
     * @param binaryRelation
     *        traversed {@link BinaryRelation}
     */
    public DefaultBinaryRelationTraverser(final Relation binaryRelation) {
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
        lastAccessedItemHolder = new UninitializedValueHolder<Association<LeftValue, RightValue>>() {

            @Override
            public void setValue(final Association<LeftValue, RightValue> association) {
                lastAccessedItemHolder = new InitializedModifiableValueHolder<>(association);
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
    public boolean isNextItemAccessible() {
        return rightValuesIterator.hasNext() || leftValuesIterator.hasNext();
    }

    @Override
    public Association<LeftValue, RightValue> getNextItem()
    throws NoNextItemException {
        try {
            if (! rightValuesIterator.hasNext())
                readNextLeftValue();

            final Association<LeftValue, RightValue> association = new Association<>(leftValue,
                                                                                     rightValuesIterator.next());

            lastAccessedItemHolder.setValue(association);

            return association;
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
     * Returns the last {@link Association} returned by this
     * {@link DefaultBinaryRelationTraverser}.
     *
     * @return last returned {@link Association}
     *
     * @throws ValueNotAccessibleException
     *         if no {@link Association} has been accessed
     */
    protected Association<LeftValue, RightValue> getLastAccessedItem()
    throws ValueNotAccessibleException {
        return lastAccessedItemHolder.getValue();
    }
}
