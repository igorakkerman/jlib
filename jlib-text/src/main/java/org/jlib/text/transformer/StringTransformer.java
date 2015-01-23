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

/**
 * Transformer of a String using the strategy defined by the implementation of this interface.
 * The actual transformation is performed within a {@link StringBuilder}, which is passed as an argument to the
 * {@link #transform} method.
 *
 * @author Igor Akkerman
 */
@FunctionalInterface
public interface StringTransformer {

    /**
     * Transforms the String contained by the specified {@link StringBuilder}
     * using the strategy of this {@link StringTransformer}.
     *
     * @param stringBuilder
     *        {@link StringBuilder} containing the String to transform
     */
    void transform(StringBuilder stringBuilder);
}
