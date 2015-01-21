package org.jlib.text.transformer;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test case for LeftAligningStringTransformer.
 *
 * @author Igor Akkerman
 */
@RunWith(Theories.class)
public class LeftAligningStringTransformerTest {

    private static class Data {

        public final String id;

        public final int finalStringLength;

        public final String inputString;

        public final String expectedTransformedString;

        public Data(final String id, final int finalStringLength, final String inputString,
                    final String expectedTransformedString) {
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
    public void testTransform(@SuppressWarnings("hiding") final Data data) {
        final StringTransformer stringTransformer = new LeftAligningStringTransformer(data.finalStringLength, 'x');
        final StringBuilder stringBuilder = new StringBuilder(data.inputString);
        stringTransformer.transform(stringBuilder);
        assertThat(stringBuilder.toString()).isEqualTo(data.expectedTransformedString).describedAs(data.toString());
    }
}
