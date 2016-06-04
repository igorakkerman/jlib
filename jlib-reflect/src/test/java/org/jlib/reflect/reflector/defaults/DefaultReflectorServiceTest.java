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
import org.jlib.reflect.languageelement.ProgramElementException;
import org.jlib.reflect.reflector.ReflectorService;
import org.junit.Test;

public class DefaultReflectorServiceTest {

    private final ReflectorService service = Reflectors.SERVICE;

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void staticRun()
        throws Exception {

        final Number value = service
            .useClass("java.lang.Integer")                  // TypedClass<?>
            .withType(Number.class)                         // TypedClass<Number>
            .withSupertypes(
                Integer.class)                  // TypedClass<Number> (verify actual supertype of instantiated class,
            // keep static type)
            .staticMethod("valueOf")                     // MethodOverload<?>
            .withParameterTypes(int.class)                  // TypedMethod1<Method, ?, int>
            .withReturnType(Number.class)                   // TypedMethod1<Method, Number, int>
            .invoke(42)                                     // MethodReturn<Number>
            .returning(
                Integer.class)                       // MethodReturn<Number> (verify supertype of returned value,
            // keep static type)
            .getReturned();                                         // Number

        assertThat(value).isEqualTo(Integer.valueOf(42));
    }

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void nonstaticRun()
        throws Exception {
        final Number value = service
            .useClass("java.lang.Integer")                  // TypedClass<?>
            .withType(Number.class)                         // TypedClass<Number>
            .withSupertypes(Integer.class)                  // TypedClass<Number>
            .constructor()                               // ConstructorOverload<Number>
            .withParameterTypes(int.class)                  // TypedMethod1<Constructor, Number, int>
            .invoke(42)                                     // MethodReturn<Number>
            .returning(Integer.class)                       // MethodReturn<Number>
            .method("compareTo")                         // MethodOverload<?>
            .withParameterTypes(Integer.class)              // TypedMethod1<Method, int, Integer>
            .withReturnType(int.class)                      // TypedMethod1<Method, int, Object>
            .invoke(3)                                      // MethodReturn<int>
            .returning(Integer.class)                       // MethodReturn<int>
            .getReturned();                                         // int

        assertThat(value).isEqualTo(Integer.valueOf(1));
    }

    @Test
    public void instance()
        throws Exception {
        final CharSequence value = service
            .useClass("java.lang.String")
            .withType(CharSequence.class)
            .instance("Hello jlib!");

        assertThat(value).isEqualTo("Hello jlib!");
    }

    @Test
    public void instancePrimitiveArray()
        throws Exception {
        final CharSequence value = service
            .useClass("java.lang.String")
            .withType(CharSequence.class)
            .instance(new char[]{'a', 'b', 'c'});

        assertThat(value).isEqualTo("abc");
    }

    @Test(expected = ProgramElementException.class)
    public void instanceWrongConstructor()
        throws Exception {
        final Number value = service
            .useClass("java.lang.Integer")
            .withType(Number.class)
            .instance();
    }
}

