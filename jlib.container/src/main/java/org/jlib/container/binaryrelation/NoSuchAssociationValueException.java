package org.jlib.container.binaryrelation;

/**
 * {@link IllegalAssociationException} thrown when referencing an
 * {@link Association} not contained by the specified {@link BinaryRelation}.
 * 
 * @author Igor Akkerman
 */
public abstract class NoSuchAssociationValueException
extends IllegalBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 5642778973583219541L;

    /** LeftValue or RightValue of the {@link Association} */
    private final Object value;

    /**
     * Creates a new {@link NoSuchAssociationValueException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param valueName
     *        {@link String} specifying the value name
     * 
     * @param value
     *        LeftValue or RightValue of the {@link Association}
     */
    public NoSuchAssociationValueException(final BinaryRelation<?, ?> binaryRelation, final String valueName,
                                      final Object value) {
        super(binaryRelation, "{1}: {2} '{3}'", value);

        this.value = value;
    }

    /**
     * Returns the LeftValue of the illegal {@link Association}.
     * 
     * @return LeftValue of the {@link Association}
     */
    public Object getValue() {
        return value;
    }
}
