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

import static org.assertj.core.api.Assertions.assertThat;
import org.jlib.reflect.languageelement.ClassLookupException;
import org.jlib.reflect.reflector.ReflectorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Answers.RETURNS_DEEP_STUBS;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReflectorClassNameToStringStyleSupplierTest {

    @SuppressWarnings("serial")
    private static class TestStyle
    extends ToStringStyle {}

    private static final String CLASS_NAME = "org.jlib.i.do.not.Exist";
    private static final ToStringStyle STYLE = new TestStyle();

    private ReflectorClassNameToStringStyleSupplier classNameStyleSupplier;

    @Mock(answer = RETURNS_DEEP_STUBS)
    private ReflectorService reflectorService;

    @Before
    public void initializeClassNameStyleSupplier() {
        classNameStyleSupplier = new ReflectorClassNameToStringStyleSupplier();
        classNameStyleSupplier.setReflectorService(reflectorService);
    }

    @Test
    public void getShouldReturnClassFromReflectorServiceUseClass()
    throws Exception {
        // given
        when(reflectorService.useClass(CLASS_NAME).withType(ToStringStyle.class).instance()).thenReturn(STYLE);

        // when
        final ToStringStyle style = classNameStyleSupplier.get(CLASS_NAME);

        // then
        assertThat(style).isSameAs(STYLE);
    }

    @Test(expected = ToStringStyleNotFoundException.class)
    public void getShouldThrowExceptionWhenReflectorServiceUseClassThrowsException()
    throws Exception {
        // given
        when(reflectorService.useClass(CLASS_NAME).withType(ToStringStyle.class).instance())
        .thenThrow(new ClassLookupException(CLASS_NAME, new Exception()));

        // when
        final ToStringStyle style = classNameStyleSupplier.get(CLASS_NAME);
    }
}
