package org.jlib.container;

/**
 * {@link IllegalArgumentException} referencing a {@link Container}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalContainerArgumentException
extends IllegalArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 2421922462571124521L;

    /** referenced {@link Container} */
    private final Container<?> container;

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     * 
     * @param container
     *        referenced {@link Container}
     */
    public IllegalContainerArgumentException(final Container<?> container) {
        this.container = container;
    }

    /**
     * Returns the {@link Container} reference by this
     * {@link IllegalContainerArgumentException}.
     * 
     * @return referenced {@link Container}
     */
    public Container<?> getContainer() {
        return container;
    }
}
