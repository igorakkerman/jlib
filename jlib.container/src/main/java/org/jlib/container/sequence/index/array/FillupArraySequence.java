package org.jlib.container.sequence.index.array;

import java.util.Collection;
import java.util.Iterator;
import java.util.Observer;

import org.jlib.container.Container;
import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.DelegatingSequence;
import org.jlib.container.sequence.EmptySequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.ObservedReplaceAppendRemoveSequence;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.Operator;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.traverser.Traverser;

import static org.jlib.core.array.ArrayUtility.iterable;

/**
 * Default implementation of a {@link ReplaceSequence} and
 * {@link AppendSequence}. It is created empty and can be filled up with Items.
 * 
 * @param <Item>
 *        type of items held int he {@link FillupArraySequence}
 * 
 * @author Igor Akkerman
 */
public class FillupArraySequence<Item>
extends DelegatingSequence<Item> {

    /**
     * Creates a new {@link FillupArraySequence}.
     */
    public FillupArraySequence() {
        super();

        setDelegateSequence(new EmptyDelegateSequence());
    }

    /**
     * {@link EmptySequence} registering a new {@link ReplaceSequence} and
     * {@link AppendSequence} as new delegate of the surrounding
     * {@link FillupArraySequence}.
     * 
     * @author Igor Akkerman
     */
    private class EmptyDelegateSequence
    extends EmptySequence<Item>
    implements ObservedReplaceAppendRemoveSequence<Item> {

        /**
         * Creates a new {@link EmptyDelegateSequence}.
         */
        public EmptyDelegateSequence() {
            super();
        }

        @Override
        public void append(final Item item) {
            setDelegateSequence(new ReplaceInsertRemoveArraySequence<Item>(item));
        }

        @Override
        public void append(final Container<? extends Item> items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(new ReplaceInsertRemoveArraySequence<Item>(items));
        }

        @Override
        public void append(final Collection<? extends Item> items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(new ReplaceInsertRemoveArraySequence<Item>(items));
        }

        @Override
        @SafeVarargs
        public final void append(final Item... items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(new ReplaceInsertRemoveArraySequence<Item>(items));
        }

        @SafeVarargs
        @Override
        public final void append(final Item item, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            ObserverUtility.operate(new Operator() {

                @Override
                public void operate() {
                    append(item);
                }
            },

            item, observers);
        }

        @SafeVarargs
        @Override
        public final void append(final Container<? extends Item> items, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            if (items.isEmpty())
                return;

            final Traverser<? extends Item> traverser = items.createTraverser();
            append(traverser.getNextItem(), observers);

            final ObservedReplaceAppendRemoveSequence<Item> delegateSequence = getDelegateSequence();

            while (traverser.isNextItemAccessible())
                delegateSequence.append(traverser.getNextItem(), observers);
        }

        @SafeVarargs
        @Override
        public final void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            if (items.isEmpty())
                return;

            append((Iterable<? extends Item>) items, observers);
        }

        @SafeVarargs
        @Override
        public final void append(final ValueObserver<Item>[] observers, final Item... items)
        throws IllegalSequenceArgumentException {
            if (items.length == 0)
                return;

            append(iterable(items), observers);
        }

        /**
         * Creates a delegate {@link ObservedReplaceAppendRemoveSequence} for
         * the surrounding {@link FillupArraySequence} containing the first Item
         * traversed by the specified {@link Iterator}, then appends the further
         * traversed Items to the delegate
         * {@link ObservedReplaceAppendRemoveSequence}.
         * 
         * @param items
         *        Items to append to the surrounding {@link FillupArraySequence}
         * 
         * @param observers
         *        comma separated sequence of {@link Observer} instances
         *        attending the operations
         */
        @SuppressWarnings("unchecked")
        private void append(final Iterable<? extends Item> items, final ValueObserver<Item>... observers) {
            final Iterator<? extends Item> iterator = items.iterator();
            append(iterator.next(), observers);

            final ObservedReplaceAppendRemoveSequence<Item> delegateSequence = getDelegateSequence();

            while (iterator.hasNext())
                delegateSequence.append(iterator.next(), observers);
        }
    }
}
