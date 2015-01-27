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

import org.jlib.core.reflection.ReflectionUtility;

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
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ReflectionUtility.class)
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

    private static final String SAMPLE_PROPERTY_NAME = "tss";
    public static final String SAMPLE_STYLE_ID = "MY_STYLE";
    private static final ToStringStyle SAMPLE_STYLE = new MyStyle();
    private static final Class<MyStyle> SAMPLE_CLASS = MyStyle.class;
    private static final String SAMPLE_CLASS_NAME = SAMPLE_CLASS.getName();
    private static final String FAKE_CLASS_NAME = "org.jlib.i.do.not.Exist";

    @Mock
    private IdentifiedToStringStyleSupplier identifiedToStringStyleSupplier;

    private ToStringStyleSupplier styleSupplier;

    @Before
    @After
    public void clearProperty() {
        System.clearProperty(SAMPLE_PROPERTY_NAME);
    }

    @Before
    public void initializeStyleSupplier() {
        styleSupplier = new NamePropertyToStringStyleSupplier(SAMPLE_PROPERTY_NAME, identifiedToStringStyleSupplier,
                                                              DEFAULT_STYLE);
    }

    @Before
    public void spyOnReflectionUtility() {
    }

    @Test
    public void forUnsetPropertyShouldMapToDefaultStyleNotCallIdentifiedSupplier() {
        final ToStringStyle style = styleSupplier.getToStringStyle();
        verifyNoMoreInteractions(identifiedToStringStyleSupplier);
        assertThat(style).isSameAs(DEFAULT_STYLE);
    }

    @Test
    public void forDefinedPropertyIdentifiedSupplierShouldUseMapping() {
        System.setProperty(SAMPLE_PROPERTY_NAME, SAMPLE_STYLE_ID);

        when(identifiedToStringStyleSupplier.isValidIdentifier(SAMPLE_STYLE_ID)).thenReturn(true);
        when(identifiedToStringStyleSupplier.getIdentifiedToStringStyle(SAMPLE_STYLE_ID)).thenReturn(SAMPLE_STYLE);

        final ToStringStyle style = styleSupplier.getToStringStyle();

        verify(identifiedToStringStyleSupplier).isValidIdentifier(SAMPLE_STYLE_ID);
        verify(identifiedToStringStyleSupplier).getIdentifiedToStringStyle(SAMPLE_STYLE_ID);
        assertThat(style).isSameAs(SAMPLE_STYLE);
    }

    //    @Test(expected = ToStringStyleNotFoundException.class)
    @Test
    public void notExistingClassNamePropertyShouldNotHaveMappingAndThrowException()
    throws Exception {

        PowerMockito.spy(ReflectionUtility.class);

        // given
//        PowerMockito.doReturn(SAMPLE_STYLE).when(ReflectionUtility.class); // works, but only in order doReturn->when
        PowerMockito.when(ReflectionUtility.class,
                          PowerMockito.method(ReflectionUtility.class, "newInstanceOf", String.class, Class.class))
                    .withArguments(FAKE_CLASS_NAME, ToStringStyle.class)
                    .thenReturn(SAMPLE_STYLE);
        ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, SAMPLE_CLASS);

        // when
        final MyStyle style = ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, SAMPLE_CLASS);
        assertThat(style).isSameAs(SAMPLE_STYLE);

//        mockStatic(ReflectionUtility.class);

//        ReflectionUtility.newInstanceOf("my.Name", ToStringStyle.class);
//
//        verifyStatic();
//        ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, ToStringStyle.class);

//        System.setProperty(SAMPLE_PROPERTY_NAME, FAKE_CLASS_NAME + "x");
//
//        when(identifiedToStringStyleSupplier.isValidIdentifier(FAKE_CLASS_NAME)).thenReturn(false);
//
//        styleSupplier.getToStringStyle();
//
//        verify(identifiedToStringStyleSupplier).isValidIdentifier(SAMPLE_STYLE_ID);
//        verifyNoMoreInteractions(identifiedToStringStyleSupplier);
        // expect ToStringStyleNotFoundException
    }

//    @Test
//    public void classNamePropertyShouldNotHaveMappingCreateStyleClass() {
//        System.setProperty(SAMPLE_PROPERTY_NAME, SAMPLE_CLASS_NAME);
//
//        when(identifiedToStringStyleSupplier.isValidIdentifier(SAMPLE_CLASS_NAME)).thenReturn(false);
//
//        final ToStringStyle style = styleSupplier.getToStringStyle();
//
//        assertThat(createToStringStyleInstance(SAMPLE)).hasSameClassAs(new MyStyle());
//    }

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
//        createToStringStyleInstance("");
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
