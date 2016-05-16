/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.value.formatter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MessageFormatNamedValueFormatterTest {

    @Test
    public void emptyTemplateShouldProduceEmptyString()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder();
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEmpty();
    }

    @Test
    public void namePlaceholderShouldOnlyProduceName()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder();
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("++ {0} **");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEqualTo("++ value **");
    }

    @Test
    public void valuePlaceholderShouldProduceNameValue()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder();
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("... {1}");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEqualTo("... Hallo");
    }

    @Test
    public void nameValuePlaceholderShouldProduceNameValue()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder();
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("{0}: {1}");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEqualTo("value: Hallo");
    }

    @Test
    public void textNameValuePlaceholderShouldProduceTextNameValue()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder("This is a text ... ");
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("{0}: {1}");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEqualTo("This is a text ... value: Hallo");
    }

    @Test
    public void nameValueExtraPlaceholderShouldProduceNameValueAndExtraString()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder();
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("{0}: {1} {2}");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEqualTo("value: Hallo {2}");
    }

    @Test
    public void wrongPlaceholderShouldProduceWrongString()
        throws Exception {
        // given
        final StringBuilder builder = new StringBuilder();
        final NamedValueFormatter<Object> formatter = new MessageFormatNamedValueFormatter("%s: %s {0}");

        // when
        formatter.append(builder, "value", "Hallo");

        // then
        Assertions.assertThat(builder.toString()).isEqualTo("%s: %s value");
    }
}
