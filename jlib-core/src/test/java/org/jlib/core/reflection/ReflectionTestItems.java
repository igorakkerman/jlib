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

public final class ReflectionTestItems {

    protected interface I1 {}

    @SuppressWarnings("serial")
    static class C1
    implements I1, Serializable {}

    @SuppressWarnings("serial")
    static class C2
    extends C1 {}

    static class C3 {}


    static final C1 c1 = new C1();
    static final C2 c2 = new C2();
    static final C3 c3 = new C3();
}
