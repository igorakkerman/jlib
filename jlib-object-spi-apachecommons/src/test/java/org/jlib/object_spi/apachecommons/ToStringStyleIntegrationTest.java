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

import org.apache.commons.lang3.builder.ToStringStyle;

import org.junit.Test;

public class ToStringStyleIntegrationTest {

    public static class MyStyle
    extends ToStringStyle {

        private static final long serialVersionUID = - 1306981006542884518L;
    }

    public static class SomethingWithDefaultConstructor {

    }

    public static class SomethingWithoutDefaultConstructor {

        @SuppressWarnings("UnusedParameters")
        public SomethingWithoutDefaultConstructor(final Object object) {}
    }

//    private static final String SAMPLE_PROPERTY_NAME = "tss";
//    public static final String SAMPLE_STYLE_ID = "MY_STYLE";
//    private static final ToStringStyle SAMPLE_STYLE = new MyStyle();
//    private static final String FAKE_CLASS_NAME = "org.jlib.i.do.not.Exist";

    @Test
    public void dummy() {}
}
