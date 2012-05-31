package org.jlib.container.binaryrelation;

/**
 * {@link RuntimeException} referencing a {@link BinaryRelation}.
 * 
 * @author Igor Akkerman
 */
public abstract class BinaryRelationException {

    /** referenced {@link BinaryRelation} */
    private final BinaryRelation<?, ?> binaryRelation;

    /**
     * Creates a new {@link BinaryRelationException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */
    public BinaryRelationException(final BinaryRelation<?, ?> binaryRelation) {
        super();

        this.binaryRelation = binaryRelation;
    }

    /**
     * Returns the {@link BinaryRelation} referenced by this
     * {@link BinaryRelationException}.
     * 
     * @return referenced {@link BinaryRelation}
     */
    public BinaryRelation<?, ?> getBinaryRelation() {
        return binaryRelation;
    }
}
