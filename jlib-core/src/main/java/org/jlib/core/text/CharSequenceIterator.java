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

package org.jlib.core.text;

import java.util.Iterator;

import org.jlib.core.iterator.NoNextItemException;

public final class CharSequenceIterator
implements Iterator<Character> {

    private final CharSequence characterSequence;
    private final int lastCharacterIndex;

    private int nextCharacterIndex;

    public CharSequenceIterator(final CharSequence characterSequence) {
        this(characterSequence, 0);
    }

    public CharSequenceIterator(final CharSequence characterSequence, final int firstCharacterIndex) {
        this(characterSequence, firstCharacterIndex, characterSequence.length() - 1);
    }

    public CharSequenceIterator(final CharSequence characterSequence, final int firstCharacterIndex,
                         final int lastCharacterIndex) {

        this.characterSequence = characterSequence;

        nextCharacterIndex = firstCharacterIndex;
        this.lastCharacterIndex = lastCharacterIndex;
    }

    @Override
    public boolean hasNext() {
        return nextCharacterIndex <= lastCharacterIndex;
    }

    @Override
    public Character next() {
        if (! hasNext())
            throw new NoNextItemException("characterSequence", characterSequence);

        return characterSequence.charAt(nextCharacterIndex++);
    }
}
