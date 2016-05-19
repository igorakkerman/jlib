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

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;
import org.jlib.basefunctions.ApplicationObject;

/**
 * {@link StringTransformer} transforming Strings using a sequence of specified
 * composing StringTransformers.
 *
 * @author Igor Akkerman
 */
public class CompositeStringTransformer
    extends ApplicationObject
    implements StringTransformer {

    /**
     * {@link List} of {@link StringTransformer StringTransformers}
     * composing this CompositeStringTransformer
     */
    private final List<StringTransformer> stringTransformers;

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * specified {@link StringTransformer StringTransformers}.
     */
    public CompositeStringTransformer() {
        stringTransformers = new ArrayList<>();
    }

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * {@link StringTransformer StringTransformers} specified in a
     * {@link List}.
     *
     * @param stringTransformers
     *        {@link List} of {@link StringTransformer StringTransformers}
     *        initially composing this CompositeStringTransformer
     */
    public CompositeStringTransformer(final List<? extends StringTransformer> stringTransformers) {
        this();
        addStringTransformers(stringTransformers);
    }

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * {@link StringTransformer StringTransformers} specified in an argument
     * sequence.
     *
     * @param stringTransformers
     *        argument sequence of {@link StringTransformer StringTransformers}
     *        initially composing this CompositeStringTransformer
     */
    public CompositeStringTransformer(final StringTransformer... stringTransformers) {
        this();
        addStringTransformers(stringTransformers);
    }

    /**
     * Adds the specified {@link StringTransformer} as composing item of this
     * CompositeStringTransformer.
     *
     * @param stringTransformer
     *        {@link StringTransformer} additionally composing this
     *        CompositeStringTransformer
     */
    public void addStringTransformer(final StringTransformer stringTransformer) {
        stringTransformers.add(stringTransformer);
    }

    /**
     * Adds the {@link StringTransformer StringTransformers} specified in an
     * argument sequence as composing item of this
     * CompositeStringTransformer.
     *
     * @param additionalStringTransformers
     *        argument list of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(final StringTransformer... additionalStringTransformers) {
        addAll(stringTransformers, additionalStringTransformers);
    }

    /**
     * Adds the {@link StringTransformer StringTransformers} specified in an
     * argument sequence as composing items of this
     * CompositeStringTransformer.
     *
     * @param additionalStringTransformers
     *        {@link List} of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(final List<? extends StringTransformer> additionalStringTransformers) {
        stringTransformers.addAll(additionalStringTransformers);
    }

    @Override
    public void transform(final StringBuilder stringBuilder) {
        stringTransformers.forEach(stringTransformer -> stringTransformer.transform(stringBuilder));
    }
}
