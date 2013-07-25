package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

public class TraversableItemsHolderAdapter<Item>
implements ItemsHolderAdapter<Item> {

    private final Traversable<? extends Item> traversable;

    public TraversableItemsHolderAdapter(final Traversable<? extends Item> traversable) {
        super();

        this.traversable = traversable;
    }

    @Override
    public <Result> Result accept(ItemsHolderVisitor<Item, Result> visitor) {
        return visitor.visitTraversable(traversable);
    }
}
