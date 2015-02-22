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

package org.jlib.core.reflection;

import org.jlib.core.reflection.ReflectionTestItems.C1;
import org.jlib.core.reflection.ReflectionTestItems.C3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.core.array.ArrayUtility.asArray;
import static org.jlib.core.reflection.ReflectionTestItems.c1;
import static org.jlib.core.reflection.ReflectionTestItems.c3;
import org.junit.Test;

public class ReflectionServiceTypesOfTest
extends ReflectionServiceTestBase {

    @Test
    public void typesInEmptyArrayShouldBeEmpty()
    throws Exception {
        assertThat(service.typesOf()).isEmpty();
    }

    @Test
    public void typeOfSinlgeClassShouldBeRecognized()
    throws Exception {
        assertThat(service.typesOf(c1)).isEqualTo(asArray(C1.class));
    }

    @Test
    public void typesOfTwoClassesShouldBeRecognized()
    throws Exception {
        assertThat(service.typesOf(c3, c1)).isEqualTo(asArray(C3.class, C1.class));
    }
}
