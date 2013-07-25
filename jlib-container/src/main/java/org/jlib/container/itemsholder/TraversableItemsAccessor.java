package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

public class TraversableItemsAccessor<Item>
implements ItemsAccessor<Item> {

    private final Traversable<? extends Item> traversable;

    public TraversableItemsAccessor(final Traversable<? extends Item> traversable) {
        super();

        this.traversable = traversable;
    }

    @Override
    public <Result> Result accept(ItemsAccessorVisitor<Item, Result> visitor) {
        return visitor.visitTraversable(traversable);
    }
}
