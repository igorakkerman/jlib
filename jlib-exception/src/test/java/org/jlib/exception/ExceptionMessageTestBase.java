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

package org.jlib.exception;

import org.jlib.message.EagerMessage;
import org.jlib.message.Message;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class ExceptionMessageTestBase {

    public static final String MESSAGE_TEXT = "A funny text.";

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private Message message;

    protected Message getMessage() {
        return message;
    }

    protected ExpectedException getExpectedException() {
        return expectedException;
    }

    @Before
    public void initializeMocks() {
        message = mock(EagerMessage.class);
    }

    @Test
    public void exceptionShouldHaveCorrectMessage()
        throws Exception {
        when(message.toString()).thenReturn(MESSAGE_TEXT);
        expectedException.expectMessage(MESSAGE_TEXT);

        throwException();
    }

    protected abstract void throwException()
        throws Exception;
}
