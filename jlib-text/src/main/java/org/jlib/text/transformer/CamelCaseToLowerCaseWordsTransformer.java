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

package org.jlib.text.transformer;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;
import static org.jlib.text.TextUtility.asIterable;
import static org.jlib.text.TextUtility.clear;

public class CamelCaseToLowerCaseWordsTransformer
implements StringTransformer {

    @Override
    public void transform(final StringBuilder stringBuilder) {

        final int initialLength = stringBuilder.length();

        if (initialLength == 0)
            return;

        final String initialString = stringBuilder.toString();

        clear(stringBuilder);

        stringBuilder.append(toLowerCase(initialString.charAt(0)));

        for (final char exceptionNameCharacter : asIterable(initialString, 1))
            if (isUpperCase(exceptionNameCharacter))
                stringBuilder.append(' ').append(toLowerCase(exceptionNameCharacter));
            else
                stringBuilder.append(exceptionNameCharacter);
    }
}
