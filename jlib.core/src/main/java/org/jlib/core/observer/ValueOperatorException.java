package org.jlib.core.observer;

/**
 * {@link ObserverException} thrown during {@link ValueOperator#operate(Object)}
 * .
 * 
 * @author Igor Akkerman
 */
public class ValueOperatorException
extends OperatorException {

    /** value operated on */
    private final Object value;

    /**
     * Creates a new {@link ValueOperatorException}.
     * 
     * @param value
     *        Value removed from {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern; {1} references
     *        {@code Value}
     * 
     * @param cause
     *        {@link RuntimeException} that caused this
     *        {@link ValueOperatorException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ValueOperatorException(final Object value, final String messagePattern, final RuntimeException cause,
                                  final Object... messageArguments) {
        super(messagePattern, cause, value, messageArguments);

        this.value = value;
    }

    /**
     * Returns the value operated on.
     * 
     * @return {@link Object} specifying the value
     */
    public Object getValue() {
        return value;
    }
}
