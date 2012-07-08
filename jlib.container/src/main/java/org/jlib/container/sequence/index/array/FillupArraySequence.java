package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.AppendSequence;
import org.jlib.container.sequence.DelegatingSequence;
import org.jlib.container.sequence.EmptySequence;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.ObservedAppendSequence;
import org.jlib.container.sequence.ReplaceSequence;
import org.jlib.core.observer.ValueObserver;

import static org.jlib.container.sequence.index.IndexSequenceUtility.createSequence;

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
    implements ObservedAppendSequence<Item> {

        /**
         * Creates a new {@link EmptyDelegateSequence}.
         */
        public EmptyDelegateSequence() {
            super();
        }

        @Override
        public void append(final Item item) {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), item));
        }

        @Override
        public void append(final Container<? extends Item> items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), items));
        }

        @Override
        public void append(final Collection<? extends Item> items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), items));
        }

        @Override
        @SafeVarargs
        public final void append(final Item... items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), items));
        }

        @SafeVarargs
        @Override
        public final void append(final Item item, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), observers, item));
        }

        @SafeVarargs
        @Override
        public final void append(final Container<? extends Item> items, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), items, observers));
        }

        @SafeVarargs
        @Override
        public final void append(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), items, observers));
        }

        @SafeVarargs
        @Override
        public final void append(final ValueObserver<Item>[] observers, final Item... items)
        throws IllegalSequenceArgumentException {
            setDelegateSequence(createSequence(ReplaceAppendRemoveArraySequence.<Item> getCreator(), observers, items));
        }
    }
}
