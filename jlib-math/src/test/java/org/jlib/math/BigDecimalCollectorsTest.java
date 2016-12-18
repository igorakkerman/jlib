/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2016 Igor Akkerman
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

package org.jlib.math;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.math.BigDecimalCollectors.summing;
import org.junit.Test;

public class BigDecimalCollectorsTest {

    @Test
    public void summingEmptyStream() {
        assertThat(Stream.<BigDecimal> empty().collect(summing()))
            .isEqualTo(ZERO);
    }

    @Test
    public void summingSingleItem() {
        assertThat(Stream.of(ONE).collect(summing()))
            .isEqualTo(ONE);
    }

    @Test
    public void summingOneToTen() {
        assertThat(IntStream.rangeClosed(1, 10).mapToObj(BigDecimal::valueOf).collect(summing()))
            .isEqualTo(BigDecimal.valueOf(55));
    }

    @Test
    public void summingx() {
        assertThat(Stream.of(BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3))
                         .collect(summing()))
            .isEqualTo(BigDecimal.valueOf(6));
    }
}
