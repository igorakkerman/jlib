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
import org.jlib.core.reflection.ClassInstantiationException;
import org.jlib.core.reflection.ReflectionUtility;

import static java.lang.String.format;
import static org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyNoMoreInteractions;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PropertyUtility.class, ReflectionUtility.class })
public class NamePropertyToStringStyleSupplierTest {

    private static final String PROPERTY_NAME = "tss";
    public static final String STYLE_ID = "MY_STYLE";
    @SuppressWarnings("serial")
    private static final ToStringStyle STYLE = new ToStringStyle() {
    };
    private static final String CLASS_NAME = "org.jlib.i.do.not.Exist";

    private NamePropertyToStringStyleSupplier styleSupplier;

    @Before
    public void initializeStyleSupplier() {
        styleSupplier = new NamePropertyToStringStyleSupplier();
        styleSupplier.setPropertyName(PROPERTY_NAME);
        styleSupplier.setIdentifiedStyleSupplier(identifiedToStringStyleSupplier);
        styleSupplier.setDefaultStyle(DEFAULT_STYLE);
    }

    @Mock
    private IdentifiedToStringStyleSupplier identifiedToStringStyleSupplier;

    @Before
    public void mockPropertyUtility() {
        mockStatic(PropertyUtility.class);
    }

    @Before
    public void spyOnReflectionUtility() {
        mockStatic(ReflectionUtility.class);
    }

    @Test
    public void unsetPropertyShouldReturnDefaultStyleNotCallIdentifiedSupplier() {

        // given
        when(PropertyUtility.getOptionalProperty(PROPERTY_NAME)).thenReturn(Optional.empty());

        // when
        final ToStringStyle style = styleSupplier.getToStringStyle();

        // then
        verifyStatic();
        PropertyUtility.getOptionalProperty(PROPERTY_NAME);
        verifyNoMoreInteractions(PropertyUtility.class);

        verifyNoMoreInteractions(identifiedToStringStyleSupplier);
        assertThat(style).isSameAs(DEFAULT_STYLE);

        verifyNoMoreInteractions(ReflectionUtility.class);
    }

    @Test
    public void styleOfMappedIdentifierShouldBeReturned() {

        // given
        when(PropertyUtility.getOptionalProperty(PROPERTY_NAME)).thenReturn(Optional.of(STYLE_ID));

        when(identifiedToStringStyleSupplier.isValidIdentifier(STYLE_ID)).thenReturn(true);
        when(identifiedToStringStyleSupplier.getIdentifiedToStringStyle(STYLE_ID)).thenReturn(STYLE);

        // when
        final ToStringStyle style = styleSupplier.getToStringStyle();

        // then
        verify(identifiedToStringStyleSupplier).isValidIdentifier(STYLE_ID);
        verify(identifiedToStringStyleSupplier).getIdentifiedToStringStyle(STYLE_ID);
        verifyNoMoreInteractions(identifiedToStringStyleSupplier);
        assertThat(style).isSameAs(STYLE);
    }

    @Test
    public void instantiatedStyleOfClassNameShouldBeRetrurned()
    throws Exception {

        // given
        when(PropertyUtility.getOptionalProperty(PROPERTY_NAME)).thenReturn(Optional.of(CLASS_NAME));
        when(identifiedToStringStyleSupplier.isValidIdentifier(CLASS_NAME)).thenReturn(false);
        when(ReflectionUtility.newInstanceOf(CLASS_NAME, ToStringStyle.class)).thenReturn(STYLE);

        // when
        final ToStringStyle style = styleSupplier.getToStringStyle();

        // then
        verifyStatic();
        PropertyUtility.getOptionalProperty(PROPERTY_NAME);
        verifyNoMoreInteractions(PropertyUtility.class);

        verify(identifiedToStringStyleSupplier).isValidIdentifier(CLASS_NAME);
        verifyNoMoreInteractions(identifiedToStringStyleSupplier);

        verifyStatic();
        ReflectionUtility.newInstanceOf(CLASS_NAME, ToStringStyle.class);
        verifyNoMoreInteractions(ReflectionUtility.class);

        assertThat(style).isSameAs(STYLE);
    }

    @Test
    public void notInstantiatableClassNameShouldFailMappingAndThrowException()
    throws Exception {

        try {
            // given
            when(PropertyUtility.getOptionalProperty(PROPERTY_NAME)).thenReturn(Optional.of(CLASS_NAME));
            when(identifiedToStringStyleSupplier.isValidIdentifier(CLASS_NAME)).thenReturn(false);
            when(ReflectionUtility.newInstanceOf(CLASS_NAME, ToStringStyle.class))./*
              */ thenThrow(new ClassInstantiationException(CLASS_NAME));

            // when
            styleSupplier.getToStringStyle();

            // then (failure)
            fail(format("Expected %a was not thrown." + ToStringStyleNotFoundException.class.getSimpleName()));
        }
        // expected
        catch (final ToStringStyleNotFoundException expectedException) {

            // then (success)
            verifyStatic();
            PropertyUtility.getOptionalProperty(PROPERTY_NAME);
            verifyNoMoreInteractions(PropertyUtility.class);

            verify(identifiedToStringStyleSupplier).isValidIdentifier(CLASS_NAME);
            verifyNoMoreInteractions(identifiedToStringStyleSupplier);

            verifyStatic();
            ReflectionUtility.newInstanceOf(CLASS_NAME, ToStringStyle.class);
            verifyNoMoreInteractions(ReflectionUtility.class);

            assertThat(expectedException).hasCauseExactlyInstanceOf(ClassInstantiationException.class);
        }
    }
}
