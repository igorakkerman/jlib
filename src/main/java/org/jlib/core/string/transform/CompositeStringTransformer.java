package org.jlib.core.string.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link StringTransformer} transforming Strings using a list of specified
 * composing StringTransformers.
 * 
 * @author Igor Akkerman
 */
public class CompositeStringTransformer
implements StringTransformer {

    /**
     * {@link List} of {@link StringTransformer StringTransformers} composing
     * this CompositeStringTransformer
     */
    private List<StringTransformer> stringTransformers;

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * specified {@link StringTransformer StringTransformers}.
     */
    public CompositeStringTransformer() {
        super();
        stringTransformers = new ArrayList<StringTransformer>();
    }

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * {@link StringTransformer StringTransformers} specified in a {@link List}.
     * 
     * @param stringTransformers
     *        {@link List} of {@link StringTransformer StringTransformers}
     *        initially composing this CompositeStringTransformer
     */
    public CompositeStringTransformer(List<? extends StringTransformer> stringTransformers) {
        this();
        addStringTransformers(stringTransformers);
    }

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * {@link StringTransformer StringTransformers} specified in an argument
     * list.
     * 
     * @param stringTransformers
     *        argument list of {@link StringTransformer StringTransformers}
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
     * argument list as composing element of this CompositeStringTransformer.
     * 
     * @param stringTransformers
     *        argument list of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(StringTransformer... stringTransformers) {
        Collections.addAll(this.stringTransformers, stringTransformers);
    }

    /**
     * Adds the {@link StringTransformer StringTransformers} specified in an
     * argument list as composing elements of this CompositeStringTransformer.
     * 
     * @param stringTransformers
     *        {@link List} of {@link StringTransformer StringTransformers}
     *        additionally composing this CompositeStringTransformer
     */
    public void addStringTransformers(List<? extends StringTransformer> stringTransformers) {
        this.stringTransformers.addAll(stringTransformers);
    }

    // @see org.jlib.core.string.transform.StringTransformer#transform(java.lang.StringBuilder)
    @Override
    public void transform(StringBuilder stringBuilder) {
        for (StringTransformer stringTransformer : stringTransformers)
            stringTransformer.transform(stringBuilder);
    }

    // @see java.lang.Object#toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() + stringTransformers;
    }

    /**
     * Returns whether the specified {@link Object} is a
     * CompositeStringTransformer composed by {@link StringTransformer
     * StringTransformers} equal to those of this CompositeStringTransformer.
     * 
     * @param otherObject {@link Object} to compare to this CompositeStringTransformer
     */
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof CompositeStringTransformer))
            return false;
        
        CompositeStringTransformer otherCompositeStringTransformer = (CompositeStringTransformer) otherObject;
        
        return stringTransformers.equals(otherCompositeStringTransformer.stringTransformers);
    }
    
    // @see java.lang.Object#hashCode()
    @Override
    public int hashCode() {
        return stringTransformers.hashCode();
    }
}
