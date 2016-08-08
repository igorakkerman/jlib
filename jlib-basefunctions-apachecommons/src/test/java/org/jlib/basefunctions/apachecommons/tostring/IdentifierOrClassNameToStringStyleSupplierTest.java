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

package org.jlib.basefunctions.apachecommons.tostring;

import org.apache.commons.lang3.builder.ToStringStyle;

import static java.lang.String.format;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
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
    private static final ToStringStyle STYLE = new TestStyle();
    private static final String CLASS_NAME = "org.jlib.i.do.not.Exist";
    private IdentifierOrClassNameToStringStyleSupplier configurableSupplier;
    @Mock
    private NamedToStringStyleSupplier namedStyleSupplier;
    @Mock
    private ClassNameToStringStyleSupplier classNameStyleSupplier;

    @Before
    public void initializeStyleSupplier() {
        configurableSupplier = new IdentifierOrClassNameToStringStyleSupplier();
        configurableSupplier.setNamedStyleSupplier(namedStyleSupplier);
        configurableSupplier.setClassNameToStringStyleSupplier(classNameStyleSupplier);
    }

    @Test
    public void styleOfMappedIdentifierShouldBeReturned() {

        // given
        when(namedStyleSupplier.get(STYLE_ID)).thenReturn(of(STYLE));

        // when
        configurableSupplier.setIdentifierOrClassName(STYLE_ID);
        final ToStringStyle style = configurableSupplier.get();

        // then
        verify(namedStyleSupplier).get(STYLE_ID);
        verifyNoMoreInteractions(namedStyleSupplier);

        verifyNoMoreInteractions(classNameStyleSupplier);

        assertThat(style).isSameAs(STYLE);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void instantiatedStyleOfClassNameShouldBeRetrurned()
        throws Exception {

        // given
        when(namedStyleSupplier.get(CLASS_NAME)).thenReturn(empty());
        when(classNameStyleSupplier.get(CLASS_NAME)).thenReturn(STYLE);

        // when
        configurableSupplier.setIdentifierOrClassName(CLASS_NAME);
        final ToStringStyle style = configurableSupplier.get();

        // then
        verify(namedStyleSupplier).get(CLASS_NAME);
        verifyNoMoreInteractions(namedStyleSupplier);

        verify(classNameStyleSupplier).get(CLASS_NAME);
        verifyNoMoreInteractions(classNameStyleSupplier);

        assertThat(style).isSameAs(STYLE);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void notInstantiatableClassNameShouldFailMappingAndThrowException()
        throws Exception {
        try {
            // given
            when(namedStyleSupplier.get(CLASS_NAME)).thenReturn(empty());
            when(classNameStyleSupplier.get(CLASS_NAME))
                .thenThrow(new ToStringStyleNotFoundException(new IllegalStateException()));

            // when
            configurableSupplier.setIdentifierOrClassName(CLASS_NAME);
            configurableSupplier.get();

            // then (failure)
            fail(format("Expected %s was not thrown.", ToStringStyleNotFoundException.class.getSimpleName()));
        }
        // expected
        catch (final ToStringStyleNotFoundException expectedException) {

            // then (success)
            verify(namedStyleSupplier).get(CLASS_NAME);
            verifyNoMoreInteractions(namedStyleSupplier);

            verify(classNameStyleSupplier).get(CLASS_NAME);
            verifyNoMoreInteractions(classNameStyleSupplier);

            assertThat(expectedException).hasCauseExactlyInstanceOf(IllegalStateException.class);
        }
    }

    @SuppressWarnings("serial")
    private static class TestStyle
        extends ToStringStyle {}
}
