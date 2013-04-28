package org.jlib.text.transformer;

import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.Sequence;

/**
 * {@link StringTransformer} transforming Strings using a sequence of specified
 * composing StringTransformers.
 * 
 * @author Igor Akkerman
 */
public class CompositeStringTransformer
implements StringTransformer {

    /**
     * {@link Sequence} of {@link StringTransformer StringTransformers}
     * composing this CompositeStringTransformer
     */
    private final AppendSequence<StringTransformer> stringTransformers;

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * specified {@link StringTransformer StringTransformers}.
     */
    public CompositeStringTransformer() {
        super();

        stringTransformers = new AddArraySequence<StringTransformer>();
    }

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * {@link StringTransformer StringTransformers} specified in a
     * {@link Sequence}.
     * 
     * @param stringTransformers
     *        {@link Sequence} of {@link StringTransformer StringTransformers}
     *        initially composing this CompositeStringTransformer
     */
    public CompositeStringTransformer(final Sequence<? extends StringTransformer> stringTransformers) {
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
        stringTransformers.add(additionalStringTransformers);
    }

    /**
     * Adds the {@link StringTransformer StringTransformers} specified in an
     * argument sequence as composing items of this
     * CompositeStringTransformer.
     * 
     * @param additionalStringTransformers
     *        {@link Sequence} of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(final Sequence<? extends StringTransformer> additionalStringTransformers) {
        stringTransformers.add(additionalStringTransformers);
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
