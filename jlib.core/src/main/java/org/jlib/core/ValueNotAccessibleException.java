package org.jlib.core;

/**
 * {@link JlibException} thrown when a requested Value is not accessible.
 * 
 * @author Igor Akkerman
 */
public class ValueNotAccessibleException
extends JlibException {

    /** serialVersionUID */
    private static final long serialVersionUID = -813625306823615853L;

    /**
     * Creates a new {@link ValueNotAccessibleException}.
     */
    public ValueNotAccessibleException() {
        super();
    }

    /**
     * Creates a new {@link ValueNotAccessibleException}.
     * 
     * @param valueName
     *        {@link String} specifying a descriptive name of the Value
     */
    public ValueNotAccessibleException(final String valueName) {
        super(valueName);
    }
}
