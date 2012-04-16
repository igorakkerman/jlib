package org.jlib.text.transformer;

import org.jlib.container.sequence.ArrayAddIndexSequence;
import org.jlib.container.sequence.AddSequence;
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
    private AddSequence<StringTransformer> stringTransformers;

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * specified {@link StringTransformer StringTransformers}.
     */
    public CompositeStringTransformer() {
        super();
        
        stringTransformers = new ArrayAddIndexSequence<StringTransformer>();
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
    public CompositeStringTransformer(Sequence<? extends StringTransformer> stringTransformers) {
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
    public CompositeStringTransformer(StringTransformer... stringTransformers) {
        this();
        addStringTransformers(stringTransformers);
    }

    /**
     * Adds the specified {@link StringTransformer} as composing element of this
     * CompositeStringTransformer.
     * 
     * @param stringTransformer
     *        {@link StringTransformer} additionally composing this
     *        CompositeStringTransformer
     */
    public void addStringTransformer(StringTransformer stringTransformer) {
        stringTransformers.add(stringTransformer);
    }

    /**
     * Adds the {@link StringTransformer StringTransformers} specified in an
     * argument sequence as composing element of this
     * CompositeStringTransformer.
     * 
     * @param additionalStringTransformers
     *        argument list of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(StringTransformer... additionalStringTransformers) {
        stringTransformers.addAll(additionalStringTransformers);
    }

    /**
     * Adds the {@link StringTransformer StringTransformers} specified in an
     * argument sequence as composing elements of this
     * CompositeStringTransformer.
     * 
     * @param additionalStringTransformers
     *        {@link Sequence} of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(final Sequence<? extends StringTransformer> additionalStringTransformers) {
        stringTransformers.addAll(additionalStringTransformers);
    }


    @Override
    public void transform(StringBuilder stringBuilder) {
        for (StringTransformer stringTransformer : stringTransformers)
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
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof CompositeStringTransformer))
            return false;

        CompositeStringTransformer otherCompositeStringTransformer = (CompositeStringTransformer) otherObject;

        return stringTransformers.equals(otherCompositeStringTransformer.stringTransformers);
    }


    @Override
    public int hashCode() {
        return stringTransformers.hashCode();
    }
}
