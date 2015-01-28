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

import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringStyle;

import org.jlib.core.property.PropertyUtility;
import org.jlib.core.reflection.ReflectionUtility;

import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PropertyUtility.class, ReflectionUtility.class })
public class NamePropertyToStringStyleSupplierTest {

    private static final String SAMPLE_PROPERTY_NAME = "tss";
    public static final String SAMPLE_STYLE_ID = "MY_STYLE";
    @SuppressWarnings("serial")
    private static final ToStringStyle SAMPLE_STYLE = new ToStringStyle() {};
    private static final String FAKE_CLASS_NAME = "org.jlib.i.do.not.Exist";

    @Mock
    private IdentifiedToStringStyleSupplier identifiedToStringStyleSupplier;

    private NamePropertyToStringStyleSupplier styleSupplier;

    @Before
    public void initializeStyleSupplier() {
        styleSupplier = new NamePropertyToStringStyleSupplier();
        styleSupplier.setPropertyName(SAMPLE_PROPERTY_NAME);
        styleSupplier.setIdentifiedStyleSupplier(identifiedToStringStyleSupplier);
        styleSupplier.setDefaultStyle(DEFAULT_STYLE);
    }

    @Before
    public void mockPropertyUtility() {
        mockStatic(PropertyUtility.class);
    }

    @Before
    public void spyOnReflectionUtility() {
        mockStatic(ReflectionUtility.class);
    }

    @Test
    public void forUnsetPropertyShouldMapToDefaultStyleNotCallIdentifiedSupplier() {
        // given
        when(PropertyUtility.getOptionalProperty(SAMPLE_PROPERTY_NAME)).thenReturn(Optional.empty());

        // when
        final ToStringStyle style = styleSupplier.getToStringStyle();

        // then
        verifyNoMoreInteractions(identifiedToStringStyleSupplier);
        assertThat(style).isSameAs(DEFAULT_STYLE);
    }

    @Test
    public void forDefinedPropertyIdentifiedSupplierShouldUseMapping() {
        when(PropertyUtility.getOptionalProperty(SAMPLE_PROPERTY_NAME)).thenReturn(Optional.of(SAMPLE_STYLE_ID));

        when(identifiedToStringStyleSupplier.isValidIdentifier(SAMPLE_STYLE_ID)).thenReturn(true);
        when(identifiedToStringStyleSupplier.getIdentifiedToStringStyle(SAMPLE_STYLE_ID)).thenReturn(SAMPLE_STYLE);

        final ToStringStyle style = styleSupplier.getToStringStyle();

        verify(identifiedToStringStyleSupplier).isValidIdentifier(SAMPLE_STYLE_ID);
        verify(identifiedToStringStyleSupplier).getIdentifiedToStringStyle(SAMPLE_STYLE_ID);
        assertThat(style).isSameAs(SAMPLE_STYLE);
    }

    @Test
    public void existingClassNamePropertyShouldFailMappingAndHaveInstanceCreated()
    throws Exception {

        // given
        when(PropertyUtility.getOptionalProperty(SAMPLE_PROPERTY_NAME)).thenReturn(Optional.of(FAKE_CLASS_NAME));

        when(identifiedToStringStyleSupplier.isValidIdentifier(FAKE_CLASS_NAME)).thenReturn(false);

        when(ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, ToStringStyle.class)).thenReturn(SAMPLE_STYLE);

        // when
        System.setProperty(SAMPLE_PROPERTY_NAME, FAKE_CLASS_NAME);
        final ToStringStyle style = styleSupplier.getToStringStyle();

        // then
        verify(identifiedToStringStyleSupplier).isValidIdentifier(FAKE_CLASS_NAME);
        verifyNoMoreInteractions(identifiedToStringStyleSupplier);

        verifyStatic();
        ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, ToStringStyle.class);

        assertThat(style).isSameAs(SAMPLE_STYLE);
    }

    // expect ToStringStyleNotFoundException

//        // given
//        PowerMockito.doReturn(SAMPLE_STYLE).when(ReflectionUtility.class, );
//        ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, ToStringStyle.class); // this is not the execution,just setup
//        PowerMockito.when(ReflectionUtility.class,
//                          PowerMockito.method(ReflectionUtility.class, "newInstanceOf", String.class, Class.class))
//                    .withArguments(FAKE_CLASS_NAME, SAMPLE_CLASS)
//                    .thenReturn(SAMPLE_STYLE);
//
//        // when
//        final MyStyle style = ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, SAMPLE_CLASS);
//        assertThat(style).isSameAs(SAMPLE_STYLE);

//        mockStatic(ReflectionUtility.class);

//        ReflectionUtility.newInstanceOf("my.Name", ToStringStyle.class);
//
//        verifyStatic();
//        ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, ToStringStyle.class);
//        assertThat(ReflectionUtility.newInstanceOf(FAKE_CLASS_NAME, SAMPLE_CLASS)).isEqualTo(SAMPLE_STYLE);

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
