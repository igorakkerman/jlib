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

package org.jlib.core.reflection.reflector;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ReflectorTest {

    @Test
    public void staticRun()
    throws Exception {
        assertThat(Reflectors.typed(Number.class)
                             .named("java.lang.Integer")
                             .ensureType(Integer.class)
                             .staticMethod("valueOf")
                             .appliedTo(int.class)
                             .ensureReturnType(Integer.class)
                             .invokedOn(42)
                             .get())
        .isEqualTo(Integer.valueOf(42));
    }
}
