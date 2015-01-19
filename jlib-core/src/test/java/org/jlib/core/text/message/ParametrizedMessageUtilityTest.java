/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.text.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jlib.core.text.message.ParametrizedMessageUtility.autoMessageText;
import org.junit.Test;

public class ParametrizedMessageUtilityTest {

    // Exception name important for test
    private static class IBliBlaBlubException
    extends Exception {
        private static final long serialVersionUID = 0;
    }

    // Exception name important for test
    private static class E
    extends Exception {
        private static final long serialVersionUID = - 5922532337673635627L;
    }

    @Test
    public void rootExceptionShouldHaveEmptyCamel()
    throws Exception {
        assertThat(autoMessageText(new Exception())).isEmpty();
    }

    @Test
    public void OneLetterNamedExceptionShouldHaveOneLetterCamel()
    throws Exception {
        assertThat(autoMessageText(new E())).isEqualTo("e");
    }

    @Test
    public void MultipleWordsExceptionShouldHaveMultipleWordsCamel()
    throws Exception {
        assertThat(autoMessageText(new IBliBlaBlubException())).isEqualTo("i bli bla blub");
    }
}
