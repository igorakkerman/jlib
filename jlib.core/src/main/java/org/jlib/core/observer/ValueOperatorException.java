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
     * @param cause
     *        {@link RuntimeException} that caused this
     *        {@link ValueOperatorException}
     */
    public ValueOperatorException(final Object value, final RuntimeException cause) {
        super("{1}", cause, value);

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
