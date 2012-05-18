package org.jlib.container.sequence.array;

/**
 * Aggregation of {@link ArraySequence} creators.
 * 
 * @author Igor Akkerman
 */
public final class ArraySequenceCreators {

    /** creator of {@link ArraySequence} instances */
    public static final ArraySequenceCreator ARRAY_SEQUENCE = new ArraySequenceCreator();

    /** creator of {@link ReplaceArraySequence} instances */
    public static final ReplaceArraySequenceCreator<?> REPLACE_ARRAY_SEQUENCE = new ReplaceArraySequenceCreator<>();

    /** creator of {@link AddReplaceArraySequence} instances */
    public static final AddReplaceArraySequenceCreator<?> ADD_REPLACE_ARRAY_SEQUENCE =
        new AddReplaceArraySequenceCreator<>();

    /** no visible constructor */
    private ArraySequenceCreators() {}
}
