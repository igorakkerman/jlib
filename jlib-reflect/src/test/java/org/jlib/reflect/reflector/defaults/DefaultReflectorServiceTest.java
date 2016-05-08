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

import static org.assertj.core.api.Assertions.assertThat;
import org.jlib.reflect.reflector.ReflectorService;
import org.junit.Test;

public class DefaultReflectorServiceTest {

    private final ReflectorService service = DefaultReflectorService.getInstance();

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void staticRun()
    throws Exception {

        final Number value = service
                             .useClass("java.lang.Integer")                  // TypedClass
                             .withType(Number.class)                         // TypedClass
                             .withSupertypes(Integer.class)                  // TypedClass
                             .useStaticMethod("valueOf")                     // Overload
                             .withParameterTypes(int.class)                  // TypedMethod1
                             .withReturnType(Number.class)                   // TypedMethod1
                             .invoke(42)                                     // MethodReturn
                             .returning(Integer.class)                       // MethodReturn
                             .get();                                         // Number

        assertThat(value).isEqualTo(Integer.valueOf(42));
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

        assertThat(value).isEqualTo(Integer.valueOf(1));
    }
}

