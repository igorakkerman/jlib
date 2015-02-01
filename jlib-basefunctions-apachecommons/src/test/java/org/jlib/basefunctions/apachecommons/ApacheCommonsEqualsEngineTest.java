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

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import org.jlib.basefunctions.ApplicationObject;
import org.jlib.basefunctions.SuperEquals;
import org.junit.Test;

public class ApacheCommonsEqualsEngineTest {

    private static class A
    implements SuperEquals {

        final int ai;
        final String as;

        public A(final int ai, final String as) {
            this.ai = ai;
            this.as = as;
        }

        @Override
        public Predicate<SuperEquals> superEquals() {
            return super::equals;
        }

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(final Object otherObject) {
            final A otherA = (A) otherObject;
            return new ApacheCommonsEqualsEngine<>(this, otherA).add(ai, otherA.ai).add(as, otherA.as).areEqual();
        }
    }

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
            return new ApacheCommonsEqualsEngine<>(this, otherB).add(bf, otherB.bf).add(bb, otherB.bb).areEqual();
        }
    }

    private static class OA
    extends ApplicationObject {

        final int ai;
        final String as;

        public OA(final int ai, final String as) {
            this.ai = ai;
            this.as = as;
        }

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(final Object otherObject) {
            final OA otherOA = (OA) otherObject;
            return new ApacheCommonsEqualsEngine<>(this, otherOA).add(ai, otherOA.ai).add(as, otherOA.as).areEqual();
        }
    }

    private static class OB
    extends OA {

        final float bf;
        final boolean bb;

        public OB(final int ai, final String as, final float bf, final boolean bb) {
            super(ai, as);
            this.bf = bf;
            this.bb = bb;
        }

        @Override
        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(final Object otherObject) {
            final OB otherOB = (OB) otherObject;
            return new ApacheCommonsEqualsEngine<>(this, otherOB).add(bf, otherOB.bf).add(bb, otherOB.bb).areEqual();
        }
    }

    private static final A A1 = new A(1, "Hallo");
    private static final A A2 = new A(1, "Huhu");
    private static final B B1 = new B(1, "Hallo", 42.0815f, true);
    private static final B B2 = new B(1, "Huhu", 42.0815f, true);

    @Test
    public void a1a1ShouldBeEqual() {
        assertThat(A1).isEqualTo(A1);
    }

    @Test
    public void a1a2ShouldNotBeEqual() {
        assertThat(A1).isNotEqualTo(A2);
    }

    @Test
    public void b1b1ShouldBeEqual() {
        assertThat(B1).isEqualTo(B1);
    }

    @Test
    public void b1b2ShouldNotBeEqual() {
        assertThat(B1).isNotEqualTo(B2);
    }

    private static final OA OA1 = new OA(1, "Hallo");
    private static final OA OA2 = new OA(1, "Huhu");
    private static final OB OB1 = new OB(1, "Hallo", 42.0815f, true);
    private static final OB OB2 = new OB(1, "Huhu", 42.0815f, true);

    @Test
    public void oa1oa1ShouldBeEqual() {
        assertThat(OA1).isEqualTo(OA1);
    }

    @Test
    public void oa1oa2ShouldNotBeEqual() {
        assertThat(OA1).isNotEqualTo(OA2);
    }

    @Test
    public void ob1ob1ShouldBeEqual() {
        assertThat(OB1).isEqualTo(OB1);
    }

    @Test
    public void ob1ob2ShouldNotBeEqual() {
        assertThat(OB1).isNotEqualTo(OB2);
    }
}
