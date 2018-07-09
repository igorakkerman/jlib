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

package org.jlib.text;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.replaceOnce;
import static org.jlib.message.Messages.message;

public class Text {

    public static final String EMPTY = "";
    public static final String[] NO_STRINGS = {};
    public static final Comparator<?> STRING_LENGTH_COMPARATOR = (compared1, compared2) -> compared1.toString().length() - compared2.toString().length();

    /** the system's line separator */
    public static StringBuilder clear(final StringBuilder stringBuilder) {
        stringBuilder.setLength(0);

        return stringBuilder;
    }

    public static String removeOnce(final String containingString, final String removedString) {
        return replaceOnce(containingString, removedString, EMPTY);
    }

    public static Iterable<Character> asIterable(final CharSequence characterSequence) {
        return () -> new CharSequenceIterator(characterSequence);
    }

    public static Iterable<Character> asIterable(final CharSequence characterSequence, final int firstCharacterIndex) {
        return () -> new CharSequenceIterator(characterSequence, firstCharacterIndex);
    }

    public static Iterable<Character> asIterable(final CharSequence characterSequence, final int firstCharacterIndex, final int lastCharacterIndex) {
        return () -> new CharSequenceIterator(characterSequence, firstCharacterIndex, lastCharacterIndex);
    }

    public static void ensureIndicesValid(final CharSequence charSequence, final int firstCharacterIndex, final int lastCharacterIndex)
        throws CharSequenceIndexOutOfBoundsException {

        if (firstCharacterIndex < 0)
            throw new CharSequenceIndexOutOfBoundsException(charSequence, message().with("firstCharacterIndex", firstCharacterIndex));

        if (firstCharacterIndex > lastCharacterIndex)
            throw new CharSequenceIndexOutOfBoundsException(charSequence, message().with("firstCharacterIndex", firstCharacterIndex)
                                                                                   .with("lastCharacterIndex", lastCharacterIndex));
    }

    @SuppressWarnings("unchecked")
    public static <Compared> Comparator<Compared> stringLength() {
        return (Comparator<Compared>) STRING_LENGTH_COMPARATOR;
    }

    @SafeVarargs
    public static void splitInto(final String compositeString, final String regex, final Consumer<String>... elementConsumers) {

        final String[] elements = compositeString.split(regex);

        if (elementConsumers.length < elements.length)
            throw new IllegalArgumentException(String.format(
                "Too few elementConsumers. #elementConsumers=%d. #elements=%d.",
                elementConsumers.length,
                elements.length));

        if (elementConsumers.length > elements.length)
            throw new IllegalArgumentException(String.format(
                "Too many elementConsumers. #elementConsumers=%d. #elements=%d.",
                elementConsumers.length,
                elements.length));

        IntStream
            .range(0, elements.length)
            .forEach(index -> elementConsumers[index].accept(elements[index]));
    }
}
