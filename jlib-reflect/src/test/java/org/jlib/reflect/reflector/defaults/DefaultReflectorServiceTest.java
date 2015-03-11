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

package org.jlib.reflect.reflector.defaults;

import org.assertj.core.api.Assertions;
import org.jlib.reflect.reflector.ReflectorService;
import org.junit.Test;

public class DefaultReflectorServiceTest {

    private final ReflectorService service = new DefaultReflectorService();

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void staticRun()
    throws Exception {

        final Number value = service
                             .useClass("java.lang.Integer")                  // UntypedClassReflector
                             .withType(Number.class)                         // TypedClassReflector
                             .withSupertypes(Integer.class)                  // TypedClassReflector
                             .useStaticMethod("valueOf")                     // UntypedMethodReflector
                             .withParameterTypes(int.class)                  // Nethod1Reflector
                             .withReturnType(Number.class)                   // MethodOverloadReflector
                             .invoke(42)                                     // MethodReturnValueReflector
                             .returning(Integer.class)                       // MethodReturnValueReflector
                             .get();                                         // ReturnValue

        Assertions.assertThat(value).isEqualTo(Integer.valueOf(42));
    }

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void nonstaticRun()
    throws Exception {
        final Number value = service
                             .useClass("java.lang.Integer")                  // UntypedClassReflector
                             .withType(Number.class)                         // TypedClassReflector
                             .withSupertypes(Integer.class)                  // TypedClassReflector
                             .useConstructor()                               // MethodOverloadReflector
                             .withParameterTypes(int.class)                  // Nethod1Reflector
                             .invoke(42)                                     // MethodReturn
                             .returning(Integer.class)                       // MethodReturnValueReflector
                             .useMethod("compareTo")                         // UntypedMethodReflector
                             .withReturnType(int.class)                      // MethodOverloadReflector
                             .withParameterTypes(Integer.class)              // Nethod1Reflector
                             .invoke(3)                                      // MethodReturnValueReflector
                             .returning(Integer.class)                       // MethodReturnValueReflector
                             .get();                                         // ReturnValue

        Assertions.assertThat(value).isEqualTo(Integer.valueOf(1));
    }
}

