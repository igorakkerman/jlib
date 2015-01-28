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

package org.jlib.object_spi.apachecommons;

import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringStyle;

import static org.jlib.core.language.OptionalUtility.optionalOf;

class MapNamedToStringStyleSupplier
implements NamedToStringStyleSupplier {

    private final Map<String, ToStringStyle> toStringStyles;

    MapNamedToStringStyleSupplier(final Map<String, ToStringStyle> toStringStyles) {
        this.toStringStyles = toStringStyles;
    }

    @Override
    public Optional<ToStringStyle> get(final String identifier) {
        return optionalOf(() -> toStringStyles.get(identifier), toStringStyles.containsKey(identifier));
    }
//
//    private static class TestX
//    extends ApplicationObject {
//
//        private int i;
//        private boolean b;
//        private boolean bigB;
//        private String s;
//        private TestX next;
//
//        public TestX() {
//            i = 42;
//            b = false;
//            bigB = TRUE;
//            s = "abc";
//        }
//    }
//
//    public static void main(final String... commandLineArguments) {
//        System.setProperty(ApacheCommonsObjectMethodForwarder.TO_STRING_STYLE_NAME_PROPERTY_NAME, "SIMPLE_STYLE");
//
//        final TestX x = new TestX();
//        TestX n = new TestX();
//        n.i = 11;
//        n.b = true;
//        n.bigB = TRUE;
//        x.next = x;
//        System.out.println(x);
//    }
}
