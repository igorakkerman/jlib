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

import java.io.Serializable;

import org.jlib.core.classinstance.WrongTypedInstanceException;

import static org.jlib.core.reflection.ReflectionUtility.ensureSubtype;
import org.junit.Test;

public class ReflectionServiceEnsureSubtypeTest
extends ReflectionServiceTestBase {

    @Test
    public void c1ShouldBeSubtypeOfI1Serializable()
    throws Exception {
        ensureSubtype(C1.class, I1.class, Serializable.class);
    }

    @Test
    public void c2ShouldBeSubtypeOfC1I1Serializable()
    throws Exception {
        ensureSubtype(C2.class, C1.class, I1.class, Serializable.class);
    }

    @Test(expected = WrongTypedInstanceException.class)
    public void c3ShouldNotBeSubtypeOfC1()
    throws Exception {
        ensureSubtype(C3.class, C1.class);
    }

    @Test(expected = WrongTypedInstanceException.class)
    public void c3ShouldNotBeSubtypeOfSerializable()
    throws Exception {
        ensureSubtype(C3.class, Serializable.class);
    }
}
