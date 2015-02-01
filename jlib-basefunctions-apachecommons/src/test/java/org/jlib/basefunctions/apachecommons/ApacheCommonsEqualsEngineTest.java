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

package org.jlib.basefunctions.apachecommons;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

// Test with class A and B for
public class ApacheCommonsEqualsEngineTest {

    private static class O {

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(final Object obj) {
            return super.equals(obj);
        }
    }

    // root level of inheritance
    private static class A
    extends O {

        final int ai;
        final String as;

        public boolean eq(final Object obj) {
            return super.equals(obj);
        }

        public A(final int ai, final String as) {
            this.ai = ai;
            this.as = as;
        }

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(final Object otherObject) {
            final A otherA = (A) otherObject;
            // only add addSuper if super class actually checks fields, not only this for identity like Object
            return new ApacheCommonsEqualsEngine<>(otherA).add(ai, otherA.ai)
                                                          .add(as, otherA.as)
                                                          .areEqual();
        }
    }

    // first level of ineheritance
    private static class B
    extends A {

        final float bf;
        final boolean bb;

        public B(final int ai, final String as, final float bf, final boolean bb) {
            super(ai, as);
            this.bf = bf;
            this.bb = bb;
        }

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(final Object otherObject) {
            final B otherB = (B) otherObject;
            return new ApacheCommonsEqualsEngine<>(otherB).addSuper(super::equals)
                                                          .add(bf, otherB.bf)
                                                          .add(bb, otherB.bb)
                                                          .areEqual();
        }
    }

    // second level of inheritance
    private static class C
    extends B {

        public C(final int ai, final String as, final float bf, final boolean bb) {
            super(ai, as, bf, bb);
        }
    }

    private static final A A1 = new A(1, "Hallo");
    private static final A A1P = new A(1, "Hallo");
    private static final A A2 = new A(1, "Huhu");
    private static final B B1 = new B(1, "Hallo", 42.0815f, true);
    private static final B B1P = new B(1, "Hallo", 42.0815f, true);
    private static final B B2 = new B(1, "Huhu", 42.0815f, true);
    private static final C C1 = new C(1, "Hallo", 42.0815f, true);
    private static final C C1P = new C(1, "Hallo", 42.0815f, true);
    private static final C C2 = new C(1, "Huhu", 42.0815f, true);

    @Test
    @SuppressWarnings("EqualsWithItself")
    public void a1a1ShouldBeEqual() {
        assertThat(A1).isEqualTo(A1P);
    }

    @Test
    public void a1a2ShouldNotBeEqual() {
        assertThat(A1).isNotEqualTo(A2);
    }

    @Test
    @SuppressWarnings("EqualsWithItself")
    public void b1b1ShouldBeEqual() {
        assertThat(B1).isEqualTo(B1P);
    }

    @Test
    public void b1b2ShouldNotBeEqual() {
        assertThat(B1).isNotEqualTo(B2);
    }

    @Test
    @SuppressWarnings("EqualsWithItself")
    public void c1c1ShouldBeEqual() {
        assertThat(C1).isEqualTo(C1P);
    }

    @Test
    public void c1c2ShouldNotBeEqual() {
        assertThat(C1).isNotEqualTo(C2);
    }
}
