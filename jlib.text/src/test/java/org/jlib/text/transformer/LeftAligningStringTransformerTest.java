package org.jlib.text.transformer;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Test case for LeftAligningStringTransformer.
 * 
 * @author Igor Akkerman
 */
@RunWith(Theories.class)
public class LeftAligningStringTransformerTest {

    private static class Data {

        public String id;

        public int finalStringLength;

        public String inputString;

        public String expectedTransformedString;

        public Data(String id, int finalStringLength, String inputString, String expectedTransformedString) {
            super();
            this.id = id;
            this.finalStringLength = finalStringLength;
            this.inputString = inputString;
            this.expectedTransformedString = expectedTransformedString;
        }

        @Override
        public String toString() {
            return "(" + id + ": " + finalStringLength + ", \"" + inputString + "\", \"" + expectedTransformedString +
                   "\")";
        }
    }

    @DataPoints
    public static Data[] data = { new Data("empty, zero", 0, "", ""), new Data("empty, even", 10, "", "xxxxxxxxxx"),
                                 new Data("empty, odd", 9, "", "xxxxxxxxx"),
                                 new Data("even, less, even", 4, "abcdef", "abcdef"),
                                 new Data("even, less, odd", 3, "abcdef", "abcdef"),
                                 new Data("odd, less, even", 4, "abcdefg", "abcdefg"),
                                 new Data("odd, less, odd", 3, "abcdefg", "abcdefg"),
                                 new Data("even, more, even", 10, "abcdef", "abcdefxxxx"), };

    @Theory
    public void testTransform(@SuppressWarnings("hiding") Data data) {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(data.finalStringLength, 'x');
        StringBuilder stringBuilder = new StringBuilder(data.inputString);
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(data.toString(), stringBuilder.toString(), is(equalTo(data.expectedTransformedString)));
    }
}
