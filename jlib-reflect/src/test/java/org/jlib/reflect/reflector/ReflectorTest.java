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

package org.jlib.reflect.reflector;

import org.assertj.core.api.Assertions;
import static org.jlib.reflect.reflector.Reflectors.useClass;
import static org.jlib.reflect.validator.Validators.instanceOf;
import static org.jlib.reflect.validator.Validators.isEqualTo;
import org.junit.Test;

public class ReflectorTest {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void staticRun()
    throws Exception {
        final Number value = useClass("java.lang.Integer")                   // UntypedClassReflector
                             .withType(Number.class)                         // TypedClassReflector
                             .assertSubtypeOf(Integer.class)                 // TypedClassReflector
                             .useStaticMethod("valueOf")                     // UntypedMethodReflector
                             .withReturnType(Number.class)                   // MethodOverloadReflector
                             .withArgumentTypes(int.class)                   // Nethod1Reflector
                             .invoke(42)                                     // MethodReturnValueReflector
                             .assertReturned(instanceOf(Integer.class))      // MethodReturnValueReflector
                             .assertReturned(isEqualTo(Integer.valueOf(42))) // MethodReturnValueReflector
                             .get();                                         // ReturnValue

        Assertions.assertThat(value).isEqualTo(Integer.valueOf(42));
    }
}

