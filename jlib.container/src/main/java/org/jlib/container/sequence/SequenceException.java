package org.jlib.container.sequence;

/**
 * {@link RuntimeException} referencing a {@link Sequence}.
 * 
 * @author Igor Akkerman
 */
public abstract class SequenceException
extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5009055546803096622L;

    /** referenced {@link Sequence} */
    private final Sequence<?> sequence;

    /**
     * Creates a new {@link SequenceException}.
     * 
     * @param sequence
     *        referenced {@link Sequence}
     */
    public SequenceException(final Sequence<?> sequence) {
        super();

        this.sequence = sequence;
    }

    /**
     * Returns the {@link Sequence} of this {@link SequenceException}.
     * 
     * @return referenced {@link Sequence}
     */
    public Sequence<?> getSequence() {
        return sequence;
    }
}
