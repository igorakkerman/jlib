package org.jlib.container.sequence.index.array;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.InsertSequence;
import org.jlib.container.sequence.RemoveSequence;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.container.sequence.ReplaceSequenceTraverser;

/**
 * 
 * 
 * @param <Item>
 * 
 * @author Igor Akkerman
 */
public class DelegatingSequence<Item>
implements ReplaceSequence<Item>, AppendSequence<Item>, InsertSequence<Item>, RemoveSequence<Item> {

    private final ReplaceSequence<Item> replaceDelegateSequence;

    private final AppendSequence<Item> appendDelegateSequence;

    private final InsertSequence<Item> insertDelegateSequence;

    private final RemoveSequence<Item> removeDelegateSequence;

    /**
     * Creates a new {@link DelegatingSequence}.
     */
    // @formatter:off
    public <Sequenze extends ReplaceSequence<Item> & AppendSequence<Item> & InsertSequence<Item> & RemoveSequence<Item>> 
           DelegatingSequence(final Sequenze delegateSequence) {
    // @formatter:on
        super();

        replaceDelegateSequence = delegateSequence;
        appendDelegateSequence = delegateSequence;
        insertDelegateSequence = delegateSequence;
        removeDelegateSequence = delegateSequence;
    }

    @Override
    public Iterator<Item> iterator() {
        return replaceDelegateSequence.iterator();
    }

    @Override
    public int getItemsCount()
    throws IllegalContainerStateException {
        return replaceDelegateSequence.getItemsCount();
    }

    @Override
    public ReplaceSequenceTraverser<Item> createTraverser() {
        return replaceDelegateSequence.createReplaceSequenceTraverser();
    }

    @Override
    public boolean isEmpty()
    throws IllegalContainerStateException {
        return replaceDelegateSequence.isEmpty();
    }

    @Override
    public boolean equals(final Object otherObject) {
        return replaceDelegateSequence.equals(otherObject);
    }

    @Override
    public boolean isContaining(final Item item)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return replaceDelegateSequence.isContaining(item);
    }

    @Override
    public Collection<Item> toCollection() {
        return replaceDelegateSequence.toList();
    }

    @Override
    public List<Item> toList() {
        return replaceDelegateSequence.toList();
    }

    @Override
    public boolean isContaining(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return replaceDelegateSequence.isContaining(items);
    }

    @Override
    public boolean isContaining(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return replaceDelegateSequence.isContaining(items);
    }

    @Override
    public boolean isContaining(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return replaceDelegateSequence.isContaining(items);
    }

    @Override
    public Item[] toArray()
    throws IllegalContainerStateException {
        return replaceDelegateSequence.toArray();
    }

    @Override
    public void append(final Item item)
    throws IllegalContainerArgumentException {
        appendDelegateSequence.append(item);
    }

    @Override
    public void append(final Container<? extends Item> items)
    throws IllegalContainerArgumentException {
        appendDelegateSequence.append(items);
    }

    @Override
    public void append(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException {
        appendDelegateSequence.append(items);
    }

    @Override
    public void append(final Item... items)
    throws IllegalContainerArgumentException {
        appendDelegateSequence.append(items);
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.remove(item);
    }

    @Override
    public void removeAll()
    throws IllegalContainerStateException {
        removeDelegateSequence.removeAll();
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.remove(items);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.remove(items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.remove(items);
    }

    @Override
    public void remove(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.remove(items);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.retain(items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.retain(items);
    }

    @Override
    public void retain(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        removeDelegateSequence.retain(items);
    }
}
