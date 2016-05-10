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

package org.jlib.reflect.programelement.reflection;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class ReflectionStaticLanguageItemSupplierTest {

    // TODO: add negative tests (method not found, wrong arguments etc.)

    private static final Class<?> CLASS = ReflectionTestMethods.class;

    private final ReflectionTestMethods service = mock(ReflectionTestMethods.class);

    @Test
    public void invokeStaticVoidEmpty()
        throws Exception {
        // only testing for no thrown exception
        final Method method = CLASS.getMethod("staticVoidEmpty");
        ReflectionLanguageElementHelper.INSTANCE.invokeStaticMethod(method);
    }

    @Test
    public void invokeStaticVoidString()
        throws Exception {
        // only testing for no thrown exception
        final Method method = CLASS.getMethod("staticVoidString", String.class);
        ReflectionLanguageElementHelper.INSTANCE.invokeStaticMethod(method, "bla");
    }

    @Test
    public void invokeStaticIntEmpty()
        throws Exception {
        final Method method = CLASS.getMethod("staticIntEmpty");
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeStaticMethod(method)).isEqualTo(42);
    }

    @Test
    public void invokeStaticStringInt()
        throws Exception {
        final Method method = CLASS.getMethod("staticStringInt", int.class);
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeStaticMethod(method, 42)).isEqualTo("42");
    }

    @Test
    public void invokeStaticStringString()
        throws Exception {
        final Method method = CLASS.getMethod("staticStringString", String.class);
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeStaticMethod(method, "HalliHallo!")).isEqualTo("HALLIHALLO!");
    }

    @Test
    public void invokeStaticStringStringOverload()
        throws Exception {
        final Method method = CLASS.getMethod("staticStringString", String.class, String.class);
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeStaticMethod(method, "bla ", "blub")).isEqualTo("bla blub");
    }

    @Test
    public void invokeVoidEmpty()
        throws Exception {
        final Method method = CLASS.getMethod("voidEmpty");
        ReflectionLanguageElementHelper.INSTANCE.invokeInstanceMethod(service, method);
        verify(service).voidEmpty();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeVoidString()
        throws Exception {
        final Method method = CLASS.getMethod("voidString", String.class);
        ReflectionLanguageElementHelper.INSTANCE.invokeInstanceMethod(service, method, "boo");
        verify(service).voidString("boo");
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeIntEmpty()
        throws Exception {
        final Method method = CLASS.getMethod("intEmpty");
        when(service.intEmpty()).thenReturn(4711);
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeInstanceMethod(service, method)).isEqualTo(4711);
        verify(service).intEmpty();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringInt()
        throws Exception {
        final Method method = CLASS.getMethod("stringInt", int.class);
        when(service.stringInt(4711)).thenReturn("boo");
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeInstanceMethod(service, method, 4711)).isEqualTo("boo");
        verify(service).stringInt(4711);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringString()
        throws Exception {
        final Method method = CLASS.getMethod("stringString", String.class);
        when(service.stringString("boofar")).thenReturn("raboof");
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeInstanceMethod(service, method, "boofar")).isEqualTo("raboof");
        verify(service).stringString("boofar");
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringStringOverload()
        throws Exception {
        final Method method = CLASS.getMethod("stringString", String.class, String.class);
        when(service.stringString("boofar", "abracadabra")).thenReturn("raboof");
        assertThat(ReflectionLanguageElementHelper.INSTANCE.invokeInstanceMethod(service, method, "boofar", "abracadabra")).isEqualTo(
            "raboof");
        verify(service).stringString("boofar", "abracadabra");
        verifyNoMoreInteractions(service);
    }
}
