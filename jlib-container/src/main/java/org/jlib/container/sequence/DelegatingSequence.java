package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.core.AbstractCloneable;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;

/**
 * {@link ObservedReplaceSequence} and {@link ObservedAppendSequence} delegating
 * all operations to the specified delegate {@link ObservedReplaceSequence} and
 * {@link ObservedAppendSequence}.
 * 
 * @param <Item>
 *        type of the items held in the delegate {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DelegatingSequence<Item>
extends AbstractCloneable
implements ObservedReplaceAppendRemoveSequence<Item> {

    /** delegate {@link ObservedReplaceAppendRemoveSequence} */
    private ObservedReplaceAppendRemoveSequence<Item> delegateSequence;

    /**
     * Creates a new {@link DelegatingSequence}.
     */
    public DelegatingSequence() {
        super();
    }

    /**
     * Creates a new {@link DelegatingSequence}.
     * 
     * @param initialDelegateSequence
     *        initial delegate {@link ObservedReplaceAppendRemoveAllSequence}
     */
    public DelegatingSequence(final ObservedReplaceAppendRemoveAllSequence<Item> initialDelegateSequence) {
        this();

        setDelegateSequence(initialDelegateSequence);
    }

    /**
     * Returns the delegate {@link ObservedAppendSequence}.
     * 
     * @return delegate {@link ObservedAppendSequence}
     */
    protected ObservedReplaceAppendRemoveSequence<Item> getDelegateSequence() {
        return delegateSequence;
    }

    /**
     * Registers the delegate {@link ObservedReplaceAppendRemoveSequence} of
     * this {@link DelegatingSequence}.
     * 
     * @param delegateSequence
     *        delegate {@link ObservedReplaceAppendRemoveSequence}
     */
    protected void setDelegateSequence(final ObservedReplaceAppendRemoveSequence<Item> delegateSequence) {
        this.delegateSequence = delegateSequence;
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateSequence.iterator();
    }

    @Override
    public int getItemsCount()
    throws IllegalContainerStateException {
        return delegateSequence.getItemsCount();
    }

    @Override
    public boolean isEmpty()
    throws IllegalContainerStateException {
        return delegateSequence.isEmpty();
    }

    @Override
    public boolean equals(final Object otherObject) {
        return delegateSequence.equals(otherObject);
    }

    @Override
    public boolean containsEqualItems(final Container<Item> otherContainer) {
        return delegateSequence.containsEqualItems(otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Collection<Item> collection) {
        return delegateSequence.containsEqualItems(collection);
    }

    @Override
    public boolean contains(final Item item)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateSequence.contains(item);
    }

    @Override
    public boolean contains(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateSequence.contains(items);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateSequence.contains(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateSequence.contains(items);
    }

    @Override
    public List<Item> toSequentialList()
    throws IllegalContainerStateException {
        return delegateSequence.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws IllegalContainerStateException {
        return delegateSequence.toArray();
    }

    @Override
    public void append(final Item item)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(item);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Item item, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(item, observers);
    }

    @Override
    public void append(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(items, observers);
    }

    @Override
    public void append(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(items);
    }

    @Override
    public List<Item> toList() {
        return delegateSequence.toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Item... items)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException {
        delegateSequence.append(observers, items);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateSequence.retain(items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateSequence.retain(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateSequence.retain(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateSequence.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateSequence.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateSequence.retain(observers, items);
    }

    @Override
    public ObservedReplaceRemoveSequenceTraverser<Item> createTraverser() {
        return delegateSequence.createTraverser();
    }

    @Override
    @SuppressWarnings("unchecked")
    public DelegatingSequence<Item> clone() {
        return (DelegatingSequence<Item>) super.clone();
    }
}
