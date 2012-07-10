package org.jlib.core.valueholder;

public abstract class OptionalValueOperator<Value> {

    /**
     * {@link ValueHolder} operating on the held Value using an
     * {@link OptionalValueOperator}.
     * 
     * @param <Value>
     *        type of the held value
     * 
     * @author Igor Akkerman
     */
    private static interface OperatedValueHolder<Value>
    extends ValueHolder<Value> {

        /**
         * Operates on the held Value using the specified
         * {@link OptionalValueOperator}.
         * 
         * @param operator
         *        {@link OptionalValueOperator} operating on the held Value
         * 
         * @author Igor Akkerman
         */
        public void operate(final OptionalValueOperator<Value> operator);
    }

    /**
     * {@link UninitializedValueHolder} calling the
     * {@link OptionalValueOperator#operateOnUnsetValue()} method from
     * {@link #operate(OptionalValueOperator)}.
     * 
     * @param <Value>
     *        type of the held value
     * 
     * @author Igor Akkerman
     */
    private static abstract class UninitializedOperatedValueHolder<Value>
    extends UninitializedValueHolder<Value>
    implements OperatedValueHolder<Value> {

        /**
         * Creates a new {@link UninitializedOperatedValueHolder}.
         */
        public UninitializedOperatedValueHolder() {
            super();
        }

        @Override
        public void operate(final OptionalValueOperator<Value> operator) {
            operator.operateOnUnsetValue();
        }
    }

    /**
     * {@link UninitializedValueHolder} operating on the held value using
     * {@link #operate(OptionalValueOperator)}.
     * 
     * @param <Value>
     *        type of the held value
     * 
     * @author Igor Akkerman
     */
    private static class InitializedOperatedValueHolder<Value>
    extends InitializedValueHolder<Value>
    implements OperatedValueHolder<Value> {

        /**
         * Creates a new {@link InitializedOperatedValueHolder}.
         * 
         * @param initialValue
         *        initial Value
         */
        public InitializedOperatedValueHolder(final Value initialValue) {
            super(initialValue);
        }

        @Override
        public void operate(final OptionalValueOperator<Value> operator) {
            operator.operate(get());
        }
    }

    public abstract void operate(Value value);

    public abstract void operateOnUnsetValue();

    public static void main(final String[] args) {
        final OptionalValueOperator<Integer> print = new OptionalValueOperator<Integer>() {

            @Override
            public void operate(final Integer value) {
                System.out.println(value);
            }

            @Override
            public void operateOnUnsetValue() {
                System.out.println("no value set");
            }
        };

        final InitializedOperatedValueHolder<Integer> valueHolder42 = new InitializedOperatedValueHolder<Integer>(42);

        valueHolder42.operate(print);

//        final UninitializedOperatedValueHolder<Integer> valueHolderUnset =
//            new UninitializedOperatedValueHolder<Integer>() {
//
//                @Override
//                public void set(final Integer value) {
//                    myInteger = value;
//                }
//            };

//        valueHolderUnset.operate(print);

    }
}
