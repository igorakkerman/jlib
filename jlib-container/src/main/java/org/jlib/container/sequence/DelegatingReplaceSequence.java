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

package org.jlib.container.sequence;

import org.jlib.container.ReplaceContainer;
import org.jlib.core.traverser.ReplaceTraverser;

public class DelegatingReplaceSequence<Item>
extends DelegatingSequence<Item>
implements ReplaceContainer<Item> {

    private final ReplaceContainer<Item> delegateReplaceContainer;

    /**
     * Creates a new {@link DelegatingSequence}.
     *
     * @param initialDelegateSequence
     *        initial delegate {@link DelegateSequence}
     */
    public <DelegateSequence extends Sequence<Item> & ReplaceContainer<Item>> /*
        */ DelegatingReplaceSequence(final DelegateSequence initialDelegateSequence) {
        super(initialDelegateSequence);

        delegateSequence = initialDelegateSequence;
    }

    @Override
    public boolean equals(final Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public DelegatingReplaceSequenceTraverser<Item> createTraverser() {
        return new DelegatingReplaceSequenceTraverser<>(getDelegateSequence().createTraverser());
    }
}
