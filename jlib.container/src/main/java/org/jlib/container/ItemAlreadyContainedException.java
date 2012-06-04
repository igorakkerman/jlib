package org.jlib.container;

/**
 * {@link IllegalContainerArgumentException} thrown when trying to illegally add
 * an Item to a {@link Container} that already exists.
 * 
 * @author Igor Akkerman
 */
public class ItemAlreadyContainedException
extends IllegalContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1090527595338576596L;

    /** already contained Item */
    private final Object item;

    /**
     * Creates a new {@link ItemAlreadyContainedException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param item
     *        already contained Item
     */
    public ItemAlreadyContainedException(final Container<?> container, final Object item) {
        super(container, "{1}: {2}", item);
        this.item = item;
    }

    /**
     * Returns the already contained item.
     * 
     * @return already contained item
     */
    public Object getItem() {
        return item;
    }
}
