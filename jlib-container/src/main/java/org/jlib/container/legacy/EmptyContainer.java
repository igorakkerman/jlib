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

package org.jlib.container.legacy;

import java.io.Serializable;

import org.jlib.container.ReadContainer;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.ReplaceIndexSequence;

/**
 * Empty {@link Sequence}.
 *
 * @param <Item>
 *        type of the items
 *
 * @author Igor Akkerman
 */
public final class EmptyContainer<Item>
extends AbstractEmptyContainer<Item>
implements ReadContainer<Item>,
           Serializable {

    private static final long serialVersionUID = 8790659392867781894L;

    /** sole instance of this class */
    private static final EmptyContainer<?> INSTANCE = new EmptyContainer<>();

    /**
     * Returns the sole instance of this class.
     *
     * @param <Item>
     *        type of potential items potentially held in this
     *        {@link EmptyContainer}
     *
     * @return sole {@link ReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptyContainer<Item> getInstance() {
        return (EmptyContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyContainer}.
     */
    private EmptyContainer() {
        super();
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object otherObject) {
        return otherObject == this;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
}
