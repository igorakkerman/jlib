/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2018 Igor Akkerman
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

package org.jlib.text;

import lombok.Setter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.jlib.text.Text.splitInto;
import org.junit.Test;

public class TextSplitIntoTest {

    @Test
    public void twoPartsUsingSetter() {

        // given
        @Setter
        class Split {
            String s1;
            String s2;
        }
        final Split split = new Split();

        // when
        splitInto("a-b", "-", split::setS1, split::setS2);

        // then
        assertThat(split.s1).isEqualTo("a");
        assertThat(split.s2).isEqualTo("b");
    }

    @Test
    public void twoPartsPrivateAccess() {

        // given
        class Split {
            String s1;
            String s2;
        }
        final Split split = new Split();

        // when
        splitInto("a-b", "-", s -> split.s1 = s, s-> split.s2 = s);

        // then
        assertThat(split.s1).isEqualTo("a");
        assertThat(split.s2).isEqualTo("b");
    }

    @Test
    public void emptyString() {

        // given
        class Single {
            String s;
        }
        final Single single = new Single();

        // when
        splitInto("", "-", s -> single.s = s);

        // then
        assertThat(single.s).isEmpty();
    }

    @Test
    public void tooFewConsumers() {
        assertThatThrownBy(() -> splitInto("a-b", "-", s -> {}))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Too few elementConsumers. #elementConsumers=1. #elements=2.");
    }

    @Test
    public void tooManyConsumers() {
        assertThatThrownBy(() -> splitInto("a", "-", s -> {}, s-> {}))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Too many elementConsumers. #elementConsumers=2. #elements=1.");
    }
}
