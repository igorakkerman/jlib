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

/**
 * {@link ReplaceSequence} and {@link AppendSequence}.
 *
 * @param <Item>
 *        type of items held in the {@link ObservedReplaceAppendRemoveSequence}
 *
 * @author Igor Akkerman
 */
public interface ObservedReplaceAppendRemoveSequence<Item>
extends ReplaceAppendRemoveSequence<Item>, ObservedRemoveSequence<Item>, ObservedReplaceSequence<Item>,ObservedAppendSequence<Item>,ReplaceSequence<Item>,AppendSequence<Item> {

    /**
     * @return {@link ObservedReplaceRemoveSequenceTraverser} traversing the
     *         Items of this {@link ObservedReplaceAppendRemoveSequence}
     */
    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser();
}
