package org.jlib.core.string.transform;

import static org.junit.Assert.*;

import static org.hamcrest.core.IsEqual.equalTo;

import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test case for LeftAligningStringTransformer.
 * 
 * @author Igor Akkerman
 */
public class LeftAligningStringTransformerTest {

    @Test
    public void testTransformEmptyEmpty() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(0, 'x');
        StringBuilder stringBuilder = new StringBuilder(0);
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("")));
    }

    @Test
    public void testTransformEmptyEven() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(10, 'x');
        StringBuilder stringBuilder = new StringBuilder(0);
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("xxxxxxxxxx")));
    }

    @Test
    public void testTransformEmptyOdd() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(9, 'x');
        StringBuilder stringBuilder = new StringBuilder(0);
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("xxxxxxxxx")));
    }

    @Test
    public void testTransformEvenLessEven() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(4, 'x');
        StringBuilder stringBuilder = new StringBuilder("abcdef");
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("abcdef")));
    }

    @Test
    public void testTransformEvenLessOdd() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(3, 'x');
        StringBuilder stringBuilder = new StringBuilder("abcdef");
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("abcdef")));
    }

    @Test
    public void testTransformOddLessEven() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(4, 'x');
        StringBuilder stringBuilder = new StringBuilder("abcdefg");
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("abcdefg")));
    }

    @Test
    public void testTransformOddLessOdd() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(3, 'x');
        StringBuilder stringBuilder = new StringBuilder("abcdefg");
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("abcdefg")));
    }

    @Test
    public void testTransformEvenMoreEven() {
        StringTransformer stringTransformer = new LeftAligningStringTransformer(10, 'x');
        StringBuilder stringBuilder = new StringBuilder("abcdef");
        stringTransformer.transform(stringBuilder);
        Assert.assertThat(stringBuilder.toString(), is(equalTo("")));
    }

}
