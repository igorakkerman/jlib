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

import org.jlib.core.system.SystemUtility;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.replaceOnce;

/**
 * Utility class providing static methods for String operations and
 * manipulations.
 *
 * @author Igor Akkerman
 */
public final class TextUtility {

    /** property name of the system's line separator */
    public static final String LINE_SEPARATOR_PROPERTY_NAME = "line.separator";

    /** the system's line separator */
    public static final String LINE_SEPARATOR = SystemUtility.getApplicationProperty(LINE_SEPARATOR_PROPERTY_NAME);

    public static String removeOnce(final String containingString, final String removedString) {
        return replaceOnce(containingString, removedString, EMPTY);
    }

    public static Iterable<Character> asIterable(final CharSequence characterSequence) {
        return () -> new CharSequenceIterator(characterSequence);
    }

    public static Iterable<Character> asIterable(final CharSequence characterSequence, final int firstCharacterIndex) {
        return () -> new CharSequenceIterator(characterSequence, firstCharacterIndex);
    }

    public static Iterable<Character> asIterable(final CharSequence characterSequence, final int firstCharacterIndex,
                                                 final int lastCharacterIndex) {
        return () -> new CharSequenceIterator(characterSequence, firstCharacterIndex, lastCharacterIndex);
    }

    /** no visible constructor */
    private TextUtility() {
    }

    // TODO: convert to StringTransformer
    public static String camelCaseToLowerCaseWords(final CharSequence sequence) {

        final int sequenceLength = sequence.length();

        if (sequenceLength == 0)
            return EMPTY;

        final StringBuilder messageBuilder = new StringBuilder(sequenceLength * 2);

        messageBuilder.append(toLowerCase(sequence.charAt(0)));

        for (final char exceptionNameCharacter : asIterable(sequence, 1))
            if (isUpperCase(exceptionNameCharacter))
                messageBuilder.append(' ').append(toLowerCase(exceptionNameCharacter));
            else
                messageBuilder.append(exceptionNameCharacter);

        return messageBuilder.toString();
    }
}
