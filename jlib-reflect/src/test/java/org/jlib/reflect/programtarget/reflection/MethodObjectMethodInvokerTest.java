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

public class MethodObjectMethodInvokerTest {

    // TODO: add negative tests (method not found, wrong arguments etc.

    private static final Class<?> CLASS = TestMethods.class;

    private final TestMethods service = mock(TestMethods.class);

    @Test
    public void invokeStaticVoidEmpty()
    throws Exception {
        // only testing for no thrown exception
        final Method method = CLASS.getMethod("staticVoidEmpty");
        new MethodObjectMethodInvoker(method).invokeStatic();
    }

    @Test
    public void invokeStaticVoidString()
    throws Exception {
        // only testing for no thrown exception
        final Method method = CLASS.getMethod("staticVoidString", String.class);
        new MethodObjectMethodInvoker(method).invokeStatic("bla");
    }

    @Test
    public void invokeStaticIntEmpty()
    throws Exception {
        final Method method = CLASS.getMethod("staticIntEmpty");
        assertThat(new MethodObjectMethodInvoker(method).invokeStatic()).isEqualTo(42);
    }

    @Test
    public void invokeStaticStringInt()
    throws Exception {
        final Method method = CLASS.getMethod("staticStringInt", int.class);
        assertThat(new MethodObjectMethodInvoker(method).invokeStatic(42)).isEqualTo("42");
    }

    @Test
    public void invokeStaticStringString()
    throws Exception {
        final Method method = CLASS.getMethod("staticStringString", String.class);
        assertThat(new MethodObjectMethodInvoker(method).invokeStatic("HalliHallo!")).isEqualTo("HALLIHALLO!");
    }

    @Test
    public void invokeStaticStringStringOverload()
    throws Exception {
        final Method method = CLASS.getMethod("staticStringString", String.class, String.class);
        assertThat(new MethodObjectMethodInvoker(method).invokeStatic("bla ", "blub")).isEqualTo("bla blub");
    }

    @Test
    public void invokeVoidEmpty()
    throws Exception {
        final Method method = CLASS.getMethod("voidEmpty");
        new MethodObjectMethodInvoker(method).invoke(service);
        verify(service).voidEmpty();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeVoidString()
    throws Exception {
        final Method method = CLASS.getMethod("voidString", String.class);
        new MethodObjectMethodInvoker(method).invoke(service, "boo");
        verify(service).voidString("boo");
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeIntEmpty()
    throws Exception {
        final Method method = CLASS.getMethod("intEmpty");
        when(service.intEmpty()).thenReturn(4711);
        assertThat(new MethodObjectMethodInvoker(method).invoke(service)).isEqualTo(4711);
        verify(service).intEmpty();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringInt()
    throws Exception {
        final Method method = CLASS.getMethod("stringInt", int.class);
        when(service.stringInt(4711)).thenReturn("boo");
        assertThat(new MethodObjectMethodInvoker(method).invoke(service, 4711)).isEqualTo("boo");
        verify(service).stringInt(4711);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringString()
    throws Exception {
        final Method method = CLASS.getMethod("stringString", String.class);
        when(service.stringString("boofar")).thenReturn("raboof");
        assertThat(new MethodObjectMethodInvoker(method).invoke(service, "boofar")).isEqualTo("raboof");
        verify(service).stringString("boofar");
        verifyNoMoreInteractions(service);
    }

    @Test
    public void invokeStringStringOverload()
    throws Exception {
        final Method method = CLASS.getMethod("stringString", String.class, String.class);
        when(service.stringString("boofar", "abracadabra")).thenReturn("raboof");
        assertThat(new MethodObjectMethodInvoker(method).invoke(service, "boofar", "abracadabra")).isEqualTo("raboof");
        verify(service).stringString("boofar", "abracadabra");
        verifyNoMoreInteractions(service);
    }
}
