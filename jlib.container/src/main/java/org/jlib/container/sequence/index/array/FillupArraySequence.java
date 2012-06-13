package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.EmptySequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.ObservedAppendSequence;
import org.jlib.container.sequence.ObservedReplaceSequence;
import org.jlib.container.sequence.index.IndexSequenceUtility;
import org.jlib.core.observer.ValueObserver;

/**
 * 
 * 
 * @author Igor Akkerman
 */
public class FillupArraySequence<Item>
extends DelegatingReplaceAppendSequence<Item> {

    private ObservedReplaceSequence<Item> delegateReplaceSequence;

    private ObservedAppendSequence<Item> delegateAppendSequence;

    private class EmptyDelegateSequence
    extends EmptySequence<Item>
    implements ObservedAppendSequence<Item> {

        /**
         * Creates a new {@link EmptyDelegateSequence}.
         */
        public EmptyDelegateSequence() {
            super();
        }

        @Override
        public void append(final Item item) {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(), item);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void append(final Container<? extends Item> items)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(),
                                                    (Container<Item>) items);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void append(final Collection<? extends Item> items)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(),
                                                    (Collection<Item>) items);
        }

        @Override
        @SafeVarargs
        public final void append(final Item... items)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(), items);
        }

        @SafeVarargs
        @Override
        public final void append(final Item item, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(), items);
        }

        @SafeVarargs
        @Override
        public final void append(final Container<? extends Item> items, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(), items);
        }

        @SafeVarargs
        @Override
        public final void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(), items);
        }

        @SafeVarargs
        @Override
        public final void append(final ValueObserver<Item>[] observers, final Item... items)
        throws IllegalSequenceArgumentException {
            delegateReplaceSequence =
                IndexSequenceUtility.createSequence(ReplaceAppendArraySequence.<Item> getCreator(), items);
        }
    }

    /**
     * Creates a new {@link FillupArraySequence}.
     */
    public FillupArraySequence() {
        super();

        setDelegateSequence(new EmptyDelegateSequence());
    }
}
