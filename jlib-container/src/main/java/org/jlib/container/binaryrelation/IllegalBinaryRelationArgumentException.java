package org.jlib.container.binaryrelation;

import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link IllegalContainerArgumentException} referencing a
 * {@link BinaryRelation}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalBinaryRelationArgumentException
extends IllegalContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5603158282885764114L;

    /** referenced {@link BinaryRelation} */
    private final BinaryRelation<?, ?> binaryRelation;

    /**
     * Creates a new {@link IllegalBinaryRelationArgumentException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */
    public IllegalBinaryRelationArgumentException(final BinaryRelation<?, ?> binaryRelation) {
        this(binaryRelation, "{1}");
    }

    /**
     * Creates a new {@link IllegalBinaryRelationArgumentException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param messagePattern
     *        {@link String} specifying the pattern of the error message
     * 
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public IllegalBinaryRelationArgumentException(final BinaryRelation<?, ?> binaryRelation,
                                                  final String messagePattern, final Object... messageArguments) {
        this(binaryRelation, messagePattern, (Throwable) null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalBinaryRelationArgumentException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param messagePattern
     *        {@link String} specifying the pattern of the error message
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalBinaryRelationArgumentException}
     * 
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public IllegalBinaryRelationArgumentException(final BinaryRelation<?, ?> binaryRelation,
                                                  final String messagePattern, final Throwable cause,
                                                  final Object... messageArguments) {
        super(binaryRelation, messagePattern, cause, messageArguments);

        this.binaryRelation = binaryRelation;
    }

    /**
     * Returns the referenced {@link BinaryRelation}.
     * 
     * @return referenced {@link BinaryRelation}
     */
    @Override
    public BinaryRelation<?, ?> getContainer() {
        return binaryRelation;
    }
}
