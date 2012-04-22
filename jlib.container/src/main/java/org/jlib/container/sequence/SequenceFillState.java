package org.jlib.container.sequence;

class SequenceFillState<Element> {

    /** delegate {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequence<Element> delegateSequence;
    
    private SequenceFillState<Element> addElementFillState;

    private SequenceFillState<Element> removeElementFillState;

    SequenceFillState(final ReplaceIndexSequence<Element> delegateSequence) {
        super();
        
        this.delegateSequence = delegateSequence;
    }

    ReplaceIndexSequence<Element> getDelegateSequence() {
        return delegateSequence;
    }

    SequenceFillState<Element> getAddElementFillState() {
        return addElementFillState;
    }

    void setAddElementFillState(SequenceFillState<Element> addElementFillState) {
        this.addElementFillState = addElementFillState;
    }

    SequenceFillState<Element> getRemoveElementFillState() {
        return removeElementFillState;
    }

    void setRemoveElementFillState(SequenceFillState<Element> removeElementFillState) {
        this.removeElementFillState = removeElementFillState;
    }
}