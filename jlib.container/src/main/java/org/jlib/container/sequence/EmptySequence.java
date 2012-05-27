package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jlib.container.Container;
import org.jlib.container.sequence.index.ReplaceIndexSequence;

/**
 * Empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items
 * 
 * @author Igor Akkerman
 */
public class EmptySequence<Item>
extends AbstractSequence<Item> {

    /** sole instance of this class */
    private static final EmptySequence<?> INSTANCE = new EmptySequence<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link ReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequence<Item> getInstance() {
        return (EmptySequence<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequence}.
     */
    protected EmptySequence() {
        super();
    }

    @Override
    public SequenceTraverser<Item> createTraverser() {
        return EmptySequenceTraverser.getInstance();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(final Item item) {
        return false;
    }

    @Override
    public boolean containsAll(final Container<? extends Item> items) {
        return false;
    }

    @Override
    public boolean containsAll(final Collection<? extends Item> items) {
        return false;
    }

    @Override
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Item... items) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> toList() {
        return Collections.unmodifiableList(Collections.EMPTY_LIST);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Item[] toArray() {
        return (Item[]) new Object[0];
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}
