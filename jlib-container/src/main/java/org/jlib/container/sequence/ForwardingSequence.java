/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.sequence;

/**
 * {@link Sequence} delegating all operations to the specified delegate {@link Sequence}.
 * The delegate {@link Sequence} may be altered during the lifetime of the {@link ForwardingSequence}.
 *
 * @param <Item>
 *        type of the items held in the delegate {@link Sequence}
 *
 * @author Igor Akkerman
 */
public class ForwardingSequence<Item>
/*extends AutoCloneable
implements Sequence<Item> */ {

//    /** delegate {@link Sequence} */
//    private Sequence<Item> delegateSequence;
//
//    /**
//     * Creates a new {@link ForwardingSequence}.
//     *
//     * @param initialDelegateSequence
//     *        initial delegate {@link DelegateSequence}
//     */
//    public <DelegateSequence extends Sequence<Item>> /*
//        */ ForwardingSequence(final DelegateSequence initialDelegateSequence) {
//
//        super();
//
//        delegateSequence = initialDelegateSequence;
//    }
//
//    /**
//     * Returns the {@link Sequence}.
//     *
//     * @return {@link Sequence}
//     */
//    protected Sequence<Item> getDelegateSequence() {
//        return delegateSequence;
//    }
//
//    /**
//     * Registers the {@link ForwardingSequence}.
//     *
//     * @param delegateSequence
//     *        {@link Sequence}
//     */
//    protected void setDelegateSequence(final Sequence<Item> delegateSequence) {
//        this.delegateSequence = delegateSequence;
//    }
//
//    @Override
//    public Iterator<Item> iterator() {
//        return delegateSequence.iterator();
//    }
//
//    @Override
//    public int getCount()
//    throws InvalidContainerStateException {
//        return delegateSequence.getCount();
//    }
//
//    @Override
//    public boolean isEmpty()
//    throws InvalidContainerStateException {
//        return delegateSequence.isEmpty();
//    }
//
//    @Override
//    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
//        return delegateSequence.containsEqualItems(otherContainer);
//    }
//
////    @Override
//    public boolean containsEqualItems(final Iterable<Item> collection) {
//        return false; // delegateSequence.containsEqualItems(collection);
//    }
//
//    @Override
//    public boolean containsItem(final Item item)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        return delegateSequence.containsItem(item);
//    }
//
//    @Override
//    public boolean containsItem(final TraversableContainer<? extends Item> items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        return delegateSequence.containsItem(items);
//    }
//
//    @Override
//    public boolean containsItem(final Collection<? extends Item> items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        return delegateSequence.containsItem(items);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean containsItem(final Item... items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//        return delegateSequence.containsItem(items);
//    }
//
////    @Override
//    public List<Item> toSequentialList()
//    throws InvalidContainerStateException {
//        return null; // delegateSequence.toSequentialList();
//    }
//
////    @Override
//    public Item[] toArray()
//    throws InvalidContainerStateException {
//        return null; // delegateSequence.toArray();
//    }
//
////    @Override
//    public List<Item> toRandomAccessList() {
//        return null; // delegateSequence.toRandomAccessList();
//    }
//
//    @Override
//    public ForwardingSequenceTraverser<Item> createTraverser() {
//        return new ForwardingSequenceTraverser<>(delegateSequence.createTraverser());
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public ForwardingSequence<Item> clone() {
//        return (ForwardingSequence<Item>) super.clone();
//    }
}
