package org.jlib.core;

/**
 * {@link JlibException} thrown when a requested Value is not set.
 * 
 * @author Igor Akkerman
 */
public class ValueNotSetException
extends ValueNotAccessibleException {

    /** serialVersionUID */
    private static final long serialVersionUID = 4844161228178575622L;

    /**
     * Creates a new {@link ValueNotSetException}.
     */
    public ValueNotSetException() {
        super();
    }

    /**
     * Creates a new {@link ValueNotSetException}.
     * 
     * @param valueName
     *        {@link String} specifying a descriptive name of the Value
     */
    public ValueNotSetException(final String valueName) {
        super(valueName);
    }
}
