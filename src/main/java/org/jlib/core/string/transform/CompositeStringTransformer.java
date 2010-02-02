package org.jlib.core.string.transform;

import java.util.LinkedList;
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
        stringTransformers = new LinkedList<StringTransformer>();
    }

    /**
     * Creates a new CompositeStringTransformer initially composed by the
     * specified {@link StringTransformer StringTransformers}.
     * 
     * @param stringTransformers
     *        {@link List} of {@link StringTransformer StringTransformers}
     *        composing this CompositeStringTransformer
     */
    public CompositeStringTransformer(List<? extends StringTransformer> stringTransformers) {
        this();
        this.stringTransformers.addAll(stringTransformers);
    }

    // @see org.jlib.core.string.transform.StringTransformer#transform(java.lang.StringBuilder)
    @Override
    public void transform(StringBuilder stringBuilder) {
        for (StringTransformer stringTransformer : stringTransformers)
            stringTransformer.transform(stringBuilder);
    }
}
