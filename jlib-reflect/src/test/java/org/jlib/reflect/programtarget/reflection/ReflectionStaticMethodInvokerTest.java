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

package org.jlib.reflect.programtarget.reflection;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class ReflectionStaticMethodInvokerTest {

    // TODO: add negative tests (method not found, wrong arguments etc.)

    private static final Class<?> CLASS = ReflectionTestMethods.class;

    private final ReflectionTestMethods service = mock(ReflectionTestMethods.class);

    @Test
    public void invokeStaticVoidEmpty()
    throws Exception {
        // only testing for no thrown exception
        final Method method = CLASS.getMethod("staticVoidEmpty");
        new ReflectionStaticMethodInvoker(method).invoke();
    }

    @Test
    public void invokeStaticVoidString()
    throws Exception {
        // only testing for no thrown exception
        final Method method = CLASS.getMethod("staticVoidString", String.class);
        new ReflectionStaticMethodInvoker(method).invoke("bla");
    }

    @Test
    public void invokeStaticIntEmpty()
    throws Exception {
        final Method method = CLASS.getMethod("staticIntEmpty");
        assertThat(new ReflectionStaticMethodInvoker(method).invoke()).isEqualTo(42);
    }

    @Test
    public void invokeStaticStringInt()
    throws Exception {
        final Method method = CLASS.getMethod("staticStringInt", int.class);
        assertThat(new ReflectionStaticMethodInvoker(method).invoke(42)).isEqualTo("42");
    }

    @Test
    public void invokeStaticStringString()
    throws Exception {
        final Method method = CLASS.getMethod("staticStringString", String.class);
        assertThat(new ReflectionStaticMethodInvoker(method).invoke("HalliHallo!")).isEqualTo("HALLIHALLO!");
    }

    @Test
    public void invokeStaticStringStringOverload()
    throws Exception {
        final Method method = CLASS.getMethod("staticStringString", String.class, String.class);
        assertThat(new ReflectionStaticMethodInvoker(method).invoke("bla ", "blub")).isEqualTo("bla blub");
    }

    @Test
    public void invokeVoidEmpty()
    throws Exception {
        final Method method = CLASS.getMethod("voidEmpty");
        new ReflectionInstanceMethodInvoker(method, service).invoke();
        verify(service).voidEmpty();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeVoidString()
    throws Exception {
        final Method method = CLASS.getMethod("voidString", String.class);
        new ReflectionInstanceMethodInvoker(method, service).invoke("boo");
        verify(service).voidString("boo");
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeIntEmpty()
    throws Exception {
        final Method method = CLASS.getMethod("intEmpty");
        when(service.intEmpty()).thenReturn(4711);
        assertThat(new ReflectionInstanceMethodInvoker(method, service).invoke()).isEqualTo(4711);
        verify(service).intEmpty();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringInt()
    throws Exception {
        final Method method = CLASS.getMethod("stringInt", int.class);
        when(service.stringInt(4711)).thenReturn("boo");
        assertThat(new ReflectionInstanceMethodInvoker(method, service).invoke(4711)).isEqualTo("boo");
        verify(service).stringInt(4711);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringString()
    throws Exception {
        final Method method = CLASS.getMethod("stringString", String.class);
        when(service.stringString("boofar")).thenReturn("raboof");
        assertThat(new ReflectionInstanceMethodInvoker(method, service).invoke("boofar")).isEqualTo("raboof");
        verify(service).stringString("boofar");
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringStringOverload()
    throws Exception {
        final Method method = CLASS.getMethod("stringString", String.class, String.class);
        when(service.stringString("boofar", "abracadabra")).thenReturn("raboof");
        assertThat(new ReflectionInstanceMethodInvoker(method, service).invoke("boofar", "abracadabra")).isEqualTo("raboof");
        verify(service).stringString("boofar", "abracadabra");
        verifyNoMoreInteractions(service);
    }
}
