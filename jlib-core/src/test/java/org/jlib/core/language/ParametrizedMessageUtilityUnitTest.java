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

package org.jlib.core.language;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.jlib.core.language.ParametrizedMessageUtility.autoMessage;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ParametrizedMessageUtilityUnitTest {

    private static class IBliBlaBlubException
    extends Exception {

        private static final long serialVersionUID = 4507996594865173187L;
    }

    @Test
    public void createMessageFromRootException()
    throws Exception {
        assertThat(autoMessage(new Exception()), isEmptyString());
    }

    @Test
    public void createMessageFromExceptionName()
    throws Exception {
        assertThat(autoMessage(new IBliBlaBlubException()), is(equalTo("i bli bla blub")));
    }
}
