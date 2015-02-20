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

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.core.reflection.ReflectionTestItems.c1;
import org.junit.Test;

public class ReflectionServiceInstanceOfTest
extends ReflectionServiceTestBase {

    @Test
    public void instanceOfClassObjectWorks()
    throws Exception {
        assertThat(service.getInstanceOf(C1.class)).hasSameClassAs(c1);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void instanceOfClassNameWorks()
    throws Exception {
        assertThat((Object) service.getInstanceOf(C1.class.getName())).hasSameClassAs(c1);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void instanceOfClassNameWithEnsuredSameTypeWorks()
    throws Exception {
        assertThat((Object) service.getInstanceOf(C1.class.getName(), C1.class)).hasSameClassAs(c1);
    }
}
