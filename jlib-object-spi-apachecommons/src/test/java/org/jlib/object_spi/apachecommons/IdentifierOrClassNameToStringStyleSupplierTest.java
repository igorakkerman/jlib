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

import org.jlib.core.classinstance.ClassInstanceService;
import org.jlib.core.classinstance.ClassInstantiationException;

import static java.lang.String.format;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdentifierOrClassNameToStringStyleSupplierTest {

    public static final String STYLE_ID = "MY_STYLE";
    @SuppressWarnings("serial")
    private static final ToStringStyle STYLE = new ToStringStyle() {};
    private static final String CLASS_NAME = "org.jlib.i.do.not.Exist";

    private IdentifierOrClassNameToStringStyleSupplier configurableSupplier;

    @Mock
    private NamedToStringStyleSupplier namedToStringStyleSupplier;

    @Mock
    private ClassInstanceService instanceService;

    @Before
    public void initializeStyleSupplier() {
        configurableSupplier = new IdentifierOrClassNameToStringStyleSupplier();
        configurableSupplier.setNamedStyleSupplier(namedToStringStyleSupplier);
        configurableSupplier.setInstanceService(instanceService);
    }

    @Test
    public void styleOfMappedIdentifierShouldBeReturned() {

        // given
        when(namedToStringStyleSupplier.get(STYLE_ID)).thenReturn(of(STYLE));

        // when
        configurableSupplier.setIdentifierOrClassName(STYLE_ID);
        final ToStringStyle style = configurableSupplier.get();

        // then
        verify(namedToStringStyleSupplier).get(STYLE_ID);
        verifyNoMoreInteractions(namedToStringStyleSupplier);

        verifyNoMoreInteractions(instanceService);

        assertThat(style).isSameAs(STYLE);
    }

    @Test
    public void instantiatedStyleOfClassNameShouldBeRetrurned()
    throws Exception {

        // given
        when(namedToStringStyleSupplier.get(CLASS_NAME)).thenReturn(empty());
        when(instanceService.instanceOf(CLASS_NAME, ToStringStyle.class)).thenReturn(STYLE);

        // when
        configurableSupplier.setIdentifierOrClassName(CLASS_NAME);
        final ToStringStyle style = configurableSupplier.get();

        // then
        verify(namedToStringStyleSupplier).get(CLASS_NAME);
        verifyNoMoreInteractions(namedToStringStyleSupplier);

        verify(instanceService).instanceOf(CLASS_NAME, ToStringStyle.class);
        verifyNoMoreInteractions(instanceService);

        assertThat(style).isSameAs(STYLE);
    }

    @Test
    public void notInstantiatableClassNameShouldFailMappingAndThrowException()
    throws Exception {

        try {
            // given
            when(namedToStringStyleSupplier.get(CLASS_NAME)).thenReturn(empty());
            when(instanceService.instanceOf(CLASS_NAME, ToStringStyle.class))./*
              */ thenThrow(new ClassInstantiationException(CLASS_NAME));

            // when
            configurableSupplier.setIdentifierOrClassName(CLASS_NAME);
            configurableSupplier.get();

            // then (failure)
            fail(format("Expected %a was not thrown." + ToStringStyleNotFoundException.class.getSimpleName()));
        }
        // expected
        catch (final ToStringStyleNotFoundException expectedException) {

            // then (success)
            verify(namedToStringStyleSupplier).get(CLASS_NAME);
            verifyNoMoreInteractions(namedToStringStyleSupplier);

            verify(instanceService).instanceOf(CLASS_NAME, ToStringStyle.class);
            verifyNoMoreInteractions(instanceService);

            assertThat(expectedException).hasCauseExactlyInstanceOf(ClassInstantiationException.class);
        }
    }
}
