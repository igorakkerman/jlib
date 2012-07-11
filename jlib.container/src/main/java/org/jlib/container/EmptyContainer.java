package org.jlib.container;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.ReplaceIndexSequence;
import org.jlib.core.array.ArrayUtility;
import org.jlib.core.traverser.Traverser;

/**
 * Empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items
 * 
 * @author Igor Akkerman
 */
public class EmptyContainer<Item>
implements Container<Item> {

    /** sole instance of this class */
    private static final EmptyContainer<?> INSTANCE = new EmptyContainer<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @param <Item>
     *        type of potential items potentially held in this
     *        {@link EmptyContainer}
     * 
     * @return sole {@link ReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptyContainer<Item> getInstance() {
        return (EmptyContainer<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyContainer}.
     */
    protected EmptyContainer() {
        super();
    }

    @Override
    public Traverser<Item> createTraverser() {
        return EmptyContainerTraverser.getInstance();
    }

    @Override
    public final int getItemsCount() {
        return 0;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean contains(final Item item) {
        return false;
    }

    @Override
    public final boolean contains(final Container<? extends Item> items) {
        return false;
    }

    @Override
    public final boolean contains(final Collection<? extends Item> items) {
        return false;
    }

    @Override
    @SafeVarargs
    public final boolean contains(final Item... items) {
        return false;
    }

    @Override
    public List<Item> toList() {
        return Collections.emptyList();
    }

    @Override
    public List<Item> toSequentialList() {
        return Collections.emptyList();
    }

    @Override
    public final Item[] toArray() {
        return ArrayUtility.getEmptyArray();
    }

    @Override
    public Iterator<Item> iterator() {
        return Collections.emptyIterator();
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity

    @Override
    public boolean containsEqualItems(final Container<Item> otherContainer) {
        return otherContainer.isEmpty();
    }

    @Override
    public boolean containsEqualItems(final Collection<Item> collection) {
        return collection.isEmpty();
    }
}
