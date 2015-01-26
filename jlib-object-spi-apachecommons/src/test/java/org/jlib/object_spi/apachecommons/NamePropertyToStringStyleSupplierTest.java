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

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NamePropertyToStringStyleSupplierTest {

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

    private static final ToStringStyle SAMPLE_MY_STYLE = new MyStyle();
    private static final String SAMPLE_PROPERTY_NAME = "tss";

    @Mock
    private IdentifiedToStringStyleSupplier identifiedToStringStyleSupplier;

    @Before
    @After
    public void clearProperty() {
        System.clearProperty(SAMPLE_PROPERTY_NAME);
    }

    @Test
    public void forUnsetPropertyShouldMapToDefaultStyleNotCallIdentifiedSupplier() {
        final ToStringStyle style = new NamePropertyToStringStyleSupplier(SAMPLE_PROPERTY_NAME,
                                                                          identifiedToStringStyleSupplier,
                                                                          SAMPLE_MY_STYLE).getToStringStyle();
        verifyNoMoreInteractions(identifiedToStringStyleSupplier);
        assertThat(style).isSameAs(SAMPLE_MY_STYLE);
    }

    @Test
    public void forSetPropertyShouldRequestIdentifiedSupplierAndUseMapping() {
        final String MY_STYLE_NAME = "MY_STYLE";
        System.setProperty(SAMPLE_PROPERTY_NAME, MY_STYLE_NAME);

        when(identifiedToStringStyleSupplier.isValidIdentifier(MY_STYLE_NAME)).thenReturn(true);
        when(identifiedToStringStyleSupplier.getIdentifiedToStringStyle(MY_STYLE_NAME)).thenReturn(SAMPLE_MY_STYLE);

        final ToStringStyle style = new NamePropertyToStringStyleSupplier(SAMPLE_PROPERTY_NAME,
                                                                          identifiedToStringStyleSupplier,
                                                                          DEFAULT_STYLE).getToStringStyle();

        verify(identifiedToStringStyleSupplier).isValidIdentifier(MY_STYLE_NAME);
        verify(identifiedToStringStyleSupplier).getIdentifiedToStringStyle(MY_STYLE_NAME);
        assertThat(style).isSameAs(SAMPLE_MY_STYLE);
    }

    // createToStringStyleInstance

//    @Test
//    public void styleClassNameShouldCreateStyleClass() {
//        assertThat(createToStringStyleInstance(MyStyle.class.getName())).hasSameClassAs(new MyStyle());
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void withDefaultConstructorClassNameShouldThrowException() {
//        createToStringStyleInstance(SomethingWithDefaultConstructor.class.getName());
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void withoutDefaultConstructorClassNameShouldThrowException() {
//        createToStringStyleInstance(SomethingWithoutDefaultConstructor.class.getName());
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void notExistingClassNameShouldThrowException() {
//        createToStringStyleInstance("org.jlib.i.do.not.Exist");
//    }
//
//    // ---
//
//    // fetchToStringStyle
//
//    @Test
//    public void unsetPropertyShouldCreateDefaultStyleClass() {
//        assertThat(fetchToStringStyle()).isSameAs(DEFAULT_STYLE);
//    }
//
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void emptyPropertyShouldThrowException() {
//        setProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME, "");
//
//        fetchToStringStyle();
//    }
//
//    @Test(expected = InvalidToStringStyleClassException.class)
//    public void blankPropertyShouldThrowException() {
//        setProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME, " ");
//
//        fetchToStringStyle();
//    }
//
//    @Test
//    public void classNamePropertyShouldCallCreateInstanceMethod()
//    throws Exception {
//        // given
//        mockStatic(IdentifierOrClassNamePropertyToStringStyleSupplier.class);
//
////        spy(ToStringStyleUtility.class);
//        setProperty(TO_STRING_STYLE_NAME_PROPERTY_NAME, "some.Class");
////        when(ToStringStyleUtility.class, "createToStringStyleInstance", "some.Class").thenReturn(new MyStyle());
////        when(ToStringStyleUtility.class,
////             method(ToStringStyleUtility.class, "createToStringStyleInstance", String.class)).withArguments(
////                                                                                                           "some
//// .Class")
////                                                                                             .thenReturn(new
//// MyStyle());
//
//        doReturn(new MyStyle()).when(IdentifierOrClassNamePropertyToStringStyleSupplier.class);
//
//        // when
//        fetchToStringStyle();
//
//        // then
//        verify(IdentifierOrClassNamePropertyToStringStyleSupplier.class).invoke("createToStringStyleInstance",
//                                                                                "some.Class");
//        verifyStatic();
////        createToStringStyleInstance("some.Class");
//    }
}
