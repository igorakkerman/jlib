package org.jlib.text.transformer;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

/**
 * {@link StringTransformer} transforming Strings using a sequence of specified
 * composing StringTransformers.
 *
 * @author Igor Akkerman
 */
public class CompositeStringTransformer
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
        for (final StringTransformer stringTransformer : stringTransformers)
            stringTransformer.transform(stringBuilder);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + stringTransformers;
    }

    /**
     * Verifies whether the specified {@link Object} is a
     * CompositeStringTransformer composed by {@link StringTransformer
     * StringTransformers} equal to those of this CompositeStringTransformer.
     *
     * @param otherObject
     *        {@link Object} to compare to this CompositeStringTransformer
     */
    @Override
    public boolean equals(final Object otherObject) {
        if (!(otherObject instanceof CompositeStringTransformer))
            return false;

        final CompositeStringTransformer otherCompositeStringTransformer = (CompositeStringTransformer) otherObject;

        return stringTransformers.equals(otherCompositeStringTransformer.stringTransformers);
    }

    @Override
    public int hashCode() {
        return stringTransformers.hashCode();
    }
}
