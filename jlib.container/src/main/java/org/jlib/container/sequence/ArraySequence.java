/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence;

import java.util.Iterator;

import org.jlib.container.Container;
import org.jlib.container.sequence.SequenceFillStateRegistry.SequenceFillState;

// @formatter:off   
/**
 * <p>
 * Fixed sized array. Replacement for the standard Java arrays with special
 * features.
 * </p>
 * <p>
 * The only syntactical difference to Java arrays lies in the notation for
 * retrieving and providing values and retrieving the array size:
 * </p>
 * 
 * <pre>
 * {@literal
 * // good(?) old Java array                      // cool(!) new jlib ArraySequence class
 * String[] stringArray = new String[10];         ArraySequence<String> stringArray = new ArraySequence<String>(10);
 * stringArray[4] = "good(?) old Java array";     stringArray.set(4, "cool(!) new jlib ArraySequence class");
 * String s = stringArray[4];                     String s = stringArray.get(4);
 * int size = stringArray.length;                 int size = stringArray.size(); }
 * </pre>
 * 
 * <p>
 * Special features:
 * </p>
 * <ul>
 * <li>Minimum and maximum index: <br/>
 * On instantiation, you can specify the first and the maximum index of the
 * ArraySequence. Thus, no offset is necessary for Arrays starting at other indices than
 * 0. The following example illustrates how an ArraySequence is filled with numbers from
 * 1 to 10:
 * 
 * <pre>
 * // good(?) old Java array                      // cool(!) new jlib ArraySequence class
 * Integer[] integerArray = new Integer[10];      ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(1, 10);
 * for (int i = 1; i <= 10; i ++)                 for (int i = 1; i <= 10; i ++)
 *     integerArray[i - 1] = i;                       integerArray.set(i, i);
 * </pre>
 * 
 * </li>
 * 
 * <li>Conformance to the Collections framework <br/>
 * The class implements the {@code Collection} interface and thus
 * behaves like all Collections.</li>
 * <br />
 * <li>Full support for generics:<br/>
 * The Java arrays do not support generic classes. For example, you cannot
 * create an array of String sequences:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * Sequence<String>[] stringSequenceArray = new Sequence<String>[10];
 *
 * // PERMITTED!
 * ArraySequence<Sequence<String>> stringSequenceArray = new ArraySequence<Sequence<String>>(10);}
 * </pre>
 * 
 * </li>
 * <li>
 * Easy to create:<br />
 * 
 * <pre>
 * {@literal
 * // creating an ArraySequence with three Strings
 * ArraySequence<String> stringArray = new ArraySequence<String>("cool", "ArraySequence", "class!");
 *
 * // creating an ArraySequence with three Strings starting at index 1
 * ArraySequence<String> stringArray = new ArraySequence<String>(1, "jlib", "is", "cool!");}
 * </pre>
 * 
 * To create Arrays of Integers. The Java
 * autoboxing feature forbids the following ArraySequence creation:
 * 
 * <pre>
 * {@literal
 * // FORBIDDEN!
 * ArraySequence<Integer> integerArray = new ArraySequence<Integer>(1, 2, 3, 4, 5, 6);}
 * </pre>
 * 
 * The compiler claims:
 * 
 * <pre>
 * {@literal The constructor ArraySequence<Integer>(Integer[]) is ambiguous}
 * </pre>
 * 
 * It doesn't know whether the first parameter is meant to be the minimum index of
 * the ArraySequence or the first Element of the sequence. You could pass a Java array of
 * Integers instead which is the equivalent to the sequence form for the argument
 * {@code Integer... elements} but this class provides an easier way: the
 * factory methods {@link #createIntegerArray(Integer[])} or
 * {@link #createIntegerArrayFrom(int, Integer[])}. The latter form takes the
 * minimum index as first argument.
 * 
 * <pre>
 * // possible but not handy
 * ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(new Integer[] {1, 2, 3, 4, 5, 6});
 * ArraySequence&lt;Integer&gt; integerArray = new ArraySequence&lt;Integer&gt;(1, new Integer[] {1, 2, 3, 4, 5, 6});
 *
 * // easier to use (needs the static import of the factory method(s))
 * ArraySequence&lt;Integer&gt; integerArray = createIntegerArray(1, 2, 3, 4, 5);
 * ArraySequence&lt;Integer&gt; integerArray = createIntegerArrayFrom(1, 1, 2, 3, 4, 5);
 * </pre>
 * 
 * </li>
 * </ul>
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 *        
 * @author Igor Akkerman
 */
// @formatter:on

// TODO: allow negative indices

public class ArraySequence<Element>
extends AbstractDelegatingIndexSequence<Element>
implements Cloneable {

    class SequenceFillState {

        private SequenceFillState addElementFillState;

        private SequenceFillState removeElementFillState;

        /** delegate {@link ReplaceIndexSequence} */
        private final ReplaceIndexSequence<Element> delegateSequence;

        ReplaceIndexSequence<Element> getDelegateSequence() {
            return delegateSequence;
        }

        SequenceFillState() {
            super();
        }

        
        SequenceFillState getAddElementFillState() {
            return addElementFillState;
        }

        
        void setAddElementFillState(SequenceFillState addElementFillState) {
            this.addElementFillState = addElementFillState;
        }

        
        SequenceFillState getRemoveElementFillState() {
            return removeElementFillState;
        }

        
        void setRemoveElementFillState(SequenceFillState removeElementFillState) {
            this.removeElementFillState = removeElementFillState;
        }
    }

    private SequenceFillState sequenceFillState;

    @Override
    protected IndexSequence<Element> getDelegateSequence() {
        return sequenceFillState.getDelegateSequence();
    }

}
