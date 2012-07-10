package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.NoSuchItemToRemoveException;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.observer.ValueObserverException;
import org.jlib.core.traverser.BidirectionalTraverser;
import org.jlib.core.traverser.ObservedRemoveTraverser;
import org.jlib.core.traverser.ReplaceTraverser;
import org.jlib.core.traverser.Traverser;

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
implements ObservedReplaceSequence<Item>, ObservedAppendSequence<Item>, ObservedRemoveSequence<Item> {

    /** delegate {@link ObservedReplaceSequence} */
    private ObservedReplaceSequence<Item> delegateReplaceSequence;

    /** delegate {@link ObservedAppendSequence} */
    private ObservedAppendSequence<Item> delegateAppendSequence;

    /** delegate {@link ObservedRemoveSequence} */
    private ObservedRemoveSequence<Item> delegateRemoveSequence;

    /**
     * Creates a new {@link DelegatingSequence}.
     */
    public DelegatingSequence() {
        super();
    }

    /**
     * Creates a new {@link DelegatingSequence}.
     * 
     * @param <Sequenze>
     *        type of the delegate {@link ObservedReplaceSequence} and
     *        {@link ObservedAppendSequence}
     * 
     * @param initialDelegateSequence
     *        initial delegate {@link ObservedReplaceSequence} and
     *        {@link ObservedAppendSequence}
     */
    // @formatter:off
    public <Sequenze extends ObservedReplaceSequence<Item> & ObservedAppendSequence<Item> & ObservedRemoveSequence<Item>>
           DelegatingSequence(final Sequenze initialDelegateSequence) {
    // @formatter:on
        this();

        setDelegateSequence(initialDelegateSequence);
    }

    /**
     * Returns the delegate {@link ObservedReplaceSequence}.
     * 
     * @return delegate {@link ObservedReplaceSequence}
     */
    protected ObservedReplaceSequence<Item> getDelegateReplaceSequence() {
        return delegateReplaceSequence;
    }

    /**
     * Returns the delegate {@link ObservedAppendSequence}.
     * 
     * @return delegate {@link ObservedAppendSequence}
     */
    protected ObservedAppendSequence<Item> getDelegateAppendSequence() {
        return delegateAppendSequence;
    }

    /**
     * Registers the delegate {@link ObservedReplaceSequence} and
     * {@link ObservedAppendSequence} type of the delegate
     * {@link ObservedReplaceSequence} and {@link ObservedAppendSequence}
     * 
     * @param <Sequenze>
     *        type of the delegate {@link ObservedReplaceSequence} and
     *        {@link ObservedAppendSequence}
     * 
     * @param delegateSequence
     *        delegate {@link ObservedReplaceSequence} and
     *        {@link ObservedAppendSequence}
     */
    // @formatter:off
    protected <Sequenze extends ObservedReplaceSequence<Item> & ObservedAppendSequence<Item> & ObservedRemoveSequence<Item>>
    void setDelegateSequence(final Sequenze delegateSequence) {
    // @formatter:on
        delegateReplaceSequence = delegateSequence;
        delegateAppendSequence = delegateSequence;
        delegateRemoveSequence = delegateSequence;
    }

    @Override
    public Traverser<Item> createTraverser() {
        return delegateReplaceSequence.createTraverser();
    }

    @Override
    public BidirectionalTraverser<Item> createBidirectionalTraverser() {
        return delegateReplaceSequence.createBidirectionalTraverser();
    }

    @Override
    public Iterator<Item> iterator() {
        return delegateReplaceSequence.iterator();
    }

    @Override
    public int getItemsCount()
    throws IllegalContainerStateException {
        return delegateReplaceSequence.getItemsCount();
    }

    @Override
    public ReplaceSequenceTraverser<Item> createReplaceSequenceTraverser() {
        return delegateReplaceSequence.createReplaceSequenceTraverser();
    }

    @Override
    public SequenceTraverser<Item> createSequenceTraverser() {
        return delegateReplaceSequence.createSequenceTraverser();
    }

    @Override
    public ReplaceTraverser<Item> createReplaceTraverser() {
        return delegateReplaceSequence.createReplaceTraverser();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceSequenceTraverser<Item> createReplaceSequenceTraverser(final ValueObserver<Item>... observers) {
        return delegateReplaceSequence.createReplaceSequenceTraverser(observers);
    }

    @Override
    public boolean isEmpty()
    throws IllegalContainerStateException {
        return delegateReplaceSequence.isEmpty();
    }

    @Override
    public boolean equals(final Object otherObject) {
        return delegateReplaceSequence.equals(otherObject);
    }

    @Override
    public boolean containsEqualItems(final Container<Item> otherContainer) {
        return delegateRemoveSequence.containsEqualItems(otherContainer);
    }

    @Override
    public boolean containsEqualItems(final Collection<Item> collection) {
        return delegateAppendSequence.containsEqualItems(collection);
    }

    @Override
    public boolean contains(final Item item)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateReplaceSequence.contains(item);
    }

    @Override
    public boolean contains(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateReplaceSequence.contains(items);
    }

    @Override
    public boolean contains(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateReplaceSequence.contains(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        return delegateReplaceSequence.contains(items);
    }

    @Override
    public List<Item> toSequentialList()
    throws IllegalContainerStateException {
        return delegateReplaceSequence.toSequentialList();
    }

    @Override
    public Item[] toArray()
    throws IllegalContainerStateException {
        return delegateReplaceSequence.toArray();
    }

    @Override
    public void append(final Item item)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(item);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Item item, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(item, observers);
    }

    @Override
    public void append(final Container<? extends Item> items)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(items, observers);
    }

    @Override
    public void append(final Collection<? extends Item> items)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(items);
    }

    @Override
    public List<Item> toList() {
        return delegateAppendSequence.toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Item... items)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void append(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalSequenceArgumentException {
        delegateAppendSequence.append(observers, items);
    }

    @Override
    public RemoveSequenceTraverser<Item> createRemoveTraverser() {
        return delegateRemoveSequence.createRemoveTraverser();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservedRemoveSequenceTraverser<Item> createRemoveTraverser(final ValueObserver<Item>... observers) {
        return delegateRemoveSequence.createRemoveTraverser(observers);
    }

    @Override
    public void remove(final Item item)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.remove(item);
    }

    @Override
    public void removeAll()
    throws IllegalContainerStateException {
        delegateRemoveSequence.removeAll();
    }

    @Override
    public void remove(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.remove(items);
    }

    @Override
    public void remove(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.remove(items);
    }

    @Override
    public void remove(final Iterable<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.remove(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.remove(items);
    }

    @Override
    public void retain(final Container<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.retain(items);
    }

    @Override
    public void retain(final Collection<? extends Item> items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.retain(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException {
        delegateRemoveSequence.retain(items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws IllegalContainerStateException {
        delegateRemoveSequence.removeAll(observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Item item, final ValueObserver<Item>... observers)
    throws NoSuchItemToRemoveException, IllegalContainerArgumentException, IllegalContainerStateException,
    ValueObserverException {
        delegateRemoveSequence.remove(item, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Iterable<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.remove(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.remove(observers, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.retain(items, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException, IllegalContainerStateException, ValueObserverException {
        delegateRemoveSequence.retain(observers, items);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservedRemoveTraverser<Item> createObservedRemoveTraverser(final ValueObserver<Item>... observers) {
        return delegateRemoveSequence.createObservedRemoveTraverser(observers);
    }
}
