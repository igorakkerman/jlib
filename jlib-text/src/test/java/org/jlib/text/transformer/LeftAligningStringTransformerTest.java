package org.jlib.text.transformer;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * Test case for {@link LeftAligningStringTransformer}.
 *
 * @author Igor Akkerman
 */
public class LeftAligningStringTransformerTest {

    @Test
    public void emptyStringToZeroLengthString() {
        assertThat(new LeftAligningStringTransformer(0, 'x').transform("")).isEmpty();
    }

    @Test
    public void emptyStringToEvenLengthString() {
        assertThat(new LeftAligningStringTransformer(10, 'x').transform("")).isEqualTo("xxxxxxxxxx");
    }

    @Test
    public void emptyStringToOddLengthString() {
        assertThat(new LeftAligningStringTransformer(9, 'x').transform("")).isEqualTo("xxxxxxxxx");
    }

    @Test
    public void evenLengthStringToShorterEvenLengthString() {
        assertThat(new LeftAligningStringTransformer(4, 'x').transform("abcdef")).isEqualTo("abcdef");
    }

    @Test
    public void evenLengthStringToShorterOddLengthString() {
        assertThat(new LeftAligningStringTransformer(3, 'x').transform("abcdef")).isEqualTo("abcdef");
    }

    @Test
    public void oddLengthStringToShorterEvenLengthString() {
        assertThat(new LeftAligningStringTransformer(4, 'x').transform("abcde")).isEqualTo("abcde");
    }

    @Test
    public void oddLengthStringToShorterOddLengthString() {
        assertThat(new LeftAligningStringTransformer(3, 'x').transform("abcde")).isEqualTo("abcde");
    }

    @Test
    public void evenLengthStringToLongerEvenLengthString() {
        assertThat(new LeftAligningStringTransformer(10, 'x').transform("abcdef")).isEqualTo("abcdefxxxx");
    }

    @Test
    public void evenLengthStringToLongerOddLengthString() {
        assertThat(new LeftAligningStringTransformer(9, 'x').transform("abcdef")).isEqualTo("abcdefxxx");
    }

    @Test
    public void oddLengthStringToLongerEvenLengthString() {
        assertThat(new LeftAligningStringTransformer(10, 'x').transform("abcde")).isEqualTo("abcdexxxxx");
    }

    @Test
    public void oddLengthStringToLongerOddLengthString() {
        assertThat(new LeftAligningStringTransformer(9, 'x').transform("abcde")).isEqualTo("abcdexxxx");
    }
}
